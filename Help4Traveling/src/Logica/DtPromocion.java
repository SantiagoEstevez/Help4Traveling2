/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import java.util.Map;

/**
 *
 * @author HP Usuario
 */
public class DtPromocion {
    // // Comentario para que me reconozca los cambios y pueda comitear...

    private String nombre;
    private String proveedor;
    private String Servicio;
    private String descuento;

    public DtPromocion(String nombre, String nkproveedor, String Servicio, String descuento) {
        this.nombre = nombre;
        this.proveedor = nkproveedor;
        this.Servicio = Servicio;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getServicio() {
        return Servicio;
    }

    public String getDescuento() {
        return descuento;
    }
    
}