
package Logica;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

public class ManejadorReserva {
   private Conexion conexion;
   private String sql;
   
   public ManejadorReserva(){
   }
    
   public void altaReserva(){
       //Nueva conexion
       conexion = new Conexion();
       Connection con = conexion.getConnection();
       Statement st;
       
       sql = "insert into .usuarios (Ref,Nick,Email,Nombre,Apellido) values('SA','santiago','san@gmail.com','santiago','estevez');";
       
       
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
