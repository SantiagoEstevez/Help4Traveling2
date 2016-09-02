/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help4traveling;
import Logica.Fabrica;
    import Logica.*;
    import Vista.Principal;

public class Help4Traveling {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Iniciando......");
       
       Fabrica fab = Fabrica.getInstance();
       Reserva r = fab.getIControladorReserva().nuevaRserva("santiago", 0);
       fab.getIControladorUsuario().listarClientes();
       ///Date a = new Date(12,12,2016);
       //Date b = new Date(12,12,2017);     
       //Servicio s = new Servicio();
       
       //System.out.println("C ......");
       //fab.getIControladorReserva().agregarItem(r,1,a,b,s);
       //fab.getIControladorReserva().verReserva();
       //System.out.println("Antes de guardar a la base de datos ......");
       //fab.getIControladorReserva().altaReserva(r);
       
       Principal p = new Principal();
       p.setLocationRelativeTo(null);
       p.setVisible(true);
       
       //ManejadorReserva a;
       //a = new ManejadorReserva();
       //a.altaReserva();
       
       //private date a;
       //a = new ManejadorReserva();
    }
    
}
