package com.german.gonzalez.model.salida;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa el Productos de Salida otorgados por el Sistema
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
public class ProductoSalida implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String title;
	
	private List<AtributoSalida> attributes;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<AtributoSalida> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(List<AtributoSalida> attributes) {
		this.attributes = attributes;
	}
	
}