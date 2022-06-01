
package Vista;

import Controlador.Login_Controlador;
import Modelo.Conectividad;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.sql.*;
import javax.swing.JOptionPane;


public class CentrodSalud_Login extends javax.swing.JFrame {
    
     
    
    public static String usuario = "";//variable para enviar datos entre interfaces
    String contraseña = "";
    Usuario us=new Usuario();
    UsuarioDAO usDAO=new UsuarioDAO();
   
    public CentrodSalud_Login() {
        initComponents();
        setSize(600,900);//reafirmando las dimensionesNel
        setResizable(false);//no se podra modificar las dimensiones
        setTitle("Acceso al Sistema");
        setLocationRelativeTo(null);
        Login_Controlador  usControlador=new Login_Controlador(us,usDAO,this);
               
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/clinicalogo.png"));
        return retValue;
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusuario = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JPasswordField();
        btacceder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtlogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusuario.setBackground(new java.awt.Color(183, 22, 37));
        txtusuario.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(255, 255, 255));
        txtusuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtusuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 250, 40));

        txtcontraseña.setBackground(new java.awt.Color(183, 22, 37));
        txtcontraseña.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcontraseña.setForeground(new java.awt.Color(255, 255, 255));
        txtcontraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcontraseña.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 250, 40));

        btacceder.setBackground(new java.awt.Color(183, 22, 37));
        btacceder.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        btacceder.setForeground(new java.awt.Color(255, 255, 255));
        btacceder.setText("ACCEDER");
        btacceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaccederActionPerformed(evt);
            }
        });
        getContentPane().add(btacceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, 180, 50));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("\"Centro de Salud Comas\"");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 470, 70));

        txtlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/diris.png"))); // NOI18N
        getContentPane().add(txtlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 470, 190));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTRASEÑA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 250, 30));

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("USERNAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 250, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clinicalogo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 270, 190));

        btnCancelar.setBackground(new java.awt.Color(183, 22, 37));
        btnCancelar.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 640, 180, 50));

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void btaccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaccederActionPerformed
        usuario = txtusuario.getText().trim(); // trim para evitar que haya espacios a los extremos de la cadena de caracteres.
        contraseña = txtcontraseña.getText().trim();
    }//GEN-LAST:event_btaccederActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CentrodSalud_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentrodSalud_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentrodSalud_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentrodSalud_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentrodSalud_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btacceder;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JLabel txtlogo;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
