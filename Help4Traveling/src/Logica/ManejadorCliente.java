/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.sql.ResultSet;

// Comentario para que me reconozca los cambios y pueda comitear...
/**
 *
 * @author Leonardo
 */
public class ManejadorCliente {
    //Clase que conserva la colección global de los Usuarios Clientes del Sistema
    private Map<String,Cliente> clientesNK;
    private static ManejadorCliente instancia = null;
    private Conexion conexion;
    private String sql;
    
    private ManejadorCliente(){
        clientesNK = new HashMap<String,Cliente>();
    }
    
    public static ManejadorCliente getInstance(){
        if (instancia == null)
            instancia = new ManejadorCliente();
        return instancia;
    }
    
    public void agregarCliente(Cliente cli){
        String nk = cli.getNickname();
        clientesNK.put(nk,cli);
    }
    
    public boolean existeNickname(String nickname){
        boolean existe = false;
        ResultSet rs;
        Conexion conex = new Conexion();
        Connection con = conex.getConnection();
        Statement st;
        String sql1 = "SELECT * FROM mydb.usuarios WHERE Nickname=" + nickname; 
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql1);
            if (rs.next())
                existe = true;
            rs.close();
            con.close();
            st.close();           
        } catch (SQLException e){
            System.out.println("No exite cliente :(");
        }
        return existe;
        //return clientesNK.containsKey(nickname);        
    }
    
    public boolean existeCorreo(String correo){
        boolean existe = false;
        ResultSet rs;
        Conexion conex = new Conexion();
        Connection con = conex.getConnection();
        Statement st;
        String sql1 = "SELECT * FROM mydb.usuarios WHERE Correo=" + correo; 
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql1);
            if (rs.next())
                existe = true;
            rs.close();
            st.close();  
            con.close();
        } catch (SQLException e){
            System.out.println("No existe correo :(");
        }
	/*Iterator<Cliente> iter = this.clientesNK.values().iterator();
	while ((iter.hasNext()) && (!existe)) {
            Cliente cli = iter.next();
            if (cli.getCorreo() == correo)
		existe = true;
	}*/        
	return existe;        
    }

    public Cliente obtenerCliente(String nk){
        
        ResultSet rsCliente;
        Cliente cl = null;
        
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        
        sql = "SELECT * FROM mydb.usuarios WHERE Nick=" + nk; 
        
        try{
            st = con.createStatement();
            rsCliente = st.executeQuery(sql);   
            
            Date fecha = new Date();
            cl = new Cliente(rsCliente.getString("Nombre"),rsCliente.getString("Apellido"),rsCliente.getString("Nick"),rsCliente.getString("Correo"),fecha,"imagen");

        
            rsCliente.close();
            con.close();
            st.close();
           
        } catch(SQLException e){
            System.out.println("No pude cargar usuarios :(");
        }
        return cl; 
        
    } 
        
        //return ((Cliente) clientesNK.get(nk));

    
    //Obtener clientes de la base de datos.
    public ArrayList<DtUsuario> listarClientes() {
        ResultSet rsClientes;
        
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
       
        sql = "SELECT * FROM mydb.usuarios";
       
        try{
            st = con.createStatement();
            rsClientes = st.executeQuery(sql);
            
            System.out.println("llegue");
            
            while (rsClientes.next()) {
                System.out.println("llegue2");
                String nombre = rsClientes.getString("Nombre");
                String apellido = rsClientes.getString("Apellido");
                String nickname = rsClientes.getString("Nick");
                String correo = rsClientes.getString("Email");
                Date nacimiento = new Date(12,12,1994);
                String imagen = "";
                
                Cliente nuevo = new Cliente(nombre, apellido, nickname, correo, nacimiento, imagen);
                clientesNK.put(nickname, nuevo);
            }
            rsClientes.close();
            con.close();
            st.close();
            
            System.out.println("Usuarios cargados :)");
        }catch(SQLException e){
            System.out.println("No pude cargar usuarios :(");
        }
        
          ArrayList<DtUsuario> listaClientes = new ArrayList<>();
        Iterator<Cliente> iter = this.clientesNK.values().iterator();
        while (iter.hasNext()){
            Cliente cli =iter.next();
            listaClientes.add(cli.getDtUsuario());
        }
            return listaClientes;
    }
        
    public void persistirCliente(Cliente cli){
       Conexion conexion = new Conexion();
       Connection con = conexion.getConnection();
       Statement st;
       char pn = cli.getNombre().charAt(0);
       char pa = cli.getApellido().charAt(0);
       StringBuilder sb = new StringBuilder();
       sb.append(pn);
       sb.append(pa);
       String ref = sb.toString();
       String fecha = String.valueOf(cli.getNacimiento().getAno()) + "-" + String.valueOf(cli.getNacimiento().getMes()) + "-" + String.valueOf(cli.getNacimiento().getDia());
       String sqlac = "INSERT INTO mydb.usuarios " + 
             "(Ref,Nick,Email,Nombre,Apellido,Nacimiento) " +
             "VALUES ('" + ref + "','" + cli.getNickname() + "','" + cli.getCorreo() + "','" + cli.getNombre() 
             + "','" + cli.getApellido() + "','" + fecha + "')";
       System.out.println(sqlac);
       String sqlai = "INSERT INTO mydb.`imágenes de usuarios` (Ref,Imagen) VALUES ('" + ref + "','" + cli.getImagen() + "')";
       System.out.println(sqlai);
       try{
           st = con.createStatement();
           System.out.println("antes de insertar");
           st.executeUpdate(sqlac);
           st.executeUpdate(sqlai);
           con.close();
           st.close();
           System.out.println("INSERTE :)");
       }
	   catch(SQLException e){
           System.out.println("No pude INSERTAR :(");
       }
   }   
       
 }
    

