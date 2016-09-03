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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class ManejadorCategoria {
    //Clase que conserva la colección global de las Categorias del Sistema
    private Map<String,Categoria> categoriasNom;
    private static ManejadorCategoria instancia = null;
    
    private ManejadorCategoria(){
        categoriasNom = new HashMap<String,Categoria>();
    }
    
    public static ManejadorCategoria getInstance(){
        if (instancia == null)
            instancia = new ManejadorCategoria();
        return instancia;
    }
    
    public void agregarCategoria(Categoria cat){
        String nombre = cat.getNombre();
        categoriasNom.put(nombre,cat);
    }
    
    public boolean existeCategoria(String nombre){
        return categoriasNom.containsKey(nombre);        
    }
    
     public boolean existeCategoria(Categoria cat){
        String nombre = cat.getNombre();
        return categoriasNom.containsKey(nombre);        
    }
    
    
    public Categoria obtenerCategoria(String nombre){
        return ((Categoria) categoriasNom.get(nombre));
    }
    
    public void eliminarCategoria(String nombre){
        categoriasNom.remove(nombre);
    
    }
    
    public void sustituirCategoria(String nombre,Categoria cat){
        categoriasNom.replace(nombre, cat);
  }
    
    public List<String> getNombresCategorias() {
        List<String> listaCat = new LinkedList<String>();
        /*Iterator<Categoria> iter = this.categoriasNom.values().iterator();
	while (iter.hasNext()) {
            Categoria cat = iter.next();
            listaCat.add(cat.getNombre());
	}*/
        Conexion conexion;
        conexion = new Conexion();
        Connection con = conexion.getConnection();
		String sql = "SELECT * FROM mydb.categorias";
        try{
			Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
                listaCat.add(rs.getString("Nombre"));	
            rs.close();
            st.close();
            con.close();
        }
        catch(SQLException e){
           System.out.println("No pude LISTAR :(");
        }
	return listaCat;        
    }
}
