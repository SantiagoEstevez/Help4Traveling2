/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 *
 * @author Leonardo
 */
public class ManejadorProveedor {
    //Clase que conserva la colección global de los Usuarios Proveedores del Sistema
    private Map<String,Proveedor> proveedoresNK;
    private static ManejadorProveedor instancia = null;
    
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
    
    public boolean existeProveedor(Proveedor prov){
        String nk = prov.getNickname();
        return proveedoresNK.containsKey(nk);        
    }
    
    public boolean existeNickname(String nk){
        return proveedoresNK.containsKey(nk);        
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

    public Proveedor obtenerProveedor(String nk){
        return ((Proveedor) proveedoresNK.get(nk));
    }
    
}
