package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.CentrodSalud_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.CentrodSalud_Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class Login_Controlador  implements ActionListener{
    private Usuario us;
    private UsuarioDAO usDAO;
    private CentrodSalud_Login  loginV;

    public Login_Controlador(Usuario us, UsuarioDAO usDAO, CentrodSalud_Login loginV) {
        this.us = us;
        this.usDAO = usDAO;
        this.loginV = loginV;
        this.loginV.btacceder.addActionListener(this);
        this.loginV.btnCancelar.addActionListener(this);        
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == loginV.btacceder) {
            if (loginV.txtusuario.getText().equals("")
                    || String.valueOf(loginV.txtcontraseña.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "Los campos están vacios, completar...");
            } else {
                String usuario = loginV.txtusuario.getText();
                String contraseña = String.valueOf(loginV.txtcontraseña.getPassword());
                us = usDAO.login(usuario, contraseña);
                if (us.getUsername()!= null) {
                    CentrodSalud_Principal admin = new CentrodSalud_Principal();
                    admin.setVisible(true);
                    this.loginV.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "¡Usuario o Contraseña incorrecta, verificar!");
                }
            }
        } else {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir ?", "Pregunta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                System.exit(0);
            }
        }

    }
       
    
}
