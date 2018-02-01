package com.inventario.esquema;

import java.io.Serializable;
import java.util.Date;

public class Bitacora implements Serializable {
	private int idBitacora;
	private String accion;
	private String tabla;
	private String usuario;
	private Date fechaCreacion;
	public Bitacora(int idBitacora, String accion, String tabla,Date fechaCreacion, String usuario) {
		this.idBitacora = idBitacora;
		this.accion = accion;
		this.tabla = tabla;
		this.usuario = usuario;
		this.fechaCreacion=fechaCreacion;
	}
	public int getIdBitacora() {
		return idBitacora;
	}
	public void setIdBitacora(int idBitacora) {
		this.idBitacora = idBitacora;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	@Override
	public String toString() {
		return "Bitacora [idBitacora=" + idBitacora + ", accion=" + accion + ", tabla=" + tabla + ", usuario=" + usuario
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}
	
}
