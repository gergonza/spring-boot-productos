package com.german.gonzalez.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Componente Core que Inicia el Sistema y Levanta todos los Beans Asociados
 * La Anotacion @SpringBootApplication indica que este componente es el responsable de levantar todos los componentes, configuraciones y dependencias del Sistema
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
@SpringBootApplication
public class Application {

	/**
	 * Metodo Core que Inicia el Sistema y Levanta todos los Beans Asociados
	 * @author German Gonzalez
	 * @since 09-03-2019
	 * @version 1.0.0
	 * @param args Objeto String[] con el arreglo de parametros de consola necesarios para inicial el Sistema
	 *
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}