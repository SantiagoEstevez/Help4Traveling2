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
    
    public boolean existeCliente(String nickname){
        return clientesNK.containsKey(nickname);        
    }
    
    public boolean existeCorreo(String correo){
        boolean existe = false;
	Iterator<Cliente> iter = this.clientesNK.values().iterator();
	while ((iter.hasNext()) && (!existe)) {
            Cliente cli = iter.next();
            if (cli.getCorreo() == correo)
		existe = true;
	}
	return existe;        
    }

    public Cliente obtenerCliente(String nk){
        return ((Cliente) clientesNK.get(nk));
    }
    
    public ArrayList<DtUsuario> listarClientes(){
        ArrayList<DtUsuario> listaClientes = new ArrayList<DtUsuario>();
        Iterator<Cliente> iter = this.clientesNK.values().iterator();
        while (iter.hasNext()){
            Cliente cli =iter.next();
            listaClientes.add(cli.getDtUsuario());
        }
            return listaClientes;
    }
    
    //Obtener clientes de la base de datos.
    public void setClientesDB() {
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
       
       
    }
    
}

