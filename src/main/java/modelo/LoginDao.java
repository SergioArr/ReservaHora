package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.Conexion;

public class LoginDao {
public static int validar(String user, String pass) {
		
		Connection con;
		Conexion cn = new Conexion();
		
		PreparedStatement ps;
		ResultSet rs;
		String us = "";
		int valido = 0;
		String sql = "SELECT * FROM mydb.usuario WHERE  username = ? and password = ?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				us = rs.getString("user");
			}
			if (us.equals("admin")) {
				valido = 1;
			}
			else {
				valido = 0;
			}
		}
		catch (Exception e)
		{
			
		}
		return valido;
		
	}

public static boolean validarUsuario(String user, String pass) {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    boolean valido = false;
    String sql = "SELECT * FROM mydb.usuario WHERE username = ? AND password = ?";

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);
        rs = ps.executeQuery();

        if (rs.next()) {
            valido = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return valido;
}

public static Persona obtenerInformacionPersona(String username) {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    Persona persona = null;
    String sql = "SELECT * FROM mydb.usuario u " +
                 "INNER JOIN mydb.persona p ON u.Rut = p.Rut " +
                 "WHERE u.username = ?";

    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        rs = ps.executeQuery();

        if (rs.next()) {
            int rut = rs.getInt("Rut");
            String nombre = rs.getString("Nombre");
            String apellido = rs.getString("Apellido");
            String telefono = rs.getString("Telefono");
            persona = new Persona(rut, nombre, apellido, telefono);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return persona;
}

}
