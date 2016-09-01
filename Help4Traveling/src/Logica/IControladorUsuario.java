
package Logica;
import java.util.ArrayList;
// Comentario para que me reconozca los cambios y pueda comitear...
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
       public abstract ArrayList<DtUsuario> listarClientes();
       public abstract ArrayList<dtReserva> listarReservasCliente(DtUsuario dtu);
       public abstract void verInfoDeProveedor();
    
}
