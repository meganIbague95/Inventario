package com.inventario.interfaz;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.inventario.controlador.ControladorInventario;
import com.inventario.enums.TipoTablaEnum;
import com.inventario.esquema.Inventario;
import com.inventario.esquema.Producto;
import com.inventario.esquema.TipoInventario;
import com.inventario.negocio.NegocioInventario;
import com.inventario.utilidades.ConstantesInterfaz;
import com.toedter.calendar.JCalendar;

public class DialogCrearInventario extends JDialog{
	private JLabel lblTipo;
	private JComboBox<String> boxTipoInventario;
	private JLabel lblFecha;
	private JCalendar calendarFecha;
	private JTable jtTable;
	private DefaultTableModel dtm ;
	private ControladorInventario controlador;
	private JButton btnAgregarProductos;
	private JButton btnEliminarProductos;
	private JButton btnCrearInventario;
	private NegocioInventario negocioInventario= new NegocioInventario();
	
	public DialogCrearInventario(ControladorInventario controladorInventario) {
		setSize(900, 700);
		setResizable(false);
		setLayout(null);
		setTitle("Crear Inventario");
		setLocationRelativeTo(null);
		this.controlador=controladorInventario;
		createJtable();
		setColumnJtable();
		inicializarComponentes();
	}
	private void createJtable() {
		jtTable = new JTable();
		this.dtm = (DefaultTableModel) jtTable.getModel();
		JScrollPane scrollPane = new JScrollPane(jtTable);
		this.add(scrollPane);
		scrollPane.setBounds(50, 200, 780, 400);
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
	public void inicializarComponentes(){
		lblTipo = new JLabel("Tipo de inventario:");
		lblTipo.setBounds(30, 30, 120, 20);
		
		boxTipoInventario= new JComboBox<String>();
		boxTipoInventario.setBounds(150, 30, 100, 20);
		boxTipoInventario.addItem("Local");
		boxTipoInventario.addItem("Bodega");
		
		lblFecha = new JLabel("Fecha de inventario:");
		lblFecha.setBounds(280, 30, 120, 20);
		
		calendarFecha= new JCalendar();
		calendarFecha.setBounds(400, 30, 200, 150);
		
		btnAgregarProductos= new JButton("Agregar productos");
		btnAgregarProductos.setBounds(50, 100, 150, 20);
		btnAgregarProductos.addActionListener(this.controlador);
		btnAgregarProductos.setActionCommand(ConstantesInterfaz.AGREGAR_PRODUCTOS);
		
		btnEliminarProductos= new JButton("Eliminar producto");
		btnEliminarProductos.setBounds(50, 150, 150, 20);
		btnEliminarProductos.addActionListener(this.controlador);
		btnEliminarProductos.setActionCommand(ConstantesInterfaz.ELIMINAR_PRODUCTO_AGREGADO);
		
		btnCrearInventario= new JButton("Crear inventario");
		btnCrearInventario.setBounds(50, 620, 150, 20);
		btnCrearInventario.addActionListener(this.controlador);
		btnCrearInventario.setActionCommand(ConstantesInterfaz.CERRAR_INVENTARIO);
		
		this.add(lblTipo);
		this.add(boxTipoInventario);
		this.add(lblFecha);
		this.add(calendarFecha);
		this.add(btnAgregarProductos);
		this.add(btnCrearInventario);
		this.add(btnEliminarProductos);
	}

	public JTable getJtTable() {
		return jtTable;
	}
	public void setJtTable(JTable jtTable) {
		this.jtTable = jtTable;
	}
	public JComboBox<String> getBoxTipoInventario() {
		return boxTipoInventario;
	}
	public void setBoxTipoInventario(JComboBox<String> boxTipoInventario) {
		this.boxTipoInventario = boxTipoInventario;
	}
	public JCalendar getCalendarFecha() {
		return calendarFecha;
	}
	public void setCalendarFecha(JCalendar calendarFecha) {
		this.calendarFecha = calendarFecha;
	}
	 

}
