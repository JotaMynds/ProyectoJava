package TESTEOS;

import DATOS_CONEXION.ConexionOracle;

public class PRUEBAS_CONEXIONES_ORACLE_MYSQL {
    public static void main(String[] args) {
        try {
            ConexionOracle conn = new ConexionOracle("hr", "hr123", "XEPDB1");
            conn.conectar();
            System.out.println("¡Conexión exitosa!");
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("Error en la conexión:");
            e.printStackTrace();
        }
    }
}