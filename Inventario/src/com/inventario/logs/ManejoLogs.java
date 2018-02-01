package com.inventario.logs;

import org.apache.log4j.Logger;

public class ManejoLogs {

	private Logger log;

	public ManejoLogs(Class<?> clase) {
		log = Logger.getLogger(clase);
	}

	public void escribirInfo(String mensaje) {
		log.info(mensaje);
	}

	public void escribirError(String error, Exception e) {
		log.error(error, e);
	}

	public void escribirError(String error) {
		log.error(error);
	}
}
