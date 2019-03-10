package com.german.gonzalez.productos;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.german.gonzalez.model.entrada.AtributoEntrada;
import com.german.gonzalez.model.entrada.ListaProductosEntrada;
import com.german.gonzalez.model.entrada.ProductoEntrada;
import com.german.gonzalez.model.salida.AtributoSalida;
import com.german.gonzalez.model.salida.ListaProductosSalida;
import com.german.gonzalez.model.salida.ProductoSalida;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controlador para Obtencion de Productos de Acuerdo a la Condicion del Producto (Nuevo o Usado)
 * La Anotacion @PropertySource indica que el Controlador tomara informacion de un Archivo Properties
 * La Anotacion @RestController indica que es un Controlador que Publica un Servicio REST
 * La Anotacion @RequestMapping indica el Path URL Cabecera del Controlador
 * Las Anotaciones @Value indican valores obtenidos de una Fuente de Datos que seran utilizados dentro del Sistema
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
@PropertySource(ignoreResourceNotFound = true, value = "classpath:config.properties")
@RestController
@RequestMapping("/products")
public class ProductosController {
	
	private final static Logger LOGGER = Logger.getLogger(ProductosController.class.getName());
	
	private static final String VALOR_NUEVO = "N";
	
	private static final String VALOR_USADO = "U";
	
	@Value("${json.nuevo}")
    private String nuevo;
	
	@Value("${json.usado}")
    private String usado;
	
	@Value("${json.item.condition}")
    private String itemCondition;
	
	@Value("${url.api.json}")
    private String urlApiJson;
	
	@Value("${mensaje.error.negocio}")
    private String mensajeErrorNegocio;
	
	@Value("${mensaje.error.sistema}")
    private String mensajeErrorSistema;

	/**
	 * Metodo que devuelve los Productos en base a su Condicion (Nuevo o Usado)
	 * La Anotacion @GetMapping indica que es una operacion de Tipo GET con un Parametro Opcional con el Simbolo del Tipo de Condicion (N para Nuevo o U para Usado)
	 * La Anotacion @ResponseBody indica que la respuesta se debe devolver como un objeto de respuesta Web
	 * @author German Gonzalez
	 * @since 09-03-2019
	 * @version 1.0.0
	 * @param id Objeto String que representa el Tipo de Condicion a Filtrar
	 * @return String Objeto JSON con los resultados Obtenidos
	 * @throws Exception
	 *
	 */
    @GetMapping(value = { "", "/", "/{id}", "/getByItemCondition", "/getByItemCondition/", "/getByItemCondition/{id}" })
    @ResponseBody
    public String getProductsByItemCondition(@PathVariable(value = "id", required=false) String id) throws Exception {
        
    	String resultado = null;
    	
    	ListaProductosSalida salida = null;
    	
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try(InputStream is = new URL(urlApiJson).openStream();) {
    		
    		BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    		
    		resultado = readAll(rd);
    		
    		ListaProductosEntrada productos = mapper.readValue(resultado, ListaProductosEntrada.class);
    		
    		if(id != null) {
    		
	    		switch(id) {
				
	    			case VALOR_NUEVO:
						salida = procesarDatos(VALOR_NUEVO, productos);
						break;
						
					case VALOR_USADO:
						salida = procesarDatos(VALOR_USADO, productos);
						break;
						
					default:
						throw new Exception(mensajeErrorNegocio);
				
				}
	    		
    		} else {
    			
    			salida = procesarDatos(null, productos);
    			
    		}
    		
    		resultado = mapper.writeValueAsString(salida);
	    
    	} catch(Exception e) {
    		
    		LOGGER.log(Level.SEVERE, mensajeErrorSistema + " " + e.toString(), e);
    		
    		throw new Exception(mensajeErrorSistema + " " + e.toString());
    		
    	}
    	
    	return resultado;
    	
    }
    
    /**
	 * Metodo que procesa la informacion solicitada de los productos y construya el JSON de Salida del Sistema
	 * @author German Gonzalez
	 * @since 09-03-2019
	 * @version 1.0.0
	 * @param condicion Objeto String que representa la condicion del Tipo de Producto (Usado o Nuevo)
	 * @param productos Objeto ListaProductosEntrada que representa la respuesta obtenido del API JSON de Entrada
	 * @return ListaProductosSalida Objeto ListaProductosSalida final de la Peticion realizada
	 * @throws Exception
	 *
	 */
    private ListaProductosSalida procesarDatos(String condicion, ListaProductosEntrada productos) throws Exception {
    	
    	ListaProductosSalida salida = new ListaProductosSalida();
    	
    	try {
    	
	    	List<ProductoEntrada> productosFiltrados = productos.getResults().stream().collect(Collectors.toList());
	    	
	    	if(condicion != null && condicion.equals(VALOR_USADO)) {
	    	
	    		salida.setNuevos(null);
	    		
	    		productosFiltrados = productos.getResults().stream().filter(p -> p.getAttributes().stream().anyMatch(a -> a.getValue_name().equals(usado))).collect(Collectors.toList());
	    		
	    	} else {
	    		
	    		salida.setNuevos(new ArrayList<>());
	    		
	    	}
	    	
	    	if(condicion != null && condicion.equals(VALOR_NUEVO)) {
	    		
	    		salida.setUsed(null);
	    		
	    		productosFiltrados = productos.getResults().stream().filter(p -> p.getAttributes().stream().anyMatch(a -> a.getValue_name().equals(nuevo))).collect(Collectors.toList());
	    		
	    	} else {
	    	
	    		salida.setUsed(new ArrayList<>());
	    		
	    	}    	
	    	
	    	for(ProductoEntrada producto : productosFiltrados) {
	    		
	    		salida = poblarListaSalida(producto, salida);
	    		
	    	}
	    	
    	} catch(Exception e) {
    		
    		LOGGER.log(Level.SEVERE, mensajeErrorSistema + " " + e.toString(), e);
    		
    	}
    	
    	return salida;
    	
    }
    
    /**
	 * Metodo para llenar la lista contenida dentro del JSON de Salida de la Peticion con los Productos Filtrados
	 * @author German Gonzalez
	 * @since 10-03-2019
	 * @version 1.0.0
	 * @param producto Objeto ProductoEntrada que representa el Producto Obtenida del API JSON de Entrada
	 * @param salidaParametro Objeto ListaProductosSalida que representa el JSON de Salida poblado hasta el momento
	 * @return ListaProductosSalida Objeto ListaProductosSalida con el nuevo Producto Agregado
	 * @throws Exception
	 *
	 */
    private ListaProductosSalida poblarListaSalida(ProductoEntrada producto, ListaProductosSalida salidaParametro) throws Exception {
    	
    	String itemConditionLocal = null;
    	
    	ListaProductosSalida salida = salidaParametro;
    	
    	try {
    	
	    	itemConditionLocal = producto.getAttributes().stream().filter(p -> p.getId().equals(itemCondition)).collect(Collectors.toList()).get(0).getValue_name();
			
			if(itemConditionLocal.equals(nuevo)) {
				
				ProductoSalida productoNuevo = new ProductoSalida();
				
				productoNuevo.setId(producto.getId());
				
				productoNuevo.setTitle(producto.getTitle());
				
				productoNuevo.setAttributes(obtenerAtributos(producto.getAttributes()));
				
				salida.getNuevos().add(productoNuevo);
				
			} else if(itemConditionLocal.equals(usado)) {
				
				ProductoSalida productoUsado = new ProductoSalida();
				
				productoUsado.setId(producto.getId());
				
				productoUsado.setTitle(producto.getTitle());
				
				productoUsado.setAttributes(obtenerAtributos(producto.getAttributes()));
				
				salida.getUsed().add(productoUsado);
				
			}
			
    	} catch(Exception e) {
    		
    		LOGGER.log(Level.SEVERE, mensajeErrorSistema + " " + e.toString(), e);
    		
    	}
    	
    	return salida;
    	
    }
    
    /**
	 * Metodo que lee la informacion de los Atributos por Producto del API de Entrada JSON para Mapearla a los Atributos del Producto del JSON de Salida
	 * @author German Gonzalez
	 * @since 09-03-2019
	 * @version 1.0.0
	 * @param atributosEntrada Objeto List<AtributoEntrada> que representa la Lista de Atributos por Producto
	 * @return List<AtributoSalida> Objeto List<AtributoSalida> con los Atributos filtrados
	 *
	 */
    private List<AtributoSalida> obtenerAtributos(List<AtributoEntrada> atributosEntrada) {
    	
    	List<AtributoSalida> atributos = new ArrayList<>();
    	
    	for(AtributoEntrada atributo : atributosEntrada) {
			
			AtributoSalida atributoSalida = new AtributoSalida();
			
			atributoSalida.setId(atributo.getId());
			
			atributoSalida.setName(atributo.getName());
			
			atributoSalida.setValue_name(atributo.getValue_name());
			
			atributos.add(atributoSalida);
			
		}
    	
    	return atributos;
    	
    }
    
    /**
	 * Metodo que lee la informacion proveniente de la peticion URL del API de Entrada
	 * @author German Gonzalez
	 * @since 09-03-2019
	 * @version 1.0.0
	 * @param rd Objeto Reader con el Buffer proveniente de la peticion URL
	 * @return String Objeto JSON con los resultados Obtenidos
	 * @throws Exception
	 *
	 */
    private String readAll(Reader rd) throws Exception {
    
    	StringBuilder sb = new StringBuilder();
    
    	int cp;
        
    	while ((cp = rd.read()) != -1) {
        
    		sb.append((char) cp);
        
    	}
        
    	return sb.toString();
      
    }

}