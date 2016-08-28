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
public class Cliente extends Usuario {

    //Constructor
    public Cliente(String nombre, String apellido, String nickname, String correo, Date nacimiento, String imagen) {
        super(nombre, apellido, nickname, correo, nacimiento, imagen);
    }    
    
}
