/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author HP Usuario
 */
public class DtPromocion {
    // // Comentario para que me reconozca los cambios y pueda comitear...

    private String nombre;
    private String proveedor;
    private String precio;
    private String descuento;
    //private List<DtServicio> servicios;

    public DtPromocion(String nombre, String proveedor, String precio, String descuento/*, List<DtServicio> servicios*/) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
        this.descuento = descuento;
        //this.servicios = servicios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDescuento() {
        return descuento;
    }

    /*
    public List<DtServicio> getServicios() {
        return servicios;
    }
     */
}
