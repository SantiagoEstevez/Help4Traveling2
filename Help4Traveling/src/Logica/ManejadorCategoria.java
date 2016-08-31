/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Iterator;
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
    
    public boolean existeCategoria(Categoria cat){
        String nombre = cat.getNombre();
        return categoriasNom.containsKey(nombre);        
    }
    
    public Categoria obtenerCategoria(String nombre){
        return ((Categoria) categoriasNom.get(nombre));
    }
}
