/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author Santiago
 */

public class Reserva {
    public enum eEstado{REGISTRADA,CANCELADA,PAGADA,FACTURADA};
    
    //Atributos
    private long id;
    private eEstado estado;
    private Date creada;
    private double total;
    private List<ItemReserva> items;
    
    //Creadores
    public Reserva(){
        this.id = 0;
        this.creada = new Date(16,12,1994);
        this.estado = eEstado.REGISTRADA;
        this.total = 0;
        this.items = null;
    }
    
    public Reserva(Date creada, eEstado estado, float total){
        this.id = 0;
        this.estado = estado;
        this.creada = creada;
        this.total = total;
        this.items = null;
    }
    
    //Geters
    public long getId(){
        return this.id;
    }
    
    public eEstado getEstado(){
        return this.estado;
    }
    
    public Date getCreada(){
        return this.creada;
    }
    
    public double getTotal(){
        return this.total;
    }

    public List<ItemReserva> getItems() {
        return items;
    }
    
    //Seters    
    public void setEstado(eEstado estado){
        this.estado = estado;
    }
    
    public void setCreada(Date creada){
        this.creada = creada;
    }
    
    public void setTotal(double total){
        this.total = total;
    }

    public void setItems(List<ItemReserva> items) {
        this.items = items;
    }    
    
}
