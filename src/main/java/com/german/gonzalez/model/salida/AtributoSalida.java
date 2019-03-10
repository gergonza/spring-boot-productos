package com.german.gonzalez.model.salida;

import java.io.Serializable;

/**
 * Clase que representa los Atributos de Salida otorgados por el Sistema
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
public class AtributoSalida implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	private String value_name;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue_name() {
		return value_name;
	}
	
	public void setValue_name(String value_name) {
		this.value_name = value_name;
	}
	
}