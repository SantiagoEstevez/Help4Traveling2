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

import java.util.ArrayList;
import java.util.List;


public class CatCompuesta extends Categoria {
    List<Categoria> categorías = new ArrayList<Categoria>();
    
    public CatCompuesta(String nombre, Categoria categoríaPadre){
            this.setTipoCategoria(Categoria.COMPUESTA);
            this.setNombre(nombre);  
            this.setCategoriaPadre(categoríaPadre);
            
    }
    
    public void insertarCategoria( Categoria categoría){
        categorías.add(categoría);
    }
    
    public void eliminarNodo(Categoria categoría){
        categorías.remove(categoría);
    }
    
   public List<Categoria> getCategorias(){
       return categorías;
   }
   
   public Categoria getCategoria(int posición){
       return categorías.get(posición);
   }
   
}

