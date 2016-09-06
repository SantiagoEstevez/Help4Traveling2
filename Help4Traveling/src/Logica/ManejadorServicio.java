/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
// Comentario para que me reconozca los cambios y pueda comitear...again

/**
 *
 * @author Leonardo
 */
public class ManejadorServicio {

    //Clase que conserva la colección global de las Ofertas Servicios del Sistema
    private Map<String, Servicio> serviciosNom;
    private static ManejadorServicio instancia = null;
    private Conexion conexion;
    private String sql;

    private ManejadorServicio() {
        serviciosNom = new HashMap<String, Servicio>();
    }

    public static ManejadorServicio getInstance() {
        if (instancia == null) {
            instancia = new ManejadorServicio();
        }
        return instancia;
    }

    public void agregarServicio(Servicio serv) {
        String nombre = serv.getNombre();
        serviciosNom.put(nombre, serv);
    }

    public boolean existeServicio(String nombre) {
        boolean existe = false;
        ResultSet rs;
        Conexion conex = new Conexion();
        Connection con = conex.getConnection();
        Statement st;
        String sql1 = "SELECT * FROM help4traveling.servicios WHERE nombre='" + nombre + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql1);
            if (rs.next()) {
                existe = true;
            }
            rs.close();
            con.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("No exite servicio :(");
        }
        if (existe) {
            System.out.println("Existe Servicio");
        } else {
            System.out.println("NO Existe Servico");
        }
        return existe;
        //return serviciosNom.containsKey(nombre);        
    }

    public Servicio obtenerServicio(String nk) {

        ResultSet rsServicio;
        Conexion conex = new Conexion();
        Connection con = conex.getConnection();
        Statement st;
        String sql1 = "SELECT * FROM help4traveling.servicios S,help4traveling.serviciosimagenes SI, help4traveling.servicioscategorias SC WHERE S.nombre=SI.servicio AND S.nombre=SC.servicio AND S.nombre='" + nk + "'";
        Servicio nuevo = new Servicio();
        try {
            st = con.createStatement();
            rsServicio = st.executeQuery(sql1);
            String nombre = rsServicio.getString("nombre");
            String proveedor = rsServicio.getString("proveedor");
            String descripcion = rsServicio.getString("descripcion");
            String precio = rsServicio.getString("precio");
            String origen = rsServicio.getString("origen");
            String destino = rsServicio.getString("destino");
            String imagen = rsServicio.getString("imagen");
            String categoria = rsServicio.getString("categoria");

            nuevo.setDescripcion(descripcion);
            nuevo.setNombre(nombre);
            Ciudad ori = ManejadorCiudad.getInstance().obtenerCiudad(origen);
            Ciudad dest = ManejadorCiudad.getInstance().obtenerCiudad(destino);

            nuevo.setDestino(dest);
            nuevo.setOrigen(ori);
            List<String> img = new LinkedList<String>();
            img.add(imagen);
            nuevo.setImagenes(img);
            HashMap<String, Categoria> cat = new HashMap<String, Categoria>();
            Categoria cate = new CatHoja(categoria, "sin padrepor ahora");
            cat.put(categoria, cate);
            float precioint = Float.parseFloat(precio);
            nuevo.setPrecio(precioint);

            rsServicio.close();
            con.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("No exite servicio :(");
        }
        return nuevo;
    }

    public DtServicio GetDataServicio(String nombre, String Proveedor) {

        ResultSet rsServicio;

        DtServicio nuevo = null;
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        sql = "SELECT * FROM help4traveling.Servicios WHERE nombre='" + nombre + "' and proveedor='" + Proveedor + "'";

        try {
            st = con.createStatement();
            rsServicio = st.executeQuery(sql);

            while (rsServicio.next()) {
                String nombre1 = rsServicio.getString("nombre");
                String proveedor = rsServicio.getString("proveedor");
                String descripcion = rsServicio.getString("descripcion");
                String precio = rsServicio.getString("precio");
                String origen = rsServicio.getString("origen");
                String destino = rsServicio.getString("destino");
                Float valor = Float.parseFloat(precio);
                nuevo = new DtServicio(nombre1, proveedor, descripcion, null, null, valor, origen, destino);

            }
            rsServicio.close();
            con.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("No pude cargar usuarios :(");
        }
        return nuevo;
    }

    public List<DtServicio> listarServicios() {
        ResultSet rsServicios;
        ResultSet rsServImagenes;
        ResultSet rsServCategorias;
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st, sti, stc;
        String sql, sqlImagenes, sqlCategorias;
        List<DtServicio> listaServicios = new LinkedList<DtServicio>();
        List<String> listaImagenes = new LinkedList<String>();
        Map<String, DtCategoria> listaCategorias = new TreeMap<String, DtCategoria>();

        sql = "SELECT * FROM help4traveling.servicios";

        try {
            st = con.createStatement();
            rsServicios = st.executeQuery(sql);

            while (rsServicios.next()) {
                String nombre = rsServicios.getString("nombre");
                String proveedor = rsServicios.getString("proveedor");
                String descripcion = rsServicios.getString("descripcion");
                String precio = rsServicios.getString("precio");
                String origen = rsServicios.getString("origen");
                String destino = rsServicios.getString("destino");

                sqlImagenes = "SELECT * FROM help4traveling.serviciosImagenes WHERE servicio = '" + nombre + "'";
                sti = con.createStatement();
                rsServImagenes = sti.executeQuery(sqlImagenes);
                while (rsServImagenes.next()) {
                    listaImagenes.add(rsServImagenes.getString("imagen"));
                }
                rsServImagenes.close();
                sti.close();

                sqlCategorias = "SELECT * FROM help4traveling.serviciosCategorias WHERE servicio = '" + nombre + "'";
                stc = con.createStatement();
                rsServCategorias = stc.executeQuery(sqlCategorias);
                while (rsServCategorias.next()) {
                    String nomCat = rsServCategorias.getString("categoria");
                    DtCategoria categoria = new DtCategoria(nomCat, rsServCategorias.getString("categoriaPadre"));
                    listaCategorias.put(nomCat, categoria);
                }
                rsServCategorias.close();
                stc.close();

                DtServicio nuevo = new DtServicio(nombre, proveedor, descripcion, listaImagenes, listaCategorias, Float.parseFloat(precio), origen, destino);
                listaServicios.add(nuevo);
            }
            rsServicios.close();
            con.close();
            st.close();

            System.out.println("Servicios cargados :)");
        } catch (SQLException e) {
            System.out.println("No pude cargar servicios :(");
        }
        return listaServicios;
    }

    public List<String> listarServiciosCategoria(String categoria){
        ResultSet rsServicios;
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        String sql;
        
        List<String> listaServicios = new LinkedList<String>();
        sql = "SELECT * FROM help4traveling.servicioscategorias WHERE categoria='" + categoria +"'";
        System.out.println("entre al listar servicios");
        try{
             
            st = con.createStatement();
            rsServicios = st.executeQuery(sql);
            
            while (rsServicios.next()){
                listaServicios.add(rsServicios.getString("servicio"));
                System.out.println("liste un servicio");
            }
            
        }catch(SQLException e){
           System.out.println("No pude cargar servicios");
           System.err.println(e.getMessage()); 
        }
        
        return listaServicios;
    }   


    public ArrayList<DtServicio> listarServiciosProveedor(DtUsuario user) {
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rsServiciosProveedor;
        sql = "SELECT * FROM help4traveling.servicios WHERE proveedor= '" + user.getNickname() + "'";
        ArrayList<DtServicio> listaServicios = new ArrayList<DtServicio>();
        try {
            st = con.createStatement();
            rsServiciosProveedor = st.executeQuery(sql);

            DtServicio ser;
            while (rsServiciosProveedor.next()) {
                System.out.println("llegue2");
                String nombre = rsServiciosProveedor.getString("nombre");
                String nkproveedor = rsServiciosProveedor.getString("proveedor");
                ser = GetDataServicio(nombre, nkproveedor);
                listaServicios.add(ser);
            }
            rsServiciosProveedor.close();
            con.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("No hubo resultado");
            System.out.println(e.getMessage());
        }
        return listaServicios;
    }

    public List<DtServicio> getDtServicios() {
        List<DtServicio> listaDtServ = new LinkedList<DtServicio>();
        Iterator<Servicio> iter = this.serviciosNom.values().iterator();
        while (iter.hasNext()) {
            Servicio serv = iter.next();
            DtServicio dtServ = serv.getDtServicio();
            listaDtServ.add(dtServ);
        }
        return listaDtServ;
    }

    public String persistirServicio(DtServicio serv) {
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        String mensaje = "Se dio de alta al Servicio.";
        System.out.println(serv.getNombre());
        if (!existeServicio(serv.getNombre())) {
            //sql = "INSERT INTO help4traveling.servicios (nombre,proveedor,descripcion,precio,origen,destino) VALUES ('" + serv.getNombre() + "','" + serv.getProveedor().getNickname() + "','" + serv.getDescripcion() + "'," + (double) serv.getPrecio() + ",'" + serv.getOrigen().getNombre() + "','" + serv.getDestino().getNombre() + "')";
            sql = "INSERT INTO help4traveling.ofertas (nombre,proveedor) VALUES ('" + serv.getNombre() + "','" + serv.getNkProveedor() + "')";
            System.out.println(sql);
            try {
                st = con.createStatement();
                System.out.println("antes de insertar");
                st.executeUpdate(sql);
                //con.close();
                st.close();
                System.out.println("INSERTE en oferta:)");
            } catch (SQLException e) {
                System.out.println("No pude INSERTAR :(");
            }
            sql = "INSERT INTO help4traveling.servicios (nombre,proveedor,descripcion,precio,origen,destino) "
                    + "VALUES ('" + serv.getNombre() + "','" + serv.getNkProveedor() + "','" + serv.getDescripcion() + "'," + (double) serv.getPrecio() + ",'" + serv.getNomCiuOrigen() + "','" + serv.getNomCiuDestino() + "')";
            System.out.println(sql);
            try {
                st = con.createStatement();
                System.out.println("antes de insertar");
                st.executeUpdate(sql);
                //con.close();
                st.close();
                System.out.println("INSERTE en servicio:)");
            } catch (SQLException e) {
                System.out.println("No pude INSERTAR :(");
            }
            List<String> imagserv = serv.getImagenes();
            Iterator<String> iteri = imagserv.iterator();
            while (iteri.hasNext()) {
                sql = "INSERT INTO help4traveling.serviciosimagenes (servicio,imagen) VALUES ('" + serv.getNombre() + "','" + iteri.next() + "')";
                try {
                    st = con.createStatement();
                    System.out.println("antes de imagen");
                    st.executeUpdate(sql);
                    st.close();
                    //con.close();                
                    System.out.println("INSERTE :)");
                } catch (SQLException e) {
                    System.out.println("No pude INSERTAR :(");
                }
            }
            Map<String, DtCategoria> catserv = serv.getDtCategorias();
            Iterator<DtCategoria> iterc = catserv.values().iterator();
            while (iterc.hasNext()) {
                DtCategoria cat = iterc.next();
                //sql = "INSERT INTO help4traveling.servicioscategorias (servicio,proveedorServicio,categoria) VALUES ('" + serv.getNombre() + "','" + serv.getProveedor().getNickname() + "','" + iterc.next().getNombre() + "')";
                sql = "INSERT INTO help4traveling.servicioscategorias (servicio,proveedorServicio,categoria,categoriaPadre) VALUES ('" + serv.getNombre() + "','" + serv.getNkProveedor() + "','" + cat.getNombre() + "','" + cat.getPadre() + "')";
                System.out.println(sql);
                try {
                    st = con.createStatement();
                    System.out.println("antes de categoria");
                    st.executeUpdate(sql);
                    st.close();
                    //con.close();                
                    System.out.println("INSERTE :)");
                } catch (SQLException e) {
                    System.out.println("No pude INSERTAR :(");
                }
            }

        } else {
            mensaje = "ERROR: El Servicio ingresado ya existe...";
        }
        return mensaje;

    }

    public List<DtPromocion> listarPromociones() {

        List<DtPromocion> listaResult = new LinkedList<DtPromocion>();

        ResultSet rsPromociones;

        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        sql = "SELECT * FROM help4traveling.promociones";

        try {
            st = con.createStatement();
            rsPromociones = st.executeQuery(sql);

            while (rsPromociones.next()) {
                String nombre = rsPromociones.getString("nombre");
                String proveedor = rsPromociones.getString("proveedor");
                String descuento = rsPromociones.getString("descuento");
                String total = rsPromociones.getString("total");
                //  Date nacimiento = new Date(12,12,1994);
                //String imagen = "";
                //
                DtPromocion nuevo = new DtPromocion(nombre, proveedor, descuento, total);
                listaResult.add(nuevo);
            }
            rsPromociones.close();
            con.close();
            st.close();

            System.out.println("promociones  cargadas :)");
        } catch (SQLException e) {
            System.out.println("No pude cargar promociones :(");
        }

        return listaResult;
    }

    public DtPromocion getDTPromocion(String nombre, String Proevedor) {

        ResultSet rsPromociones;

        DtPromocion nuevo = null;
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        sql = "SELECT * FROM help4traveling.promociones WHERE nombre='" + nombre + "' and proveedor='" + Proevedor + "'";

        try {
            st = con.createStatement();
            rsPromociones = st.executeQuery(sql);

            //  Date fecha = new Date();
            while (rsPromociones.next()) {
                String nombre1 = rsPromociones.getString("nombre");
                String proveedor = rsPromociones.getString("proveedor");
                String descuento = rsPromociones.getString("descuento");
                String total = rsPromociones.getString("total");

                nuevo = new DtPromocion(nombre1, proveedor, descuento, total);

            }
            rsPromociones.close();
            con.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("No pude cargar usuarios :(");
        }
        return nuevo;
    }

    public List<String> listarServiciosDePromociones(String nombpro, String proev) {

        List<String> listaResult = new LinkedList<String>();

        ResultSet rsPromociones;

        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        sql = "SELECT * FROM help4traveling.promocionesservicios WHERE promocion='" + nombpro + "' and proveedorPromocion='" + proev + "'";

        try {
            st = con.createStatement();
            rsPromociones = st.executeQuery(sql);

            while (rsPromociones.next()) {
                String nombre = rsPromociones.getString("servicio");
                String proveedor = rsPromociones.getString("proveedorServicio");
                String resultado = nombre + "," + proveedor;

                listaResult.add(resultado);
            }
            rsPromociones.close();
            con.close();
            st.close();

            System.out.println("promociones  cargadas :)");
        } catch (SQLException e) {
            System.out.println("No pude cargar promociones :(");
        }

        return listaResult;
    }

}
