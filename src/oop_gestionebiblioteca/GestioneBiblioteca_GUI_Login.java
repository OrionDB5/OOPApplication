/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Benedetto
 */
public class GestioneBiblioteca_GUI_Login extends javax.swing.JFrame {

    /**
     * Creates new form GestioneBiblioteca_GUI_Login
     */
    public GestioneBiblioteca_GUI_Login() {
        
            initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabelCloseButton = new javax.swing.JLabel();
        jLogoBiblioteca = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jPanelLoginBox = new javax.swing.JPanel();
        jLabelLogin = new javax.swing.JLabel();
        jIconLogin = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JToggleButton();
        jPanelRegistrati = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelLogin1 = new javax.swing.JLabel();
        jPanelErrorLogin = new javax.swing.JPanel();

        jLabelErrorLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(23, 105, 64));
        setForeground(new java.awt.Color(23, 105, 64));
        setLocation(new java.awt.Point(50, 50));
        setMaximumSize(new java.awt.Dimension(1400, 768));
        setMinimumSize(new java.awt.Dimension(1200, 768));
        setUndecorated(true);
        setResizable(false);

        jPanelHeader.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHeader.setMaximumSize(new java.awt.Dimension(1400, 120));
        jPanelHeader.setMinimumSize(new java.awt.Dimension(1400, 120));
        jPanelHeader.setName(""); // NOI18N
        jPanelHeader.setPreferredSize(new java.awt.Dimension(1400, 120));

        jLabelCloseButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Benedetto\\Documents\\NetBeansProjects\\OOP_GestioneBiblioteca\\src\\close.png")); // NOI18N
        jLabelCloseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCloseButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCloseButtonMouseExited(evt);
            }
        });

        jLogoBiblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_biblioteca.png"))); // NOI18N

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLogoBiblioteca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 546, Short.MAX_VALUE)
                .addComponent(jLabelCloseButton)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCloseButton))
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLogoBiblioteca)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanelBody.setBackground(new java.awt.Color(92, 184, 147));
        jPanelBody.setMaximumSize(new java.awt.Dimension(1400, 480));
        jPanelBody.setMinimumSize(new java.awt.Dimension(1400, 480));
        jPanelBody.setPreferredSize(new java.awt.Dimension(1400, 480));
        jPanelBody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelBodyMouseClicked(evt);
            }
        });

        jPanelLoginBox.setBackground(new java.awt.Color(255, 255, 255));

        jLabelLogin.setFont(new java.awt.Font("Lucida Fax", 0, 30)); // NOI18N
        jLabelLogin.setText("Login");

        jIconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login_icon.png"))); // NOI18N

        jTextEmail.setBackground(new java.awt.Color(224, 240, 221));
        jTextEmail.setBorder(javax.swing.BorderFactory.createLineBorder(jButtonLogin.getBackground()));
        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        jLabelEmail.setFont(new java.awt.Font("Lucida Fax", 0, 10)); // NOI18N
        jLabelEmail.setText("Indirizzo e-mail : ");

        jLabelPassword.setFont(new java.awt.Font("Lucida Fax", 0, 10)); // NOI18N
        jLabelPassword.setText("Password : ");

        jPasswordField1.setBackground(new java.awt.Color(224, 240, 221));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(jButtonLogin.getBackground()));

        jButtonLogin.setBackground(new java.awt.Color(179, 104, 23));
        jButtonLogin.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 33, 33), 2));
        jButtonLogin.setBorderPainted(false);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginBoxLayout = new javax.swing.GroupLayout(jPanelLoginBox);
        jPanelLoginBox.setLayout(jPanelLoginBoxLayout);
        jPanelLoginBoxLayout.setHorizontalGroup(
            jPanelLoginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginBoxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogin)
                .addGap(100, 100, 100))
            .addGroup(jPanelLoginBoxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLoginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPassword)
                    .addGroup(jPanelLoginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelEmail)
                        .addComponent(jTextEmail)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelLoginBoxLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jIconLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelLoginBoxLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanelLoginBoxLayout.setVerticalGroup(
            jPanelLoginBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginBoxLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jIconLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLogin)
                .addGap(16, 16, 16)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonLogin)
                .addGap(23, 23, 23))
        );

        jPanelRegistrati.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRegistrati.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelRegistrati.setPreferredSize(new java.awt.Dimension(323, 383));
        jPanelRegistrati.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelRegistratiMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RegistratiButton.png"))); // NOI18N

        jLabelLogin1.setFont(new java.awt.Font("Lucida Fax", 0, 30)); // NOI18N
        jLabelLogin1.setText("Registrati");

        javax.swing.GroupLayout jPanelRegistratiLayout = new javax.swing.GroupLayout(jPanelRegistrati);
        jPanelRegistrati.setLayout(jPanelRegistratiLayout);
        jPanelRegistratiLayout.setHorizontalGroup(
            jPanelRegistratiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistratiLayout.createSequentialGroup()
                .addGroup(jPanelRegistratiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistratiLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabelLogin1))
                    .addGroup(jPanelRegistratiLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanelRegistratiLayout.setVerticalGroup(
            jPanelRegistratiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistratiLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelLogin1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelErrorLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelErrorLogin.setFocusable(false);

        jLabelErrorLogin.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanelErrorLoginLayout = new javax.swing.GroupLayout(jPanelErrorLogin);
        jPanelErrorLogin.setLayout(jPanelErrorLoginLayout);
        jPanelErrorLoginLayout.setHorizontalGroup(
            jPanelErrorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelErrorLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelErrorLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelErrorLoginLayout.setVerticalGroup(
            jPanelErrorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelErrorLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelErrorLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelErrorLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelLoginBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101)
                .addComponent(jPanelRegistrati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addGroup(jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBodyLayout.createSequentialGroup()
                        .addComponent(jPanelLoginBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelErrorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBodyLayout.createSequentialGroup()
                        .addComponent(jPanelRegistrati, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(278, 278, 278))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelBody, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseButtonMouseClicked

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEmailActionPerformed

    private void jLabelCloseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseButtonMouseEntered
        jLabelCloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close_hover.png")));

    }//GEN-LAST:event_jLabelCloseButtonMouseEntered

    private void jLabelCloseButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseButtonMouseExited
        jLabelCloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png")));
     

    }//GEN-LAST:event_jLabelCloseButtonMouseExited

    
    private void jPanelBodyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBodyMouseClicked
      
    }//GEN-LAST:event_jPanelBodyMouseClicked

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        jLabelErrorLogin.setText("Errore");
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jPanelRegistratiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRegistratiMouseClicked

        System.out.println("Panel registrati cliccato");
        GestioneBiblioteca_GUI_Register p_registrati = new GestioneBiblioteca_GUI_Register();
        p_registrati.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jPanelRegistratiMouseClicked

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
            java.util.logging.Logger.getLogger(GestioneBiblioteca_GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestioneBiblioteca_GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestioneBiblioteca_GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestioneBiblioteca_GUI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestioneBiblioteca_GUI_Login().setVisible(true);
            }

            private void jButtonLoginActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jButtonLogin;
    private javax.swing.JLabel jIconLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCloseButton;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelErrorLogin;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelLogin1;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLogoBiblioteca;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelErrorLogin;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelLoginBox;
    private javax.swing.JPanel jPanelRegistrati;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextEmail;
    // End of variables declaration//GEN-END:variables
    private MyCanvas m = new MyCanvas();
    
    

}
