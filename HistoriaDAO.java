package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class HistoriaDAO {
    
    Conectividad cn = new Conectividad();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public boolean registrar(Historia hi) {
        String sql = "INSERT INTO historiaclinica(antec_familiares, antec_personales, estado_historia) VALUES (?,?,?)";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, hi.getAntec_familiares());
            ps.setString(2, hi.getAntec_personales());
            ps.setString(3, hi.getEstado_historia());
            ps.execute();
            return true;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List ListarHistoria(String valor) {

        List<Historia> ListaHistoria= new ArrayList();
        String sql = "SELECT * FROM historiaclinica ORDER BY estado_historia ASC";
        String buscar = "SELECT * FROM historiaclinica where antec_familiares LIKE '%"
                + valor +  "%'";
        try {
            con = cn.getConectividad();
            if (valor.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            } else {
                ps = con.prepareStatement(buscar);
                rs = ps.executeQuery();
            }

            while (rs.next()) {
                Historia hi = new Historia();
                hi.setId_historiaclinica(rs.getInt("id_historiaclinica"));
                hi.setAntec_familiares(rs.getString("antec_familiares"));
                hi.setAntec_personales(rs.getString("antec_personales"));
               hi.setEstado_historia(rs.getString("estado_historia"));
                ListaHistoria.add(hi);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaHistoria;
    }

    public boolean modificar(Historia hi) {
        String sql = "UPDATE historiaclinica SET antec_familiares=?, antec_personales=? where id_historiaclinica=?";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, hi.getAntec_familiares());
            ps.setString(2, hi.getAntec_personales());
            ps.setInt(3, hi.getId_historiaclinica());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean accion(String estado_historia, int id_historiaclinica) {
        String sql = "UPDATE historiaclinica SET estado_historia=? where id_historiaclinica=?";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado_historia);
            ps.setInt(2, id_historiaclinica);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    
}
