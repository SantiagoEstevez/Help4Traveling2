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
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
// Comentario para que me reconozca los cambios y pueda comitear...again
/**
 *
 * @author Leonardo
 */
public class ManejadorServicio {
    //Clase que conserva la colección global de las Ofertas Servicios del Sistema
    private Map<String,Servicio> serviciosNom;
    private static ManejadorServicio instancia = null;
    private Conexion conexion;
    private String sql;
    
    private ManejadorServicio(){
        serviciosNom = new HashMap<String,Servicio>();
    }
    
    public static ManejadorServicio getInstance(){
        if (instancia == null)
            instancia = new ManejadorServicio();
        return instancia;
    }
    
    public void agregarServicio(Servicio serv){
        String nombre = serv.getNombre();
        serviciosNom.put(nombre,serv);
    }
    
    public boolean existeServicio(String nombre){
        return serviciosNom.containsKey(nombre);        
    }
    
    public Servicio obtenerServicio(String nk){
        return ((Servicio) serviciosNom.get(nk));
    }
    
    public List<DtServicio> listarServicios(){
        ResultSet rsServicios;
        ResultSet rsServImagenes;
        ResultSet rsServCategorias;
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st, sti, stc;
        String sql,sqlImagenes,sqlCategorias;
        List<DtServicio> listaServicios = new LinkedList<DtServicio>();
        List<String> listaImagenes = new LinkedList<String>();
        Map<String, DtCategoria> listaCategorias = new TreeMap<String, DtCategoria>();
       
        sql = "SELECT * FROM help4traveling.servicios";
      
        try{
            st = con.createStatement();
            rsServicios = st.executeQuery(sql);
            
            while (rsServicios.next()) {
                String nombre = rsServicios.getString("nombre");
                String proveedor = rsServicios.getString("proveedor");
                String descripcion = rsServicios.getString("descripcion");
                String precio = rsServicios.getString("precio");
                String origen = rsServicios.getString("origen");
                String destino = rsServicios.getString("destino");
                
                sqlImagenes = "SELECT * FROM help4traveling.serviciosImagenes WHERE servicio = '" + nombre + "'";
                sti = con.createStatement();
                rsServImagenes = sti.executeQuery(sqlImagenes);
                while (rsServImagenes.next()) {
                    listaImagenes.add(rsServImagenes.getString("imagen"));
                }
                rsServImagenes.close();
                sti.close();
                
                sqlCategorias = "SELECT * FROM help4traveling.serviciosImagenes WHERE servicio = '" + nombre + "'";
                stc = con.createStatement();
                rsServCategorias = stc.executeQuery(sqlImagenes);
                while (rsServCategorias.next()) {
                    String nomCat = rsServCategorias.getString("nombre");
                    DtCategoria categoria = new DtCategoria(nomCat, rsServCategorias.getString("padre"));
                    listaCategorias.put(nomCat, categoria);
                }
                rsServCategorias.close();
                stc.close();
                
                DtServicio nuevo = new DtServicio(nombre, proveedor, descripcion, listaImagenes, listaCategorias, Float.parseFloat(precio), origen, destino);
            }
            rsServicios.close();
            con.close();
            st.close();
            
            System.out.println("Servicios cargados :)");
        }catch(SQLException e){
            System.out.println("No pude cargar servicios :(");
        }
        return listaServicios;
    }
    
    public ArrayList<DtServicio> listarServiciosProveedor(DtUsuario user){
        conexion = new Conexion();
       Connection con = conexion.getConnection();
       Statement st;
       ResultSet rsServiciosProveedor;
       sql = "SELECT * FROM help4traveling.servicios WHERE proveedor='" + user.getNickname()+"'"; 
       try{
            st = con.createStatement();
            rsServiciosProveedor = st.executeQuery(sql);
            
            while (rsServiciosProveedor.next()) {
                System.out.println("llegue2");
                String nombre = rsServiciosProveedor.getString("Nombre");
                String nkproveedor = rsServiciosProveedor.getString("Proveedor");
                String descripcion = rsServiciosProveedor.getString("");
                String precio = rsServiciosProveedor.getString("Precio");
                String ciuorigen = rsServiciosProveedor.getString("Ciudad Origen");
                String ciuodestino = rsServiciosProveedor.getString("Ciudad Destino");
                
                long precioint = Integer.parseInt(precio);
                
                Servicio nuevo = new Servicio(/*idint,"REGISTRADA", cliente,null*/);
                nuevo.setNombre(nombre);
                nuevo.setPrecio(precioint);
                //nuevo.setOrigen(origen);
                this.serviciosNom.put(nombre, nuevo);
                
            } 
            rsServiciosProveedor.close();
            con.close();
            st.close();
            
            }catch(SQLException e){
           System.out.println("No hubo resultado");
       }
       
        ArrayList<DtServicio> listaServiciosProveedor = new ArrayList<>();
        Iterator<Servicio> iter = this.serviciosNom.values().iterator();
        while (iter.hasNext()){
            Servicio res =iter.next();
            listaServiciosProveedor.add(res.getDtServicio());
        }
            return listaServiciosProveedor;
    }
    
    public List<DtServicio> getDtServicios() {
        List<DtServicio> listaDtServ = new LinkedList<DtServicio>();
        Iterator<Servicio> iter = this.serviciosNom.values().iterator();
	while (iter.hasNext()) {
            Servicio serv = iter.next();            
            DtServicio dtServ = serv.getDtServicio(); 
            listaDtServ.add(dtServ);
	}
	return listaDtServ;        
    }
    
    public void persistirServicio(Servicio serv){
       Conexion conexion;
       String sql;
       conexion = new Conexion();
       Connection con = conexion.getConnection();
       Statement st;
       String categorias = "";
       List<String> imagserv = serv.getImagenes();
       String imagenes = "";
       Iterator<String> iteri = imagserv.iterator();
       while (iteri.hasNext()) {
            String img = iteri.next();
            imagenes = imagenes + img + ", ";
       }
       Map<String,Categoria> catserv = serv.getCategorias();
       Iterator<Categoria> iter = catserv.values().iterator();
       while (iter.hasNext()) {
            Categoria cat = iter.next();
            categorias = categorias + cat.getNombre() + ", ";
       }
       sql = "INSERT INTO mydb.servicios " + 
             "(Ref,Nombre,Categorias,Proveedor,`Ciudad Origen`,`Ciudad Destino`,Imágenes,`Precio (USD)`) " +
             "VALUES ('S25','" + serv.getNombre() + "','" + categorias + "','TC"/* + serv.getProveedor().getNickname()*/
             + "','" + serv.getOrigen().getNombre() + "','" + serv.getDestino().getNombre() + "','" + imagenes + "'," + serv.getPrecio() +")";
       System.out.println(sql);
       
       try{
           st = con.createStatement();
           System.out.println("antes de insertar");
           st.executeUpdate(sql);
           con.close();
           st.close();
           System.out.println("INSERTE :)");
       }
       catch (SQLException e){
           System.out.println("No pude INSERTAR :(");
       }
   }
    
}
