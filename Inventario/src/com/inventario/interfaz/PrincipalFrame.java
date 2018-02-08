package com.inventario.interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
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
	private JMenuItem consultarInventario;
	private JButton btnCrearProducto;
	private JButton btnCrearParametrizacion;
	private JButton btnConsultarProductos;
	private JButton btnCrearInventario;
	private JButton btnConsultarInventario;
	private JButton btnSalir;
	private ControladorInventario controlador;
	public PrincipalFrame() {
		setSize(570,250);
		setLayout(null);
		setTitle("Principal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.controlador=new ControladorInventario(this);
		
		menu = new JMenuBar();
		menu.setBounds(0, 0, 570, 20);
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
		consultarInventario= new JMenuItem("Consultar Inventario");
		consultarInventario.addActionListener(controlador);
		consultarInventario.setActionCommand(ConstantesInterfaz.CONSULTAR_INVENTARIO);
		
		btnCrearProducto= new JButton("Crear Producto");
		btnCrearProducto.setBounds(30, 50,150,50);
		btnCrearProducto.addActionListener(controlador);
		btnCrearProducto.setActionCommand(ConstantesInterfaz.INSERTAR_PRODUCTO);		
		btnCrearParametrizacion= new JButton("Crear Parametrización");
		btnCrearParametrizacion.setBounds(190, 50,180,50);
		btnCrearParametrizacion.addActionListener(controlador);
		btnCrearParametrizacion.setActionCommand(ConstantesInterfaz.CREAR_PARAMETRIZACION);		
		btnConsultarProductos= new JButton("Consultar productos");
		btnConsultarProductos.setBounds(380, 50,150,50);
		btnConsultarProductos.addActionListener(controlador);
		btnConsultarProductos.setActionCommand(ConstantesInterfaz.CONSULTAR_PRODUCTO);
		btnCrearInventario= new JButton("Crear inventario");
		btnCrearInventario.setBounds(30, 110,150,50);
		btnCrearInventario.addActionListener(controlador);
		btnCrearInventario.setActionCommand(ConstantesInterfaz.CREAR_INVENTARIO);
		btnConsultarInventario= new JButton("Consultar inventario");
		btnConsultarInventario.setBounds(190, 110,180,50);
		btnConsultarInventario.addActionListener(controlador);
		btnConsultarInventario.setActionCommand(ConstantesInterfaz.CONSULTAR_INVENTARIO);
		btnSalir= new JButton("Cerrar");
		btnSalir.setBounds(380, 110,150,50);
		btnSalir.addActionListener(controlador);
		btnSalir.setActionCommand(ConstantesInterfaz.CERRAR_PRINCIPAL);
		
		menu.add(opciones);
		opciones.add(crearProducto);
		
		opciones.add(crearParametrizacion);
		opciones.add(consultarProductos);
		opciones.add(crearInventario);
		opciones.add(consultarInventario);
		this.add(menu);
		this.add(btnCrearProducto);
		this.add(btnCrearParametrizacion);
		this.add(btnConsultarProductos);
		this.add(btnCrearInventario);
		this.add(btnConsultarInventario);
		this.add(btnSalir);
		
	
	}
	public static void main(String[] args) {
		PrincipalFrame principalFrame=new PrincipalFrame();
		principalFrame.setVisible(true);
	}

}
