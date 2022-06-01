package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class MedicosDAO {
    
    Conectividad cn = new Conectividad();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrar (Medicos med){
        String sql = "Insert into medicos (nombre_medico, cmp, correo_medico, "
                + "telefono_medico, id_especialidad, estado_medico)"
                + "values (?,?,?,?,?,?)";
        
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, med.getNombre_medico());
            ps.setString(2, med.getCmp());
            ps.setString(3, med.getCorreo_medico());
            ps.setString(4, med.getTelefono_medico());
            ps.setInt(5, med.getId_especialidad());
            ps.setString(6, med.getEstado_medico());
            ps.execute();      
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }       
    }
    
    public List ListaMedicos (String valor){
        List <Medicos> ListaMedicos = new ArrayList();
        String sql = "SELECT * FROM medicos ORDER BY estado_medico ASC";
        String buscar = "SELECT * FROM medicos where nombre_medico LIKE '%" 
               + valor + "%'";
        try {
            
            con = cn.getConectividad();
            if(valor.equalsIgnoreCase("")){
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            }else{
                ps = con.prepareStatement(buscar);
                rs = ps.executeQuery();
            }
            
            while (rs.next()){
                Medicos med = new Medicos();
                med.setId_medico(rs.getInt("id_medico"));
                med.setNombre_medico(rs.getString("nombre_medico"));
                med.setCmp(rs.getString("cmp"));
                med.setCorreo_medico(rs.getString("correo_medico"));
                med.setTelefono_medico(rs.getString("telefono_medico"));
                med.setId_especialidad(rs.getInt("id_especialidad"));
                med.setEstado_medico(rs.getString("estado_medico"));
                ListaMedicos.add(med);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
      return ListaMedicos;  
        
    }
    
    public boolean modificar (Medicos med){
        String sql = "update medicos set nombre_medico = ?, cmp =?, correo_medico=?,"
                + "telefono_medico=?, id_especialidad=? where id_medico=? ";
        
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, med.getNombre_medico());
            ps.setString(2, med.getCmp());
            ps.setString(3, med.getCorreo_medico());
            ps.setString(4, med.getTelefono_medico());
            ps.setInt(5, med.getId_especialidad());
            ps.setInt(6, med.getId_medico());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
   public boolean accion (String estado_medico, int id_medico){
       String sql = "update medicos set estado_medico =? where id_medico =?";
       
       try {
           con = cn.getConectividad();
           ps = con.prepareStatement(sql);
           ps.setString(1, estado_medico);
           ps.setInt(2, id_medico);
           ps.execute();
           return true;
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.toString());
            return false;
       }
   } 
    
    
    
    
    
    
}
