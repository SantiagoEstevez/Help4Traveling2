/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
// Comentario para que me reconozca los cambios y pueda comitear...
/**
 *
 * @author Leonardo
 */
public class ControladorServicio implements IControladorOferta  {
    
    private boolean comprobarCompletitudDatos(DtServicio dts) {
        if (dts.getNkProveedor() == "")
            return false;
        else if (dts.getNombre() == "")
		 return false;
             else if (dts.getDescripcion() == "")
                      return false;
                  else if (dts.getPrecio() >= 0)
                           return true;
                       else if (dts.getNomCiuOrigen() == "")
				return false;
                            else if (dts.getDtCategorias().isEmpty())
                                     return false; 
                                 else return true;		
    }
    
    private boolean existenCategorias(Map<String,DtCategoria> catServ, List<String> catSist) {
        boolean categoriasok = true;
        boolean encontrado;
        Iterator<DtCategoria> iter1 = catServ.values().iterator();
	while ((iter1.hasNext()) && (categoriasok)) {
            Iterator<String> iter2 = catSist.iterator();
            String nom = iter1.next().getNombre();
            encontrado = false;
            while (iter2.hasNext() && (!encontrado)) 
                if (nom == iter2.next())
                    encontrado = true;
            if (!encontrado)  
                categoriasok = false;            
        }
        return categoriasok;
    }
    
    public boolean altaServicio(DtServicio dts) {
        boolean altaok, camposok, categoriasok, existeProv, existeCiuO, existeCiuD;
        camposok = comprobarCompletitudDatos(dts);
        Proveedor p;
        altaok = true;
	if (camposok) {
            List<String> listaCat = ManejadorCategoria.getInstance().getNombresCategorias();
            categoriasok = existenCategorias(dts.getDtCategorias(), listaCat);
            if (categoriasok) {
                existeProv = ManejadorProveedor.getInstance().existeProveedor(dts.getNkProveedor());
                if (existeProv) {
                    existeCiuO = ManejadorCiudad.getInstance().existeCiudad(dts.getNomCiuOrigen());
                    if (existeCiuO) {
                        if (dts.getNomCiuDestino() != "") {
                            existeCiuD = ManejadorCiudad.getInstance().existeCiudad(dts.getNomCiuDestino());
                            if (!existeCiuD)
                                altaok = false;
                        }                        
                    }
                    else altaok = false;
                }
                else altaok = false;
            }
            else altaok = false;
        }
        else altaok = false;
        if (altaok) {
            Ciudad co = ManejadorCiudad.getInstance().obtenerCiudad(dts.getNomCiuOrigen());
            Servicio s = new Servicio(dts.getNombre(), dts.getDescripcion(), dts.getImagenes(), dts.getPrecio(), co);
            if (dts.getNomCiuDestino() != "") {
                Ciudad cd = ManejadorCiudad.getInstance().obtenerCiudad(dts.getNomCiuDestino());
                s.setDestino(cd);
            }
            p = ManejadorProveedor.getInstance().obtenerProveedor(dts.getNkProveedor());
            p.agregarServicio(s);
            ManejadorServicio.getInstance().agregarServicio(s);            
        }
        return altaok;
    }
    
    public void altaDeServicio(DtServicio dts) {
        boolean altaok;
	altaok = altaServicio(dts);
	if (!altaok) {
            
	}
        else {
        
        }
    }
    
    public void altaDePromocion() {
    
    }
    
    public boolean altaDeCategoria(String nombre, String NombPadre) {
        
        
        if(!(ManejadorCategoria.getInstance().existeCategoria(nombre))) {
            
            if(NombPadre==null){
                CatHoja nueva =new CatHoja(nombre,null);
                ManejadorCategoria.getInstance().agregarCategoria(nueva);
                return true;
            }
            else{
                if((ManejadorCategoria.getInstance().existeCategoria(NombPadre))) {
                   /*busco si  el padre es valido tengo que saber si el padre es hoja o no, ya que si lo es
                   debo cambiarlo por una categoria compuesta ya que va a pasar a ser padre de otra categoria
                    n*/
                    
                    if(ManejadorCategoria.getInstance().obtenerCategoria(NombPadre) instanceof CatHoja){
                        Categoria papa=ManejadorCategoria.getInstance().obtenerCategoria(NombPadre);
                        //creo la nueva compuesta con los datos de la simple
                        Categoria papaCompuesto =new CatCompuesta(NombPadre,papa.getPadre());
                        //luego la sustituyo
                        ManejadorCategoria.getInstance().sustituirCategoria(NombPadre, papaCompuesto);
                    }
                    CatCompuesta instPadre=(CatCompuesta)ManejadorCategoria.getInstance().obtenerCategoria(NombPadre);
                 
                    Categoria nueva1 =new CatHoja(nombre,instPadre);
                    ((CatCompuesta)instPadre).insertarCategoria(nueva1);
                    ManejadorCategoria.getInstance().agregarCategoria(nueva1);
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{ 
                return false;
                
        }
    }   
    
    
    public void actualizarUnServicio() {
        
    }
    
    public List<String> listarCategorias() {
        ManejadorCategoria mac = ManejadorCategoria.getInstance();
        return mac.getNombresCategorias();
    }
    
    public List<String> listarServiciosCategoria(String cat){
        ManejadorServicio mas = ManejadorServicio.getInstance();
        List<String> listaserv = mas.listarServicios();
        List<String> listaServiciosCategoria = new ArrayList<String>();
        Iterator<String> iter =  listaserv.iterator();
        while   (iter.hasNext()){
            String serv = iter.next();
            if (mas.obtenerServicio(serv).existeCategoria(mas.obtenerServicio(serv).obtenerCategoria(cat))){
                listaServiciosCategoria.add(serv);
            }    
        }
        return listaServiciosCategoria;
    }
    
    public void verInfodeServicio(){
        
    }
    
    public void verInfoDePromocion() {
        
    }
    
}
