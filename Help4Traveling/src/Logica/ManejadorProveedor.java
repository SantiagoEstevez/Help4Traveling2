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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
// Comentario para que me reconozca los cambios y pueda comitear...again
/**
 *
 * @author Leonardo
 */
public class ManejadorProveedor {
    //Clase que conserva la colección global de los Usuarios Proveedores del Sistema
    private Map<String,Proveedor> proveedoresNK;
    private static ManejadorProveedor instancia = null;
    private Conexion conexion;
    private String sql;
    
    private ManejadorProveedor(){
        proveedoresNK = new HashMap<String,Proveedor>();
    }
    
    public static ManejadorProveedor getInstance(){
        if (instancia == null)
            instancia = new ManejadorProveedor();
        return instancia;
    }
    
    public void agregarProveedor(Proveedor prov){
        String nk = prov.getNickname();
        proveedoresNK.put(nk,prov);
    }
    
    public boolean existeProveedor(String nickname){
        return proveedoresNK.containsKey(nickname);        
    }
    
    public boolean existeCorreo(String correo){
        boolean existe = false;
	Iterator<Proveedor> iter = this.proveedoresNK.values().iterator();
	while ((iter.hasNext()) && (!existe)) {
            Proveedor prov = iter.next();
            if (prov.getCorreo() == correo)
		existe = true;
	}
	return existe;        
    }

    public Proveedor obtenerProveedor(String nickname){
        return ((Proveedor) proveedoresNK.get(nickname));
    }
    
    
    public ArrayList<DtUsuario> listarProveedores(){
        
        ResultSet rsProveedores;
        
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        
        String sitios = "mydb.sitios web y empresas de proveedores";
       
        sql = "SELECT * FROM mydb.usuarios, mydb.sitios WHERE mydb.usuarios.Ref = mydb.sitios.Ref"; 

        
        try{
            st = con.createStatement();
            rsProveedores = st.executeQuery(sql);
            String tabla = rsProveedores.toString();
            
            
            System.out.println("realize el executeQuery" + tabla);
            
            System.out.println("llegue");
            
            while (rsProveedores.next()) {
                String nombre = rsProveedores.getString("Nombre");

                String apellido = rsProveedores.getString("Apellido");
                String nickname = rsProveedores.getString("Nick");
                String correo = rsProveedores.getString("Email");

                Date nacimiento = new Date(12,12,1994);
                String imagen = "";
                //String empresa = rsProveedores.getString("Empresa");
                //String direccion = rsProveedores.getString("Direccion");
                Proveedor nuevo = new Proveedor(nombre, apellido, nickname, correo, nacimiento, imagen,"empresa","direccion");
                proveedoresNK.put(nickname, nuevo);
            }
            rsProveedores.close();
            con.close();
            st.close();
            
            System.out.println("Usuarios cargados :)");
        }catch(SQLException e){
            System.out.println("No pude cargar usuarios :(");
        }
        
          ArrayList<DtUsuario> listaProveedores = new ArrayList<>();
        Iterator<Proveedor> iter = this.proveedoresNK.values().iterator();
        while (iter.hasNext()){
            Proveedor pr =iter.next();
            listaProveedores.add(pr.getDtUsuario());
        }
            return listaProveedores;
    }           
       
}
