package com.german.gonzalez.model.entrada;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa la Lista de Productos provenientes del API JSON
 * @author German Gonzalez
 * @since 09-03-2019
 * @version 1.0.0
 *
 */
public class ListaProductosEntrada implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ProductoEntrada> results;

	public List<ProductoEntrada> getResults() {
		return results;
	}

	public void setResults(List<ProductoEntrada> results) {
		this.results = results;
	}
	
}