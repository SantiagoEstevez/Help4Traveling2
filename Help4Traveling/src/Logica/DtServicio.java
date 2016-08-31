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
 * @author Leonardo
 */
public class DtServicio {
    private String nombre;
    private String nkproveedor;
    private String descripcion;
    private List<String> imagenes;
    private Map<String,DtCategoria> categorias;
    private float precio;
    private String nomciuorigen;
    private String nomciudestino;

    public DtServicio(String nombre, String nkproveedor, String descripcion, List<String> imagenes, Map<String, DtCategoria> categorias, float precio, String origen, String destino) {
        this.nombre = nombre;
        this.nkproveedor = nkproveedor;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.categorias = categorias;
        this.precio = precio;
        this.nomciuorigen = origen;
        this.nomciudestino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public Map<String, DtCategoria> getDtCategorias() {
        return categorias;
    }

    public float getPrecio() {
        return precio;
    }

    public String getNkProveedor() {
        return nkproveedor;
    }

    public String getNomCiuOrigen() {
        return nomciuorigen;
    }

    public String getNomCiuDestino() {
        return nomciudestino;
    }

    
        
    
}

