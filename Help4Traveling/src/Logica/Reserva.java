/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Santiago
 */

public class Reserva {
    public enum eEstado{REGISTRADA,CANCELADA,PAGADA,FACTURADA};
    
    //Atributos
    private long id;
    private eEstado estado;
    private date creada;
    private double total;
    
    //Creadores
    public Reserva(){
        this.id = 0;
        this.creada = new date(16,12,1994);
        this.estado = eEstado.REGISTRADA;
        this.total = 0;
    }
    
    public Reserva(date creada, eEstado estado, float total){
        this.id = 0;
        this.estado = estado;
        this.creada = creada;
        this.total = total;
    }
    
    //Geters
    public long getId(){
        return this.id;
    }
    
    public eEstado getEstado(){
        return this.estado;
    }
    
    public date getCreada(){
        return this.creada;
    }
    
    public double getTotal(){
        return this.total;
    }
    
    //Seters    
    public void setEstado(eEstado estado){
        this.estado = estado;
    }
    
    public void setCreada(date creada){
        this.creada = creada;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
}
