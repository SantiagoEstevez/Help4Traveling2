/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;


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
    
    public DtReserva verReserva(Reserva nueva) {
        return nueva.getDtReserva();
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
    
    public Boolean cancelarUnaReserva(long id) {
        ManejadorReserva mr = ManejadorReserva.getInstance();
        return mr.cancelarReserva(id);
    }
    
    public List<DtReserva> listarReservas() {
        ManejadorReserva mr = ManejadorReserva.getInstance();
        return mr.listarReservas();
    }
    
    public void setReservasDB() {
        ManejadorReserva mr = ManejadorReserva.getInstance();
        mr.setReservasDB();
    }
}
