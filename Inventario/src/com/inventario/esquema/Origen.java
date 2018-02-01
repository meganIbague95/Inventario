package com.inventario.esquema;

import java.io.Serializable;

public class Origen implements Serializable{
	private Integer idOrigen;
	private String nombre;
	public Origen(Integer idOrigen, String nombre) {
		this.idOrigen = idOrigen;
		this.nombre = nombre;
	}
	public Integer getIdOrigen() {
		return idOrigen;
	}
	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return  nombre;
	}
	
	

}
