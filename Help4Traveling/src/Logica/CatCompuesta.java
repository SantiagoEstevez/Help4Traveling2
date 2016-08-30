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


public class CatCompuesta extends Categoría {
    List<Categoría> categorías = new ArrayList<Categoría>();
    
    public CatCompuesta(String nombre, Categoría categoríaPadre){
            this.setTipoCategoría(Categoría.COMPUESTA);
            this.setNombre(nombre);  
            
            this.setCategoríaPadre(categoríaPadre);
            
    }
    
    public void insertarCategoría( Categoría categoría){
        categorías.add(categoría);
    }
    
    public void eliminarNodo(Categoría categoría){
        categorías.remove(categoría);
    }
    
   public List<Categoría> getCategorías(){
       return categorías;
   }
   
   public Categoría getCategoría(int posición){
       return categorías.get(posición);
   }
   
}

