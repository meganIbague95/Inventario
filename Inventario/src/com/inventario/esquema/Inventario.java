package com.inventario.esquema;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

public class Inventario implements Serializable{
	private Integer idInventario;
	private BigDecimal precioVenta;
	private String tipoInventario;
	private Date fechaInventario;
	private Integer idProducto;
	public Inventario(Integer idInventario,BigDecimal precioVenta,String tipoInventario, Date fechaInventario) {
		this.idInventario = idInventario;
		this.precioVenta=precioVenta;
		this.tipoInventario = tipoInventario;
		this.fechaInventario = fechaInventario;
	}
	public Inventario(BigDecimal precioVenta,String tipoInventario, Date fechaInventario) {
		this.precioVenta=precioVenta;
		this.tipoInventario = tipoInventario;
		this.fechaInventario = fechaInventario;
	}
	public Integer getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getTipoInventario() {
		return tipoInventario;
	}
	public void setTipoInventario(String tipoInventario) {
		this.tipoInventario = tipoInventario;
	}
	public Date getFechaInventario() {
		return fechaInventario;
	}
	public void setFechaInventario(Date fechaInventario) {
		this.fechaInventario = fechaInventario;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	@Override
	public String toString() {
		return "Inventario [idInventario=" + idInventario + ", precioVenta=" + precioVenta + ", tipoInventario="
				+ tipoInventario + ", fechaInventario=" + fechaInventario + ", idProducto=" + idProducto + "]";
	}




}
