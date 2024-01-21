package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
Connection con;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "root", "contrasena");
			
		}catch (Exception e) {
			
		}
		return con;
	}
	
	public Connection getConnectionWithInvalidURL() throws SQLException {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/invaliddb?serverTimezone=UTC", "root", "contrasena");
	    } catch (SQLException e) {
	        throw e;
	    } catch (Exception e) {
	        throw new SQLException("Error al conectar con URL incorrecta", e);
	    }
	    return con;
	}
	
	public Connection getConnectionWithCredentials(String user, String password) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", user, password);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    return con;
	}
	

}
