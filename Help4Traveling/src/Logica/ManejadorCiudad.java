/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
    
    public boolean existeCiudad(String nombre){
        return ciudadesNom.containsKey(nombre);        
    }
    
    public Ciudad obtenerCiudad(String nombre){
        return ((Ciudad) ciudadesNom.get(nombre));
    }
    
}
