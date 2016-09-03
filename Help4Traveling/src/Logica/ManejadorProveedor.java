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
    
    public boolean existeNickname(String nickname){
        boolean existe = false;
        ResultSet rs;
        Conexion conex = new Conexion();
        Connection con = conex.getConnection();
        Statement st;
        //String sql1 = "SELECT * FROM mydb.usuarios WHERE Nickname='" + nickname + "' AND Empresa <> NULL AND Link <> NULL)"; 
        String sql1 = "SELECT * FROM help4traveling.usuarios WHERE nickname='" + nickname + "'"; 
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql1);
            if (rs.next())
                existe = true;
            rs.close();
            con.close();
            st.close();           
        } catch (SQLException e){
            System.out.println("No existe proveedor :(");
        }
        return existe; 
    
        //return proveedoresNK.containsKey(nickname);        
    }
    
    public boolean existeCorreo(String correo){
        boolean existe = false;
        ResultSet rs;
        Conexion conex = new Conexion();
        Connection con = conex.getConnection();
        Statement st;
        String sql1 = "SELECT * FROM help4traveling.usuarios WHERE email='" + correo + "'"; 
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
	/*Iterator<Proveedor> iter = this.proveedoresNK.values().iterator();
	while ((iter.hasNext()) && (!existe)) {
            Proveedor prov = iter.next();
            if (prov.getCorreo() == correo)
		existe = true;
	}*/
	return existe;        
    }

    public Proveedor obtenerProveedor(String nickname){
        ResultSet rs;
        Proveedor p = null;
        Conexion conex = new Conexion();
        Connection con = conex.getConnection();
        Statement st;
        //String sql1 = "SELECT * FROM mydb.usuarios WHERE Nickname='" + nickname + "' AND Empresa <> NULL AND Link <> NULL)"; 
        String sql1 = "SELECT * FROM mydb.usuarios WHERE Nick='" + nickname + "'";  
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql1);
            if (rs.next()) {
                Date fecha = new Date();
                p = new Proveedor(rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Nick"),rs.getString("Correo"),fecha,"imagen","empresa","link");
            }            
            rs.close();
            con.close();
            st.close();           
        } catch (SQLException e){
            System.out.println("No obtuve proveedor :(");
        }
        return p;
        //return ((Proveedor) proveedoresNK.get(nickname));
    }
    
    
    public ArrayList<DtUsuario> listarProveedores(){
        
        ResultSet rsProveedores;
        
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
              
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
       
    public String persistirProveedor(Proveedor prov){
       Conexion conexion;
       System.out.println("Entro a persistir");
       conexion = new Conexion();
       String mensaje = "Se dio de alta al Usuario Proveedor.";
       Connection con = conexion.getConnection();
       Statement st;
       /*char pn = prov.getNombre().charAt(0);
       char pa = prov.getApellido().charAt(0);
       StringBuilder sb = new StringBuilder();
       sb.append(pn);
       sb.append(pa);
       String ref = sb.toString();*/
     if (!existeNickname(prov.getNickname())) {  
       String fecha = String.valueOf(prov.getNacimiento().getAno()) + "-" + String.valueOf(prov.getNacimiento().getMes()) + "-" + String.valueOf(prov.getNacimiento().getDia());
       String sqlau = "INSERT INTO help4traveling.usuarios " + 
             "(nickname,nombre,apellido,email,imagen,fechaNac) " +
             "VALUES ('" + prov.getNickname() + "','" + prov.getNombre() + "','" + prov.getApellido() + "','" + prov.getCorreo() 
             + "','" + prov.getImagen() + "','" + fecha + "')";
       System.out.println(sqlau);
       String sqlap = "INSERT INTO help4traveling.proveedores (nickname,empresa,link) VALUES ('" + prov.getNickname() + "','" + prov.getEmpresa() + "','" + prov.getLink() + "')";
       try{
           st = con.createStatement();
           System.out.println("antes de insertar");
           st.executeUpdate(sqlau);
           st.executeUpdate(sqlap);
           con.close();
           st.close();
           System.out.println("INSERTE :)");
       }
       catch(SQLException e){
           System.out.println("No pude INSERTAR :(");
       }
     }
     else mensaje = "ERROR: El Nickname ingresado ya existe.";
     return mensaje;      
   }
    
}
