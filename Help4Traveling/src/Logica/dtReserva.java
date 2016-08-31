/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Santiago
 */
public class dtReserva {
    //Atributos
    private long id;
    private Reserva.eEstado estado;
    private Date creada;
    private double total;
    private String cliente;
    private Map<Integer, ItemReserva> items;
    
    //Creadores    
    public dtReserva(long id, Date creada, Reserva.eEstado estado, double total, String cliente, Map<Integer, ItemReserva> items){
        this.id = id;
        this.estado = estado;
        this.creada = creada;
        this.total = total;
        this.cliente = cliente;
        this.items = items;
    }
    
    //Geters
    public long getId(){
        return this.id;
    }
    
    public Reserva.eEstado getEstado(){
        return this.estado;
    }
    
    public Date getCreada(){
        return this.creada;
    }
    
    public String getCliente(){
        return this.cliente;
    }
    
    public double getTotal(){
        return this.total;
    }

    public Map<Integer, ItemReserva> getItems() {
        return items;
    }
}
