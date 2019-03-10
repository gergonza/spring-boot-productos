package com.german.gonzalez.model.entrada;

import java.io.Serializable;

/**
 * Clase que representa la data generica del negocio de Producto
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
public class Dato implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;

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
	
}