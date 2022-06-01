package Controlador;

import Modelo.ComboBox;
import Modelo.Medicos;
import Modelo.MedicosDAO;
import Modelo.Tabla;
import Vista.CentrodSalud_Principal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class Medico_Controlador implements ActionListener, MouseListener, KeyListener {
    
    private Medicos med;
    private MedicosDAO mDAO;
    private CentrodSalud_Principal vista;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel temporal;

    public Medico_Controlador(Medicos med, MedicosDAO mDAO, CentrodSalud_Principal vista) {
        this.med = med;
        this.mDAO = mDAO;
        this.vista = vista;
        this.vista.btnGuardarMedico.addActionListener(this);
        this.vista.btnModificarMedico.addActionListener(this);
        this.vista.btnNuevoMedico.addActionListener(this);
        this.vista.tbMedicos.addMouseListener(this);
        this.vista.jMenuItemELIMINARMedicos.addActionListener(this);
        this.vista.jMenuItemREINGRESARMedicos.addActionListener(this);
        this.vista.txtBuscarMedico.addKeyListener(this);
        listarMedicos();
        llenarMedicos();
        
        //AutoCompleteDecorator.decorate(vista.cbMedico);
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.btnGuardarMedico){
            if(vista.txtNombreMe.getText().equals("") || vista.txtCMP.getText().equals("")
                    || vista.txtMailMedico.getText().equals("") || vista.txtTelefonoMedico.getText().equals("")){
                JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
            }else{
                med.setNombre_medico(vista.txtNombreMe.getText());
                med.setCmp(vista.txtCMP.getText());
                med.setCorreo_medico(vista.txtMailMedico.getText());
                med.setTelefono_medico(vista.txtTelefonoMedico.getText());
                 ComboBox itemEspe = (ComboBox) vista.cbEspecialidad.getSelectedItem();
                med.setId_especialidad(itemEspe.getId());
                med.setEstado_medico("Activo");
                
                if (mDAO.registrar(med)){
                    limpiarTabla();
                    listarMedicos();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Médico Registrado exitosamente!");
                }else{
                    JOptionPane.showMessageDialog(null, "¡ERROR, al registrar médico!");
                }
            }
        }else if (e.getSource() == vista.btnModificarMedico){
                    if(vista.txtIDMedico.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "¡Seleccione una fila!");
                    }else{
                        if (vista.txtNombreMe.getText().equals("") || vista.txtNombreMe.getText().equals("")
                                || vista.txtCMP.getText().equals("") || vista.txtNombreMe.getText().equals("")
                                || vista.txtMailMedico.getText().equals("") || vista.txtTelefonoMedico.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "¡Todos los campos son obligatorios!");
                        }else{
                            med.setNombre_medico(vista.txtNombreMe.getText());
                            med.setCmp(vista.txtCMP.getText());
                            med.setCorreo_medico(vista.txtMailMedico.getText());
                            med.setTelefono_medico(vista.txtTelefonoMedico.getText());
                             ComboBox itemEspe = (ComboBox) vista.cbEspecialidad.getSelectedItem();
                            med.setId_especialidad(itemEspe.getId());
                            med.setId_medico(Integer.parseInt(vista.txtIDMedico.getText()));
                            
                            if(mDAO.modificar(med)){
                                limpiarTabla();
                                listarMedicos();
                                JOptionPane.showMessageDialog(null, "¡Registro de médico modificado!");
                            }else{
                                JOptionPane.showMessageDialog(null, "¡Error al modificar registro de médico!");
                            }
                        }
                    }
        }else if (e.getSource() == vista.jMenuItemELIMINARMedicos){
            if (vista.txtIDMedico.getText().equals("")){
                JOptionPane.showMessageDialog(null, "¡Seleccione una fila!");
            }else{
                int id = Integer.parseInt(vista.txtIDMedico.getText());
                if (mDAO.accion("Inactivo", id)){
                    limpiarTabla();
                    listarMedicos();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "¡Registro de médico eliminado exitosamente!");
                }else{
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar registro de médico!");
                }
            }
        }else if (e.getSource() == vista.jMenuItemREINGRESARMedicos){
            if(vista.txtIDMedico.getText().equals("")){
               JOptionPane.showMessageDialog(null, "¡Seleccione una fila para Reingresar!");
            }else{
                int id = Integer.parseInt(vista.txtIDMedico.getText());
                if(mDAO.accion("Activo", id)){
                    limpiarTabla();
                    listarMedicos();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Registro de médico Reingresado!");
                }else{
                    JOptionPane.showMessageDialog(null, "¡Error al reingresar!");
                }
            }
        }else {
            limpiar();
    
    }
        }
        
        
        
        
        
    
    public void listarMedicos(){
        Tabla color = new Tabla();
        vista.tbMedicos.setDefaultRenderer(vista.tbMedicos.getColumnClass(0), color);
        List <Medicos> lista = mDAO.ListaMedicos(vista.txtBuscarMedico.getText());
        modelo = (DefaultTableModel) vista.tbMedicos.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_medico();
            ob[1] = lista.get(i).getNombre_medico();
            ob[2] = lista.get(i).getCmp();
            ob[3] = lista.get(i).getCorreo_medico();
            ob[4] = lista.get(i).getTelefono_medico();
            ob[5] = lista.get(i).getId_especialidad();
            ob[6] = lista.get(i).getEstado_medico();
            modelo.addRow(ob);
        }
        vista.tbMedicos.setModel(modelo);
        JTableHeader header = vista.tbMedicos.getTableHeader();
        header.setOpaque(false);
        header.setBackground(Color.yellow);
        header.setForeground(Color.black);
    }
    public void limpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.tbMedicos){
            int fila = vista.tbMedicos.rowAtPoint(e.getPoint());
            vista.txtIDMedico.setText(vista.tbMedicos.getValueAt(fila, 0).toString());
            vista.txtNombreMe.setText(vista.tbMedicos.getValueAt(fila, 1).toString());
            vista.txtCMP.setText(vista.tbMedicos.getValueAt(fila, 2).toString());
            vista.txtMailMedico.setText(vista.tbMedicos.getValueAt(fila, 3).toString());
            vista.txtTelefonoMedico.setText(vista.tbMedicos.getValueAt(fila, 4).toString());
           vista.cbEspecialidad.setSelectedItem(new ComboBox(med.getId_especialidad(), med.getNombre_especialidad()));
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
        if(e.getSource() == vista.txtBuscarMedico){
        limpiarTabla();
        listarMedicos();
    }
        }
    
              private void llenarMedicos() {
        List<Medicos> lista = mDAO.ListaMedicos(vista.txtBuscarMedico.getText());
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId_medico();
            String nombre = lista.get(i).getNombre_medico();
            //vista.cbMedico.addItem(new ComboBox(id, nombre));

        }
    }
    

    
    private void limpiar(){
        vista.txtIDMedico.setText("");
        //vista.txtNombreEspecialidad.setText("");
        vista.txtCMP.setText("");
        vista.txtMailMedico.setText("");
        vista.txtTelefonoMedico.setText("");
        vista.txtNombreMe.setText("");
        vista.cbEspecialidad.setSelectedIndex(0);
        vista.txtNombreMe.requestFocus();
    }
    
    
    
    
}
