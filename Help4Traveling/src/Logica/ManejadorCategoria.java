/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
// Comentario para que me reconozca los cambios y pueda comitear...
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
    
    public List<String> getNombresCategorias(){
        List<String> listaCat = new LinkedList<String>();
        Iterator<Categoria> iter = this.categoriasNom.values().iterator();
	while (iter.hasNext()) {
            Categoria cat = iter.next();
            listaCat.add(cat.getNombre());
	}
	return listaCat;        
    }
}
