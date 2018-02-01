package com.inventario.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.inventario.interfaz.DialogLogin;
import com.inventario.negocio.SeguridadInventario;
import com.inventario.utilidades.ConstantesInterfaz;

public class ControladorSeguridad implements ActionListener {
	private SeguridadInventario si;
	private DialogLogin login;

	public ControladorSeguridad(DialogLogin login) {
		this.login=login;
		si= new SeguridadInventario();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if( e.getActionCommand().equals(ConstantesInterfaz.INGRESAR)){
			
				if(si.validarUsuario(login.getTxtUsuario().getText(),login.getTxtContrasenia().getText())){
					JOptionPane.showMessageDialog(null, "Usuario correcto","Autenticación",JOptionPane.INFORMATION_MESSAGE);
				}
			
		}
		else if( e.getActionCommand().equals(ConstantesInterfaz.CERRAR)){
			System.out.println("holaaa");
		}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),"Error autenticación",JOptionPane.ERROR_MESSAGE);
		}
	}

}
