package Controlador;

import Modelo.ComboBox;
import Modelo.Paciente;
import Modelo.PacienteDAO;
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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class Paciente_Controlador implements ActionListener, MouseListener, KeyListener  {
        
    private Paciente pa;
    private PacienteDAO pDAO;
    private CentrodSalud_Principal vista;
    
    DefaultTableModel modelo = new DefaultTableModel();

    public Paciente_Controlador(Paciente pa, PacienteDAO pDAO, CentrodSalud_Principal vista) {
        this.pa = pa;
        this.pDAO = pDAO;
        this.vista = vista;
        this.vista.btnGuardarPaciente.addActionListener(this);
        this.vista.btnModificarPaciente.addActionListener(this);
        this.vista.btnNuevoPaciente.addActionListener(this);
        //this.vista.btnBuscarCita.addActionListener(this);
        this.vista.jMenuItemELIMINARPaciente.addActionListener(this);
        this.vista.jMenuItemREINGRESARPaciente.addActionListener(this);
        this.vista.tbPaciente.addMouseListener(this);
        this.vista.txtBuscarPaciente.addKeyListener(this);
          //this.vista.tbPacienteCita.addMouseListener(this);
          //this.vista.txtcitaPaciente.addKeyListener(this);
        listarPacientes();

          // listarPacientesCita();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardarPaciente) {
            if (vista.txtNombrePaciente.getText().equals("")
                    || vista.txtdni.getText().equals("")
                    || vista.txtTelefonoPaciente.getText().equals("") || vista.txtDireccionPaciente.getText().equals("")
                    || vista.cbDistrito.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
            } else {
                pa.setNombre_paciente(vista.txtNombrePaciente.getText());
                pa.setDni(vista.txtdni.getText());
                pa.setTelefono_paciente(vista.txtTelefonoPaciente.getText());
                pa.setDireccion_paciente(vista.txtDireccionPaciente.getText());
                pa.setDistrito_paciente(vista.cbDistrito.getSelectedItem().toString());
                pa.setId_historiaclinica(Integer.parseInt(vista.txtIDHISTORIAPACIENTE.getText()));
                pa.setEstado_paciente("Activo");
 
                if (pDAO.registrar(pa)) {
                    limpiarTabla();
                    listarPacientes();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Paciente registrado con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al registrar Paciente!");
                }
            }
        } else if (e.getSource() == vista.btnModificarPaciente) {
            if (vista.txtNombrePaciente.getText().equals("")
                    || vista.txtdni.getText().equals("")
                    || vista.txtTelefonoPaciente.getText().equals("") || vista.txtDireccionPaciente.getText().equals("")
                    || vista.cbDistrito.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
            } else {
                 pa.setNombre_paciente(vista.txtNombrePaciente.getText());
                pa.setDni(vista.txtdni.getText());
                pa.setTelefono_paciente(vista.txtTelefonoPaciente.getText());
                pa.setDireccion_paciente(vista.txtDireccionPaciente.getText());
                pa.setDistrito_paciente(vista.cbDistrito.getSelectedItem().toString());
                pa.setId_paciente(Integer.parseInt(vista.txtID_Paciente.getText()));
                
                if (pDAO.modificar(pa)) {
                    limpiarTabla();
                    listarPacientes();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Modificaciòn realizada con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al modificar Paciente!");
                }
            }
        } else if (e.getSource() == vista.jMenuItemELIMINARPaciente) {
            if (vista.txtID_Paciente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Seleccione una fila para eliminar!");
            } else {
                int id = Integer.parseInt(vista.txtID_Paciente.getText());
                if (pDAO.accion("Inactivo", id)) {
                    limpiarTabla();
                    listarPacientes();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Paciente eliminado con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar paciente!");
                }
            }
        } else if (e.getSource() == vista.jMenuItemREINGRESARPaciente) {
            if (vista.txtID_Paciente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");
            } else {
                int id = Integer.parseInt(vista.txtID_Paciente.getText());
                if (pDAO.accion("Activo", id)) {
                    limpiarTabla();
                    listarPacientes();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Paciente Reingresado!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al Reingresar Paciente!");
              }
            }
                   
        }else {
            limpiar();
    
    }
    }
    
        public void listarPacientes(){
        
        Tabla color = new Tabla();
        vista.tbPaciente.setDefaultRenderer(vista.tbPaciente.getColumnClass(0), color);
        List<Paciente> lista = pDAO.ListaPacientes(vista.txtBuscarPaciente.getText());

        modelo = (DefaultTableModel) vista.tbPaciente.getModel();
        //modelo = (DefaultTableModel) vista.tbPacienteCita.getModel();
        
         Object[] ob = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_paciente();
            ob[1] = lista.get(i).getNombre_paciente();
            ob[2] = lista.get(i).getDni();
            ob[3] = lista.get(i).getTelefono_paciente();
            ob[4] = lista.get(i).getDireccion_paciente();
            ob[5] = lista.get(i).getDistrito_paciente();
            ob[6] = lista.get(i).getId_historiaclinica();
            ob[7] = lista.get(i).getEstado_paciente();

            modelo.addRow(ob);
        }
        vista.tbPaciente.setModel(modelo);
        //vista.tbPacienteCita.setModel(modelo);
    }
    
    public void limpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i -1;            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    if(e.getSource() == vista.tbPaciente){
        int fila = vista.tbPaciente.rowAtPoint(e.getPoint());
        vista.txtID_Paciente.setText(vista.tbPaciente.getValueAt(fila, 0).toString());
        vista.txtNombrePaciente.setText(vista.tbPaciente.getValueAt(fila, 1).toString());
        vista.txtdni.setText(vista.tbPaciente.getValueAt(fila, 2).toString());
        vista.txtTelefonoPaciente.setText(vista.tbPaciente.getValueAt(fila, 3).toString());
        vista.txtDireccionPaciente.setText(vista.tbPaciente.getValueAt(fila, 4).toString());
         vista.cbDistrito.setSelectedItem(vista.tbPaciente.getValueAt(fila, 5).toString());
          vista.txtIDHISTORIAPACIENTE.setText(vista.tbPaciente.getValueAt(fila, 6).toString());

    }   
//        if(e.getSource() == vista.tbPacienteCita){
//        int fila = vista.tbPaciente.rowAtPoint(e.getPoint());
//        vista.txtidcitaPaciente.setText(vista.tbPacienteCita.getValueAt(fila, 0).toString());
//        vista.txtcitaPaciente.setText(vista.tbPacienteCita.getValueAt(fila, 1).toString());
//    }
    }
    /* public void listarPacientesCita(){
        
        Tabla color = new Tabla();
        //vista.tbPaciente.setDefaultRenderer(vista.tbPaciente.getColumnClass(0), color);
        List<Paciente> lista = pDAO.ListaPacientes(vista.txtcitaPaciente.getText());
        modelo = (DefaultTableModel) vista.tbPacienteCita.getModel();
        
         Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_paciente();
            ob[1] = lista.get(i).getNombre_paciente();
            ob[2] = lista.get(i).getDni();
            ob[3] = lista.get(i).getTelefono_paciente();
            ob[4] = lista.get(i).getDireccion_paciente();
            ob[5] = lista.get(i).getDistrito_paciente();

            modelo.addRow(ob);
        }
        vista.tbPacienteCita.setModel(modelo);
    }*/
    



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
       
    if(e.getSource() == vista.txtBuscarPaciente){
        limpiarTabla();
        listarPacientes();
    }
//      if(e.getSource() == vista.txtcitaPaciente){
//        limpiarTabla();
//        listarPacientes();
//    }
    }
    
    private void limpiar(){
    vista.txtNombrePaciente.setText("");
    vista.txtdni.setText("");
    vista.txtTelefonoPaciente.setText("");
    vista.txtDireccionPaciente.setText("");
    vista.txtIDHISTORIAPACIENTE.setText("");
    vista.txtID_Paciente.setText("");
    vista.cbDistrito.setSelectedIndex(0);
    vista.txtNombrePaciente.requestFocus();
}  
                  
    

    
}
