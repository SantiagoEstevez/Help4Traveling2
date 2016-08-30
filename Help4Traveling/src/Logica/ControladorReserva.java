/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


public class ControladorReserva implements IControladorReserva {
    //public enum eTipoItem{SERVICIO,PROMOCION};
    private Reserva nueva;
    
    public void nuevaRserva(String nickname, double precio) {
        nueva = new Reserva();
        nueva.setTotal(precio);
        nueva.setCliente(nickname);
    }
    
    public void agregarItem(int cantidad, Date fi, Date ff){
        nueva.agregarItem(cantidad, fi, ff, cantidad);
        
    }
    
    public void altaDeReserva() {
        
    }
    
    public void actualizarEstadoDeReserva() {
        
    }
    
    public void verInfoDeReserva() {
        
    }
    
    public void cancelarUnaReserva() {
        
    }
    
    
}
