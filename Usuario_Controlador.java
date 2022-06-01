package Controlador;

import Modelo.Tabla;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.CentrodSalud_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class Usuario_Controlador implements ActionListener, MouseListener, KeyListener  {
        
    private Usuario us;
    private UsuarioDAO usDAO;
    private CentrodSalud_Principal vista;
    
    DefaultTableModel modelo = new DefaultTableModel();

    public Usuario_Controlador(Usuario us, UsuarioDAO usDAO, CentrodSalud_Principal vista) {
        this.us = us;
        this.usDAO = usDAO;
        this.vista = vista;
        this.vista.btnGuardarU.addActionListener(this);
        this.vista.btnModificarU.addActionListener(this);
        this.vista.btnNuevoU.addActionListener(this);
        this.vista.jMenuItemELIMINARUSUARIO.addActionListener(this);
        this.vista.jMenuItemREINGRESARUSUARIO.addActionListener(this);
        this.vista.tbUsuarios.addMouseListener(this);
        this.vista.txtBuscarU.addKeyListener(this);
        listarUsuarios();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardarU) {
            if (vista.txtUser.getText().equals("")
                    || vista.txtNombreU.getText().equals("")
                    || String.valueOf(vista.txtContra.getPassword()).equals("")|| vista.txtMail.getText().equals("")
                    || vista.txtTelefono.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
            } else {
                us.setNombre(vista.txtNombreU.getText());
                us.setUsername(vista.txtUser.getText());
                us.setContraseña(String.valueOf(vista.txtContra.getPassword()));
                us.setPerfil(vista.cbPerfil.getSelectedItem().toString());
                us.setCorreo_electronico(vista.txtMail.getText());
                us.setTelefono(vista.txtTelefono.getText());
                us.setEstado("Activo");
   

                if (usDAO.registrar(us)) {
                    limpiarTabla();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Usuario registrado con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al registrar el Usuario!");
                }
            }
        } else if (e.getSource() == vista.btnModificarU) {
            if (vista.txtUser.getText().equals("")
                    || vista.txtNombreU.getText().equals("")|| vista.txtMail.getText().equals("")
                    || vista.txtTelefono.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
            } else {
                us.setNombre(vista.txtNombreU.getText());
                us.setUsername(vista.txtUser.getText());
                us.setContraseña(String.valueOf(vista.txtContra.getPassword()));
                us.setPerfil(vista.cbPerfil.getSelectedItem().toString());
                us.setCorreo_electronico(vista.txtMail.getText());
                us.setTelefono(vista.txtTelefono.getText());
                us.setId_usuario(Integer.parseInt(vista.txtID_Usuario.getText()));
                if (usDAO.modificar(us)) {
                    limpiarTabla();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Modificación realizada con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al modificar el Usuario!");
                }
            }
        } else if (e.getSource() == vista.jMenuItemELIMINARUSUARIO) {
            if (vista.txtID_Usuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Seleccione una fila para eliminar!");
            } else {
                int id = Integer.parseInt(vista.txtID_Usuario.getText());
                if (usDAO.accion("Inactivo", id)) {
                    limpiarTabla();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Usuario eliminado con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error eliminado con éxito!");
                }
            }
        } else if (e.getSource() == vista.jMenuItemREINGRESARUSUARIO) {
            if (vista.txtID_Usuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");
            } else {
                int id = Integer.parseInt(vista.txtID_Usuario.getText());
                if (usDAO.accion("Activo", id)) {
                    limpiarTabla();
                    listarUsuarios();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Usuario reingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al reingresar");
                }
            }
        } else {
            limpiar();
        }
    
    }
    
        public void listarUsuarios(){
        
        Tabla color = new Tabla();
        vista.tbUsuarios.setDefaultRenderer(vista.tbUsuarios.getColumnClass(0), color);
        List<Usuario> lista = usDAO.ListaUsuarios(vista.txtBuscarU.getText());
        modelo = (DefaultTableModel) vista.tbUsuarios.getModel();
        
         Object[] ob = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_usuario();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getUsername();
            ob[3] = lista.get(i).getPerfil();
            ob[4] = lista.get(i).getCorreo_electronico();
            ob[5] = lista.get(i).getTelefono();
            ob[6] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        vista.tbUsuarios.setModel(modelo);
    }
    
    public void limpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i -1;            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    if(e.getSource() == vista.tbUsuarios){
        int fila = vista.tbUsuarios.rowAtPoint(e.getPoint());
        vista.txtID_Usuario.setText(vista.tbUsuarios.getValueAt(fila, 0).toString());
        vista.txtNombreU.setText(vista.tbUsuarios.getValueAt(fila, 1).toString());
        vista.txtUser.setText(vista.tbUsuarios.getValueAt(fila, 2).toString());
        vista.cbPerfil.setSelectedItem(vista.tbUsuarios.getValueAt(fila, 3).toString());
        vista.txtMail.setText(vista.tbUsuarios.getValueAt(fila, 4).toString());
        vista.txtTelefono.setText(vista.tbUsuarios.getValueAt(fila, 5).toString());
        vista.txtContra.setEnabled(false);
    }   
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         }

    @Override
    public void mouseEntered(MouseEvent e) {
          }

    @Override
    public void mouseExited(MouseEvent e) {
          }

    @Override
    public void keyTyped(KeyEvent e) {
         }

    @Override
    public void keyPressed(KeyEvent e) {
         }

    @Override
    public void keyReleased(KeyEvent e) {
       
    if(e.getSource() == vista.txtBuscarU){
        limpiarTabla();
        listarUsuarios();
    }
    }
    
    private void limpiar(){
    vista.txtNombreU.setText("");
    vista.txtMail.setText("");
    vista.txtID_Usuario.setText("");
    vista.txtContra.setText("");
    vista.txtUser.setText("");
    vista.txtTelefono.setText("");
    vista.cbPerfil.setSelectedIndex(0);
    vista.txtContra.setEnabled(true);
    vista.txtUser.requestFocus();
}  
    
}
