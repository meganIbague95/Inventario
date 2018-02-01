package com.inventario.esquema;

import java.io.Serializable;

public class TipoProducto implements Serializable {
	private Integer idTipo;
	private String nombre;
	public TipoProducto(Integer idTipo, String nombre) {
		this.idTipo = idTipo;
		this.nombre = nombre;
	}
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return nombre;
	}
	
	

}
