package Logica;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class Conexion {

    private static String servidor = "jdbc:mysql://localhost:3306/help4traveling?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String pass = "santiagopako";
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection conexion;

    public Conexion() {
        try {
            Class.forName(driver).newInstance();
            try {
                conexion = DriverManager.getConnection(servidor, user, pass);
            } catch (SQLException ex) {
                System.out.println("Error al conectar con el servidor de base de datos.");
            }
            System.out.println("Conecte");
        } catch (Exception e) {
            System.out.println("Error al cargar los driver.");
        }
    }

    public Connection getConnection() {
        return conexion;
    }
}
