package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.Conexion;

public class ConexionTest {
	public ConexionTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void teadDownClass() {		
	}
	
	@Before
	public void setUp(){
		
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
    public void testGetConnection() {
        Conexion conexion = new Conexion();
        try {
            Connection con = conexion.getConnection();
            assertNotNull("La conexión no debe ser nula", con);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Excepción al intentar obtener la conexión: " + e.getMessage());
        }
    }
	
	 @Test(expected = SQLException.class)
	    public void testInvalidURL() throws SQLException {
	        Conexion conexion = new Conexion();
	        conexion.getConnectionWithInvalidURL();
	    }
	 
	 @Test
	 public void testInvalidCredentials() {
	     Conexion conexion = new Conexion();
	     Connection con = conexion.getConnectionWithCredentials("usuarioIncorrecto", "contrasenaIncorrecta");
	     assertNull("La conexión debe ser nula con credenciales incorrectas", con);
	 }

}
