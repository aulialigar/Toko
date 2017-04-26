/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pack.control.login_koneksi;

/**
 *
 * @author Smktelkom
 */
public class login extends javax.swing.JFrame {

    public static String user;

    /**
     * Creates new form login
     */
    public login() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        signup = new javax.swing.JButton();
        signin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(190, 0, 130, 0);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack/view/admin.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, -10, 132, 260);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel3.add(exit);
        exit.setBounds(120, 190, 60, 30);

        jLabel2.setText("P A S S W O R D :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(70, 80, 100, 20);

        jLabel1.setText("U S E R N A M E :");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(70, 10, 100, 30);
        jPanel3.add(nama);
        nama.setBounds(70, 40, 80, 30);
        jPanel3.add(pass);
        pass.setBounds(70, 100, 80, 30);

        signup.setText("Sign Up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel3.add(signup);
        signup.setBounds(20, 190, 80, 30);

        signin.setText("Sign In");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        jPanel3.add(signin);
        signin.setBounds(70, 150, 80, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 320, 240);

        setSize(new java.awt.Dimension(332, 276));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        // TODO add your handling code here:
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/toko?zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, nama.getText());
            ps.setString(2, pass.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new home().show();
                user = nama.getText();//perlu deklarasi user diclass utama.
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane,"Salah!");
                pass.setText("");
                nama.requestFocus();
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"Gagal!");
        }
    }//GEN-LAST:event_signinActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        // TODO add your handling code here:
        String username = nama.getText();
        String password = pass.getText();

        try {
            try (Statement statement = (Statement) login_koneksi.GetConnection().createStatement()) {
                statement.executeUpdate("INSERT INTO tb_akun(username, password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Selamat! Anda berhasil Sign Up");
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi lagi prosedur");
        }
    }//GEN-LAST:event_signupActionPerformed

     public JTextField getUser(){ 
        return nama;
    }                               

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nama;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton signin;
    private javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables
}
