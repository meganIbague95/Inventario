package com.inventario.interfaz;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.inventario.controlador.ControladorInventario;
import com.inventario.enums.GeneroEnum;
import com.inventario.enums.TipoTablaEnum;
import com.inventario.esquema.Categoria;
import com.inventario.esquema.Marca;
import com.inventario.esquema.Origen;
import com.inventario.esquema.Producto;
import com.inventario.esquema.Tamanio;
import com.inventario.esquema.TipoProducto;
import com.inventario.negocio.NegocioInventario;
import com.inventario.utilidades.ConstantesInterfaz;

public class DialogMostrarProductos extends JDialog{
	private JTable jtTable;
	private DefaultTableModel dtm ;
	private JLabel lblCategoria;
	private JLabel lblMarca;
	private JLabel lblOrigen;
	private JLabel lblTamanio;
	private JLabel lblTipo;
	private JLabel lblGenero;
	private JButton btnEditar;
//	private JButton btnEliminar;
	
	private JComboBox<Categoria> boxCategoria;
	private JComboBox<Marca> boxMarca;
	private JComboBox<Origen> boxOrigen;
	private JComboBox<Tamanio> boxTamanio;
	private JComboBox<TipoProducto> boxTipo;
	private JComboBox<GeneroEnum> boxGenero;
	private JButton btnFiltrar;
	private JButton btnCerrar;
	private NegocioInventario negocioInventario= new NegocioInventario();
	private ControladorInventario controladorInventario;

	public DialogMostrarProductos(ControladorInventario controladorInventario) {
		this.controladorInventario=controladorInventario;
		setSize(800, 800);
		setResizable(false);
		setLayout(null);
		setTitle("Mostrar productos");
		setLocationRelativeTo(null);
		createJtable();
		setColumnJtable();
		inicializar();
		
	}
	private void createJtable() {
		jtTable = new JTable();
		this.dtm = (DefaultTableModel) jtTable.getModel();
		JScrollPane scrollPane = new JScrollPane(jtTable);
		this.add(scrollPane);
		scrollPane.setBounds(50, 200, 650, 600);
	}
	public void agregarBoton(){
//		TableColumn agregarColumn;
//		agregarColumn = jtTable.getColumnModel().getColumn(9);
//		agregarColumn.setCellEditor(new myeditor(jtTable));
//		agregarColumn.setCellRenderer(new myrenderer(true));
	}
	public void addValueJTable(Producto producto) {
		
		dtm.setRowCount(dtm.getRowCount() + 1);
		dtm.setValueAt(producto.getIdProducto(), dtm.getRowCount() - 1, 0);
		dtm.setValueAt(producto.getCantidad(), dtm.getRowCount() - 1, 1);
		dtm.setValueAt(producto.getNombreProducto(), dtm.getRowCount() - 1, 2);
		dtm.setValueAt(producto.getPrecioCompra(), dtm.getRowCount() - 1, 3);
		dtm.setValueAt(producto.getPrecioVenta(), dtm.getRowCount() - 1, 4);
		dtm.setValueAt(producto.getCategoria(), dtm.getRowCount() - 1, 5);
		dtm.setValueAt(producto.getGenero(), dtm.getRowCount() - 1, 6);
		dtm.setValueAt(producto.getMarca(), dtm.getRowCount() - 1, 7);
		dtm.setValueAt(producto.getTamanio(), dtm.getRowCount() - 1, 8);
		dtm.setValueAt(producto.getOrigen(), dtm.getRowCount() - 1, 9);	
		dtm.setValueAt(producto.getTipo(), dtm.getRowCount() - 1, 10);	
		jtTable.getColumn("Editar").setCellEditor(new BotonEdicion(new JCheckBox(),controladorInventario));
		jtTable.getColumn("Eliminar").setCellEditor(new BotonEliminar(new JCheckBox(),controladorInventario));
		
	}

	public void setColumnJtable() {
		DefaultTableModel dtm = (DefaultTableModel) jtTable.getModel();
		dtm.addColumn("Identificador");
		dtm.addColumn("Cantidad");
		dtm.addColumn("Nombre");
		dtm.addColumn("Precio interno");
		dtm.addColumn("Precio venta");
		dtm.addColumn("Categoria");
		dtm.addColumn("Genero");
		dtm.addColumn("Marca");
		dtm.addColumn("Tamaño");
		dtm.addColumn("Origen");
		dtm.addColumn("Tipo");
		dtm.addColumn("Editar");
		dtm.addColumn("Eliminar");

	}
	
	public void adicionarProducto(List<Producto> productos) {
//		System.out.println(process.size());
		clearTable();
		for (int i = 0; i < productos.size(); i++) {
			addValueJTable(productos.get(i));
		}
		this.repaint();
		

	}
	
	private void clearTable() {
		int aux=dtm.getRowCount();
		   for(int i=0; i<aux;i++){
			   dtm.removeRow(0);
		   }
	}
	private void inicializar(){

		lblCategoria= new JLabel("Categoria");
		lblCategoria.setBounds(50,50,100,25);

		boxCategoria= new JComboBox<Categoria>();
		boxCategoria.setBounds(120, 50, 100, 25);
		boxCategoria.addItem(null);
		for (Object objeto : negocioInventario.listarObjetos(TipoTablaEnum.CATEGORIA)) {
			Categoria categoria = (Categoria)objeto;
			boxCategoria.addItem(categoria);
		}
		

		lblTipo= new JLabel("Tipo");
		lblTipo.setBounds(250,50,100,25);

		boxTipo= new JComboBox<TipoProducto>();
		boxTipo.setBounds(310, 50, 100, 25);
		boxTipo.addItem(null);
		for (Object objeto : negocioInventario.listarObjetos(TipoTablaEnum.TIPO)) {
			TipoProducto tipo = (TipoProducto)objeto;
			boxTipo.addItem(tipo);
		}
		lblTamanio= new JLabel("Tamaño");
		lblTamanio.setBounds(430,50,100,25);

		boxTamanio= new JComboBox<Tamanio>();
		boxTamanio.setBounds(500, 50, 100, 25);
		boxTamanio.addItem(null);
		for (Object objeto : negocioInventario.listarObjetos(TipoTablaEnum.TAMANIO)) {
			Tamanio tamanio = (Tamanio)objeto;
			boxTamanio.addItem(tamanio);
		}
		lblMarca= new JLabel("Marca");
		lblMarca.setBounds(50,100,100,25);

		boxMarca= new JComboBox<Marca>();
		boxMarca.setBounds(120, 100, 100, 25);
		boxMarca.addItem(null);
		for (Object objeto : negocioInventario.listarObjetos(TipoTablaEnum.MARCA)) {
			Marca marca = (Marca)objeto;
			boxMarca.addItem(marca);
		}
		
		lblOrigen= new JLabel("Origen");
		lblOrigen.setBounds(250,100,100,25);

		boxOrigen= new JComboBox<Origen>();
		boxOrigen.setBounds(320, 100, 100, 25);
		boxOrigen.addItem(null);
		for (Object objeto : negocioInventario.listarObjetos(TipoTablaEnum.ORIGEN)) {
			Origen origen = (Origen)objeto;
			boxOrigen.addItem(origen);
		}
		lblGenero= new JLabel("Genero");
		lblGenero.setBounds(430,100,100,25);

		boxGenero= new JComboBox<GeneroEnum>();
		boxGenero.setBounds(500, 100, 100, 25);
		boxGenero.addItem(null);
		boxGenero.addItem(GeneroEnum.HOMBRE);
		boxGenero.addItem(GeneroEnum.MUJER);
		boxGenero.addItem(GeneroEnum.NIÑO);
		boxGenero.addItem(GeneroEnum.NIÑA);
		
		btnFiltrar= new JButton("Filtrar");
		btnFiltrar.setBounds(250, 150, 100, 25);
		btnFiltrar.addActionListener(this.controladorInventario);
		btnFiltrar.setActionCommand(ConstantesInterfaz.FILTRAR_PRODUCTO);
		
		btnCerrar= new JButton("Filtrar");
		btnCerrar.setBounds(380, 150, 100, 25);
		btnCerrar.addActionListener(this.controladorInventario);
		btnCerrar.setActionCommand(ConstantesInterfaz.CERRAR_FILTRO);
		btnEditar= new JButton("ed");
		btnEditar.addActionListener(this.controladorInventario);
		btnEditar.setActionCommand(ConstantesInterfaz.EDITAR_PRODUCTO);
		
		
		this.add(lblCategoria);
		this.add(boxCategoria);
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
		this.add(lblGenero);
		this.add(boxGenero);
		this.add(btnFiltrar);
	}
	public JComboBox<Categoria> getBoxCategoria() {
		return boxCategoria;
	}
	public void setBoxCategoria(JComboBox<Categoria> boxCategoria) {
		this.boxCategoria = boxCategoria;
	}
	public JComboBox<Marca> getBoxMarca() {
		return boxMarca;
	}
	public void setBoxMarca(JComboBox<Marca> boxMarca) {
		this.boxMarca = boxMarca;
	}
	public JComboBox<Origen> getBoxOrigen() {
		return boxOrigen;
	}
	public void setBoxOrigen(JComboBox<Origen> boxOrigen) {
		this.boxOrigen = boxOrigen;
	}
	public JComboBox<Tamanio> getBoxTamanio() {
		return boxTamanio;
	}
	public void setBoxTamanio(JComboBox<Tamanio> boxTamanio) {
		this.boxTamanio = boxTamanio;
	}
	public JComboBox<TipoProducto> getBoxTipo() {
		return boxTipo;
	}
	public void setBoxTipo(JComboBox<TipoProducto> boxTipo) {
		this.boxTipo = boxTipo;
	}
	public JComboBox<GeneroEnum> getBoxGenero() {
		return boxGenero;
	}
	public void setBoxGenero(JComboBox<GeneroEnum> boxGenero) {
		this.boxGenero = boxGenero;
	}
	public JTable getJtTable() {
		return jtTable;
	}
	public void setJtTable(JTable jtTable) {
		this.jtTable = jtTable;
	}
	

}
