package com.inventario.interfaz;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.inventario.controlador.ControladorInventario;
import com.inventario.enums.GeneroEnum;
import com.inventario.enums.TipoTablaEnum;
import com.inventario.esquema.Categoria;
import com.inventario.esquema.Marca;
import com.inventario.esquema.Origen;
import com.inventario.esquema.Tamanio;
import com.inventario.esquema.TipoProducto;
import com.inventario.negocio.NegocioInventario;
import com.inventario.utilidades.ConstantesInterfaz;

public class DialogInsertarProducto extends JDialog {
	private JLabel lblNombre;
	private JLabel lblCategoria;
	private JLabel lblTipo;
	private JLabel lblPrecio;
	private JLabel lblTamanio;
	private JLabel lblMarca;
	private JLabel lblGenero;
	private JLabel lblOrigen;
	private JLabel lblCantidad;
	private JLabel lblPrecioVenta;
	private JTextField txtNombre;
	private JComboBox<Categoria> boxCategoria;
	private JComboBox<TipoProducto> boxTipo;
	private JTextField txtPrecio;
	private JComboBox<Tamanio> boxTamanio;
	private JComboBox<Marca> boxMarca;
	private JComboBox<GeneroEnum> boxGenero;
	private JComboBox<Origen> boxOrigen;
	private JTextField txtCantidad;
	private JTextField txtPrecioVenta;
	private JButton btnCrear;
	private JButton btnCerrar;
	private ControladorInventario controlador;
	
	private NegocioInventario negocio=new NegocioInventario();

	public DialogInsertarProducto(ControladorInventario controladorInventario) {
		setSize(600, 400);
		setResizable(false);
		setLayout(null);
		setTitle("Iniciar Sesion");
		setLocationRelativeTo(null);
		this.controlador=controladorInventario;
		inicializarComponentes();
	}
	public void inicializarComponentes(){
		lblNombre= new JLabel("Nombre");
		lblNombre.setBounds(50,50,100,25);

		txtNombre= new JTextField();
		txtNombre.setBounds(140, 50, 100, 25);

		lblCantidad =new JLabel("Cantidad");
		lblCantidad.setBounds(250,50,100,25);
		
		txtCantidad= new JTextField();
		txtCantidad.setBounds(340, 50, 100, 25);
		
		lblPrecio= new JLabel("Precio interno");
		lblPrecio.setBounds(50,100,100,25);

		txtPrecio= new JTextField();
		txtPrecio.setBounds(140, 100, 100, 25);

		lblPrecioVenta= new JLabel("Precio Venta");
		lblPrecioVenta.setBounds(250, 100, 100, 25);
		
		txtPrecioVenta= new JTextField();
		txtPrecioVenta.setBounds(340, 100, 100, 25);
		
		lblCategoria= new JLabel("Categoria");
		lblCategoria.setBounds(50,150,100,25);

		boxCategoria= new JComboBox<Categoria>();
		boxCategoria.setBounds(140, 150, 100, 25);
		for (Object objeto : negocio.listarObjetos(TipoTablaEnum.CATEGORIA)) {
			Categoria categoria = (Categoria)objeto;
			boxCategoria.addItem(categoria);
		}
		
		
		lblTipo= new JLabel("Tipo");
		lblTipo.setBounds(250,150,100,25);

		boxTipo= new JComboBox<TipoProducto>();
		boxTipo.setBounds(340, 150, 100, 25);
		for (Object objeto : negocio.listarObjetos(TipoTablaEnum.TIPO)) {
			TipoProducto tipo = (TipoProducto)objeto;
			boxTipo.addItem(tipo);
		}
		lblTamanio= new JLabel("Tamaño");
		lblTamanio.setBounds(50,200,100,25);

		boxTamanio= new JComboBox<Tamanio>();
		boxTamanio.setBounds(140, 200, 100, 25);
		for (Object objeto : negocio.listarObjetos(TipoTablaEnum.TAMANIO)) {
			Tamanio tamanio = (Tamanio)objeto;
			boxTamanio.addItem(tamanio);
		}
		lblMarca= new JLabel("Marca");
		lblMarca.setBounds(250,200,100,25);

		boxMarca= new JComboBox<Marca>();
		boxMarca.setBounds(340, 200, 100, 25);
		for (Object objeto : negocio.listarObjetos(TipoTablaEnum.MARCA)) {
			Marca marca = (Marca)objeto;
			boxMarca.addItem(marca);
		}
		
		
		
		lblGenero= new JLabel("Genero");
		lblGenero.setBounds(50,250,100,25);

		boxGenero= new JComboBox<GeneroEnum>();
		boxGenero.setBounds(140, 250, 100, 25);
		boxGenero.addItem(GeneroEnum.MUJER);
		boxGenero.addItem(GeneroEnum.HOMBRE);
		boxGenero.addItem(GeneroEnum.NIÑA);
		boxGenero.addItem(GeneroEnum.NIÑO);

		lblOrigen= new JLabel("Origen");
		lblOrigen.setBounds(250,250,100,25);

		boxOrigen= new JComboBox<Origen>();
		boxOrigen.setBounds(340, 250, 100, 25);
		for (Object objeto : negocio.listarObjetos(TipoTablaEnum.ORIGEN)) {
			Origen origen = (Origen)objeto;
			boxOrigen.addItem(origen);
		}
		
		
		btnCrear= new JButton("Crear");
		btnCrear.setBounds(150, 300, 100, 25);
		btnCrear.addActionListener(this.controlador);
		btnCrear.setActionCommand(ConstantesInterfaz.CREAR);


		btnCerrar= new JButton("Cerrar");
		btnCerrar.setBounds(300, 300, 100, 25);
		btnCerrar.addActionListener(this.controlador);
		btnCerrar.setActionCommand(ConstantesInterfaz.CERRAR);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblCategoria);
		this.add(boxCategoria);
		this.add(lblPrecio);
		this.add(txtPrecio);
		this.add(lblTipo);
		this.add(boxTipo);
		this.add(lblTamanio);
		this.add(boxTamanio);
		this.add(lblMarca);
		this.add(boxMarca);
		this.add(lblGenero);
		this.add(boxGenero);
		this.add(lblOrigen);
		this.add(boxOrigen);
		this.add(lblCantidad);
		this.add(txtCantidad);
		this.add(lblPrecioVenta);
		this.add(txtPrecioVenta);
		this.add(btnCrear);
		this.add(btnCerrar);
	}
	
public JTextField getTxtPrecioVenta() {
		return txtPrecioVenta;
	}
	public void setTxtPrecioVenta(JTextField txtPrecioVenta) {
		this.txtPrecioVenta = txtPrecioVenta;
	}
public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JComboBox<Categoria> getBoxCategoria() {
		return boxCategoria;
	}
	public void setBoxCategoria(JComboBox<Categoria> boxCategoria) {
		this.boxCategoria = boxCategoria;
	}
	public JComboBox<TipoProducto> getBoxTipo() {
		return boxTipo;
	}
	public void setBoxTipo(JComboBox<TipoProducto> boxTipo) {
		this.boxTipo = boxTipo;
	}
	public JTextField getTxtPrecio() {
		return txtPrecio;
	}
	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
	}
	public JComboBox<Tamanio> getBoxTamanio() {
		return boxTamanio;
	}
	public void setBoxTamanio(JComboBox<Tamanio> boxTamanio) {
		this.boxTamanio = boxTamanio;
	}
	public JComboBox<Marca> getBoxMarca() {
		return boxMarca;
	}
	public void setBoxMarca(JComboBox<Marca> boxMarca) {
		this.boxMarca = boxMarca;
	}
	public JComboBox<GeneroEnum> getBoxGenero() {
		return boxGenero;
	}
	public void setBoxGenero(JComboBox<GeneroEnum> boxGenero) {
		this.boxGenero = boxGenero;
	}
	public JComboBox<Origen> getBoxOrigen() {
		return boxOrigen;
	}
	public void setBoxOrigen(JComboBox<Origen> boxOrigen) {
		this.boxOrigen = boxOrigen;
	}
	public JTextField getTxtCantidad() {
		return txtCantidad;
	}
	public void setTxtCantidad(JTextField txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

}
