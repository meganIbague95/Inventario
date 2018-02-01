package com.inventario.esquema;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable{
	
	private String nombre;
	private String contrasenia;
	private Date ultimoIngreso;
	private String estado;
	private Integer numeroIngreso;
	private Integer intentosFallidos;
	private Perfil perfil;
	private Persona persona;
	
	
	public Usuario(String nombre, String contrasenia, Perfil perfil) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.perfil = perfil;
	}
	public Usuario(String nombre, String contraseña, Date ultimoIngreso, String estado, Integer numeroIngreso,
			Integer intentosFallidos, Perfil perfil, Persona persona) {
		this.nombre = nombre;
		this.contrasenia = contraseña;
		this.ultimoIngreso = ultimoIngreso;
		this.estado = estado;
		this.numeroIngreso = numeroIngreso;
		this.intentosFallidos = intentosFallidos;
		this.perfil = perfil;
		this.persona = persona;
	}
	public Usuario(String nombre, String estado, int intentosFallidos, Perfil perfil, Persona persona){
		this.nombre = nombre;
		this.estado = estado;
		this.intentosFallidos = intentosFallidos;
		this.perfil = perfil;
		this.persona = persona;
	}
	public Usuario(String contrasenia){
		this.contrasenia=contrasenia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contrasenia;
	}
	public void setContraseña(String contraseña) {
		this.contrasenia = contraseña;
	}
	public Date getUltimoIngreso() {
		return ultimoIngreso;
	}
	public void setUltimoIngreso(Date ultimoIngreso) {
		this.ultimoIngreso = ultimoIngreso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getNumeroIngreso() {
		return numeroIngreso;
	}
	public void setNumeroIngreso(Integer numeroIngreso) {
		this.numeroIngreso = numeroIngreso;
	}
	public Integer getIntentosFallidos() {
		return intentosFallidos;
	}
	public void setIntentosFallidos(Integer intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasenia=" + contrasenia + ", ultimoIngreso=" + ultimoIngreso
				+ ", estado=" + estado + ", numeroIngreso=" + numeroIngreso + ", intentosFallidos=" + intentosFallidos
				+ ", perfil=" + perfil + ", persona=" + persona + "]";
	}
	
	

}
