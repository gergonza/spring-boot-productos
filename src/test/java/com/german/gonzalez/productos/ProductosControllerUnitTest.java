package com.german.gonzalez.productos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.german.gonzalez.model.entrada.AtributoEntrada;
import com.german.gonzalez.model.entrada.Dato;
import com.german.gonzalez.model.entrada.ListaProductosEntrada;
import com.german.gonzalez.model.entrada.Locacion;
import com.german.gonzalez.model.entrada.Precio;
import com.german.gonzalez.model.entrada.ProductoEntrada;
import com.german.gonzalez.model.salida.ListaProductosSalida;
import com.german.gonzalez.productos.ExceptionHandlingControllerAdvice;
import com.german.gonzalez.productos.ProductosController;

/**
 * Componente Responsable para Ejecutar las Pruebas de Integracion del Sistema
 * La Anotacion @RunWith indica la clase de la cual se tomaran los componentes para ejecutar las Pruebas
 * La Anotacion @SpringBootTest indica que se ejecutan pruebas basadas en Spring Boot
 * La Anotacion @AutoConfigureMockMvc indica que se habilitaran la configuracion automatica de Mocks para las Pruebas
 * Las Anotaciones @Autowired indica los Beans que seran inyectados para la realizacion de las Pruebas
 * @author German Gonzalez
 * @since 10-03-2019
 * @version 1.0.0
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductosControllerUnitTest {
	
	private ListaProductosEntrada productos;
	
	@Autowired
    private MockMvc mvc;
    
    @Autowired
    private ProductosController productosController;
    
    /**
     * Metodo que realiza el Mapeo de un JSON a un Objeto (Serializar JSON a Objeto)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @param json Objeto String que representa el JSON a Serializar
     * @param clazz Objeto Class<T> Generico que representa la Clase Java el cual sera destino de la Serializacion del JSON
     * @return T Objeto Generico <T> correspondiente a la Clase Destino de la Serializacion
     * @throws Exception
     *
     */
    private <T> T mapFromJson(String json, Class<T> clazz) throws Exception {
    	      
    	ObjectMapper objectMapper = new ObjectMapper();
    	      
    	return objectMapper.readValue(json, clazz);
    	   
    }
    
    /**
     * Metodo que ejecutara las configuraciones previas al inicio de las pruebas
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Before
    public void setup() throws Exception {
    	
    	this.mvc = standaloneSetup(this.productosController).setControllerAdvice(new ExceptionHandlingControllerAdvice()).build();
    	
    	AtributoEntrada atributo = new AtributoEntrada();
    	
    	atributo.setId("1");
    	
    	atributo.setAttribute_group_id("Prueba");
    	
    	atributo.setAttribute_group_name("Prueba");
    	
    	atributo.setName("Prueba");
    	
    	atributo.setValue_id("Prueba");
    	
    	atributo.setValue_name("Prueba");
    	
    	atributo.getValue_id();
    	
    	atributo.getAttribute_group_id();
    	
    	atributo.getAttribute_group_name();
    	
    	Dato dato = new Dato();
    	
    	dato.setId("1");
    	
    	dato.setName("Caracas");
    	
    	dato.getId();
    	
    	dato.getName();
    	
    	Locacion locacion = new Locacion();
    	
    	locacion.setAddress_line("Prueba");
    	
    	locacion.setCity(dato);
    	
    	locacion.setLatitude(0);
    	
    	locacion.setLongitude(0);
    	
    	locacion.setZip_code("Prueba");
    	
    	locacion.getAddress_line();
    	
    	locacion.getLatitude();
    	
    	locacion.getLongitude();
    	
    	locacion.getZip_code();
    	
    	locacion.getCity();
    	
    	locacion.getCountry();
    	
    	locacion.getNeighborhood();
    	
    	locacion.getState();
    	
    	Precio precio = new Precio();
    	
    	precio.setAmount(0);
    	
    	precio.setCurrency_id("CL");
    	
    	precio.setCurrency_symbol("$");
    	
    	precio.setDecimal_places(1);
    	
    	precio.setDecimal_separator(",");
    	
    	precio.setThousands_separator(".");
    	
    	precio.getAmount();
    	
    	precio.getCurrency_id();
    	
    	precio.getCurrency_symbol();
    	
    	precio.getDecimal_places();
    	
    	precio.getDecimal_separator();
    	
    	precio.getThousands_separator();

        ProductoEntrada producto1 = new ProductoEntrada();

        producto1.setId("MLC462810708");
        
        producto1.setTitle("Condominio Ecoterraneo");
        
        producto1.setPermalink("https://casa.mercadolibre.cl/MLC-462810708-condominio-ecoterraneo-_JM");

        producto1.setPicture("https://http2.mlstatic.com/D_NQ_P_784814-MLC27733094452_072018-I.jpg");

        producto1.setBuying_mode("classified");
        
        producto1.setPrice(precio);
        
        producto1.setLocation(locacion);
        
        producto1.getId();
        
        producto1.getBuying_mode();
        
        producto1.getPermalink();
        
        producto1.getPicture();
        
        producto1.getTitle();
        
        producto1.getPrice();
        
        producto1.getLocation();

        ProductoEntrada producto2 = new ProductoEntrada();

        producto2.setId("MLC462810635");
        
        producto2.setTitle("Condominio Rukan");
        
        producto2.setPermalink("https://casa.mercadolibre.cl/MLC-462810635-condominio-rukan-_JM");

        producto2.setPicture("https://http2.mlstatic.com/D_NQ_P_618013-MLC27733095533_072018-I.jpg");

        producto2.setBuying_mode("classified");

        productos = new ListaProductosEntrada();
        
        productos.setResults(new ArrayList<>());

        productos.getResults().add(producto1);

        productos.getResults().add(producto2);

    }
    
    /**
     * Metodo que ejecutara la prueba unitaria correspondiente a la invocacion de la URL "/products" (Todos los Productos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProduct() throws Exception {
        
    	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON))
			.andReturn();
    	
    	int status = mvcResult.getResponse().getStatus();
    	   
    	assertEquals(200, status);
    	   
    	String content = mvcResult.getResponse().getContentAsString();
    	   
    	ListaProductosSalida productlist = this.mapFromJson(content, ListaProductosSalida.class);
    	   
    	assertTrue(productlist.getNuevos().get(0).getTitle().equals("Sky 100"));
    	
    }
    
    /**
     * Metodo que ejecutara la prueba unitaria correspondiente a la invocacion de la URL "/products/getByItemCondition" (Todos los Productos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemCondition() throws Exception {
    	
    	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition").accept(MediaType.APPLICATION_JSON))
    			.andReturn();
        	
    	int status = mvcResult.getResponse().getStatus();
    	   
    	assertEquals(200, status);
    	   
    	String content = mvcResult.getResponse().getContentAsString();
    	   
    	ListaProductosSalida productlist = this.mapFromJson(content, ListaProductosSalida.class);
    	   
    	assertTrue(productlist.getNuevos().get(0).getTitle().equals("Sky 100"));
    	
    }
    
    /**
     * Metodo que ejecutara la prueba unitaria correspondiente a la invocacion de la URL "/products/getByItemCondition/" (Todos los Productos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemConditionSlash() throws Exception {
    	
    	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition/").accept(MediaType.APPLICATION_JSON))
    			.andReturn();
        	
    	int status = mvcResult.getResponse().getStatus();
    	   
    	assertEquals(200, status);
    	   
    	String content = mvcResult.getResponse().getContentAsString();
    	   
    	ListaProductosSalida productlist = this.mapFromJson(content, ListaProductosSalida.class);
    	   
    	assertTrue(productlist.getNuevos().get(0).getTitle().equals("Sky 100"));
    	
    }
    
    /**
     * Metodo que ejecutara la prueba unitaria correspondiente a la invocacion de la URL "/products/N" (Solo los Productos Nuevos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductNew() throws Exception {
    	
    	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/N").accept(MediaType.APPLICATION_JSON))
    			.andReturn();
        	
    	int status = mvcResult.getResponse().getStatus();
    	   
    	assertEquals(200, status);
    	   
    	String content = mvcResult.getResponse().getContentAsString();
    	   
    	ListaProductosSalida productlist = this.mapFromJson(content, ListaProductosSalida.class);
    	   
    	assertTrue(productlist.getNuevos().get(0).getTitle().equals("Sky 100"));
    	
    }
    
    /**
     * Metodo que ejecutara la prueba unitaria correspondiente a la invocacion de la URL "/products/getByItemCondition/N" (Solo los Productos Nuevos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemConditionNew() throws Exception {
    	
    	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition/N").accept(MediaType.APPLICATION_JSON))
    			.andReturn();
        	
    	int status = mvcResult.getResponse().getStatus();
    	   
    	assertEquals(200, status);
    	   
    	String content = mvcResult.getResponse().getContentAsString();
    	   
    	ListaProductosSalida productlist = this.mapFromJson(content, ListaProductosSalida.class);
    	   
    	assertTrue(productlist.getNuevos().get(0).getTitle().equals("Sky 100"));
    	
    }
    
    /**
     * Metodo que ejecutara la prueba unitaria correspondiente a la invocacion de la URL "/products/U" (Solo los Productos Usados)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductUsed() throws Exception {
    	
    	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/U").accept(MediaType.APPLICATION_JSON))
    			.andReturn();
        	
    	int status = mvcResult.getResponse().getStatus();
    	   
    	assertEquals(200, status);
    	   
    	String content = mvcResult.getResponse().getContentAsString();
    	   
    	ListaProductosSalida productlist = this.mapFromJson(content, ListaProductosSalida.class);
    	   
    	assertTrue(productlist.getUsed().get(0).getTitle().equals("San Ignacio 999 / Metro Parque Ohiggins"));
    	
    }
    
    /**
     * Metodo que ejecutara la prueba unitaria correspondiente a la invocacion de la URL "/products/getByItemCondition/U" (Solo los Productos Usados)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemConditionUsed() throws Exception {
    	
    	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition/U").accept(MediaType.APPLICATION_JSON))
    			.andReturn();
        	
    	int status = mvcResult.getResponse().getStatus();
    	   
    	assertEquals(200, status);
    	   
    	String content = mvcResult.getResponse().getContentAsString();
    	   
    	ListaProductosSalida productlist = this.mapFromJson(content, ListaProductosSalida.class);
    	   
    	assertTrue(productlist.getUsed().get(0).getTitle().equals("San Ignacio 999 / Metro Parque Ohiggins"));
    	
    }
    
    /**
     * Metodo que ejecutara la prueba unitaria correspondiente a la invocacion de la URL "/products/getByItemCondition/A" (Productos Ni Nuevos Ni Usados)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemConditionNorNewNorUsed() throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition/A"))
			.andExpect(MockMvcResultMatchers.status().is5xxServerError())
			.andExpect(jsonPath("$.message").value("Ha Ocurrido un Error al Procesar la Peticion: java.lang.Exception: Debe Ingresar N para Nuevo o U para Usado"));
    	
    }
    
}