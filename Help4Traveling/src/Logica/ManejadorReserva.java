
package Logica;
    import java.sql.Connection;
    import java.sql.DriverManager;
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
   
    private Map<Long,Reserva> reservasId;
    private ManejadorReserva(){
        reservasId = new HashMap<Long,Reserva>();
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
       
       sql = "DELETE FROM mydb.reservas " + 
             "WHERE id=" + id;
       System.out.println(sql);
       
       try{
           st = con.createStatement();
           System.out.println("Eliminando reserva...");
           st.executeUpdate(sql);
           con.close();
           st.close();
           System.out.println("Reserva eliminada");
       }catch(SQLException e){
           System.out.println("Reserva no eliminada");
       }
   }
      
    public boolean existeReserva(long id){
        return reservasId.containsKey(id);        
    }
    
    public List<Long> listarReservas(){
        List<Long> listares = new ArrayList<Long>();
        Iterator<Reserva> iter = this.reservasId.values().iterator();
        while (iter.hasNext()){
            Reserva res = iter.next();
            listares.add(res.getId());
        }
        return listares;
    }
    
    public List<DtReserva> getDtReservas() {
        List<DtReserva> listaDtRes = new LinkedList<DtReserva>();
        Iterator<Reserva> iter = this.reservasId.values().iterator();
	while (iter.hasNext()) {
            Reserva res = iter.next();            
            DtReserva dtRes = res.getDtReserva(); 
            listaDtRes.add(dtRes);
	}
	return listaDtRes;        
    }
}
