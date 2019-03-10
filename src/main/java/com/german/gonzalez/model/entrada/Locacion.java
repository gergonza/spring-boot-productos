package com.german.gonzalez.model.entrada;

import java.io.Serializable;

/**
 * Clase que representa la localizacion de los Productos del API JSON
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
public class Locacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Dato country;
	
	private Dato state;
	
	private Dato city;
	
	private Dato neighborhood;
	
	private String address_line;
	
	private String zip_code;
	
	private double latitude;
	
	private double longitude;

	public Dato getCountry() {
		return country;
	}

	public void setCountry(Dato country) {
		this.country = country;
	}

	public Dato getState() {
		return state;
	}

	public void setState(Dato state) {
		this.state = state;
	}

	public Dato getCity() {
		return city;
	}

	public void setCity(Dato city) {
		this.city = city;
	}

	public Dato getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Dato neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getAddress_line() {
		return address_line;
	}

	public void setAddress_line(String address_line) {
		this.address_line = address_line;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}