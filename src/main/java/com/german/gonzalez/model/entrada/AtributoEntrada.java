package com.german.gonzalez.model.entrada;

import java.io.Serializable;

/**
 * Clase que representa los Atributos de Entrada proveniente del API JSON
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
public class AtributoEntrada implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	private String value_id;
	
	private String value_name;
	
	private String attribute_group_id;
	
	private String attribute_group_name;

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

	public String getValue_id() {
		return value_id;
	}

	public void setValue_id(String value_id) {
		this.value_id = value_id;
	}

	public String getValue_name() {
		return value_name;
	}

	public void setValue_name(String value_name) {
		this.value_name = value_name;
	}

	public String getAttribute_group_id() {
		return attribute_group_id;
	}

	public void setAttribute_group_id(String attribute_group_id) {
		this.attribute_group_id = attribute_group_id;
	}

	public String getAttribute_group_name() {
		return attribute_group_name;
	}

	public void setAttribute_group_name(String attribute_group_name) {
		this.attribute_group_name = attribute_group_name;
	}

}