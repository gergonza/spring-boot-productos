package com.german.gonzalez.model.entrada;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa el Producto proveniente del API de Entrada JSON
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
public class ProductoEntrada implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String title;
	
	private String permalink;
	
	private String picture;
	
	private Precio price;
	
	private String buying_mode;
	
	private List<AtributoEntrada> attributes;
	
	private Locacion location;

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

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Precio getPrice() {
		return price;
	}

	public void setPrice(Precio price) {
		this.price = price;
	}

	public String getBuying_mode() {
		return buying_mode;
	}

	public void setBuying_mode(String buying_mode) {
		this.buying_mode = buying_mode;
	}

	public List<AtributoEntrada> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AtributoEntrada> attributes) {
		this.attributes = attributes;
	}

	public Locacion getLocation() {
		return location;
	}

	public void setLocation(Locacion location) {
		this.location = location;
	}
	
}