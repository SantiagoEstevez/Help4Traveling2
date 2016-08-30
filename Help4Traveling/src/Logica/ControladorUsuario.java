/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Leonardo
 */
public class ControladorUsuario implements IControladorUsuario {
	
    private boolean esFechaValida(Date fecha) {
        return true;
    }
    
    private boolean comprobarCompletitudDatos(DataUsuario dtu) {
        if (dtu.getNickname() == "")
            return false;
        else if (dtu.getNombre() == "")
		 return false;
             else if (dtu.getApellido() == "")
                      return false;
		  else if (dtu.getCorreo() == "")
			   return false;
                       else if (!esFechaValida(dtu.getNacimiento()))
                                return false;
                            else if (dtu.getTipo() == "Cliente")
                                     return true;
				 else if (dtu.getEmpresa() == "")
					  return false;
                                      else if (dtu.getLink() == "")
                                               return false; 
                                           else return true;		
    }
	
    private boolean esUsuarioCliente(DataUsuario dtu) {
	if (dtu.getTipo() == "Cliente")
            return true;
	else return false;		
    }
    
    public boolean ingresarDatosUsuario(DataUsuario dtu) {
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
	
    public void altaUsuarioCliente(DataUsuario dtu) {
        Cliente cli = new Cliente(dtu.getNombre(), dtu.getApellido(), dtu.getNickname(), dtu.getCorreo(), dtu.getNacimiento(), dtu.getImagen());
	ManejadorCliente muc = ManejadorCliente.getInstance();
	muc.agregarCliente(cli);
    }
	
    public void altaUsuarioProveedor(DataUsuario dtu) {
	Proveedor prov = new Proveedor(dtu.getEmpresa(), dtu.getLink(), dtu.getNombre(), dtu.getApellido(), dtu.getNickname(), dtu.getCorreo(), dtu.getNacimiento(), dtu.getImagen());
	ManejadorProveedor mup = ManejadorProveedor.getInstance();
	mup.agregarProveedor(prov);	
    }
	
    public void cancelarAltaUsuario() {
		
    }
		
    public void altaDeUsuario(DataUsuario dtu) {
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
    
    public void verInfoDeCliente() {
        
    }
    
    public void verInfoDeProveedor(){
        
    }    
    
}

