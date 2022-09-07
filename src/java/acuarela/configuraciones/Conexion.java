
package acuarela.configuraciones;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost:33065/acuarela";
    String user="root@localhost";
    String pass="";
    public Connection getConnection(){
        try{
          Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection(url,user,pass);
        } catch (Exception e){
            
        }
        return con;
    }
}
    
