package com.inventario.enums;

public enum TipoInventarioEnum {
LOCAL,BODEGA;
	
	public static TipoInventarioEnum convertirTipo(String tipo){
		TipoInventarioEnum tipoInventario=null;
		if(tipo.equalsIgnoreCase(LOCAL.name())){
			tipoInventario=LOCAL;
		}else if(tipo.equalsIgnoreCase(BODEGA.name())){
			tipoInventario=BODEGA;
		}
		return tipoInventario;
	}
}
