package com.inventario.esquema;

import java.math.BigDecimal;
import java.sql.Date;

public class Entrada {
	private Integer idEntrada;
	private Integer cantidad;
	private BigDecimal precioEntrada;
	private Integer idProducto;
	private Date fechaCreacion;
	public Entrada(Integer idEntrada, Integer cantidad, BigDecimal precioEntrada, Integer idProducto, Date fechaCreacion) {
		this.idEntrada = idEntrada;
		this.cantidad = cantidad;
		this.precioEntrada = precioEntrada;
		this.idProducto = idProducto;
		this.fechaCreacion=fechaCreacion;
	}
	public Integer getIdEntrada() {
		return idEntrada;
	}
	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioEntrada() {
		return precioEntrada;
	}
	public void setPrecioEntrada(BigDecimal precioEntrada) {
		this.precioEntrada = precioEntrada;
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
		return "Entrada [idEntrada=" + idEntrada + ", cantidad=" + cantidad + ", precioEntrada=" + precioEntrada
				+ ", idProducto=" + idProducto + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	

}
