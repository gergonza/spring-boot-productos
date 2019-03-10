package com.german.gonzalez.model.salida;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Clase que representa los Productos de Salida otorgados por el Sistema
 * La Anotacion @JsonInclude indica que campos seran incluidos en el JSON de Salida, en este caso, no se incluyen los objetos nulos
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
@JsonInclude(Include.NON_NULL)
public class ListaProductosSalida implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("new")
	private List<ProductoSalida> nuevos;
	
	private List<ProductoSalida> used;
	
	public List<ProductoSalida> getNuevos() {
		return nuevos;
	}

	public void setNuevos(List<ProductoSalida> nuevos) {
		this.nuevos = nuevos;
	}

	public List<ProductoSalida> getUsed() {
		return used;
	}
	
	public void setUsed(List<ProductoSalida> used) {
		this.used = used;
	}
	
}