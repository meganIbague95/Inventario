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
import com.inventario.esquema.Categoria;
import com.inventario.esquema.Inventario;
import com.inventario.esquema.Producto;
import com.inventario.utilidades.ConstantesInterfaz;

public class DialogMostrarInventarios extends JDialog {
	private ControladorInventario controladorInventario;
	private JLabel lblInventario;
	private JComboBox<String> boxInventario;
	
	private JButton btnGuardarInventario;
	private JButton btnMostrar;
	private JTable jtTable;
	private DefaultTableModel dtm ;


	public DialogMostrarInventarios(ControladorInventario controladorInventario) {
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
	public void inicializar(){
		lblInventario= new JLabel("Inventario");
		lblInventario.setBounds(200,50,100,25);

		boxInventario= new JComboBox<String>();
		boxInventario.setBounds(300, 50, 100, 25);
		boxInventario.addItem("Local");
		boxInventario.addItem("Bodega");

		btnMostrar= new JButton("Mostrar");
		btnMostrar.setBounds(430, 50, 100, 25);
		btnMostrar.addActionListener(this.controladorInventario);
		btnMostrar.setActionCommand(ConstantesInterfaz.MOSTRAR_INVENTARIO);
		

		this.add(lblInventario);
		this.add(boxInventario);
		this.add(btnMostrar);
	}
	private void createJtable() {
		jtTable = new JTable();
		this.dtm = (DefaultTableModel) jtTable.getModel();
		JScrollPane scrollPane = new JScrollPane(jtTable);
		this.add(scrollPane);
		scrollPane.setBounds(50, 100, 650, 600);
	}
	
	public void addValueJTable(Inventario inventario) {
		
		dtm.setRowCount(dtm.getRowCount() + 1);
		dtm.setValueAt(inventario.getIdInventario(), dtm.getRowCount() - 1, 0);
		dtm.setValueAt(inventario.getPrecioVenta(), dtm.getRowCount() - 1, 1);
		dtm.setValueAt(inventario.getTipoInventario(), dtm.getRowCount() - 1, 2);
		dtm.setValueAt(inventario.getFechaInventario(), dtm.getRowCount() - 1, 3);
		jtTable.getColumn("Editar").setCellEditor(new BotonEditarInventario(new JCheckBox(),controladorInventario));
		jtTable.getColumn("Eliminar").setCellEditor(new BotonEliminarInventario(new JCheckBox(),controladorInventario));
		
	}

	public void setColumnJtable() {
		DefaultTableModel dtm = (DefaultTableModel) jtTable.getModel();
		dtm.addColumn("Identificador");
		dtm.addColumn("Precio venta");
		dtm.addColumn("Tipo Inventario");
		dtm.addColumn("Fecha Inventario");
		dtm.addColumn("Editar");
		dtm.addColumn("Eliminar");

	}
	
	public void adicionarProducto(List<Inventario> inventarios) {
//		System.out.println(process.size());
		clearTable();
		for (int i = 0; i < inventarios.size(); i++) {
			addValueJTable(inventarios.get(i));
		}
		this.repaint();
		

	}
	
	private void clearTable() {
		int aux=dtm.getRowCount();
		   for(int i=0; i<aux;i++){
			   dtm.removeRow(0);
		   }
	}
	public JComboBox<String> getBoxInventario() {
		return boxInventario;
	}
	public void setBoxInventario(JComboBox<String> boxInventario) {
		this.boxInventario = boxInventario;
	}
	
}
