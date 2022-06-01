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
public class UsuarioDAO {
    
    Conectividad cn = new Conectividad();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario login(String username, String contraseña) {
        String sql = "Select * from usuarios where username=? and contraseña=?";
        Usuario us = new Usuario();
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setUsername(rs.getString("username"));
                us.setContraseña(rs.getString("contraseña"));
                us.setPerfil(rs.getString("perfil"));
                us.setCorreo_electronico(rs.getString("correo_electronico"));
                us.setTelefono(rs.getString("telefono"));
                us.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return us;
    }

    public boolean registrar(Usuario us) {
        String sql = "INSERT INTO usuarios(nombre, username, contraseña, perfil, correo_electronico, telefono, estado) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getUsername());
            ps.setString(3, us.getContraseña());
            ps.setString(4, us.getPerfil());
            ps.setString(5, us.getCorreo_electronico());
            ps.setString(6, us.getTelefono());
            ps.setString(7, us.getEstado());
            ps.execute();
            return true;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List ListaUsuarios(String valor) {

        List<Usuario> ListaUsers = new ArrayList();
        String sql = "SELECT * FROM usuarios ORDER BY estado ASC";
        String buscar = "SELECT * FROM usuarios where username LIKE '%"
                + valor + "%' OR nombre LIKE'%" + valor + "%'";
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
                Usuario us = new Usuario();
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setUsername(rs.getString("username"));
                us.setPerfil(rs.getString("perfil"));
                us.setCorreo_electronico(rs.getString("correo_electronico"));
                us.setTelefono(rs.getString("telefono"));
                us.setEstado(rs.getString("estado"));
                ListaUsers.add(us);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaUsers;
    }

    public boolean modificar(Usuario us) {
        String sql = "UPDATE usuarios SET nombre=?, username=?,  perfil=?, correo_electronico =?, telefono=? where id_usuario=?";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getUsername());
            ps.setString(3, us.getPerfil());
            ps.setString(4, us.getCorreo_electronico());
            ps.setString(5, us.getTelefono());
            ps.setInt(6, us.getId_usuario());
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean accion(String estado, int id_usuario) {
        String sql = "UPDATE usuarios SET estado=? where id_usuario=?";
        try {
            con = cn.getConectividad();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id_usuario);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    
}
