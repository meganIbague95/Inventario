package com.inventario.interfaz;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.inventario.controlador.ControladorSeguridad;
import com.inventario.utilidades.ConstantesInterfaz;

public class DialogLogin extends JDialog{
	private JLabel lblUsuario;
	private JLabel lblConstrasenia;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private JButton btnIngresar;
	private JButton btnCerrar;
	private ControladorSeguridad controlador;
	public DialogLogin() {
		this.controlador=new ControladorSeguridad(this);
		setSize(600, 400);
		setResizable(false);
		setLayout(null);
		setTitle("Iniciar Sesion");
		setLocationRelativeTo(null);
		inicializarComponentes();


	}

	public void inicializarComponentes(){
		lblUsuario= new JLabel("Usuario");
		lblUsuario.setBounds(200,100,100,25);

		txtUsuario= new JTextField();
		txtUsuario.setBounds(300, 100, 100, 25);

		lblConstrasenia= new JLabel("Contraseña");
		lblConstrasenia.setBounds(200,150,100,25);

		txtContrasenia= new JPasswordField();
		txtContrasenia.setBounds(300, 150, 100, 25);

		btnIngresar= new JButton("Ingresar");
		btnIngresar.setBounds(180, 200, 100, 25);
		btnIngresar.addActionListener(this.controlador);
		btnIngresar.setActionCommand(ConstantesInterfaz.INGRESAR);


		btnCerrar= new JButton("Cerrar");
		btnCerrar.setBounds(300, 200, 100, 25);
		btnCerrar.addActionListener(this.controlador);
		btnCerrar.setActionCommand(ConstantesInterfaz.CERRAR);
		this.add(lblUsuario);
		this.add(txtUsuario);
		this.add(lblConstrasenia);
		this.add(txtContrasenia);
		this.add(btnIngresar);
		this.add(btnCerrar);
		
	}
	
	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JTextField getTxtContrasenia() {
		return txtContrasenia;
	}

	public void setTxtContrasenia(JPasswordField txtContrasenia) {
		this.txtContrasenia = txtContrasenia;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public static void main(String[] args) {
		DialogLogin login= new DialogLogin();
		login.setVisible(true);
	}
}
