package com.inventario.esquema;

import java.io.Serializable;

public class Marca implements Serializable{
	private Integer idMarca;
	private String nombreMarca;
	public Marca(int idMarca, String nombreMarca) {
		this.idMarca = idMarca;
		this.nombreMarca = nombreMarca;
	}
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	@Override
	public String toString() {
		return nombreMarca;
	}
	

}
