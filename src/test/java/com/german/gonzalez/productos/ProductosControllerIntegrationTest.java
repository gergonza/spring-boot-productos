package com.german.gonzalez.productos;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
public class ProductosControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private ProductosController productosController;
    
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
    }

    /**
     * Metodo que ejecutara la prueba de integracion correspondiente a la invocacion de la URL "/products" (Todos los Productos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProduct() throws Exception {
        
    	mvc.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk())
        	.andExpect(jsonPath("$.*.*.title", hasItem(equalTo("San Ignacio 999 / Metro Parque Ohiggins"))))
        	.andDo(print());
    	
    }
    
    /**
     * Metodo que ejecutara la prueba de integracion correspondiente a la invocacion de la URL "/products/getByItemCondition" (Todos los Productos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemCondition() throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition").accept(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.*.*.title", hasItem(equalTo("San Ignacio 999 / Metro Parque Ohiggins"))))
    		.andDo(print());
    	
    }
    
    /**
     * Metodo que ejecutara la prueba de integracion correspondiente a la invocacion de la URL "/products/getByItemCondition/" (Todos los Productos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemConditionSlash() throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition/").accept(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.*.*.title", hasItem(equalTo("San Ignacio 999 / Metro Parque Ohiggins"))))
    		.andDo(print());
    	
    }
    
    /**
     * Metodo que ejecutara la prueba de integracion correspondiente a la invocacion de la URL "/products/N" (Solo los Productos Nuevos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductNew() throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders.get("/products/N").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.*.*.title", hasItem(equalTo("Condominio Ecoterraneo"))))
			.andDo(print());
    	
    }
    
    /**
     * Metodo que ejecutara la prueba de integracion correspondiente a la invocacion de la URL "/products/getByItemCondition/N" (Solo los Productos Nuevos)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemConditionNew() throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition/N").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.*.*.title", hasItem(equalTo("Condominio Ecoterraneo"))))
			.andDo(print());
    	
    }
    
    /**
     * Metodo que ejecutara la prueba de integracion correspondiente a la invocacion de la URL "/products/U" (Solo los Productos Usados)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductUsed() throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders.get("/products/U").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.*.*.title", hasItem(equalTo("San Ignacio 999 / Metro Parque Ohiggins"))))
			.andDo(print());
    	
    }
    
    /**
     * Metodo que ejecutara la prueba de integracion correspondiente a la invocacion de la URL "/products/getByItemCondition/U" (Solo los Productos Usados)
     * @author German Gonzalez
     * @since 10-03-2019
     * @version 1.0.0
     * @throws Exception
     *
     */
    @Test
    public void getProductByItemConditionUsed() throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders.get("/products/getByItemCondition/U").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.*.*.title", hasItem(equalTo("San Ignacio 999 / Metro Parque Ohiggins"))))
			.andDo(print());
    	
    }
    
    /**
     * Metodo que ejecutara la prueba de integracion correspondiente a la invocacion de la URL "/products/getByItemCondition/A" (Productos Ni Nuevos Ni Usados)
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
			.andExpect(jsonPath("$.reason").value("Ha Ocurrido un Error al Procesar la Peticion: java.lang.Exception: Debe Ingresar N para Nuevo o U para Usado"));
    	
    }
    
}