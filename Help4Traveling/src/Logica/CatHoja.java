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
public class CatHoja extends Categoria {
    
    public CatHoja(String nombre, Categoria categoríaPadre){
        this.setTipoCategoria(Categoria.HOJA);
        this.setNombre( nombre);
        this.setCategoriaPadre(categoriaPadre);
    }
    
    
}
