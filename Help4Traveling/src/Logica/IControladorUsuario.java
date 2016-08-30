
package Logica;

/**
 *
 * @author yaman
 */
public interface IControladorUsuario {
       public abstract boolean ingresarDatosUsuario(DataUsuario dtu);
       public abstract void altaUsuarioCliente(DataUsuario dtu);
       public abstract void cancelarAltaUsuario();
       public abstract void altaUsuarioProveedor(DataUsuario dtu);
       public abstract void altaDeUsuario(DataUsuario dtu);
       public abstract void verInfoDeCliente();
       public abstract void verInfoDeProveedor();
    
}
