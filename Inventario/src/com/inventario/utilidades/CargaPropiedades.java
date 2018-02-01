package com.inventario.utilidades;

import java.util.ResourceBundle;

public class CargaPropiedades {
	private ResourceBundle propiedadesBD;
	
	public CargaPropiedades() {
	propiedadesBD = ResourceBundle.getBundle(Constantes.ARCHIVO_PROPIEDADES_DB); 
	}

	public ResourceBundle getPropiedadesBD() {
		return propiedadesBD;
	}

	public void setPropiedadesBD(ResourceBundle propiedadesBD) {
		this.propiedadesBD = propiedadesBD;
	}

}
