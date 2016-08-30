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
public class CatHoja extends Categoría {
    
    public CatHoja(String nombre, Categoría categoríaPadre){
        this.setTipoCategoría(Categoría.HOJA);
        this.setNombre( nombre);
        
        this.setCategoríaPadre(categoríaPadre);
    }
    
    
}
