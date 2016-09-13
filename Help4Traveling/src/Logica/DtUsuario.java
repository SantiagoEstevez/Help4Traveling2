/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
// Comentario para que me reconozca los cambios y pueda comitear...

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leonardo
 */
public class DtUsuario {

    private String nombre;
    private String apellido;
    private String nickname;
    private String correo;
    private Date nacimiento;
    private String imagen;
    private String tipo;
    private String empresa;
    private String link;
    private Conexion conexion;
    private String sql;

    public DtUsuario(String nombre, String apellido, String nickname, String correo, Date nacimiento, String imagen, String tipo, String empresa, String link) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.imagen = imagen;
        this.tipo = tipo;
        this.empresa = empresa;
        this.link = link;
    }

    public DtUsuario(String nombre, String apellido, String nickname, String correo, Date nacimiento, String imagen, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    public DtUsuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getNacimiento() {
        return nacimiento;
        /*//conexion = new Conexion();
       Connection con = Conexion.getInstance().getConnection();
        if (con != null) {
       Statement st;
       ResultSet rsFecha;
       String fechanac = null;
       
       String sql1 = "SELECT * FROM usuarios WHERE nickname='" + this.nickname + "'";
       try {
            st = con.createStatement();
            
            rsFecha = st.executeQuery(sql1);
            rsFecha.next();
            fechanac = rsFecha.getString("fechaNac");
            
            rsFecha.close();
            //con.close();
            st.close();           
        } catch (SQLException e){
            System.out.println("No tiene Fecha :(");
            System.err.println(e.getMessage());
          }
       Date fechan = new Date(fechanac);
       return fechan;
         */
    }

    public String getImagen() {
        return imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEmpresa() {
        return empresa;
        /*//conexion = new Conexion();
       Connection con = Conexion.getInstance().getConnection();
        if (con != null) {
       Statement st;
       ResultSet rsEmpresa;
       String empresaprov = null;
       
       String sql1 = "SELECT * FROM proveedores WHERE nickname='" + this.nickname + "'";
       try {
            st = con.createStatement();
            
            rsEmpresa = st.executeQuery(sql1);
            rsEmpresa.next();
            empresaprov = rsEmpresa.getString("empresa");
            
            rsEmpresa.close();
            //con.close();
            st.close();           
        } catch (SQLException e){
            System.out.println("No tiene Empresa :(");
            System.err.println(e.getMessage());
          }
       
       return empresaprov;
         */
    }

    public String getLink() {
        return link;
        /*//conexion = new Conexion();
       Connection con = Conexion.getInstance().getConnection();
        if (con != null) {
       Statement st;
       ResultSet rsLink;
       String empresalink = null;
       
       String sql1 = "SELECT * FROM proveedores WHERE nickname='" + this.nickname + "'";
       try {
            st = con.createStatement();
            
            rsLink = st.executeQuery(sql1);
            rsLink.next();
            empresalink = rsLink.getString("link");
            
            rsLink.close();
            //con.close();
            st.close();           
        } catch (SQLException e){
            System.out.println("No tiene Link :(");
            System.err.println(e.getMessage());
          }
       
       return empresalink;    }   
         */
    }
}

