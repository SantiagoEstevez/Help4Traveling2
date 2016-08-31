/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


public class ControladorReserva implements IControladorReserva {   
    
    //Crear una nueva reserva
    public Reserva nuevaRserva(String nickname, double precio) {
        Reserva nueva = new Reserva();
        nueva.setTotal(precio);
        nueva.setCliente(nickname);
        return nueva;
    }
    
    public void agregarItem(Reserva nueva, int cantidad, Date fi, Date ff, Oferta oferta){
        System.out.println("llegue");
        System.out.println(nueva.getTotal());
        nueva.agregarItem(cantidad, fi, ff, oferta);
    }
    
    public dtReserva verReserva(Reserva nueva) {
        return nueva.verReserva();
    }
    
    public void altaReserva(Reserva nueva) {
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
