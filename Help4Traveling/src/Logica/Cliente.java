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
public class Cliente extends Usuario {
    private Map<Long, Reserva> reservasId;    
    
    //Constructor
    public Cliente(String nombre, String apellido, String nickname, String correo, Date nacimiento, String imagen) {
        super(nombre, apellido, nickname, correo, nacimiento, imagen);
        this.reservasId = new HashMap<Long, Reserva>();
    }    
    
    // Operaciones para manejar coleccion de Reservas del Servicio
    public void agregarReserva(Reserva res){
        Long id = res.getId();
        reservasId.put(id,res);
    }
    
    public boolean existeReserva(Reserva res){
        Long id = res.getId();
        return reservasId.containsKey(id);        
    }
    
    public Reserva obtenerReserva(Long id){
        return ((Reserva) reservasId.get(id));
    }
    
}
