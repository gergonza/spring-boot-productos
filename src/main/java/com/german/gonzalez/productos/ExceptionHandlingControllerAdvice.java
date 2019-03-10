package com.german.gonzalez.productos;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controlador para Ejecutar una Accion en Particular en caso de que ocurra una Excepcion
 * La Anotacion @ControllerAdvice indica que es un Controlador que establece un comportamiento global del sistema en caso de ocurrir algun evento
 * @author German Gonzalez
 * @since 10-03-2019
 * @version 1.0.0
 *
 */
@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

	/**
	 * Metodo para la accion definida del Sistema en caso de que ocurra una Excepcion (omitiendo el comportamiento por defecto y personalizando la gestion del lanzamiento de las excepciones)
	 * La Anotacion @ExceptionHandler indica que este metodo es activado por Spring Boot como el Bean responsable de disparar la Excepcion relacionada como parametro
	 * @author German Gonzalez
	 * @since 10-03-2019
	 * @version 1.0.0
	 * @param ex Objeto Exception que representa la excepcion lanzada
	 * @return ResponseEntity<String> Objeto ResponseEntity<String> que representa el Objeto que contiene la informacion establecida por el @ControllerAdvice
	 *
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleExecutionException(Exception ex) {
		return response("Error Interno", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Metodo para crear el String con el mensaje que sera lanzado cuando ocurra la excepcion con la informacion necesaria
	 * @author German Gonzalez
	 * @since 10-03-2019
	 * @version 1.0.0
	 * @param message Objeto String que representa el tipo de mensaje asociado a la excepcion lanzada
	 * @param reason Objeto String que representa el contenido vinculado al mensaje asociado a la excepcion lanzada
	 * @return String Objeto String que representa el mensaje construido con la informacion de la excepcion
	 *
	 */
	private static String createJson(String message, String reason) {
		return "{\"error\" : \"" + message + "\"," +
			   "\"date\" : \"" + new Date()  + "\"," +
			   "\"reason\" : \"" + reason  + "\"}";
	}

	/**
	 * Metodo para crear el Objeto Response con el JSON que sera lanzado cuando ocurra la excepcion con la informacion necesaria
	 * @author German Gonzalez
	 * @since 10-03-2019
	 * @version 1.0.0
	 * @param message Objeto String que representa el mensaje asociado a la excepcion lanzada
	 * @param reason Objeto String que representa el contenido vinculado al mensaje asociado a la excepcion lanzada
	 * @param httpStatus Objeto HttpStatus que representa el codigo HTTP a devolver cuando ocurra la excepcion 
	 * @return ResponseEntity<String> Objeto ResponseEntity<String> que representa el Objeto JSON construido con la informacion de la excepcion
	 *
	 */
	private static ResponseEntity<String> response(String message,
                                               String reason,
                                               HttpStatus httpStatus) {
	   
		String json = createJson(message, reason);
    
		return new ResponseEntity<>(json, httpStatus);
   
	}

}