package com.inventario.esquema;

import java.math.BigDecimal;

public class InventarioPeriodico {
	private Integer idInventarioPeriodico;
	private Integer cantidad;
	private Integer idProducto;
	private Integer idinventario;
	private BigDecimal precioVenta;
	public InventarioPeriodico(Integer idInventarioPeriodico, Integer cantidad, Integer idProducto,
			Integer idinventario, BigDecimal precioVenta) {
		this.idInventarioPeriodico = idInventarioPeriodico;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.idinventario = idinventario;
		this.precioVenta = precioVenta;
	}
	
	public InventarioPeriodico(Integer cantidad, Integer idProducto,
			Integer idinventario, BigDecimal precioVenta) {
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.idinventario = idinventario;
		this.precioVenta = precioVenta;
	}
	public Integer getIdInventarioPeriodico() {
		return idInventarioPeriodico;
	}
	public void setIdInventarioPeriodico(Integer idInventarioPeriodico) {
		this.idInventarioPeriodico = idInventarioPeriodico;
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
	public Integer getIdinventario() {
		return idinventario;
	}
	public void setIdinventario(Integer idinventario) {
		this.idinventario = idinventario;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
	
	
	

}
