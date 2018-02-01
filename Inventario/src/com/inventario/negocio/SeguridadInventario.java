package com.inventario.negocio;

import com.inventario.esquema.Usuario;
import com.inventario.logs.ManejoLogs;
import com.inventario.transaccionesbd.TransaccionesDAO;
import com.inventario.utilidades.Utilidades;

public class SeguridadInventario {
	private TransaccionesDAO dao;
	private ManejoLogs log = new ManejoLogs(SeguridadInventario.class);

	public SeguridadInventario() {
		try {
			dao = new TransaccionesDAO();
		} catch (Exception e) {
			log.escribirError("Error al instanciar dao", e);
		}
	}

	public Boolean validarUsuario(String usuario, String contrasenia) throws Exception {
		Boolean validarUsuario= Boolean.TRUE;
		String contraseniaEncriptada = Utilidades.encriptarContrasenia(contrasenia);
		Usuario usuarioLogueo = null;

		usuarioLogueo = dao.consultarUsuarioSeguridad(usuario);
		if (usuarioLogueo == null) {
			throw new Exception("El usuario no existe en el sistema");
		}
		if (!contraseniaEncriptada.equals(usuarioLogueo.getContraseña())) {
			throw new Exception("Contraseña inválida");
		}

		return validarUsuario;
	}

	public void crearUsuario(Usuario usuario) throws Exception {
		String contraseniaEncriptada = Utilidades.encriptarContrasenia(usuario.getContraseña());
		usuario.setContraseña(contraseniaEncriptada);
		dao.insertarUsuario(usuario);
	}

	public Boolean compararContrasenia(String contrasenia, String contraseniaVerificada) {
		return contrasenia.equals(contraseniaVerificada);
	}
}
