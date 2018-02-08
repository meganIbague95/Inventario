package com.inventario.utilidades;

public class ConstantesSQL {
	public static final String INSERTAR_PRODUCTO="INSERT INTO PRODUCTO( nombre,idCategoria,genero,idTipo,idMarca,precioCompra,idTamanio, idOrigen,fechacreacion,cantidad, precioventa) values (?,?,?,?,?,?,?,?,sysdate(),?,?)";
	public static final String CONSULTAR_PRODUCTO="SELECT p.nombre,c.idCategoria,p.genero,t.idTipoProducto,m.idMarca,p.precioCompra,ta.idTamanio,p.idProducto, o.idOrigen, p.cantidad,m.nombre,c.nombre,ta.nombre, o.nombre,t.nombre,p.precioventa FROM PRODUCTO p,MARCA m,CATEGORIA c,TAMANIO ta,ORIGEN o, TIPOPRODUCTO t  "
			+ "where p.idmarca=m.idmarca and c.idCategoria=p.idCategoria and t.idTipoProducto=p.idTipo and ta.idTamanio=p.idTamanio and o.idOrigen=p.idOrigen and idproducto=?";
	public static final String CONSULTAR_PRODUCTOS="SELECT p.nombre,c.idCategoria,p.genero,t.idTipoProducto,m.idMarca,p.precioCompra,ta.idTamanio,p.idProducto, o.idOrigen, p.cantidad,m.nombre,c.nombre,ta.nombre, o.nombre,t.nombre,p.precioventa FROM PRODUCTO p,MARCA m,CATEGORIA c,TAMANIO ta,ORIGEN o, TIPOPRODUCTO t  "
			+ "where p.idmarca=m.idmarca and c.idCategoria=p.idCategoria and t.idTipoProducto=p.idTipo and ta.idTamanio=p.idTamanio and o.idOrigen=p.idOrigen";
	public static final String EDITAR_PRODUCTO="UPDATE PRODUCTO SET nombre=?,idCategoria=?,genero=?,idTipo=?,idMarca=?,precioCompra=?,idTamanio=?, idOrigen=?, precioventa=?,fechaModificacion=sysdate() where idProducto=? " ;	
	public static final String ELIMINAR_PRODUCTO="DELETE FROM PRODUCTO WHERE idProducto=?";
	public static final String CONSULTAR_PRODUCTO_CATEGORIA=" and c.idCategoria=?";
	public static final String CONSULTAR_PRODUCTO_TIPO=" and t.idTipoProducto=?";
	public static final String CONSULTAR_PRODUCTO_TAMANIO=" and ta.idTamanio=?";
	public static final String CONSULTAR_PRODUCTO_ORIGEN=" and o.idOrigen=?";
	public static final String CONSULTAR_PRODUCTO_GENERO=" and p.genero=?";
	public static final String CONSULTAR_PRODUCTO_MARCA=" and m.idmarca=?";
	public static final String INSERTAR_INVENTARIO="INSERT INTO INVENTARIO(cantidad,precioVenta,idProducto,fechacreacion) values (?,?,?,sysdate())";
	public static final String INSERTAR_PARAMETRIZACION="INSERT INTO ";
	public static final String VALUES=" (nombre,fechaCreacion)values (?,sysdate())";
	public static final String CONSULTAR_OBJETO="SELECT nombre, ";
	public static final String FROM=" FROM ";
	public static final String EDITAR_MARCA="UPDATE MARCA SET nombre=?, fechaModificacion=sysdate() where idMarca=?" ;
	public static final String EDITAR_CATEGORIA="UPDATE CATEGORIA SET nombre=?, fechaModificacion=sysdate() where idCategoria=?" ;
	public static final String EDITAR_TAMANIO="UPDATE TAMANIO SET nombre=?, fechaModificacion=sysdate() where idTamanio=?" ;
	public static final String EDITAR_ORIGEN="UPDATE ORIGEN SET nombre=?, fechaModificacion=sysdate() where idOrigen=?" ;
	public static final String EDITAR_TIPO="UPDATE TIPOPRODUCTO SET nombre=?, fechaModificacion=sysdate() where idTipoProducto=? " ;
	public static final String ELIMINAR_PARAMETRIZACION="DELETE FROM ";
	public static final String WHERE=" WHERE ";
	public static final String PARAMETRO=" = ? ";
	public static final String CONSULTAR_USUARIO="SELECT U.usuario,U.contrasenia,U.ultimoingreso,U.estado,U.numeroingresos,U.intentosFallidos,P.idPerfil,P.nombre,PE.primerNombre,PE.segundoNombre,PE.primerApellido,PE.segundoApellido,PE.cargo from USUARIO U, PERFIL P,PERSONA PE"
			+ "where U.IDPERFIL=P.IDPERFIL AND U.TIPOIDENTIFICACION=PE.TIPOIDENTIFICACION AND U.IDENTIFICACION=PE.IDENTIFICACION AND USUARIO=?";
	public static final String CONSULTAR_USUARIO_SEGURIDAD="SELECT contrasenia from Usuario where USUARIO=?";
	public static final String INSERTAR_BITACORA="INSERT INTO BITACORA(accion,tabla,usuario,fechacreacion) values (?,?,?,sysdate())";
	public static final String INSERTAR_USUARIO="INSERT INTO USUARIO(usuario, contrasenia,idPerfil,estado,fechaCreacion,tipoIdentificacion,identificacion)values(?,?,?,'A',sysdate(),?,?) ";
	public static final String CONSULTAR_BITACORA="SELECT idbitacora,accion,tabla,fechaCreacion from BITACORA where usuario=?";
	public static final String INSERTAR_PERSONA="INSERT INTO PERSONA (tipoIdentificacion,identificacion, primerNombre,segundoNombre, primerApellido,segundoApellido,cargo,fechaCreacion,correo) VALUES(?,?,?,?,?,?,?,sysdate(),?)";
	public static final String INSERTAR_PERFIL="INSERT INTO PERFIL(nombre,fechaCreacion,descripcion)values(?,sysdate(),?)";
	public static final String CONSULTAR_PERSONA="SELECT tipoIdentificacion,identificacion,primerNombre,segundoNombre,primerApellido,segundoApellido,cargo,correo from PERSONA where tipoIdentificacion=? and identificacion=?";
	public static final String CONSULTAR_PERFILES="SELECT idPerfil,nombre,descripcion from PERFIL";
	public static final String EDITAR_USUARIO="UPDATE USUARIO SET contrasenia=?,idPerfil=?,estado=?,fechaModificacion=sysdate(), ultimoingreso=?, numeroingresos=?, intentosfallidos=? WHERE USUARIO=?";
	public static final String EDITAR_PERSONA="UPDATE PERSONA SET tipoIdentificacion=?,identificacion=?,primerNombre=?,segundoNombre=?,cargo=?,fechaModificacion=sysdate(),correo=?";
	public static final String EDITAR_PERFIL="UPDATE PERFIL SET nombre=?,fechaModificacion=sysdate(),descripcion=?";
	public static final String ELIMINAR_USUARIO="DELETE FROM USUARIO WHERE idUsuario=?";
	public static final String ELIMINAR_PERSONA="DELETE FROM PERSONA WHERE tipoIdentifiacion=? and identificacion=?";
	public static final String ELIMINAR_PERFIL="DELETE FROM PERFIL WHERE idPerfil=?";
	public static final String INSERTAR_ENTRADA="INSERT INTO ENTRADA(cantidad,precioVenta,idProducto,fechaCreacion)values(?,?,?,sysdate())";
	public static final String INSERTAR_SALIDA="INSERT INTO SALIDA(cantidad,idProducto,fechaCreacion)values(?,?,sysdate()) ";
	public static final String CREAR_INVENTARIO="INSERT INTO INVENTARIO(fechaCreacion,precioTotal,tipoInventario,fechaInventario)values(sysdate(),?,?,?)";
	public static final String CREAR_INVENTARIO_PERIODICO="INSERT INTO INVENTARIOPERIODICO(cantidad,precioVenta,idInventario,idProducto,fechaCreacion)values(?,?,?,?,sysdate())";
	public static final String CONSULTAR_CODIGO_INVENTARIO="SELECT idInventario,precioTotal,tipoInventario,fechaInventario from INVENTARIO order by idInventario desc limit 1";
	public static final String CONSULTAR_PRODUCTO_INVENTARIO="SELECT p.nombre,c.idCategoria,p.genero,t.idTipoProducto,m.idMarca,p.precioCompra,ta.idTamanio,p.idProducto, o.idOrigen, p.cantidad,m.nombre,c.nombre,ta.nombre, o.nombre,t.nombre,p.precioventa FROM PRODUCTO p,MARCA m,CATEGORIA c,TAMANIO ta,ORIGEN o, TIPOPRODUCTO t, inventarioperiodico ip, inventario i where p.idmarca=m.idmarca and c.idCategoria=p.idCategoria and t.idTipoProducto=p.idTipo and ta.idTamanio=p.idTamanio and o.idOrigen=p.idOrigen and  p.idproducto=ip.idproducto and i.idinventario=ip.idinventario and i.idinventario=? ";
	public static final String CONSULTAR_INVENTARIO="SELECT idinventario, preciototal,tipoinventario,fechainventario from inventario where tipoinventario=?";
	public static final String ORDENAR=" ORDER BY p.NOMBRE ASC";
	public static final String ELIMINAR_INVENTARIO_PERIODICO="DELETE FROM INVENTARIOPERIODICO WHERE idProducto=?";
	public static final String ELIMINAR_INVENTARIO_PERIODICO_PORINV="DELETE FROM INVENTARIOPERIODICO WHERE idInventario=?";
	public static final String ELIMINAR_INVENTARIO="DELETE FROM INVENTARIO WHERE idInventario=?";
}
