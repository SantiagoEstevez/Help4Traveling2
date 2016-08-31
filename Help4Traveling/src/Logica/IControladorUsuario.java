
package Logica;

/**
 *
 * @author yaman
 */
public interface IControladorUsuario {
       public abstract boolean ingresarDatosUsuario(DtUsuario dtu);
       public abstract void altaUsuarioCliente(DtUsuario dtu);
       public abstract void cancelarAltaUsuario();
       public abstract void altaUsuarioProveedor(DtUsuario dtu);
       public abstract void altaDeUsuario(DtUsuario dtu);
       public abstract void verInfoDeCliente();
       public abstract void verInfoDeProveedor();
    
}
