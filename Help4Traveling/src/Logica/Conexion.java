package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    Conector conector = Conector.getInstance();

    private String servidor = conector.getServidor();
    private String usuario = conector.getUsuario();
    private String clave = conector.getClave();
    private String driver = conector.getDriver();

    private static Connection conexion;

    private Conexion() {
        nuevaConexion();
    }

    public static Conexion getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {

        private static final Conexion INSTANCE = new Conexion();
    }

    public void nuevaConexion() {
        try {
            System.out.print("Conectando al servidor: ");
            Class.forName(driver).newInstance();
            try {
                conexion = DriverManager.getConnection(servidor, usuario, clave);
                System.out.println("OK");
            } catch (SQLException ex) {
                System.out.println("ERROR.");
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "No se pudo establecer la Conexión.", "Aviso", JOptionPane.ERROR_MESSAGE);
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR.");
            System.out.println(e);
        }
    }

    public void cerrarConexion() throws SQLException {
        if ((conexion != null) && (conexion.isValid(0))) {
            conexion.close();
        }
    }

    public Boolean getEstado() throws SQLException {
        return ((conexion != null) && (conexion.isValid(0)));
    }

    public Connection getConnection() {
        return conexion;
    }

    public void ejecutarSentencia(String sentencia, Boolean update) {
        Statement st;
        String sql;
        sql = sentencia;
        try {
            st = conexion.createStatement();
            if (update) {
                st.executeUpdate(sql);
            } else {
                ResultSet rs;
                rs = st.executeQuery(sql);
                rs.close();
            }
            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
