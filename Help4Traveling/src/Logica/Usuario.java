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
public class Usuario {
    
    private String nombre;
    private String apellido;
    private String nickname;
    private String correo;
    private String nacimiento;

    public Usuario(String nombre, String apellido, String nickname, String correo, String nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.correo = correo;
        this.nacimiento = nacimiento;
    }
    

   //Getters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCorreo() {
        return correo;
    }
    
    //Setters
    
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

       
}

