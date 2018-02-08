package com.inventario.transaccionesbd;


import java.util.ArrayList;
import java.util.List;

import com.inventario.enums.TipoTablaEnum;
import com.inventario.esquema.Bitacora;
import com.inventario.esquema.Categoria;
import com.inventario.esquema.Entrada;
import com.inventario.esquema.Inventario;
import com.inventario.esquema.InventarioPeriodico;
import com.inventario.esquema.Marca;
import com.inventario.esquema.Origen;
import com.inventario.esquema.Perfil;
import com.inventario.esquema.Persona;
import com.inventario.esquema.Producto;
import com.inventario.esquema.Salida;
import com.inventario.esquema.Tamanio;
import com.inventario.esquema.TipoProducto;
import com.inventario.esquema.Usuario;

public interface TransaccionesDAOInterface {
	public void insertarProducto(Producto producto) throws Exception;
	public Producto consultarProducto(Integer codigo) throws Exception;
	public void editarProducto(Producto producto) throws Exception;
	public void eliminarProduto(Integer codigo)throws Exception;
	public void insertarObjetos(TipoTablaEnum tipoTabla,String nombre) throws Exception;
	public List<Object> consultarObjeto(TipoTablaEnum tipoTabla) throws Exception;
	public void editarMarca(Marca marca)throws Exception;
	public void editarCategoria(Categoria categoria)throws Exception;
	public void editarTamanio(Tamanio tamanio)throws Exception;
	public void editarTipo(TipoProducto tipo)throws Exception;
	public void editarOrigen(Origen origen)throws Exception;
	public void eliminarObjeto(TipoTablaEnum tipoTabla, Object objeto)throws Exception;
	public Usuario consultarUsuario(String login)throws Exception;
	public Usuario consultarUsuarioSeguridad(String login)throws Exception;
	public void insertarBitacora(Bitacora bitacora) throws Exception;
	public void insertarUsuario(Usuario usuario) throws Exception;
	public Bitacora consultarBitacora(String usuario) throws Exception;
	public void insertarPersona(Persona persona) throws Exception;
	public void insertarPerfil(Perfil perfil) throws Exception;
	public Persona consultarPersona(String tipoIdentificacion, Integer identificacion)throws Exception;
	public List<Perfil> consultarPerfiles()throws Exception;
	public void editarUsuario(Usuario usuario)throws Exception;
	public void editarPersona(Persona persona)throws Exception;
	public void editarPerfil(Perfil perfil)throws Exception;
	public void eliminarUsuario(String usuario)throws Exception;
	public void eliminarPersona(String tipoIdentificacion, Integer identificacion)throws Exception;
	public void eliminarPerfil(Integer codigo)throws Exception;
	public void insertarEntrada(Entrada entrada) throws Exception;
	public void insertarSalida(Salida salida) throws Exception;
	public void crearInventario(Inventario inventario)throws Exception;
	public void crearPeriodico(InventarioPeriodico inventarioPeriodico)throws Exception;
	public Inventario consultarInventario()throws Exception;
	public ArrayList<Producto> consultarProductosInventario(Integer idInventario)throws Exception;
	public List<Inventario> consultarInventarios(String tipoInventario)throws Exception; 
	public List<Producto> consultarProductoPorInventario(Integer idinventario,Producto productoEntrada) throws Exception;
	public void eliminarProductoInventario(Integer codigo)throws Exception;
	public void eliminarInventarioPeriodico(Integer codigo)throws Exception;
	public void eliminarInventario(Integer codigo)throws Exception;
	
}
