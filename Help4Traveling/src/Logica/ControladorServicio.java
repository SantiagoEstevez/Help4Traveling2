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
/**
 *
 * @author Leonardo
 */
public class ControladorServicio implements IControladorServicio  {
    
    private String comprobarCompletitudDatos(DtServicio dts) {
        String mensaje = "CAMPOSOK";
        if (dts.getNombre().equals(""))
	    mensaje = "ERROR: El Nombre no puede ser vacío...";
        else if (dts.getPrecio() <= 0)
                 mensaje = "ERROR: El Pecio debe ser mayor que 0...";
             else if (dts.getImagenes().size() > 3)
                      mensaje = "ERROR: Debe elegir como mucho 3 imagenes...";
                  else if (dts.getNomCiuOrigen().equals(""))
                           mensaje = "ERROR: La ciudad de origen no puede ser vacía..."; 
                       else if (dts.getDtCategorias().size() == 0)
                                mensaje = "ERROR: Debe elegir al menos una categoria..."; 
        return mensaje;		
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
    
    public String altaServicio(DtServicio dts) {
        String mensaje = comprobarCompletitudDatos(dts);
        Proveedor p;
        if (mensaje.equals("CAMPOSOK")) {
            /*System.out.print("Origen: ");
            System.out.println(dts.getNomCiuOrigen());
            Ciudad co = ManejadorCiudad.getInstance().obtenerCiudad(dts.getNomCiuOrigen());
            p = ManejadorProveedor.getInstance().obtenerProveedor(dts.getNkProveedor());
            Servicio s = new Servicio(dts.getNombre(), p, dts.getDescripcion(), dts.getImagenes(), dts.getPrecio(), co);
            if (!dts.getNomCiuDestino().equals("")) {
                Ciudad cd = ManejadorCiudad.getInstance().obtenerCiudad(dts.getNomCiuDestino());
                s.setDestino(cd);
            }*/
            //p.agregarServicio(s);
            //ManejadorServicio.getInstance().agregarServicio(s); 
            ManejadorServicio ms = ManejadorServicio.getInstance();
            mensaje = ms.persistirServicio(dts);
        }
        return mensaje;
    }
    
    public String altaDeServicio(DtServicio dts) {
        String mensaje = "El servicio fue agregado con exito.";
	mensaje = altaServicio(dts);
	return mensaje;
    }
    
    public void altaDePromocion() {
    
    }
    
    public String altaDeCategoria(String nombre, String NombPadre) {
        
        //String retorno="";
        if(!(ManejadorCategoria.getInstance().existeCategoria(nombre))) {
            
            if(NombPadre==null){
                Categoria nueva =new CatHoja(nombre,null);
                if (ManejadorCategoria.getInstance().agregarCategoria(nueva))
                    
                    return "Categroria base " +nombre+ " creada correctamente)";
                else
                    return ("La categroria base " +nombre+ " no pudo ser  creada");
            }
            else{
                if((ManejadorCategoria.getInstance().existeCategoria(NombPadre))) {
                   /*busco si  el padre es valido tengo que saber si el padre es hoja o no, ya que si lo es
                   debo cambiarlo por una categoria compuesta ya que va a pasar a ser padre de otra categoria
                    n*/
                    
                   /* if(ManejadorCategoria.getInstance().obtenerCategoria(NombPadre) instanceof CatHoja){
                        Categoria papa=ManejadorCategoria.getInstance().obtenerCategoria(NombPadre);
                        //creo la nueva compuesta con los datos de la simple
                        Categoria papaCompuesto =new CatCompuesta(NombPadre,papa.getPadre());
                        //luego la sustituyo
                        ManejadorCategoria.getInstance().sustituirCategoria(NombPadre, papaCompuesto);
                    }*/
                   /* CatCompuesta instPadre=(CatCompuesta)ManejadorCategoria.getInstance().obtenerCategoria(NombPadre);
                 */
                    Categoria nueva1 =new CatHoja(nombre,NombPadre);
                    /*((CatCompuesta)instPadre).insertarCategoria(nueva1);*/
                    ManejadorCategoria.getInstance().agregarCategoria(nueva1);
                    return  "Categroria  " +nombre +" hija de "+NombPadre+" fue creada correctamente";
                }
                else{
                    return  "Categroria  " +nombre +" No fue creada correctamente ya que " +NombPadre+" no existe ";
                }
            }
        }
        else{ 
                return "Categroria  " +nombre +" No fue creada correctamente ya que esa categoria ya existe ";
                
        }
    }   
    
    public List<DtServicio> listarServicios() {
        return ManejadorServicio.getInstance().listarServicios();  
    }
    
    
    public void actualizarUnServicio() {
        
    }
    
    public List<String> listarCategorias() {
        ManejadorCategoria mac = ManejadorCategoria.getInstance();
        return mac.getNombresCategorias();
    }
    
    public List<String> listarServiciosCategoria(String cat){
        /*ManejadorServicio mas = ManejadorServicio.getInstance();
        List<String> listaserv = mas.listarServicios();
        List<String> listaServiciosCategoria = new ArrayList<String>();
        Iterator<String> iter =  listaserv.iterator();
        while   (iter.hasNext()){
            String serv = iter.next();
            if (mas.obtenerServicio(serv).existeCategoria(mas.obtenerServicio(serv).obtenerCategoria(cat))){
                listaServiciosCategoria.add(serv);
            }    
        }*/
        List<String> listaServiciosCategoria = new ArrayList<String>();
        return listaServiciosCategoria;
    }
    
    public void verInfodeServicio(){
        
    }
    
    public void verInfoDePromocion() {
        
    }
    
}
