/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.List;
// Comentario para que me reconozca los cambios y pueda comitear...
/**
 *
 * @author Leonardo
 */
public interface IControladorServicio {
       public abstract String altaDeServicio(DtServicio dts);
       public abstract void altaDePromocion();
       public abstract String altaDeCategoria(String nombre, String NombPadre);
       public abstract List<DtServicio> listarServicios();
       public abstract void actualizarUnServicio();
       public abstract List<String> listarCategorias();
       public abstract List<String> listarServiciosCategoria(String cat);
       public abstract void verInfodeServicio(String nombre, String Proevedor);
       public abstract void verInfoDePromocion();
    
}
