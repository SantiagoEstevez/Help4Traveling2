/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class Servicio extends Oferta {
    private String descripcion;
    private List<String> imagenes;
    private Map<String,Categoria> categoriasNom;
    private float precio;
    private Ciudad origen;
    private Ciudad destino;

    public Servicio(String descripcion, List<String> imagenes, float precio, Ciudad origen, String nombre) {
        super(nombre);
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.categoriasNom = new HashMap<String,Categoria>();
        this.precio = precio;
        this.origen = origen;
        this.destino = null;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public float getPrecio() {
        return precio;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }    

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }    
    
    // Operaciones para manejar coleccion de Categorias del Servicio
    public void agregarCategoria(Categoria cat){
        String nombre = cat.getNombre();
        categoriasNom.put(nombre,cat);
    }
    
    public boolean existeCategoria(Categoria cat){
        String nombre = cat.getNombre();
        return categoriasNom.containsKey(nombre);        
    }
    
    public Categoria obtenerCategoria(String nombre){
        return ((Categoria) categoriasNom.get(nombre));
    }      
}
