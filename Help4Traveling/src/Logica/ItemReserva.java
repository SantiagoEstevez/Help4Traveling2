/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Leonardo
 */
public class ItemReserva {
    private int id;
    private int cantidad;
    private Date inicio;
    private Date fin;
    private int idOferta;
    
    public ItemReserva() {
        
    }

    public ItemReserva(int id, int cantidad, Date inicio, Date fin, int idOferta) {
        this.id = id;
        this.cantidad = cantidad;
        this.inicio = inicio;
        this.fin = fin;
        this.idOferta = idOferta;
    }
    
    //Geters
    public int getId() {
        return this.id;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public Date getInicio() {
        return this.inicio;
    }

    public Date getFin() {
        return this.fin;
    }

    public int getIdOferta() {
        return this.idOferta;
    }

    //Seters
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }   
    
    
}
