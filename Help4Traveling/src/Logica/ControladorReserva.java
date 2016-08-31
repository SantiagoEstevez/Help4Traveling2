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
    
    public void agregarItem(int cantidad, Date fi, Date ff, Oferta oferta){
        nueva.agregarItem(cantidad, fi, ff, oferta);
    }
    
    public dtReserva verReserva() {
        return nueva.verReserva();
    }
    
    public void altaReserva() {
        ManejadorReserva mr = ManejadorReserva.getInstance();
        mr.altaReserva(nueva);
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
