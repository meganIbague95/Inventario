package com.inventario.negocio;

import java.util.ArrayList;
import java.util.List;

import com.inventario.enums.TipoTablaEnum;
import com.inventario.esquema.Inventario;
import com.inventario.esquema.InventarioPeriodico;
import com.inventario.esquema.Producto;
import com.inventario.logs.ManejoLogs;
import com.inventario.transaccionesbd.TransaccionesDAO;
import com.inventario.utilidades.Utilidades;

public class NegocioInventario {

	private TransaccionesDAO dao;
	private ManejoLogs log = new ManejoLogs(NegocioInventario.class);

	public NegocioInventario() {
		try {
			dao = new TransaccionesDAO();
		} catch (Exception e) {
			log.escribirError("Error al instanciar dao", e);
		}
	}

	public List<Object> listarObjetos(TipoTablaEnum tipoTabla) {
		try {
			return dao.consultarObjeto(tipoTabla);
		} catch (Exception e) {
			log.escribirError("Error al listar marcas", e);
			return null;
		}

	}
	public void crearProducto(Producto producto) throws Exception{
		validarCampos(producto);
		dao.insertarProducto(producto);
	}
	private void validarCampos(Producto producto) throws Exception{
		try {
			
		if(!Utilidades.validarCampoObligatorio(producto.getNombreProducto())){
			throw new Exception("El nombre del producto es obligatorio");
		}
		if(!Utilidades.validarCampoObligatorio(producto.getPrecioCompra())){
			throw new Exception("El precio de compra es obligatorio");
		}
		if(!Utilidades.validarCampoObligatorio(producto.getCantidad())){
			throw new Exception("La cantidad es obligatoria");
		}
		} catch (NumberFormatException e) {
			throw new Exception("Hay campos númericos con caracteres");
		}
	}
	public void crearObjeto(TipoTablaEnum tipoTabla, String nombre) throws Exception{
		if(!Utilidades.validarCampoObligatorio(nombre)){
			throw new Exception("El nombre es obligatorio");
		}
		dao.insertarObjetos(tipoTabla, nombre);
		
	}

	public List<Producto> consultarProducto(Producto producto) {
		List<Producto> lista= new ArrayList<Producto>();
		try {
			lista= dao.consultarProducto(producto);
		} catch (Exception e) {
			log.escribirError("Error al consultar Producto " + producto, e);
		}
		return lista;
	}
	public void editarProducto(Producto producto){
		try {
			dao.editarProducto(producto);
		} catch (Exception e) {
			e.printStackTrace();
			log.escribirError("Error al editar Producto " + producto, e);
		}
	}
	public Producto consultarProducto(Integer idProducto) {
		Producto producto= null;
		try {
			producto= dao.consultarProducto(idProducto);
		} catch (Exception e) {
			e.printStackTrace();
			log.escribirError("Error al consultar Producto " + producto, e);
		}
		return producto;
	}
	public void eliminarProducto(Integer idProducto){
		try {
			dao.eliminarProduto(idProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void crearInventario(Inventario inventario){
		try {
			dao.crearInventario(inventario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void crearInventarioPeriodico(InventarioPeriodico inventarioPeriodico){
		try {
			dao.crearPeriodico(inventarioPeriodico);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Inventario consultarInventario(){
		Inventario inventario=null;
		try {
			inventario=dao.consultarInventario();
			System.out.println(dao.consultarInventario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventario;
				
		
	}
}
