package com.inventario.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.inventario.enums.GeneroEnum;
import com.inventario.enums.TipoTablaEnum;
import com.inventario.esquema.Categoria;
import com.inventario.esquema.Inventario;
import com.inventario.esquema.InventarioPeriodico;
import com.inventario.esquema.Marca;
import com.inventario.esquema.Origen;
import com.inventario.esquema.Producto;
import com.inventario.esquema.Tamanio;
import com.inventario.esquema.TipoProducto;
import com.inventario.interfaz.DialogAgregarProductos;
import com.inventario.interfaz.DialogCrearInventario;
import com.inventario.interfaz.DialogCrearObjeto;
import com.inventario.interfaz.DialogEditarProducto;
import com.inventario.interfaz.DialogInsertarProducto;
import com.inventario.interfaz.DialogMostrarProductos;
import com.inventario.interfaz.PrincipalFrame;
import com.inventario.negocio.NegocioInventario;
import com.inventario.utilidades.ConstantesInterfaz;

public class ControladorInventario implements ActionListener {
	private NegocioInventario ni;
	private DialogInsertarProducto insertarProducto;
	private DialogCrearObjeto objetoDialog;
	private PrincipalFrame principal;
	private DialogMostrarProductos dialogMostrarProductos;
	private Integer idProductoEditar;
	private Integer idProductoEliminar;
	private ArrayList<Producto> codigosProductos;
	private DialogEditarProducto dialogEditarProducto;
	private DialogCrearInventario dialogCrearInventario;
	private DialogAgregarProductos dialogAgregarProductos;


	public ControladorInventario(PrincipalFrame principal) {
		ni = new NegocioInventario();
		this.principal=principal;
		// login = new Login(this);
		// login.setVisible(true);
		codigosProductos= new ArrayList<Producto>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals(ConstantesInterfaz.CREAR)) {
				Categoria categoria = ((Categoria) insertarProducto.getBoxCategoria().getSelectedItem());
				Marca marca = ((Marca) insertarProducto.getBoxMarca().getSelectedItem());
				TipoProducto tipo = ((TipoProducto) insertarProducto.getBoxTipo().getSelectedItem());
				Tamanio tamanio = ((Tamanio) insertarProducto.getBoxTamanio().getSelectedItem());
				Origen origen = ((Origen) insertarProducto.getBoxOrigen().getSelectedItem());
				GeneroEnum genero = (GeneroEnum) insertarProducto.getBoxGenero().getSelectedItem();
				BigDecimal precioCompra = new BigDecimal(insertarProducto.getTxtPrecio().getText());
				Integer cantidad = new Integer(insertarProducto.getTxtCantidad().getText());
				BigDecimal precioVenta = new BigDecimal(insertarProducto.getTxtPrecioVenta().getText());
				Producto producto = new Producto(insertarProducto.getTxtNombre().getText(), categoria,
						genero.name(), tipo, marca, precioCompra, tamanio,
						origen, cantidad,precioVenta);
				ni.crearProducto(producto);

			} else if (e.getActionCommand().equals(ConstantesInterfaz.CERRAR)) {
				System.out.println("holaaa");
			}
			else if (e.getActionCommand().equals(ConstantesInterfaz.CREAR_OBJETO)) {
				TipoTablaEnum tipoTabla=(TipoTablaEnum) objetoDialog.getBoxTipoTabla().getSelectedItem();
				String nombre=objetoDialog.getTxtNombre().getText();				
				ni.crearObjeto(tipoTabla, nombre);
			}
			else if (e.getActionCommand().equals(ConstantesInterfaz.INSERTAR_PRODUCTO)) {
				insertarProducto= new DialogInsertarProducto(this);
				insertarProducto.setVisible(true);
			}
			else if (e.getActionCommand().equals(ConstantesInterfaz.CREAR_PARAMETRIZACION)) {
				objetoDialog= new DialogCrearObjeto(this);
				objetoDialog.setVisible(true);
			}
			else if (e.getActionCommand().equals(ConstantesInterfaz.CONSULTAR_PRODUCTO)) {
				dialogMostrarProductos= new DialogMostrarProductos(this);
				dialogMostrarProductos.setVisible(true);
			}else if (e.getActionCommand().equals(ConstantesInterfaz.FILTRAR_PRODUCTO)) {
				Categoria categoria = ((Categoria) dialogMostrarProductos.getBoxCategoria().getSelectedItem());
				Marca marca = ((Marca) dialogMostrarProductos.getBoxMarca().getSelectedItem());
				TipoProducto tipo = ((TipoProducto) dialogMostrarProductos.getBoxTipo().getSelectedItem());
				Tamanio tamanio = ((Tamanio) dialogMostrarProductos.getBoxTamanio().getSelectedItem());
				Origen origen = ((Origen) dialogMostrarProductos.getBoxOrigen().getSelectedItem());
				String genero = (String) dialogMostrarProductos.getBoxGenero().getSelectedItem();
				Producto producto = new Producto(categoria, genero, tipo, marca, tamanio, origen);
				dialogMostrarProductos.adicionarProducto(ni.consultarProducto(producto));				
			}
			else if(e.getActionCommand().equals(ConstantesInterfaz.CREAR_INVENTARIO)){
				dialogCrearInventario= new DialogCrearInventario(this);
				dialogCrearInventario.setVisible(true);
			}
			else if (e.getActionCommand().equals(ConstantesInterfaz.EDITAR_PRODUCTO)) {
				Categoria categoria = ((Categoria) dialogEditarProducto.getBoxCategoria().getSelectedItem());
				Marca marca = ((Marca) dialogEditarProducto.getBoxMarca().getSelectedItem());
				TipoProducto tipo = ((TipoProducto) dialogEditarProducto.getBoxTipo().getSelectedItem());
				Tamanio tamanio = ((Tamanio) dialogEditarProducto.getBoxTamanio().getSelectedItem());
				Origen origen = ((Origen) dialogEditarProducto.getBoxOrigen().getSelectedItem());
				GeneroEnum genero = (GeneroEnum) dialogEditarProducto.getBoxGenero().getSelectedItem();			

				Producto producto = dialogEditarProducto.getProducto();
				if(categoria!=null){
					producto.setCategoria(categoria);
				}
				if(marca!=null){
					producto.setMarca(marca);
				}
				if(origen!=null){
					producto.setOrigen(origen);
				}
				if(tipo!=null){
					producto.setTipo(tipo);
				}
				if(tamanio!=null){
					producto.setTamanio(tamanio);
				}
				if(genero!=null){
					producto.setGenero(genero.name());
				}
				if(dialogEditarProducto.getTxtPrecio().getText()!=null && !dialogEditarProducto.getTxtPrecio().getText().trim().equals("")){
					BigDecimal precioCompra = new BigDecimal(dialogEditarProducto.getTxtPrecio().getText());
					producto.setPrecioCompra(precioCompra);
				}
				if(dialogEditarProducto.getTxtPrecioVenta().getText()!=null && !dialogEditarProducto.getTxtPrecioVenta().getText().trim().equals("")){
					BigDecimal precioVenta = new BigDecimal(dialogEditarProducto.getTxtPrecioVenta().getText());
					producto.setPrecioVenta(precioVenta);
				}
				if(dialogEditarProducto.getTxtCantidad().getText()!=null && !dialogEditarProducto.getTxtCantidad().getText().trim().equals("")){
					Integer cantidad = new Integer(dialogEditarProducto.getTxtCantidad().getText());
					producto.setCantidad(cantidad);
				}
				ni.editarProducto(producto);
				dialogEditarProducto.dispose();
				dialogMostrarProductos.repaint();
			}else if(e.getActionCommand().equals(ConstantesInterfaz.ABRIR_VENTANA_EDITAR)){
				Producto producto = ni.consultarProducto(idProductoEditar);

				dialogEditarProducto= new DialogEditarProducto(this, producto);
				dialogEditarProducto.setVisible(Boolean.TRUE);

			}
			else if(e.getActionCommand().equals(ConstantesInterfaz.ELIMINAR_PRODUCTO)){
				int result= JOptionPane.showConfirmDialog(null, "Realmente desea eliminar este producto?", ConstantesInterfaz.CONFIRMAR_ELIMINAR_PRODUCTO, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION){
					ni.eliminarProducto(idProductoEliminar);
					dialogMostrarProductos.repaint();
				}

			}
			else if(e.getActionCommand().equals(ConstantesInterfaz.AGREGAR_PRODUCTOS)){
				dialogAgregarProductos= new DialogAgregarProductos(this);
				dialogAgregarProductos.setVisible(true);
			}
			else if (e.getActionCommand().equals(ConstantesInterfaz.FILTRAR_AGREGAR)) {
				Categoria categoria = ((Categoria) dialogAgregarProductos.getBoxCategoria().getSelectedItem());
				Marca marca = ((Marca) dialogAgregarProductos.getBoxMarca().getSelectedItem());
				TipoProducto tipo = ((TipoProducto) dialogAgregarProductos.getBoxTipo().getSelectedItem());
				Tamanio tamanio = ((Tamanio) dialogAgregarProductos.getBoxTamanio().getSelectedItem());
				Origen origen = ((Origen) dialogAgregarProductos.getBoxOrigen().getSelectedItem());
				String genero = (String) dialogAgregarProductos.getBoxGenero().getSelectedItem();
				Producto producto = new Producto(categoria, genero, tipo, marca, tamanio, origen);
				dialogAgregarProductos.adicionarProducto(ni.consultarProducto(producto));				
			}
			else if (e.getActionCommand().equals(ConstantesInterfaz.AGREGAR_PRO)) {
				boolean conf=false;
				if(codigosProductos.size()>0){
					for (int i = 0; i < codigosProductos.size(); i++) {
						if(codigosProductos.get(i).getIdProducto().equals(dialogAgregarProductos.extraerDatos().getIdProducto())){
							conf=true;							
						}
					}
					if(conf){
						JOptionPane.showMessageDialog(null,  "Ese producto ya se agregó");
						conf=false;
					}
					else{
						codigosProductos.add(dialogAgregarProductos.extraerDatos());
					}
				}
				else{
					codigosProductos.add(dialogAgregarProductos.extraerDatos());
					System.out.println("esto esta vacio");
				}
				dialogCrearInventario.adicionarProducto(codigosProductos);
			}
			else if (e.getActionCommand().equals(ConstantesInterfaz.ELIMINAR_PRODUCTO_AGREGADO)) {
				int filaSeleccionada=dialogCrearInventario.getJtTable().getSelectedRow();
				if(filaSeleccionada==-1){
					JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
				}
				else{
					codigosProductos.remove(filaSeleccionada);
					dialogCrearInventario.adicionarProducto(codigosProductos);
				}
				
			}else if (e.getActionCommand().equals(ConstantesInterfaz.CERRAR_INVENTARIO)) {
				String tipoInventario=dialogCrearInventario.getBoxTipoInventario().getSelectedItem().toString();
				Date fechaInventario=dialogCrearInventario.getCalendarFecha().getDate();
				java.sql.Date fechaSql=new java.sql.Date(fechaInventario.getTime());
				Inventario inventario= new Inventario(new BigDecimal(10000),tipoInventario,fechaSql);
				ni.crearInventario(inventario);
				for (int i = 0; i < codigosProductos.size(); i++) {
					Integer cantidad=(int)dialogCrearInventario.getJtTable().getValueAt(i, 1);
					System.out.println("cantidad "+cantidad);
					Integer idProducto= codigosProductos.get(i).getIdProducto();
					Integer idInventario=ni.consultarInventario().getIdInventario();
					BigDecimal precioVenta=codigosProductos.get(i).getPrecioCompra().multiply(new BigDecimal(codigosProductos.get(i).getCantidad()));
					InventarioPeriodico inventarioPeriodico= new InventarioPeriodico(cantidad, idProducto, idInventario, precioVenta);
					ni.crearInventarioPeriodico(inventarioPeriodico);
				}
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error autenticación", JOptionPane.ERROR_MESSAGE);
		}
	}

	public Integer getIdProductoEditar() {
		return idProductoEditar;
	}

	public void setIdProductoEditar(Integer idProductoEditar) {
		this.idProductoEditar = idProductoEditar;
	}

	public Integer getIdProductoEliminar() {
		return idProductoEliminar;
	}

	public void setIdProductoEliminar(Integer idProductoEliminar) {
		this.idProductoEliminar = idProductoEliminar;
	}

}
