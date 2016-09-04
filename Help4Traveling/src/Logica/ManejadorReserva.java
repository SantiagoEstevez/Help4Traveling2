
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
    public static enum eEstado{REGISTRADA,CANCELADA,PAGADA,FACTURADA};

   
    private Map<Long,Reserva> reservasId;
    private ManejadorReserva(){
        reservasId = new HashMap<>();
    }
    
    //Constructor
    public static ManejadorReserva getInstance(){
        if (instancia == null)
            instancia = new ManejadorReserva();
        return instancia;
    }
    
   public void altaReserva(Reserva nueva){
       conexion = new Conexion();
       Connection con = conexion.getConnection();
       Statement st;
       
       sql = "INSERT INTO mydb.reservas " + 
             "(Ref,Número,`Fecha de Creación`,`Precio (USD)`,Estado,Cliente) " +
             "VALUES ('R1'," + nueva.getId() + ",'" + nueva.getCreada() + "'," + nueva.getTotal() + 
             ",'" + nueva.getEstado() + "','SE')";
            //",'" + nueva.getEstado() + "','" + nueva.getCliente() + "')";
       System.out.println(sql);
       
       try{
           st = con.createStatement();
           System.out.println("antes de insertar");
           st.executeUpdate(sql);
           con.close();
           st.close();
           System.out.println("INSERTE :)");
       }catch(SQLException e){
           System.out.println("No pude INSERTAR :(");
       }
   }
   
      public void cancelarReserva(long id){
       conexion = new Conexion();
       Connection con = conexion.getConnection();
       Statement st;
       
       sql = "DELETE FROM ReservasItems " + 
             "WHERE reserva=" + id;
       System.out.println(sql);
       
       try{
           st = con.createStatement();
           System.out.print("Eliminando items...");
           st.executeUpdate(sql);
           //con.close();
           st.close();
           System.out.println("OK");
           
           reservasId.remove(id);
           sql = "DELETE FROM Reservas " + 
             "WHERE numero=" + id;
           
           System.out.println(sql);
       
           st = con.createStatement();
           System.out.print("Eliminando reserva...");
           st.executeUpdate(sql);
           con.close();
           st.close();
           System.out.println("OK");
           
           reservasId.remove(id);
                      
       }catch(SQLException e){
           System.out.println("ERROR");
           System.out.println(e.getMessage());
       }

       
   }
      
    public boolean existeReserva(long id){
        return reservasId.containsKey(id);        
    }
    
    public List<DtReserva> listarReservas(){
        List<DtReserva> listares = new ArrayList<>();
        Iterator<Reserva> iter = this.reservasId.values().iterator();
        while (iter.hasNext()){
            Reserva res = iter.next();
            listares.add(res.getDtReserva());
        }
        return listares;
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
    
    public ArrayList<DtReserva> listarReservasCliente(DtUsuario user){
       conexion = new Conexion();
       Connection con = conexion.getConnection();
       Statement st;
       ResultSet rsReservasCliente;
       sql = "SELECT * FROM mydb.reservas" +
               "WHERE Nick=" + user.getNickname() +" OR Nick="+user.getNickname(); 
       try{
            st = con.createStatement();
            rsReservasCliente = st.executeQuery(sql);
            
            while (rsReservasCliente.next()) {
                System.out.println("llegue2");
                String id = rsReservasCliente.getString("Ref");
                String estado = rsReservasCliente.getString("Estado");
                String fecha = rsReservasCliente.getString("Fecha de Creacion");
                String cliente = rsReservasCliente.getString("Cliente");
                String precio = rsReservasCliente.getString("Precio");
                
                long idint = Integer.parseInt(id);
                double precioint = Integer.parseInt(precio);
                Reserva nueva = new Reserva(/*idint,"REGISTRADA", cliente,null*/);
                nueva.setCliente(cliente);
                nueva.setEstado(Reserva.eEstado.REGISTRADA);
                nueva.setTotal(precioint);
                this.reservasId.put(idint, nueva);
                
            } 
            rsReservasCliente.close();
            con.close();
            st.close();
            
            }catch(SQLException e){
           System.out.println("No hubo resultado");
       }
       
        ArrayList<DtReserva> listaReservasCliente = new ArrayList<>();
        Iterator<Reserva> iter = this.reservasId.values().iterator();
        while (iter.hasNext()){
            Reserva res =iter.next();
            listaReservasCliente.add(res.getDtReserva());
        }
            return listaReservasCliente;
    }
    public void setReservasDB() {
        ResultSet rsReservas;
        
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
       
        sql = "SELECT * FROM Reservas";
       
        try{
            st = con.createStatement();
            rsReservas = st.executeQuery(sql);
            
            System.out.println("Cargando Reservas");
            
            while (rsReservas.next()) {
                System.out.println("Cargando nueva Reserva");
                
                Date creada = new Date(rsReservas.getString("fecha"));
                //Date creada = new Date(rsReservas.getDate("Fecha de Creación"));
                //System.out.println(creada.getFecha("-"));
                Long num = rsReservas.getLong("numero");
                String estado = rsReservas.getString("estado");
                
                double total = rsReservas.getDouble("total");
                String cliente = rsReservas.getString("cliente");
                Map<Integer,ItemReserva> mapa = new HashMap();
                
                //CARGAR RESERVASITEMS!
                
                Reserva nueva = new Reserva(creada,Reserva.eEstado.REGISTRADA,total,cliente,mapa);
                nueva.setId(num);
                Long id = nueva.getId();
                reservasId.put(id,nueva);
                System.out.println("Reserva: "+nueva.getId());

            }
            rsReservas.close();
            con.close();
            st.close();
            
            System.out.println("Reservas cargadas!");
        }catch(SQLException e){
            System.out.println("Reservas no cargadas!");
            System.out.println(e.getMessage());
        }
          
    }
}
