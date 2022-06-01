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
public class PacienteDAO {
    
    Conectividad cn = new Conectividad();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean registrar(Paciente pa) {
        String sql = "INSERT INTO paciente(nombre_paciente, dni, telefono_paciente, "
                + "direccion_paciente, distrito_paciente, id_historiaclinica, estado_paciente) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pa.getNombre_paciente());
            ps.setString(2, pa.getDni());
            ps.setString(3, pa.getTelefono_paciente());
            ps.setString(4, pa.getDireccion_paciente());
            ps.setString(5, pa.getDistrito_paciente());
            ps.setInt(6, pa.getId_historiaclinica());
            ps.setString(7, pa.getEstado_paciente());


            ps.execute();
            return true;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List ListaPacientes(String valor) {

        List<Paciente> ListaPaciente = new ArrayList();
        String sql = "SELECT * FROM paciente ORDER BY estado_paciente ASC";
        String buscar = "SELECT * FROM paciente where nombre_paciente LIKE '%"
                 + valor + "%'";
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
                Paciente pa = new Paciente();
                pa.setId_paciente(rs.getInt("id_paciente"));
                pa.setNombre_paciente(rs.getString("nombre_paciente"));
                pa.setDni(rs.getString("dni"));
                pa.setTelefono_paciente(rs.getString("telefono_paciente"));
                pa.setDireccion_paciente(rs.getString("direccion_paciente"));
                pa.setDistrito_paciente(rs.getString("distrito_paciente"));
                pa.setId_historiaclinica(rs.getInt("id_historiaclinica"));
                pa.setEstado_paciente(rs.getString("estado_paciente"));

                ListaPaciente.add(pa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaPaciente;
    }

    public boolean modificar(Paciente pa) {
        String sql = "UPDATE paciente SET nombre_paciente=?, dni=?,  telefono_paciente=?, direccion_paciente =?, distrito_paciente=? where id_paciente=?";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, pa.getNombre_paciente());
            ps.setString(2, pa.getDni());
            ps.setString(3, pa.getTelefono_paciente());
            ps.setString(4, pa.getDireccion_paciente());
            ps.setString(5, pa.getDistrito_paciente());
            ps.setInt(6, pa.getId_paciente());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean accion(String estado_paciente, int id_paciente) {
        String sql = "UPDATE paciente SET estado_paciente=? where id_paciente=?";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado_paciente);
            ps.setInt(2, id_paciente);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
      /*public List ListaPacientesCita(String valor) {

        List<Paciente> ListaPacienteCita = new ArrayList();
        String sql = "SELECT * FROM paciente ORDER BY estado_paciente ASC";
        String buscar = "SELECT * FROM paciente where nombre_paciente LIKE '%"
                 + valor + "%'";
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
                Paciente pa = new Paciente();
                pa.setId_paciente(rs.getInt("id_paciente"));
                pa.setNombre_paciente(rs.getString("nombre_paciente"));
                pa.setDni(rs.getString("dni"));
                pa.setTelefono_paciente(rs.getString("telefono_paciente"));
                pa.setDireccion_paciente(rs.getString("direccion_paciente"));
                pa.setDistrito_paciente(rs.getString("distrito_paciente"));
                pa.setEstado_paciente(rs.getString("estado_paciente"));
                ListaPacienteCita.add(pa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaPacienteCita;
    }*/
    
}
