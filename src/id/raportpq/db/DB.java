package id.raportpq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Go
 */
public class DB {
   
 public static Connection getConnection(){
 
 Connection con = null;
     try {       
         con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tpq_almujahidin","root","");
      
     } catch (SQLException ex) {
         Logger.getLogger(DB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     
      return con;
 }
}