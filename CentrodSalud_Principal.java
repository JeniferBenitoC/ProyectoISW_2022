
package Vista;


import Controlador.Historia_Controlador;

import Controlador.Medico_Controlador;
import Controlador.Paciente_Controlador;
import Controlador.Usuario_Controlador;
import Modelo.ComboBox;
import Modelo.Conectividad;
import Modelo.Historia;
import Modelo.HistoriaDAO;

import Modelo.Medicos;
import Modelo.MedicosDAO;
import Modelo.Paciente;
import Modelo.PacienteDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
        
    
public class CentrodSalud_Principal extends javax.swing.JFrame{

    
    String user, nombre_usuario;
    public static int sesion_usuario;
    
    
    String Id_paciente,Id_Receta,Id_Medico, Id_medi="", indicacion ="", id_pacientecita, nombre_medico;
    DefaultTableModel Model = new DefaultTableModel();
    int Cant;
    Conectividad con = new Conectividad();
    Connection cn = con.getConectividad();
    Usuario us = new Usuario();
    UsuarioDAO usDAO = new UsuarioDAO();

    Medicos me = new Medicos();
    MedicosDAO mDAO = new MedicosDAO();
    Historia hi = new Historia();
    HistoriaDAO hiDAO = new HistoriaDAO();
    Paciente pa = new Paciente();
    PacienteDAO pDAO = new PacienteDAO();


    /*InhabilitarPestañas
    PanelClinica.setEnabledAt(1,false)*/
    
    public CentrodSalud_Principal() {
        initComponents();
        this.setSize(1210, 730);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        setTitle("¡Bienvenido a su Sesión en el sistema!");  
        user = CentrodSalud_Login.usuario;
        sesion_usuario = 1; //variable de función bandera
        
         Date sistFecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        jLabelFECHA.setText(formato.format(sistFecha));
        
        Timer temp = new Timer(100, new CentrodSalud_Principal.horas());
        temp.start();

         Usuario_Controlador usuariocontrol = new Usuario_Controlador(us, usDAO, this);
        Medico_Controlador mcontrol = new Medico_Controlador(me, mDAO, this);
        Historia_Controlador hcontrol = new Historia_Controlador(hi, hiDAO,this);
        Paciente_Controlador pcontrol = new Paciente_Controlador(pa,pDAO,this);
         
    }
    
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/clinicalogo.png"));
        return retValue;
    }
    
    class horas implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Date sistHora = new Date();
            String pmAm = "hh:mm:ss  a";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            jLabelHORA.setText(String.format(format.format(sistHora), hoy));
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuUsuario = new javax.swing.JPopupMenu();
        jMenuItemELIMINARUSUARIO = new javax.swing.JMenuItem();
        jMenuItemREINGRESARUSUARIO = new javax.swing.JMenuItem();
        jPopupMenuEspecialidad = new javax.swing.JPopupMenu();
        jMenuItemELIMINAREspecialidad = new javax.swing.JMenuItem();
        jMenuItemREINGRESAREspecialidad = new javax.swing.JMenuItem();
        jPopupMenuMedicos = new javax.swing.JPopupMenu();
        jMenuItemELIMINARMedicos = new javax.swing.JMenuItem();
        jMenuItemREINGRESARMedicos = new javax.swing.JMenuItem();
        jPopupMenuHistoria = new javax.swing.JPopupMenu();
        jMenuItemELIMINARHistoria = new javax.swing.JMenuItem();
        jMenuItemREINGRESARHistoria = new javax.swing.JMenuItem();
        jPopupMenuPaciente = new javax.swing.JPopupMenu();
        jMenuItemELIMINARPaciente = new javax.swing.JMenuItem();
        jMenuItemREINGRESARPaciente = new javax.swing.JMenuItem();
        jPopupMenuMedicamento = new javax.swing.JPopupMenu();
        jMenuItemELIMINARMedicamento = new javax.swing.JMenuItem();
        jMenuItemREINGRESARMedicamentos = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelClinica = new javax.swing.JTabbedPane();
        jPanelInicio = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabelFECHA1 = new javax.swing.JLabel();
        jLabelFECHA = new javax.swing.JLabel();
        jLabelFECHA2 = new javax.swing.JLabel();
        jLabelHORA = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbNombreUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanelUsuarios = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarU = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreU = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtID_Usuario = new javax.swing.JTextField();
        panel1 = new java.awt.Panel();
        btnNuevoU = new javax.swing.JButton();
        btnGuardarU = new javax.swing.JButton();
        btnModificarU = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        PanelMedicos = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtBuscarMedico = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNombreMe = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCMP = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtMailMedico = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTelefonoMedico = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbEspecialidad = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtIDMedico = new javax.swing.JTextField();
        panel2 = new java.awt.Panel();
        btnNuevoMedico = new javax.swing.JButton();
        btnGuardarMedico = new javax.swing.JButton();
        btnModificarMedico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMedicos = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jPanelHistoria = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtBuscarHistoria = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtAntecedentesF = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtAntecedentePer = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtIdHistoria = new javax.swing.JTextField();
        panel3 = new java.awt.Panel();
        btnNuevaHistoria = new javax.swing.JButton();
        btnGuardarHistoria = new javax.swing.JButton();
        btnModificarHis = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHistoria = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jPanelPacientes = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtBuscarPaciente = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtNombrePaciente = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtTelefonoPaciente = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtDireccionPaciente = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        cbDistrito = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        txtID_Paciente = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtIDHISTORIAPACIENTE = new javax.swing.JTextField();
        panel4 = new java.awt.Panel();
        btnNuevoPaciente = new javax.swing.JButton();
        btnGuardarPaciente = new javax.swing.JButton();
        btnModificarPaciente = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbPaciente = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuReportes = new javax.swing.JMenu();
        jMenuItemReporteUsuarios = new javax.swing.JMenuItem();
        jMenuItemReporteMedicos = new javax.swing.JMenuItem();
        jMenuItemReportePacientes = new javax.swing.JMenuItem();
        jMenuItemReporteCitas = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItemELIMINARUSUARIO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemELIMINARUSUARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ELIMINARPE.png"))); // NOI18N
        jMenuItemELIMINARUSUARIO.setText("ELIMINAR");
        jPopupMenuUsuario.add(jMenuItemELIMINARUSUARIO);

        jMenuItemREINGRESARUSUARIO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemREINGRESARUSUARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/REINGRESAR.png"))); // NOI18N
        jMenuItemREINGRESARUSUARIO.setText("REINGRESAR");
        jPopupMenuUsuario.add(jMenuItemREINGRESARUSUARIO);

        jMenuItemELIMINAREspecialidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemELIMINAREspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ELIMINARPE.png"))); // NOI18N
        jMenuItemELIMINAREspecialidad.setText("ELIMINAR");
        jPopupMenuEspecialidad.add(jMenuItemELIMINAREspecialidad);

        jMenuItemREINGRESAREspecialidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemREINGRESAREspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/REINGRESAR.png"))); // NOI18N
        jMenuItemREINGRESAREspecialidad.setText("REINGRESAR");
        jPopupMenuEspecialidad.add(jMenuItemREINGRESAREspecialidad);

        jMenuItemELIMINARMedicos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemELIMINARMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ELIMINARPE.png"))); // NOI18N
        jMenuItemELIMINARMedicos.setText("ELIMINAR");
        jPopupMenuMedicos.add(jMenuItemELIMINARMedicos);

        jMenuItemREINGRESARMedicos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemREINGRESARMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/REINGRESAR.png"))); // NOI18N
        jMenuItemREINGRESARMedicos.setText("REINGRESAR");
        jPopupMenuMedicos.add(jMenuItemREINGRESARMedicos);

        jMenuItemELIMINARHistoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemELIMINARHistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ELIMINARPE.png"))); // NOI18N
        jMenuItemELIMINARHistoria.setText("ELIMINAR");
        jPopupMenuHistoria.add(jMenuItemELIMINARHistoria);

        jMenuItemREINGRESARHistoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemREINGRESARHistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/REINGRESAR.png"))); // NOI18N
        jMenuItemREINGRESARHistoria.setText("REINGRESAR");
        jPopupMenuHistoria.add(jMenuItemREINGRESARHistoria);

        jMenuItemELIMINARPaciente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemELIMINARPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ELIMINARPE.png"))); // NOI18N
        jMenuItemELIMINARPaciente.setText("ELIMINAR");
        jPopupMenuPaciente.add(jMenuItemELIMINARPaciente);

        jMenuItemREINGRESARPaciente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemREINGRESARPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/REINGRESAR.png"))); // NOI18N
        jMenuItemREINGRESARPaciente.setText("REINGRESAR");
        jPopupMenuPaciente.add(jMenuItemREINGRESARPaciente);

        jMenuItemELIMINARMedicamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemELIMINARMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ELIMINARPE.png"))); // NOI18N
        jMenuItemELIMINARMedicamento.setText("ELIMINAR");
        jPopupMenuMedicamento.add(jMenuItemELIMINARMedicamento);

        jMenuItemREINGRESARMedicamentos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItemREINGRESARMedicamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/REINGRESAR.png"))); // NOI18N
        jMenuItemREINGRESARMedicamentos.setText("REINGRESAR");
        jPopupMenuMedicamento.add(jMenuItemREINGRESARMedicamentos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLÍNICA ECOSSALUD");
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/diris.png"))); // NOI18N
        jPanel2.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel2.setText("\"Centro de Salud Comas\"");
        jPanel2.add(jLabel2);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1180, 120);

        PanelClinica.setBackground(new java.awt.Color(216, 238, 235));
        PanelClinica.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 15)); // NOI18N

        jPanelInicio.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setLayout(new java.awt.GridLayout(2, 2));

        jLabelFECHA1.setBackground(new java.awt.Color(255, 255, 204));
        jLabelFECHA1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabelFECHA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFECHA1.setText("FECHA:");
        jPanel6.add(jLabelFECHA1);

        jLabelFECHA.setBackground(new java.awt.Color(255, 255, 204));
        jLabelFECHA.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabelFECHA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFECHA.setText("DD/MM/AA");
        jPanel6.add(jLabelFECHA);

        jLabelFECHA2.setBackground(new java.awt.Color(255, 255, 204));
        jLabelFECHA2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabelFECHA2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFECHA2.setText("HORA:");
        jPanel6.add(jLabelFECHA2);

        jLabelHORA.setBackground(new java.awt.Color(255, 255, 204));
        jLabelHORA.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabelHORA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHORA.setText("00:00:00");
        jPanel6.add(jLabelHORA);

        jPanelInicio.add(jPanel6);
        jPanel6.setBounds(430, 110, 350, 140);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 48)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("¡BIENVENID@ AL SISTEMA!");
        jPanelInicio.add(jLabel6);
        jLabel6.setBounds(280, 50, 630, 50);
        jPanelInicio.add(lbNombreUsuario);
        lbNombreUsuario.setBounds(510, 80, 250, 60);

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanelInicio.add(jLabel3);
        jLabel3.setBounds(0, 0, 1180, 490);
        jPanelInicio.add(jPanel8);
        jPanel8.setBounds(170, 230, 10, 10);

        PanelClinica.addTab("INICIO", jPanelInicio);

        jPanelUsuarios.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVO USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 18))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(216, 238, 235));
        jPanel1.setLayout(new java.awt.GridLayout(8, 2));

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel1.add(jLabel5);

        txtBuscarU.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtBuscarU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtBuscarU);

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("USERNAME");
        jPanel1.add(jLabel7);

        txtUser.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtUser);

        jLabel8.setBackground(new java.awt.Color(255, 255, 204));
        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("NOMBRE");
        jPanel1.add(jLabel8);

        txtNombreU.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtNombreU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtNombreU);

        jLabel9.setBackground(new java.awt.Color(255, 255, 204));
        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CONTRASEÑA");
        jPanel1.add(jLabel9);

        txtContra.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtContra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtContra);

        jLabel10.setBackground(new java.awt.Color(255, 255, 204));
        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PERFIL");
        jPanel1.add(jLabel10);

        cbPerfil.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE UNA OPCIÓN --", "ADMINISTRADOR", "EMPLEADO CENTRO DE SALUD" }));
        jPanel1.add(cbPerfil);

        jLabel11.setBackground(new java.awt.Color(255, 255, 204));
        jLabel11.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("CORREO ELECTRÓNICO");
        jPanel1.add(jLabel11);

        txtMail.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtMail);

        jLabel12.setBackground(new java.awt.Color(255, 255, 204));
        jLabel12.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TELEFONO");
        jPanel1.add(jLabel12);

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtTelefono);

        jLabel13.setBackground(new java.awt.Color(255, 255, 204));
        jLabel13.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ID USUARIO");
        jPanel1.add(jLabel13);

        txtID_Usuario.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtID_Usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID_Usuario.setEnabled(false);
        jPanel1.add(txtID_Usuario);

        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, 490, 320));

        panel1.setBackground(new java.awt.Color(216, 238, 235));
        panel1.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btnNuevoU.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnNuevoU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuariope.png"))); // NOI18N
        btnNuevoU.setText("NUEVO");
        btnNuevoU.setToolTipText("NUEVO");
        btnNuevoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUActionPerformed(evt);
            }
        });
        panel1.add(btnNuevoU);

        btnGuardarU.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnGuardarU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GUARDARPE.png"))); // NOI18N
        btnGuardarU.setText("GUARDAR");
        btnGuardarU.setToolTipText("GUARDAR");
        panel1.add(btnGuardarU);

        btnModificarU.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnModificarU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EDITARPE.png"))); // NOI18N
        btnModificarU.setText("MODIFICAR");
        btnModificarU.setToolTipText("MODIFICAR");
        panel1.add(btnModificarU);

        jPanel9.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 460, 60));

        jPanelUsuarios.add(jPanel9);
        jPanel9.setBounds(650, 10, 510, 470);

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDUSUARIO", "NOMBRE", "USERNAME", "PERFIL", "CORREO", "TELEFONO", "ESTADO"
            }
        ));
        tbUsuarios.setColumnSelectionAllowed(true);
        tbUsuarios.setComponentPopupMenu(jPopupMenuUsuario);
        jScrollPane1.setViewportView(tbUsuarios);

        jPanelUsuarios.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 630, 420);

        PanelClinica.addTab("USUARIOS", jPanelUsuarios);

        PanelMedicos.setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVO MÉDICO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 18))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.setLayout(new java.awt.GridLayout(8, 2));

        jLabel14.setBackground(new java.awt.Color(255, 255, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        jPanel11.add(jLabel14);

        txtBuscarMedico.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtBuscarMedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(txtBuscarMedico);

        jLabel15.setBackground(new java.awt.Color(255, 255, 204));
        jLabel15.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("NOMBRE");
        jPanel11.add(jLabel15);

        txtNombreMe.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtNombreMe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(txtNombreMe);

        jLabel16.setBackground(new java.awt.Color(255, 255, 204));
        jLabel16.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CMP");
        jPanel11.add(jLabel16);

        txtCMP.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtCMP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(txtCMP);

        jLabel19.setBackground(new java.awt.Color(255, 255, 204));
        jLabel19.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CORREO ELECTRÓNICO");
        jPanel11.add(jLabel19);

        txtMailMedico.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtMailMedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(txtMailMedico);

        jLabel20.setBackground(new java.awt.Color(255, 255, 204));
        jLabel20.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("TELEFONO");
        jPanel11.add(jLabel20);

        txtTelefonoMedico.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtTelefonoMedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(txtTelefonoMedico);

        jLabel18.setBackground(new java.awt.Color(255, 255, 204));
        jLabel18.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ESPECIALIDAD");
        jPanel11.add(jLabel18);

        cbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- SELECCIONE UNA OPCIÓN ---" }));
        jPanel11.add(cbEspecialidad);

        jLabel21.setBackground(new java.awt.Color(255, 255, 204));
        jLabel21.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("ID MÉDICO");
        jPanel11.add(jLabel21);

        txtIDMedico.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtIDMedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDMedico.setEnabled(false);
        jPanel11.add(txtIDMedico);

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, 490, 320));

        panel2.setBackground(new java.awt.Color(216, 238, 235));
        panel2.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btnNuevoMedico.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnNuevoMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medicope.png"))); // NOI18N
        btnNuevoMedico.setText("NUEVO");
        btnNuevoMedico.setToolTipText("NUEVO MÉDICO");
        btnNuevoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMedicoActionPerformed(evt);
            }
        });
        panel2.add(btnNuevoMedico);

        btnGuardarMedico.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnGuardarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GUARDARPE.png"))); // NOI18N
        btnGuardarMedico.setText("GUARDAR");
        btnGuardarMedico.setToolTipText("GUARDAR");
        panel2.add(btnGuardarMedico);

        btnModificarMedico.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnModificarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EDITARPE.png"))); // NOI18N
        btnModificarMedico.setText("MODIFICAR");
        btnModificarMedico.setToolTipText("MODIFICAR");
        panel2.add(btnModificarMedico);

        jPanel10.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 460, 60));

        PanelMedicos.add(jPanel10);
        jPanel10.setBounds(650, 10, 510, 470);

        tbMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID MEDICO", "NOMBRE", "CMP", "CORREO", "TELEFONO", "ESPECIALIDAD", "ESTADO"
            }
        ));
        tbMedicos.setComponentPopupMenu(jPopupMenuMedicos);
        jScrollPane2.setViewportView(tbMedicos);

        PanelMedicos.add(jScrollPane2);
        jScrollPane2.setBounds(20, 20, 620, 420);

        jLabel22.setBackground(new java.awt.Color(255, 255, 204));
        PanelMedicos.add(jLabel22);
        jLabel22.setBounds(0, 0, 1180, 490);

        PanelClinica.addTab("MÉDICOS", PanelMedicos);

        jPanelHistoria.setLayout(null);

        jPanel17.setBackground(new java.awt.Color(255, 255, 204));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVA HISTORIA CLINICA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 18))); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(216, 238, 235));
        jPanel18.setLayout(new java.awt.GridLayout(8, 2));

        jLabel23.setBackground(new java.awt.Color(255, 255, 204));
        jLabel23.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        jLabel23.setText("BUSCAR");
        jPanel18.add(jLabel23);

        txtBuscarHistoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel18.add(txtBuscarHistoria);

        jLabel24.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("ANTECEDENTES FAMILIARES");
        jPanel18.add(jLabel24);

        txtAntecedentesF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel18.add(txtAntecedentesF);

        jLabel25.setBackground(new java.awt.Color(255, 255, 204));
        jLabel25.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("ANTECEDENTES PERSONALES");
        jPanel18.add(jLabel25);

        txtAntecedentePer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel18.add(txtAntecedentePer);

        jLabel30.setBackground(new java.awt.Color(255, 255, 204));
        jLabel30.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("ID HISTORIA CLÍNICA");
        jPanel18.add(jLabel30);

        txtIdHistoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdHistoria.setEnabled(false);
        jPanel18.add(txtIdHistoria);

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, 490, 320));

        panel3.setBackground(new java.awt.Color(216, 238, 235));
        panel3.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btnNuevaHistoria.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnNuevaHistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/HISTORIAPE.png"))); // NOI18N
        btnNuevaHistoria.setText("NUEVO");
        btnNuevaHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaHistoriaActionPerformed(evt);
            }
        });
        panel3.add(btnNuevaHistoria);

        btnGuardarHistoria.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnGuardarHistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GUARDARPE.png"))); // NOI18N
        btnGuardarHistoria.setText("GUARDAR");
        panel3.add(btnGuardarHistoria);

        btnModificarHis.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnModificarHis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EDITARPE.png"))); // NOI18N
        btnModificarHis.setText("MODIFICAR");
        panel3.add(btnModificarHis);

        jPanel17.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 460, 60));

        jPanelHistoria.add(jPanel17);
        jPanel17.setBounds(650, 10, 510, 470);

        tbHistoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID HISTORIA CLINICA", "ANTECEDENTES FAMILIARES", "ANTECEDENTES PERSONALES", "ESTADO"
            }
        ));
        tbHistoria.setComponentPopupMenu(jPopupMenuHistoria);
        jScrollPane3.setViewportView(tbHistoria);

        jPanelHistoria.add(jScrollPane3);
        jScrollPane3.setBounds(10, 20, 630, 420);

        jLabel31.setText("jLabel4");
        jPanelHistoria.add(jLabel31);
        jLabel31.setBounds(0, -4, 1170, 490);

        PanelClinica.addTab("HISTORIA CLÍNICA", jPanelHistoria);

        jPanelPacientes.setLayout(null);

        jPanel19.setBackground(new java.awt.Color(255, 255, 204));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVO PACIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 18))); // NOI18N
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(216, 238, 235));
        jPanel20.setLayout(new java.awt.GridLayout(8, 2));

        jLabel32.setBackground(new java.awt.Color(255, 255, 204));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LUPA.png"))); // NOI18N
        jPanel20.add(jLabel32);

        txtBuscarPaciente.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtBuscarPaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel20.add(txtBuscarPaciente);

        jLabel33.setBackground(new java.awt.Color(255, 255, 204));
        jLabel33.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("NOMBRE");
        jPanel20.add(jLabel33);

        txtNombrePaciente.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtNombrePaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel20.add(txtNombrePaciente);

        jLabel34.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("DNI");
        jPanel20.add(jLabel34);

        txtdni.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtdni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel20.add(txtdni);

        jLabel38.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("TELEFONO");
        jPanel20.add(jLabel38);

        txtTelefonoPaciente.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtTelefonoPaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel20.add(txtTelefonoPaciente);

        jLabel37.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("DIRECCIÓN");
        jPanel20.add(jLabel37);

        txtDireccionPaciente.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtDireccionPaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel20.add(txtDireccionPaciente);

        jLabel36.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("DISTRITO");
        jPanel20.add(jLabel36);

        cbDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE UNA OPCIÓN --", "CARABAYLLO", "COMAS", "INDEPENDENCIA", "LOS OLIVOS", "PUENTE PIEDRA", "SAN MARTIN DE PORRES" }));
        jPanel20.add(cbDistrito);

        jLabel39.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("ID PACIENTE");
        jPanel20.add(jLabel39);

        txtID_Paciente.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtID_Paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID_Paciente.setEnabled(false);
        jPanel20.add(txtID_Paciente);

        jLabel42.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("N° HISTORIA CLINICA");
        jPanel20.add(jLabel42);

        txtIDHISTORIAPACIENTE.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtIDHISTORIAPACIENTE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel20.add(txtIDHISTORIAPACIENTE);

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, 460, 320));

        panel4.setBackground(new java.awt.Color(216, 238, 235));
        panel4.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btnNuevoPaciente.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnNuevoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pacientepe.png"))); // NOI18N
        btnNuevoPaciente.setText("NUEVO");
        btnNuevoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPacienteActionPerformed(evt);
            }
        });
        panel4.add(btnNuevoPaciente);

        btnGuardarPaciente.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnGuardarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GUARDARPE.png"))); // NOI18N
        btnGuardarPaciente.setText("GUARDAR");
        panel4.add(btnGuardarPaciente);

        btnModificarPaciente.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        btnModificarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EDITARPE.png"))); // NOI18N
        btnModificarPaciente.setText("MODIFICAR");
        panel4.add(btnModificarPaciente);

        jPanel19.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 450, 60));

        jPanelPacientes.add(jPanel19);
        jPanel19.setBounds(680, 10, 480, 470);

        tbPaciente.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tbPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDPACIENTE", "NOMBRE", "DNI", "TELEFONO", "DIRECCION", "DISTRITO", "HC", "ESTADO"
            }
        ));
        tbPaciente.setComponentPopupMenu(jPopupMenuPaciente);
        jScrollPane4.setViewportView(tbPaciente);

        jPanelPacientes.add(jScrollPane4);
        jScrollPane4.setBounds(10, 20, 660, 420);

        PanelClinica.addTab("PACIENTES", jPanelPacientes);

        getContentPane().add(PanelClinica);
        PanelClinica.setBounds(0, 120, 1180, 520);

        jMenuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/informe.png"))); // NOI18N
        jMenuReportes.setText("REPORTES");
        jMenuReportes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItemReporteUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuariope.png"))); // NOI18N
        jMenuItemReporteUsuarios.setText("REPORTE DE USUARIOS");
        jMenuItemReporteUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReporteUsuariosActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItemReporteUsuarios);

        jMenuItemReporteMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medicope.png"))); // NOI18N
        jMenuItemReporteMedicos.setText("REPORTE DE MÉDICOS");
        jMenuItemReporteMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReporteMedicosActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItemReporteMedicos);

        jMenuItemReportePacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pacientepe.png"))); // NOI18N
        jMenuItemReportePacientes.setText("REPORTE DE PACIENTES");
        jMenuItemReportePacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReportePacientesActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItemReportePacientes);

        jMenuItemReporteCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/citape.png"))); // NOI18N
        jMenuItemReporteCitas.setText("REPORTE DE CITAS");
        jMenuReportes.add(jMenuItemReporteCitas);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medipemenu.png"))); // NOI18N
        jMenuItem1.setText("REPORTE DE MEDICAMENTOS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItem1);

        jMenuBar1.add(jMenuReportes);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir (2).png"))); // NOI18N
        jMenu5.setText("SALIR");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir (2).png"))); // NOI18N
        jMenuItem2.setText("SALIR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void reporteUsuarios(){
         Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/REPORTE DE USUARIOS.pdf"));
            
             com.itextpdf.text.Image banner = com.itextpdf.text.Image.getInstance("src/Imagenes/Clinica2.0.png");
            banner.scaleToFit(400, 400);
            banner.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("REPORTE DE USUARIOS. \n \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.BLACK));
            documento.open();
            documento.add(banner);
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(6);

            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Usuario");
            tabla.addCell("Perfil");
            tabla.addCell("Correo");
             tabla.addCell("Telefono");
             
                         try {
                Connection cn = con.getConectividad();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from usuarios");
                
                ResultSet rs = pst.executeQuery();
                if(rs.next()){ //SI encuentra los datos continua al siguiente paso
                    do{
                       tabla.addCell(rs.getString(1)); //Parametro en la columna en la que se va a guardar
                       tabla.addCell(rs.getString(2));
                       tabla.addCell(rs.getString(3));
                       tabla.addCell(rs.getString(5));
                       tabla.addCell(rs.getString(6));
                       tabla.addCell(rs.getString(7));
                    }while(rs.next());
                    documento.add(tabla);
                }
                                      
            } catch (SQLException e) {
                System.err.println("Error al generar reporte de usuarios. " + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de usuarios creada correctamente");
            
        } catch (Exception e) {
              System.err.println("Error en PDF o ruta de imagen. " + e);
            JOptionPane.showMessageDialog(null, "¡ERROR al generar PDF!, contacte al administrador. ");

        }
    }
    
    private void reporteMedicos(){
        Document documento1 = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento1, new FileOutputStream(ruta + "/Desktop/REPORTE DE MEDICOS.pdf"));
            
            
            com.itextpdf.text.Image banner = com.itextpdf.text.Image.getInstance("src/Imagenes/Clinica2.0.png");
            banner.scaleToFit(400, 400);
            banner.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("REPORTE DE MEDICOS \n \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.BLACK));
            documento1.open();
            documento1.add(banner);
            documento1.add(parrafo);

            
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("ID");
            tabla.addCell("NOMBRE");
            tabla.addCell("CMP");
            tabla.addCell("TELEFONO");
            tabla.addCell("ESPECIALIDAD");
            
                         try {
                Connection cn = con.getConectividad();
                PreparedStatement pst = cn.prepareStatement(
                        " select m.id_medico, m.nombre_medico, m.cmp, m.telefono_medico,e.nombre_especialidad\n" +
                            "  from medicos m inner join especialidad e\n" +
                            "  on m.id_especialidad = e.id_especialidad");
                
                ResultSet rs = pst.executeQuery();
                if(rs.next()){ //SI encuentra los datos continua al siguiente paso
                    do{
                       tabla.addCell(rs.getString(1)); //Parametro en la columna en la que se va a guardar
                       tabla.addCell(rs.getString(2));
                       tabla.addCell(rs.getString(3));
                       tabla.addCell(rs.getString(4));
                       tabla.addCell(rs.getString(5));

                    }while(rs.next());
                    
                    documento1.add(tabla);
                }
                                      
            } catch (SQLException e) {
                System.err.println("¡Error al generar reporte de médicos! " + e);
            }

            documento1.close();
            JOptionPane.showMessageDialog(null, "¡Reporte de médicos creado correctamente!");
            
        } catch (Exception e) {
              System.err.println("Error en PDF o ruta de imagen. " + e);
            JOptionPane.showMessageDialog(null, "¡ERROR al generar PDF!, contacte al administrador. ");
        }
    }
    
    private void reportePacientes(){
        Document documento2 = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento2, new FileOutputStream(ruta + "/Desktop/REPORTE DE PACIENTES.pdf"));
            
            
            com.itextpdf.text.Image banner = com.itextpdf.text.Image.getInstance("src/Imagenes/Clinica2.0.png");
            banner.scaleToFit(400, 400);
            banner.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("REPORTE DE PACIENTES \n \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK));
            documento2.open();
            documento2.add(banner);
            documento2.add(parrafo);

            
            PdfPTable tabla = new PdfPTable(6);
             tabla.addCell("H. CLINICA");
            tabla.addCell("NOMBRE");
            tabla.addCell("DNI");
            tabla.addCell("TELEFONO");
           tabla.addCell("DIRECCION");
            tabla.addCell("DISTRITO");
            
                         try {
                Connection cn = con.getConectividad();
                PreparedStatement pst = cn.prepareStatement(
                            "select *from paciente");
                
                ResultSet rs = pst.executeQuery();
                if(rs.next()){ //SI encuentra los datos continua al siguiente paso
                    do{
                       tabla.addCell(rs.getString(1)); //Parametro en la columna en la que se va a guardar
                       tabla.addCell(rs.getString(2));
                       tabla.addCell(rs.getString(3));
                       tabla.addCell(rs.getString(4));
                       tabla.addCell(rs.getString(5));
                       tabla.addCell(rs.getString(6));

                    }while(rs.next());
                    
                    documento2.add(tabla);
                }
                                      
            } catch (SQLException e) {
                System.err.println("Error al generar reporte de pacientes. " + e);
            }

            documento2.close();
            JOptionPane.showMessageDialog(null, "¡Reporte de pacientes creado correctamente!");
            
        } catch (Exception e) {
              System.err.println("Error en PDF o ruta de imagen. " + e);
            JOptionPane.showMessageDialog(null, "¡ERROR al generar PDF!, contacte al administrador. ");
        }
    }
    
   private void reporteEspecialidad(){
        Document documento3 = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento3, new FileOutputStream(ruta + "/Desktop/REPORTE DE ESPECIALIDADES.pdf"));
            
            
            com.itextpdf.text.Image banner = com.itextpdf.text.Image.getInstance("src/Imagenes/Clinica2.0.png");
            banner.scaleToFit(400, 400);
            banner.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("REPORTE DE ESPECIALIDADES \n \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK));
            documento3.open();
            documento3.add(banner);
            documento3.add(parrafo);

            
            PdfPTable tabla = new PdfPTable(3);
             tabla.addCell("ID_ESPECIALIDAD");
            tabla.addCell("NOMBRE_ESPECIALIDAD");
            tabla.addCell("DESCRIPCION");

                         try {
                Connection cn = con.getConectividad();
                PreparedStatement pst = cn.prepareStatement(
                            "select *from especialidad");
                
                ResultSet rs = pst.executeQuery();
                if(rs.next()){ //SI encuentra los datos continua al siguiente paso
                    do{
                       tabla.addCell(rs.getString(1)); //Parametro en la columna en la que se va a guardar
                       tabla.addCell(rs.getString(2));
                       tabla.addCell(rs.getString(3));


                    }while(rs.next());
                    
                    documento3.add(tabla);
                }
                                      
            } catch (SQLException e) {
                System.err.println("Error al generar reporte de especialidades. " + e);
            }

            documento3.close();
            JOptionPane.showMessageDialog(null, "¡Reporte de especialidades creado correctamente!");
            
        } catch (Exception e) {
              System.err.println("Error en PDF o ruta de imagen. " + e);
            JOptionPane.showMessageDialog(null, "¡ERROR al generar PDF!, contacte al administrador. ");
        }
    }
   
    
    public void reporteMedicamentos(){
        Document documento4 = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento4, new FileOutputStream(ruta + "/Desktop/REPORTE DE MEDICAMENTOS.pdf"));
            
            
            com.itextpdf.text.Image banner = com.itextpdf.text.Image.getInstance("src/Imagenes/Clinica2.0.png");
            banner.scaleToFit(400, 400);
            banner.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("REPORTE DE MEDICAMENTOS \n \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK));
            documento4.open();
            documento4.add(banner);
            documento4.add(parrafo);

            
            PdfPTable tabla = new PdfPTable(5);
             tabla.addCell("ID MEDICAMENTO");
            tabla.addCell("NOMBRE");
            tabla.addCell("DOSIS");
            tabla.addCell("PRESENTACION");
           tabla.addCell("PRECIO");

            
                         try {
                Connection cn = con.getConectividad();
                PreparedStatement pst = cn.prepareStatement(
                            "select *from medicamento");
                
                ResultSet rs = pst.executeQuery();
                if(rs.next()){ //SI encuentra los datos continua al siguiente paso
                    do{
                       tabla.addCell(rs.getString(1)); //Parametro en la columna en la que se va a guardar
                       tabla.addCell(rs.getString(2));
                       tabla.addCell(rs.getString(3));
                       tabla.addCell(rs.getString(4));
                       tabla.addCell(rs.getString(5));


                    }while(rs.next());
                    
                    documento4.add(tabla);
                }
                                      
            } catch (SQLException e) {
                System.err.println("Error al generar reporte de pacientes. " + e);
            }

            documento4.close();
            JOptionPane.showMessageDialog(null, "¡Reporte de medicamentos creado correctamente!");
            
        } catch (Exception e) {
              System.err.println("Error en PDF o ruta de imagen. " + e);
            JOptionPane.showMessageDialog(null, "¡ERROR al generar PDF!, contacte al administrador. ");
        }
    }
    
    private void jMenuItemReporteUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReporteUsuariosActionPerformed
       reporteUsuarios();
    }//GEN-LAST:event_jMenuItemReporteUsuariosActionPerformed

    private void jMenuItemReporteMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReporteMedicosActionPerformed
        reporteMedicos();
    }//GEN-LAST:event_jMenuItemReporteMedicosActionPerformed

    private void jMenuItemReportePacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReportePacientesActionPerformed
         reportePacientes();        
    }//GEN-LAST:event_jMenuItemReportePacientesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        reporteMedicamentos();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnNuevoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoPacienteActionPerformed

    private void btnNuevaHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaHistoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaHistoriaActionPerformed

    private void btnNuevoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoMedicoActionPerformed

    private void btnNuevoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoUActionPerformed

 
       public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CentrodSalud_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentrodSalud_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentrodSalud_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentrodSalud_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentrodSalud_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane PanelClinica;
    private javax.swing.JPanel PanelMedicos;
    public javax.swing.JButton btnGuardarHistoria;
    public javax.swing.JButton btnGuardarMedico;
    public javax.swing.JButton btnGuardarPaciente;
    public javax.swing.JButton btnGuardarU;
    public javax.swing.JButton btnModificarHis;
    public javax.swing.JButton btnModificarMedico;
    public javax.swing.JButton btnModificarPaciente;
    public javax.swing.JButton btnModificarU;
    public javax.swing.JButton btnNuevaHistoria;
    public javax.swing.JButton btnNuevoMedico;
    public javax.swing.JButton btnNuevoPaciente;
    public javax.swing.JButton btnNuevoU;
    public javax.swing.JComboBox<String> cbDistrito;
    public javax.swing.JComboBox<Object> cbEspecialidad;
    public javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFECHA;
    private javax.swing.JLabel jLabelFECHA1;
    private javax.swing.JLabel jLabelFECHA2;
    private javax.swing.JLabel jLabelHORA;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuItemELIMINAREspecialidad;
    public javax.swing.JMenuItem jMenuItemELIMINARHistoria;
    public javax.swing.JMenuItem jMenuItemELIMINARMedicamento;
    public javax.swing.JMenuItem jMenuItemELIMINARMedicos;
    public javax.swing.JMenuItem jMenuItemELIMINARPaciente;
    public javax.swing.JMenuItem jMenuItemELIMINARUSUARIO;
    public javax.swing.JMenuItem jMenuItemREINGRESAREspecialidad;
    public javax.swing.JMenuItem jMenuItemREINGRESARHistoria;
    public javax.swing.JMenuItem jMenuItemREINGRESARMedicamentos;
    public javax.swing.JMenuItem jMenuItemREINGRESARMedicos;
    public javax.swing.JMenuItem jMenuItemREINGRESARPaciente;
    public javax.swing.JMenuItem jMenuItemREINGRESARUSUARIO;
    private javax.swing.JMenuItem jMenuItemReporteCitas;
    private javax.swing.JMenuItem jMenuItemReporteMedicos;
    private javax.swing.JMenuItem jMenuItemReportePacientes;
    private javax.swing.JMenuItem jMenuItemReporteUsuarios;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelHistoria;
    private javax.swing.JPanel jPanelInicio;
    private javax.swing.JPanel jPanelPacientes;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JPopupMenu jPopupMenuEspecialidad;
    private javax.swing.JPopupMenu jPopupMenuHistoria;
    private javax.swing.JPopupMenu jPopupMenuMedicamento;
    private javax.swing.JPopupMenu jPopupMenuMedicos;
    private javax.swing.JPopupMenu jPopupMenuPaciente;
    private javax.swing.JPopupMenu jPopupMenuUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbNombreUsuario;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    public javax.swing.JTable tbHistoria;
    public javax.swing.JTable tbMedicos;
    public javax.swing.JTable tbPaciente;
    public javax.swing.JTable tbUsuarios;
    public javax.swing.JTextField txtAntecedentePer;
    public javax.swing.JTextField txtAntecedentesF;
    public javax.swing.JTextField txtBuscarHistoria;
    public javax.swing.JTextField txtBuscarMedico;
    public javax.swing.JTextField txtBuscarPaciente;
    public javax.swing.JTextField txtBuscarU;
    public javax.swing.JTextField txtCMP;
    public javax.swing.JPasswordField txtContra;
    public javax.swing.JTextField txtDireccionPaciente;
    public javax.swing.JTextField txtIDHISTORIAPACIENTE;
    public javax.swing.JTextField txtIDMedico;
    public javax.swing.JTextField txtID_Paciente;
    public javax.swing.JTextField txtID_Usuario;
    public javax.swing.JTextField txtIdHistoria;
    public javax.swing.JTextField txtMail;
    public javax.swing.JTextField txtMailMedico;
    public javax.swing.JTextField txtNombreMe;
    public javax.swing.JTextField txtNombrePaciente;
    public javax.swing.JTextField txtNombreU;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtTelefonoMedico;
    public javax.swing.JTextField txtTelefonoPaciente;
    public javax.swing.JTextField txtUser;
    public javax.swing.JTextField txtdni;
    // End of variables declaration//GEN-END:variables


}
