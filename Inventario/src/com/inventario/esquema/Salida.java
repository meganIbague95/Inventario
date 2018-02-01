package com.inventario.esquema;

import java.sql.Date;

public class Salida {
	private Integer idSalida;
	private Integer cantidad;
	private Integer idProducto;
	private Date fechaCreacion;
	public Salida(Integer idSalida, Integer cantidad, Integer idProducto, Date fechaCreacion) {
		this.idSalida = idSalida;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.fechaCreacion=fechaCreacion;
	}
	public Integer getIdSalida() {
		return idSalida;
	}
	public void setIdSalida(Integer idSalida) {
		this.idSalida = idSalida;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	@Override
	public String toString() {
		return "Salida [idSalida=" + idSalida + ", cantidad=" + cantidad + ", idProducto=" + idProducto
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	
	
}
