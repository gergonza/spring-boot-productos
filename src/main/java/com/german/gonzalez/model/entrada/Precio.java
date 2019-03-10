package com.german.gonzalez.model.entrada;

import java.io.Serializable;

/**
 * Clase que representa el precio de los Productos del API JSON
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
public class Precio implements Serializable {

	private static final long serialVersionUID = 1L;

	private String currency_id;
	
	private String currency_symbol;
	
	private double amount;
	
	private String decimal_separator;
	
	private String thousands_separator;
	
	private long decimal_places;

	public String getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}

	public String getCurrency_symbol() {
		return currency_symbol;
	}

	public void setCurrency_symbol(String currency_symbol) {
		this.currency_symbol = currency_symbol;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDecimal_separator() {
		return decimal_separator;
	}

	public void setDecimal_separator(String decimal_separator) {
		this.decimal_separator = decimal_separator;
	}

	public String getThousands_separator() {
		return thousands_separator;
	}

	public void setThousands_separator(String thousands_separator) {
		this.thousands_separator = thousands_separator;
	}

	public long getDecimal_places() {
		return decimal_places;
	}

	public void setDecimal_places(long decimal_places) {
		this.decimal_places = decimal_places;
	}
	
}