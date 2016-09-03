/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.util.ArrayList;
// Comentario para que me reconozca los cambios y pueda comitear...
/**
 *
 * @author Leonardo
 */
public class ControladorUsuario implements IControladorUsuario {
	
    private boolean esFechaValida(Date fecha) {
        return true;
    }
    
    private boolean comprobarCompletitudDatos(DtUsuario dtu) {
        if (dtu.getNickname().equals(""))
            return false;
        else if (dtu.getNombre().equals(""))
		 return false;
             else if (dtu.getApellido().equals(""))
                      return false;
		  else if (dtu.getCorreo().equals(""))
			   return false;
                       else if (!esFechaValida(dtu.getNacimiento()))
                                return false;
                            else if (dtu.getTipo().equals("Cliente"))
                                     return true;
				 else if (dtu.getEmpresa().equals(""))
					  return false;
                                      else if (dtu.getLink().equals(""))
                                               return false; 
                                           else return true;		
    }
	
    private boolean esUsuarioCliente(DtUsuario dtu) {
	if (dtu.getTipo().equals("Cliente"))
            return true;
	else return false;		
    }
    
    public boolean ingresarDatosUsuario(DtUsuario dtu) {
        boolean camposok, clienteok, existenk, existemail;
        boolean datosok = false;
	camposok = comprobarCompletitudDatos(dtu);
	if (camposok) {
            clienteok = esUsuarioCliente(dtu);
            if (clienteok) {
		ManejadorCliente muc = ManejadorCliente.getInstance();
		existenk = muc.existeNickname(dtu.getNickname());
		if (!existenk) {
                    existemail = muc.existeCorreo(dtu.getCorreo());
                    if (!existemail)
			datosok = true;
		}	
            }
            else {
		ManejadorProveedor mup = ManejadorProveedor.getInstance();
		existenk = mup.existeNickname(dtu.getNickname());
		if (!existenk) {
                    existemail = mup.existeCorreo(dtu.getCorreo());
                    if (!existemail)
                    datosok = true;
		}					
            }
	}
	return datosok;	
    }
	
    public void altaUsuarioCliente(DtUsuario dtu) {
        Cliente cli = new Cliente(dtu.getNombre(), dtu.getApellido(), dtu.getNickname(), dtu.getCorreo(), dtu.getNacimiento(), dtu.getImagen());
	ManejadorCliente muc = ManejadorCliente.getInstance();
	//muc.agregarCliente(cli);
        muc.persistirCliente(cli);
    }
	
    public void altaUsuarioProveedor(DtUsuario dtu) {
	Proveedor prov = new Proveedor(dtu.getNombre(), dtu.getApellido(), dtu.getNickname(), dtu.getCorreo(), dtu.getNacimiento(), dtu.getImagen(), dtu.getEmpresa(), dtu.getLink());
	ManejadorProveedor mup = ManejadorProveedor.getInstance();
	//mup.agregarProveedor(prov);	
        mup.persistirProveedor(prov);
    }
	
    public void cancelarAltaUsuario() {
		
    }
		
    public void altaDeUsuario(DtUsuario dtu) {
	boolean datosok, clienteok;
	datosok = ingresarDatosUsuario(dtu);
	if (datosok) {
            clienteok = esUsuarioCliente(dtu);
            if (clienteok)
		altaUsuarioCliente(dtu);
            else altaUsuarioProveedor(dtu);
	}    
	else {}
    }
    
       public ArrayList<DtUsuario> listarClientes() {
        ManejadorCliente muc = ManejadorCliente.getInstance();
        return muc.listarClientes();
        
    }

        
    public ArrayList<DtReserva> listarReservasCliente(DtUsuario dtu){
        ManejadorCliente muc = ManejadorCliente.getInstance();
        ArrayList<DtReserva> reservas = new ArrayList<DtReserva>();
        if (muc.existeNickname(dtu.getNickname())){
            reservas = muc.obtenerCliente(dtu.getNickname()).listarReservas();
        }
        return reservas;
    }
    
    
    
    public ArrayList<DtUsuario> listarProveedores() {
        ManejadorProveedor map = ManejadorProveedor.getInstance();
        return map.listarProveedores();
        
    }

        
    public ArrayList<DtServicio> listarServicioProveedor(DtUsuario dtu){
        ManejadorProveedor map = ManejadorProveedor.getInstance();
        ArrayList<DtServicio> servicios = new ArrayList<DtServicio>();
        if (map.existeNickname(dtu.getNickname())){
            servicios = map.obtenerProveedor(dtu.getNickname()).listarServicios();
        }
        return servicios;
    }
    
    
    
    public void verInfoDeProveedor(){
        
    }    
}

