package com.inventario.interfaz;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.inventario.controlador.ControladorInventario;
import com.inventario.enums.TipoTablaEnum;
import com.inventario.negocio.NegocioInventario;
import com.inventario.utilidades.ConstantesInterfaz;

public class DialogCrearObjeto extends JDialog{
	private JLabel lblObjeto;
	private JComboBox<TipoTablaEnum> boxTipoTabla;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnCrear;
	private JButton btnCerrar;
	private ControladorInventario controlador;
	private NegocioInventario negocioInventario=new NegocioInventario();
	public DialogCrearObjeto(ControladorInventario controladorInventario) {
		setSize(600, 400);
		setResizable(false);
		setLayout(null);
		setTitle("Crear parametrización");
		setLocationRelativeTo(null);
		this.controlador=controladorInventario;
		inicializarComponentes();
	}
	public void inicializarComponentes(){
		lblObjeto= new JLabel("Tipo de objeto:");
		lblObjeto.setBounds(50,50,100,25);

		boxTipoTabla= new JComboBox<TipoTablaEnum>();
		boxTipoTabla.setBounds(150, 50, 100, 25);
		
		for (TipoTablaEnum tipoTabla : TipoTablaEnum.values()) {
			boxTipoTabla.addItem(tipoTabla);
		}			
		
		lblNombre= new JLabel("Nombre");
		lblNombre.setBounds(50,100,100,25);
		
		txtNombre= new JTextField();
		txtNombre.setBounds(150, 100, 100, 25);
		
		btnCrear= new JButton("Crear");
		btnCrear.setBounds(120, 150, 100, 25);
		btnCrear.addActionListener(this.controlador);
		btnCrear.setActionCommand(ConstantesInterfaz.CREAR_OBJETO);


		btnCerrar= new JButton("Cerrar");
		btnCerrar.setBounds(250, 150, 100, 25);
		btnCerrar.addActionListener(this.controlador);
		btnCerrar.setActionCommand(ConstantesInterfaz.CERRAR);
			
		this.add(lblObjeto);
		this.add(boxTipoTabla);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(btnCrear);
		this.add(btnCerrar);

		}
	
	public JComboBox<TipoTablaEnum> getBoxTipoTabla() {
		return boxTipoTabla;
	}
	public void setBoxTipoTabla(JComboBox<TipoTablaEnum> boxTipoTabla) {
		this.boxTipoTabla = boxTipoTabla;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JButton getBtnCrear() {
		return btnCrear;
	}
	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}
	public JButton getBtnCerrar() {
		return btnCerrar;
	}
	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	
}
