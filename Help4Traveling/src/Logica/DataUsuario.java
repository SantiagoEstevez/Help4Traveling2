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
public class DataUsuario {
    private String nombre;
    private String apellido;
    private String nickname;
    private String correo;
    private String nacimiento;
    
    
    public DataUsuario(){
        this.nombre="";
        this.apellido="";
        this.nickname="";
        this.correo="";
        this.nacimiento="";       
    }

    public DataUsuario(String nombre, String apellido, String nickname, String correo, String nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.correo = correo;
        this.nacimiento=nacimiento;
    }

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

    public String getNacimiento() {
        return nacimiento;
    }
    
    

    
    
}
