package Controlador;

import Modelo.Historia;
import Modelo.HistoriaDAO;
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
public class Historia_Controlador implements ActionListener, MouseListener, KeyListener  {
        
    private Historia hi;
    private HistoriaDAO hiDAO;
    private CentrodSalud_Principal vista;
    
    DefaultTableModel modelo = new DefaultTableModel();

    public Historia_Controlador(Historia hi, HistoriaDAO hiDAO, CentrodSalud_Principal vista) {
        this.hi = hi;
        this.hiDAO = hiDAO;
        this.vista = vista;
        this.vista.btnGuardarHistoria.addActionListener(this);
        this.vista.btnModificarHis.addActionListener(this);
        this.vista.btnNuevaHistoria.addActionListener(this);
        this.vista.jMenuItemELIMINARHistoria.addActionListener(this);
        this.vista.jMenuItemREINGRESARHistoria.addActionListener(this);
        this.vista.tbHistoria.addMouseListener(this);
        this.vista.txtBuscarHistoria.addKeyListener(this);
        listarHistoria();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardarHistoria) {
            if (vista.txtAntecedentesF.getText().equals("")
                    || vista.txtAntecedentePer.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
            } else {
                hi.setAntec_familiares(vista.txtAntecedentesF.getText());
                hi.setAntec_personales(vista.txtAntecedentePer.getText());
                hi.setEstado_historia("Activo");

                if (hiDAO.registrar(hi)) {
                    limpiarTabla();
                    listarHistoria();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Historia clinica registrado con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al registrar Historia Clinica!");
                }
            }
        } else if (e.getSource() == vista.btnModificarHis) {
            if (vista.txtAntecedentesF.getText().equals("")
                    || vista.txtAntecedentePer.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
            } else {
                hi.setAntec_familiares(vista.txtAntecedentesF.getText());
                hi.setAntec_personales(vista.txtAntecedentePer.getText());
                hi.setId_historiaclinica(Integer.parseInt(vista.txtIdHistoria.getText()));
                if (hiDAO.modificar(hi)) {
                    limpiarTabla();
                    listarHistoria();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Modificaciòn realizada con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al modificar la historia clínica!");
                }
            }
        } else if (e.getSource() == vista.jMenuItemELIMINARHistoria) {
            if (vista.txtIdHistoria.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡Seleccione una fila para eliminar!");
            } else {
                int id = Integer.parseInt(vista.txtIdHistoria.getText());
                if (hiDAO.accion("Inactivo", id)) {
                    limpiarTabla();
                    listarHistoria();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Datos de historia clínica eliminados con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar datos en historia clínica!");
                }
            }
        } else if (e.getSource() == vista.jMenuItemREINGRESARHistoria) {
            if (vista.txtIdHistoria.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");
            } else {
                int id = Integer.parseInt(vista.txtIdHistoria.getText());
                if (hiDAO.accion("Activo", id)) {
                    limpiarTabla();
                    listarHistoria();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Historia clínica reingresada");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al reingresar!");
                }
            }
        } else {
            limpiar();
        }
    
    }
    
        public void listarHistoria(){
        
        Tabla color = new Tabla();
        vista.tbHistoria.setDefaultRenderer(vista.tbHistoria.getColumnClass(0), color);
        List<Historia> lista = hiDAO.ListarHistoria(vista.txtBuscarHistoria.getText());
        modelo = (DefaultTableModel) vista.tbHistoria.getModel();
        
         Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_historiaclinica();
            ob[1] = lista.get(i).getAntec_familiares();
            ob[2] = lista.get(i).getAntec_personales();
            ob[3] = lista.get(i).getEstado_historia();
            modelo.addRow(ob);
        }
        vista.tbHistoria.setModel(modelo);
    }
    
    public void limpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i -1;            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    if(e.getSource() == vista.tbHistoria){
        int fila = vista.tbHistoria.rowAtPoint(e.getPoint());
        vista.txtIdHistoria.setText(vista.tbHistoria.getValueAt(fila, 0).toString());
        vista.txtAntecedentesF.setText(vista.tbHistoria.getValueAt(fila, 1).toString());
        vista.txtAntecedentePer.setText(vista.tbHistoria.getValueAt(fila, 2).toString());
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
       
    if(e.getSource() == vista.txtBuscarHistoria){
        limpiarTabla();
       listarHistoria();
    }
    }
    
    private void limpiar(){
       vista.txtAntecedentePer.setText("");
        vista.txtAntecedentesF.setText("");
        vista.txtIdHistoria.setText("");
        vista.txtAntecedentesF.requestFocus();
    }  
    
}
