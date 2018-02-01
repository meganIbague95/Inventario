package com.inventario.interfaz;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.inventario.controlador.ControladorInventario;
import com.inventario.utilidades.ConstantesInterfaz;

public class PrincipalFrame extends JFrame {
	private JMenuBar menu;
	private JMenu opciones;
	private JMenuItem crearProducto;
	private JMenuItem crearParametrizacion;
	private JMenuItem consultarProductos;
	private JMenuItem crearInventario;
	private ControladorInventario controlador;
	public PrincipalFrame() {
		setSize(500,500);
		setLayout(null);
		setTitle("Principal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		
		this.controlador=new ControladorInventario(this);
		
		menu = new JMenuBar();
		menu.setBounds(0, 0, 500, 20);
		opciones= new JMenu("Opciones");
		
		crearProducto= new JMenuItem("Crear Producto");
		crearProducto.addActionListener(controlador);
		crearProducto.setActionCommand(ConstantesInterfaz.INSERTAR_PRODUCTO);
		crearParametrizacion= new JMenuItem("Crear parametrizacion");
		crearParametrizacion.addActionListener(controlador);
		crearParametrizacion.setActionCommand(ConstantesInterfaz.CREAR_PARAMETRIZACION);
		consultarProductos= new JMenuItem("Consultar productos");
		consultarProductos.addActionListener(controlador);
		consultarProductos.setActionCommand(ConstantesInterfaz.CONSULTAR_PRODUCTO);
		crearInventario= new JMenuItem("Crear Inventario");
		crearInventario.addActionListener(controlador);
		crearInventario.setActionCommand(ConstantesInterfaz.CREAR_INVENTARIO);
		
		menu.add(opciones);
		opciones.add(crearProducto);
		
		opciones.add(crearParametrizacion);
		opciones.add(consultarProductos);
		opciones.add(crearInventario);
		this.add(menu);
	
	}
	public static void main(String[] args) {
		PrincipalFrame principalFrame=new PrincipalFrame();
		principalFrame.setVisible(true);
	}

}
