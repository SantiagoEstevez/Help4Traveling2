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
public abstract class Categoria {

/*    public static final int HOJA = 1;
    public static final int COMPUESTA = 2;
     */    

    
    private String nombre = "";
 
    private final CatCompuesta padre;
 //   protected int tipoCategoria;
 //   protected Categoria categoriaPadre;

    public Categoria(String nombre, CatCompuesta dad) {
        this.nombre = nombre;
        this.padre = dad;
    }
    
    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getNomPadre(){
        return this.padre.getNombre();
    }

    public CatCompuesta getPadre() {
        return padre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
  /*  
    public int getTipoCategoria(){
        return this.tipoCategoria;
    }
    
    public void setTipoCategoria( int tipoCategoria){
        this.tipoCategoria = tipoCategoria;
    }
    
    public Categoria getCategoriaPadre(){
        return this.categoriaPadre;
    }
    
    public void setCategoriaPadre(Categoria categoríaPadre){
        this.categoriaPadre = categoríaPadre;
    }*/
}