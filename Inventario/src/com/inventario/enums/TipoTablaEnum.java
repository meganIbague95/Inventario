package com.inventario.enums;

public enum TipoTablaEnum {
MARCA("MARCA","idMarca"),CATEGORIA("CATEGORIA","idCategoria"),TAMANIO("TAMANIO","idTamanio"), ORIGEN("ORIGEN","idOrigen"), TIPO("TIPOPRODUCTO","idTipoProducto"), TIPOINVENTARIO("TIPOINVENTARIO","idtipoInventario");
	
	private String nombreTabla;
	private String nombreColumna;
	private TipoTablaEnum(String nombreTabla, String nombreColumna) {
		this.nombreTabla = nombreTabla;
		this.nombreColumna = nombreColumna;
	}
	public String getNombreTabla() {
		return nombreTabla;
	}
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	public String getNombreColumna() {
		return nombreColumna;
	}
	public void setNombreColumna(String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}
	
}
