package com.inventario.test;

import java.math.BigDecimal;
import java.util.List;

import com.inventario.enums.TipoTablaEnum;
import com.inventario.esquema.Categoria;
import com.inventario.esquema.Inventario;
import com.inventario.esquema.Marca;
import com.inventario.esquema.Origen;
import com.inventario.esquema.Perfil;
import com.inventario.esquema.Producto;
import com.inventario.esquema.Tamanio;
import com.inventario.esquema.TipoProducto;
import com.inventario.esquema.Usuario;
import com.inventario.negocio.SeguridadInventario;
import com.inventario.transaccionesbd.TransaccionesDAO;

public class Prueba {
	TransaccionesDAO dao;
	public Prueba() throws Exception {
		dao= new TransaccionesDAO();
	}

	public static void main(String[] args) {
		try {
			Prueba prueba = new Prueba();
			SeguridadInventario s= new SeguridadInventario();
			Usuario usuario= new Usuario("admin", "admin", new Perfil(1, "AdminitradorSistema"));
			s.crearUsuario(usuario);
			//			prueba.editarProducto();
//			prueba.insertarProducto();
			//			prueba.consultarProducto();
//			prueba.eliminar();
//			prueba.consultarProductoCategoria();
//			prueba.crearInventario();
//			prueba.crearObjetos();
//			prueba.editarMarca();
//			prueba.consultarObjetos();
//			prueba.editarCategoria();
//			prueba.editarTamanio();
//			prueba.editarTipo();
//			prueba.editarOrigen();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertarProducto(){
//		Producto producto=new Producto("Paris Hilton",1,"1",1,1,new BigDecimal("70000"), 1,0,1 );
//		try {
//
//			dao.insertarProducto(producto);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void consultarProducto(){
		try {		

			System.out.println(dao.consultarProducto(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editarProducto(){
//		try {		
//			Producto producto=new Producto("Carolina Herrera",1,"1",1,1,new BigDecimal("100000"), 1,4,1 );
//			dao.editarProducto(producto);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void eliminar(){
		try {		
			dao.eliminarProduto(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public void crearInventario(){
//		Inventario inventario= new Inventario(1, 3, new BigDecimal("60000"), 7);
//		try {
//
//			dao.insertarInventario(inventario);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public void crearObjetos(){
//		Categoria categoria = new Categoria(1, "Re ultimo");
//		TipoTabla tipoTabla;
//		try {
//
//			dao.insertarObjetos(TipoTabla.CATEGORIA, categoria);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public void editarMarca(){
		try {		
			Marca marca=new Marca(1,"Carolina Herrera");
			dao.editarMarca(marca);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void consultarObjetos(){
		try {		
		List<Object> categorias=dao.consultarObjeto(TipoTablaEnum.CATEGORIA);
		for (Object object : categorias) {
			Categoria categoria= (Categoria)object;
			System.out.println(categoria.toString());
			
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editarCategoria(){
		try {	
			Categoria categoria=new Categoria(1,"Normal");
			dao.editarCategoria(categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editarTamanio(){
		try {	
			Tamanio tamanio= new Tamanio(2, "200ml");
			dao.editarTamanio(tamanio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editarOrigen(){
		try {	
			Origen origen= new Origen(1, "Nacional");
			dao.editarOrigen(origen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editarTipo(){
		try {	
			TipoProducto tipo = new TipoProducto(1, "Perfume");
			dao.editarTipo(tipo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
