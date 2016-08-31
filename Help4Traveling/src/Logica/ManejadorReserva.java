
package Logica;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

public class ManejadorReserva {
    private static ManejadorReserva instancia = null;
    private Conexion conexion;
    private String sql;
   
    //Constructor
    public static ManejadorReserva getInstance(){
        if (instancia == null)
            instancia = new ManejadorReserva();
        return instancia;
    }
    
   public void altaReserva(Reserva nueva){
       //Nueva conexion
       conexion = new Conexion();
       Connection con = conexion.getConnection();
       Statement st;
       
       sql = "INSERT INTO mydb.reservas " + 
             "(Ref,Número,FechadeCreación,`Precio(USD)`,Estado,Cliente) " +
             "VALUES ('RE'," + nueva.getId() + ",'" + nueva.getCreada() + "'," + nueva.getTotal() + 
             ",'" + nueva.getEstado() + "','" + nueva.getCliente() + "')";
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
}
