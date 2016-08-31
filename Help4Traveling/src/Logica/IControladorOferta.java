/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
// Comentario para que me reconozca los cambios y pueda comitear...
/**
 *
 * @author Leonardo
 */
public interface IControladorOferta {
       public abstract void altaDeServicio(DtServicio dts);
       public abstract void altaDePromocion();
       public abstract void altaDeCategoria();
       public abstract void actualizarUnServicio();
       public abstract void verInfoDeServicio();
       public abstract void verInfoDePromocion();
    
}
