package EJEMPLOS;

import java.sql.SQLException;

public class pruebas {

	public static void main(String[] args) {
		ConexionMySQL conexion = new ConexionMySQL("root", "", "futbol"); // CONEXION CON LA TABLA
		
		try {
			conexion.conectar();
			String sentencia = "INSERT INTO futbolista (Nombre, Edad) VALUES ('manue' ,20)"; // DECLARACION DE LA SENTENCIA

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
