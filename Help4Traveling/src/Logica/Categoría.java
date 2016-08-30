/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author yaman
 */
public abstract class Categoría {
    public static final int HOJA = 1;
    public static final int COMPUESTA = 2;
    
    protected String nombre = "";
    protected int tipoCategoría;
    protected Categoría categoríaPadre;
    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getTipoCategoría(){
        return this.tipoCategoría;
    }
    
    public void setTipoCategoría( int tipoCategoría){
        this.tipoCategoría = tipoCategoría;
    }
    
    public Categoría getCategoríaPadre(){
        return this.categoríaPadre;
    }
    
    public void setCategoríaPadre(Categoría categoríaPadre){
        this.categoríaPadre = categoríaPadre;
    }
}

