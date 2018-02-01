package com.inventario.esquema;

import java.io.Serializable;

public class Perfil implements Serializable{
	private int idPerfil;
	private String nombre;
	private String descripcion;
	
	public Perfil(int idPerfil, String nombre, String descripcion) {
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Perfil(int idPerfil, String nombre) {
		this.idPerfil = idPerfil;
		this.nombre = nombre;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	

}
