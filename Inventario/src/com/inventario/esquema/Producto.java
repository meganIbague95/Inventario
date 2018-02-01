package com.inventario.esquema;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Producto implements Serializable{
	private Integer idProducto;
	private String nombreProducto;
	private Categoria categoria;
	private String genero;
	private TipoProducto tipo;
	private Marca marca;
	private Tamanio tamanio;
	private Origen origen;
	private Integer cantidad;
	private BigDecimal precioCompra;
	private BigDecimal precioVenta;
	public Producto(String nombreProducto, Categoria categoria, String genero, TipoProducto tipo,Marca marca,
			BigDecimal precioCompra, Tamanio tamanio, Integer idProducto, Origen origen, Integer cantidad,BigDecimal precioVenta) {
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.genero = genero;
		this.tipo = tipo;
		this.marca=marca;
		this.precioCompra = precioCompra;
		this.tamanio = tamanio;
		this.idProducto=idProducto;
		this.origen=origen;
		this.cantidad=cantidad;
		this.precioVenta=precioVenta;
	}
	public Producto(String nombreProducto, Categoria categoria, String genero, TipoProducto tipo,Marca marca,
			BigDecimal precioCompra, Tamanio tamanio, Origen origen, Integer cantidad, BigDecimal precioVenta) {
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.genero = genero;
		this.tipo = tipo;
		this.marca=marca;
		this.precioCompra = precioCompra;
		this.tamanio = tamanio;
		this.origen=origen;
		this.cantidad=cantidad;
		this.precioVenta=precioVenta;
	}
	
	public Producto(Categoria categoria, String genero, TipoProducto tipo, Marca marca, Tamanio tamanio, Origen origen) {
		super();
		this.categoria = categoria;
		this.genero = genero;
		this.tipo = tipo;
		this.marca = marca;
		this.tamanio = tamanio;
		this.origen = origen;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public TipoProducto getTipo() {
		return tipo;
	}
	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Tamanio getTamanio() {
		return tamanio;
	}
	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}
	public Origen getOrigen() {
		return origen;
	}
	public void setOrigen(Origen origen) {
		this.origen = origen;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	@Override
	public String toString() {
		return "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", categoria=" + categoria
				+ ", genero=" + genero + ", tipo=" + tipo + ", marca=" + marca + ", tamanio=" + tamanio + ", origen="
				+ origen + ", cantidad=" + cantidad + ", precioCompra=" + precioCompra;
	}
	
	
}
