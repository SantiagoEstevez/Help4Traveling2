/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class ManejadorCliente {
    //Clase que conserva la colección global de los Usuarios Clientes del Sistema
    private Map<String,Cliente> clientesNK;
    private static ManejadorCliente instancia = null;
    
    private ManejadorCliente(){
        clientesNK = new HashMap<String,Cliente>();
    }
    
    public static ManejadorCliente getinstance(){
        if (instancia == null)
            instancia = new ManejadorCliente();
        return instancia;
    }
    
    public void agregarCliente(Cliente cli){
        String nk = cli.getNickname();
        clientesNK.put(nk,cli);
    }
    
    public boolean existeCliente(Cliente cli){
        String nk = cli.getNickname();
        return clientesNK.containsKey(nk);        
    }
    
    public Cliente obtenerCliente(String nk){
        return ((Cliente) clientesNK.get(nk));
    }
    
}

