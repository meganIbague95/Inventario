package com.inventario.conexion;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.inventario.utilidades.Constantes;

public class ConnectionManagerJDBC {

	public static Properties propertiesGeneral;

	public static Connection getConnection() throws Exception {

		Connection connection = null;
		try {
			if(propertiesGeneral == null){
				propertiesGeneral = new Properties();
				FileInputStream abrirProperties = new FileInputStream(Constantes.ARCHIVO_PROPIEDADES_DB);
				propertiesGeneral.load(abrirProperties);
			}
			String url = Constantes.URL;
			String ip = propertiesGeneral.getProperty(Constantes.IP_BD);
			String port = propertiesGeneral.getProperty(Constantes.PUERTO);
			String instancia = propertiesGeneral.getProperty(Constantes.INSTANCIA);
			String usuario = propertiesGeneral.getProperty(Constantes.USUARIO);
			String password = propertiesGeneral.getProperty(Constantes.CONSTRASENIA);

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Va a retornar conexión JBDC:" + url + ip + ":" + port + "/" + instancia + "," + usuario
					+ "," + password);
			connection = DriverManager.getConnection(url + ip + ":" + port + "/" + instancia, usuario, password);
			connection.setAutoCommit(false);


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return connection;

	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection connection, boolean commit) throws Exception {
		try {
			if (!connection.isClosed() && connection != null) {
				if (commit) {
					connection.commit();
				} else {
					connection.rollback();
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionManagerJDBC.closeConnection(connection);
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closePreparedStatement(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement s) {
		try {
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeCallableStatement(CallableStatement cs) {
		try {
			if (cs != null) {
				cs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
