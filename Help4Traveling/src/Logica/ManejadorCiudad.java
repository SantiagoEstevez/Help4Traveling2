/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
// Comentario para que me reconozca los cambios y pueda comitear...
/**
 *
 * @author Leonardo
 */
public class ManejadorCiudad {
    //Clase que conserva la colección global de las Ciudads del Sistema
    private Map<String,Ciudad> ciudadesNom;
    private static ManejadorCiudad instancia = null;
    
    private ManejadorCiudad(){
        ciudadesNom = new HashMap<String,Ciudad>();
    }
    
    public static ManejadorCiudad getInstance(){
        if (instancia == null)
            instancia = new ManejadorCiudad();
        return instancia;
    }
    
    public void agregarCiudad(Ciudad ciu){
        String nombre = ciu.getNombre();
        ciudadesNom.put(nombre,ciu);
    }
    
    public boolean existeCiudad(String nombre/*, String pais*/){
        boolean existe;
        ResultSet rs;
        Ciudad ciu = null;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        //String sql = "SELECT * FROM mydb.ciudades, mydb.paises WHERE Pais='" + pais + "' AND Nombre='" + nombre + "')"; 
        String sql = "SELECT * FROM mydb.ciudades WHERE Nombre='" + nombre + "')"; 
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); 
            Pais p = new Pais(rs.getString("Pais"),null);
            ciu = new Ciudad(rs.getString("Nombre"),p);
            rs.close();
            con.close();
            st.close();           
        } catch (SQLException e){
            System.out.println("No obtuve ciudad :(");
        }
        if (ciu == null)
            existe = false;
        else existe = true;
        return existe; 
        //return ciudadesNom.containsKey(nombre);        
    }
    
    public Ciudad obtenerCiudad(String nombre/*, String pais*/){
        ResultSet rs;
        Ciudad ciu = null;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        //String sql = "SELECT * FROM mydb.ciudades, mydb.paises WHERE Pais='" + pais + "' AND Nombre='" + nombre + "')"; 
        String sql = "SELECT * FROM mydb.ciudades WHERE Nombre='" + nombre + "')"; 
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); 
            //Pais p = new Pais(rs.getString("Pais"),null);
            ciu = new Ciudad(rs.getString("Nombre"),null/*,p*/);
            rs.close();
            con.close();
            st.close();           
        } catch (SQLException e){
            System.out.println("No obtuve ciudad :(");
        }
        return ciu; 
        //return ((Ciudad) ciudadesNom.get(nombre));
    }
    
}
