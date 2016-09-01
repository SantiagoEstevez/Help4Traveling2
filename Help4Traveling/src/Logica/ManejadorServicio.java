/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
// Comentario para que me reconozca los cambios y pueda comitear...
/**
 *
 * @author Leonardo
 */
public class ManejadorServicio {
    //Clase que conserva la colección global de las Ofertas Servicios del Sistema
    private Map<String,Servicio> serviciosNom;
    private static ManejadorServicio instancia = null;
    
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
    
    public List<String> listarServicios(){
        List<String> listaserv = new ArrayList<String>();
        Iterator<Servicio> iter = this.serviciosNom.values().iterator();
        while (iter.hasNext()){
            Servicio serv = iter.next();
            listaserv.add(serv.getNombre());
            
        }
        return listaserv;
        
        
    }
}
