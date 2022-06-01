
package Modelo;
import java.sql.*;

import javax.swing.JOptionPane;

public class Conectividad {
   
    
//Conexion Local
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

     
   public Connection getConectividad() {
          try {
            String bd = "jdbc:mysql://localhost:3306/bd_clinica1";
            con = DriverManager.getConnection(bd, "root", "");
            return con;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            System.out.println("Error en conexión local " + e);
        }
        return (null);
    }
        
 }
