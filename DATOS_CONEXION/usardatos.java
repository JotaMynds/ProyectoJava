package DATOS_CONEXION;

import java.sql.SQLException;

public class usardatos {

	public static void main(String[] args) {
		ConexionMySQL conexion = new ConexionMySQL("root", "", "futbol");
		try {
			conexion.conectar();
			
			String sentencia = "SELECT * FROM futbolista"; //SENTENCIA
			conexion.ejecutarInsertDeleteUpdate(sentencia);
			conexion.desconectar();
			//dispose(); // en el codigo JFrame funciona
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}
