package com.inventario.esquema;

import java.io.Serializable;

public class Tamanio implements Serializable{
	private Integer idTamanio;
	private String nombre;
	public Tamanio(Integer idTamanio, String nombre) {
		this.idTamanio = idTamanio;
		this.nombre = nombre;
	}
	public Integer getIdTamanio() {
		return idTamanio;
	}
	public void setIdTamanio(Integer idTamanio) {
		this.idTamanio = idTamanio;
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
