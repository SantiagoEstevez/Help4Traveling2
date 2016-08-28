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
public class Proveedor extends Usuario {
    private String empresa;
    private String link;

    //Constructor
    public Proveedor(String empresa, String link, String nombre, String apellido, String nickname, String correo, Date nacimiento, String imagen) {
        super(nombre, apellido, nickname, correo, nacimiento, imagen);
        this.empresa = empresa;
        this.link = link;
    }

    //Getters
    public String getEmpresa() {
        return empresa;
    }

    public String getLink() {
        return link;
    }

    //Setters
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setLink(String link) {
        this.link = link;
    }
       
}
