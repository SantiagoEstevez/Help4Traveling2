package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ManejadorReserva {

    private static ManejadorReserva instancia = null;
    private Conexion conexion;
    private String sql;

    public static enum eEstado {
        REGISTRADA, CANCELADA, PAGADA, FACTURADA
    };

    private Map<Long, Reserva> reservasId;
    private Map<Integer, List<ItemReserva>> itemsId;

    private ManejadorReserva() {
        reservasId = new HashMap<>();
        itemsId = new HashMap<>();
    }

    //Constructor
    public static ManejadorReserva getInstance() {
        if (instancia == null) {
            instancia = new ManejadorReserva();
        }
        return instancia;
    }

    public void altaReserva(Reserva nueva) {
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        sql = "INSERT INTO help4traveling.reservas "
                + "(Ref,Número,`Fecha de Creación`,`Precio (USD)`,Estado,Cliente) "
                + "VALUES ('R1'," + nueva.getId() + ",'" + nueva.getCreada() + "'," + nueva.getTotal()
                + ",'" + nueva.getEstado() + "','SE')";
        //",'" + nueva.getEstado() + "','" + nueva.getCliente() + "')";
        System.out.println(sql);

        try {
            st = con.createStatement();
            System.out.println("antes de insertar");
            st.executeUpdate(sql);
            con.close();
            st.close();
            System.out.println("INSERTE :)");
        } catch (SQLException e) {
            System.out.println("No pude INSERTAR :(");
        }
    }

    public void cancelarReserva(long id) {
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        sql = "DELETE FROM ReservasItems "
                + "WHERE reserva=" + id;
        System.out.println(sql);

        try {
            st = con.createStatement();
            System.out.print("Eliminando items...");
            st.executeUpdate(sql);
            //con.close();
            st.close();
            System.out.println("OK");

            reservasId.remove(id);
            sql = "DELETE FROM Reservas "
                    + "WHERE numero=" + id;

            System.out.println(sql);

            st = con.createStatement();
            System.out.print("Eliminando reserva...");
            st.executeUpdate(sql);
            con.close();
            st.close();
            System.out.println("OK");

            reservasId.remove(id);

        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
        }

    }

    public boolean existeReserva(long id) {
        return reservasId.containsKey(id);
    }

    public List<DtReserva> listarReservas() {
        List<DtReserva> listares = new ArrayList<>();
        Iterator<Reserva> iter = this.reservasId.values().iterator();
        while (iter.hasNext()) {
            Reserva res = iter.next();
            listares.add(res.getDtReserva());
        }
        return listares;
    }

    public List<ItemReserva> listarItems(Integer reserva) {
        List<ItemReserva> listaitems = new ArrayList<>();
        listaitems = itemsId.get(reserva);
        return listaitems;
    }

    public List<DtReserva> getDtReservas() {
        List<DtReserva> listaDtRes = new LinkedList<>();
        Iterator<Reserva> iter = this.reservasId.values().iterator();
        while (iter.hasNext()) {
            Reserva res = iter.next();
            DtReserva dtRes = res.getDtReserva();
            listaDtRes.add(dtRes);
        }
        return listaDtRes;
    }

    public ArrayList<DtReserva> listarReservasCliente(DtUsuario user) {
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rsReservasCliente;
        sql = "SELECT * FROM help4traveling.reservas WHERE cliente='" + user.getNickname() + "'";

        try {
            st = con.createStatement();
            rsReservasCliente = st.executeQuery(sql);
            while (rsReservasCliente.next()) {
                String id = rsReservasCliente.getString("numero");
                String estado = rsReservasCliente.getString("estado");
                String fecha = rsReservasCliente.getString("fecha");
                String cliente = rsReservasCliente.getString("cliente");
                String precio = rsReservasCliente.getString("total");

                long idint = Integer.parseInt(id);
                double precioint = Integer.parseInt(precio);
                Reserva nueva = new Reserva(/*idint,"REGISTRADA", cliente,null*/);
                nueva.setCliente(cliente);
                nueva.setId(idint);
                nueva.setEstado(Reserva.eEstado.REGISTRADA);
                nueva.setTotal(precioint);
                this.reservasId.put(idint, nueva);
                System.out.println("Agregué una");

            }
            rsReservasCliente.close();
            con.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("No hubo resultado");
        }

        ArrayList<DtReserva> listaReservasCliente = new ArrayList<>();
        Iterator<Reserva> iter = this.reservasId.values().iterator();
        while (iter.hasNext()) {
            Reserva res = iter.next();
            listaReservasCliente.add(res.getDtReserva());
        }
        return listaReservasCliente;
    }

    public void setReservasDB() {
        ResultSet rsReservas;

        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        sql = "SELECT * FROM help4traveling.reservas";

        try {
            st = con.createStatement();
            rsReservas = st.executeQuery(sql);

            System.out.print("Cargando Reservas: ");

            while (rsReservas.next()) {

                Long num = rsReservas.getLong("numero");
                Date creada = new Date(rsReservas.getString("fecha"));
                double total = rsReservas.getDouble("total");
                String estado = rsReservas.getString("estado");
                String cliente = rsReservas.getString("cliente");
                Map<Integer, ItemReserva> mapa = new HashMap();

                Reserva nueva = new Reserva(creada, Reserva.eEstado.valueOf(estado), total, cliente, mapa);

                /* CARGAR RESERVASITEMS */
                nueva.setId(num);       //Temporal?
                Long id = nueva.getId();
                reservasId.put(id, nueva);
                System.out.print(nueva.getId() + " ");
            }
            System.out.println();
            rsReservas.close();
            con.close();
            st.close();

            System.out.println("Reservas cargadas!");
        } catch (SQLException e) {
            System.out.println("Reservas no cargadas!");
            System.out.println(e.getMessage());
        }

    }

    public void setItemsDB() {
        ResultSet rsItems;
        itemsId.clear();

        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;

        sql = "SELECT * FROM help4traveling.reservasitems";

        try {
            st = con.createStatement();
            rsItems = st.executeQuery(sql);

            System.out.print("Cargando Items ");

            while (rsItems.next()) {

                int reserva = rsItems.getInt("reserva");
                int cantidad = rsItems.getInt("cantidad");

                Date inicio = new Date(rsItems.getString("inicio"));
                Date fin = new Date(rsItems.getString("fin"));

                String nomoferta = rsItems.getString("oferta");
                String nomprov = rsItems.getString("proveedorOferta");
                //Proveedor proveedor = ManejadorProveedor.getInstance().obtenerProveedor(nomprov);
                Oferta oferta = new Servicio();
                oferta.setNombre(nomoferta);

                ItemReserva nuevo = new ItemReserva(reserva, cantidad, inicio, fin, oferta);

                if (itemsId.containsKey(reserva)) {
                    itemsId.get(reserva).add(nuevo);
                } else {
                    List<ItemReserva> item = new ArrayList();
                    item.add(nuevo);
                    itemsId.put(reserva, item);
                }
                System.out.print(nuevo.getId() + " ");

            }
            System.out.println();
            rsItems.close();
            con.close();
            st.close();

            System.out.println("Items cargados!");
        } catch (SQLException e) {
            System.out.println("Items no cargados!");
            System.out.println(e.getMessage());
        }

    }
}
