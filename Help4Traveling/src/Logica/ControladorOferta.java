/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
// Comentario para que me reconozca los cambios y pueda comitear...
/**
 *
 * @author Leonardo
 */
public class ControladorOferta implements IControladorOferta  {
    
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
        boolean camposok, categoriasok, existeProv, existeCiuO, existeCiuD;
        Proveedor p;
        camposok = comprobarCompletitudDatos(dts);
	if (camposok) {
            /*if (clienteok) {
		ManejadorCliente muc = ManejadorCliente.getInstance();
		existenk = muc.existeCliente(dtu.getNickname());
		if (!existenk) {
                    existemail = muc.existeCorreo(dtu.getCorreo());
                    if (!existemail)
			datosok = true;
		}	
            }
            else {
		ManejadorProveedor mup = ManejadorProveedor.getInstance();
		existenk = mup.existeProveedor(dtu.getNickname());
		if (!existenk) {
                    existemail = mup.existeCorreo(dtu.getCorreo());
                    if (!existemail)
                    datosok = true; 
		}					
            }
	}
	return datosok;´*/	  
        
        }
        return true;
    }
    
    public void altaDeServicio(DtServicio dts) {
        boolean altaok;
	altaok = altaServicio(dts);
	if (!altaok) {
            
	}
    }
    
    public void altaDePromocion() {
    
    }
    
    public void altaDeCategoria() {
        
    }
    
    public void actualizarUnServicio() {
        
    }
    
    public void verInfoDeServicio() {
        
    }
    
    public void verInfoDePromocion() {
        
    }
    
}
