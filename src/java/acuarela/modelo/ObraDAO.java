
package acuarela.modelo;

import acuarela.configuraciones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class ObraDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Obra ListarId(int id){ 
        String sql="select * from obra where id_obra="+id;
        Obra o= new Obra();
        try {
          con =cn.getConnection();
           ps =con.prepareStatement(sql);
           rs =ps.executeQuery();
        } catch (Exception e) {
        }
        return o;
    }
   public List listar(){
       List<Obra>obra=new ArrayList();
       String sql="select * from obra";
       try {
           con =cn.getConnection();
           ps =con.prepareStatement(sql);
           rs =ps.executeQuery();
           while (rs.next()) {               
               Obra o=new Obra();
               o.setId_obra(rs.getInt(1));
               o.setTitulo(rs.getNString(2));
               o.setDescripcion(rs.getString(3));
               o.setImagen(rs.getBinaryStream(4));
               o.setPrecio(rs.getDouble(5));
               obra.add(o);
           }
       } catch (Exception e) {
       }
       return obra;
   }
   public void LIstarImg(int id, HttpServletResponse response){
       String sql= "select * obra where id_obra="+id;
       InputStream inputStream = null;
       OutputStream outputStream= null;
       BufferedInputStream bufferedInputStream=null;
       BufferedOutputStream bufferedOutputStream= null;
       try {
           outputStream=response.getOutputStream();
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           if(rs.next()){
               inputStream=rs.getBinaryStream("imagen");
           }
           bufferedInputStream= new BufferedInputStream(inputStream);
           bufferedOutputStream=new BufferedOutputStream(outputStream);
           int i= 0;
           while ((i=bufferedInputStream.read())!=-1) {
               bufferedOutputStream.write(i);
           }
       } catch (Exception e) {
       }
   }
}
