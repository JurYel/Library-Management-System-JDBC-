/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.gui;

/**
 *
 * @author Jur Yel
 */
import com.dbms.jdbc.mysql.dao.AccountsDAO;
import com.dbms.jdbc.mysql.dao.IssuedBooksDAO;
import com.dbms.jdbc.mysql.gui.student.Student_ProfileUI;
import com.dbms.jdbc.mysql.gui.asst.Asst_BooksUI;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class Main_LoginUI extends javax.swing.JFrame {

    /**
     * Creates new form Main_LoginUI
     */
    private AccountsDAO accDAO;
    private String fullname;
    private IssuedBooksDAO issuedDAO;
    
    public Main_LoginUI() {
        try{
            accDAO = new AccountsDAO();
            issuedDAO = new IssuedBooksDAO();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Main_LoginUI.this,"DAO Error: " + exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtxt_UserID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpf_Password = new javax.swing.JPasswordField();
        jCheckBox_ShowPassword = new javax.swing.JCheckBox();
        jbtn_Login = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LBMS: Login");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtxt_UserID.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jtxt_UserID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_UserID.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtxt_UserID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxt_UserIDKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jLabel1.setText("User ID:");

        jLabel2.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jLabel2.setText("Password:");

        jpf_Password.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jpf_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jpf_Password.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpf_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpf_PasswordKeyPressed(evt);
            }
        });

        jCheckBox_ShowPassword.setFont(new java.awt.Font("Josefin Sans", 0, 13)); // NOI18N
        jCheckBox_ShowPassword.setText("Show Password");
        jCheckBox_ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_ShowPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_UserID, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jpf_Password)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jCheckBox_ShowPassword)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_UserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpf_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_ShowPassword)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jbtn_Login.setBackground(new java.awt.Color(0, 0, 0));
        jbtn_Login.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jbtn_Login.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_Login.setText("Login");
        jbtn_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_LoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Coolvetica Rg", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("Library");

        jLabel4.setFont(new java.awt.Font("Coolvetica Rg", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("Management System");

        jLabel5.setFont(new java.awt.Font("Josefin Sans", 2, 13)); // NOI18N
        jLabel5.setText("Don't have an account?");

        jLabel6.setFont(new java.awt.Font("Josefin Sans", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Register");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jbtn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel3)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_LoginActionPerformed
        String userID = jtxt_UserID.getText().trim();
        String pass = jpf_Password.getText().trim();
        
        try{
            if(userID.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(Main_LoginUI.this,"Fill in all fields","Login Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(accDAO.checkIfExist(userID)){
                    if(accDAO.checkUserCredentials(userID, pass)){
                        if(accDAO.checkIfBlocked(userID)){
                            JOptionPane.showMessageDialog(Main_LoginUI.this, "Your account has been blocked!","Login Failed",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            if(accDAO.checkIfAdmin(userID)){
                                /* Show Account Table */
                                fullname = accDAO.getFullName(userID);
                                String position = accDAO.getUserPosition(userID);
                                accDAO.recordLogin(userID, position);
                                AccountsUI accUI = new AccountsUI(0,userID,fullname);

                                accUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();



                            }
                            else if(accDAO.checkIfStudAsst(userID)){
                                /* show user account with issued books */

                                fullname = accDAO.getFullName(userID);
                                String position = accDAO.getUserPosition(userID);
                                accDAO.recordLogin(userID, position);
                                Asst_BooksUI asstUI = new Asst_BooksUI(1,userID,fullname);
 
                                asstUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();

                            }
                            else{
                                fullname = accDAO.getFullName(userID);
                                Student_ProfileUI studUI = new Student_ProfileUI(2,userID,fullname);

                                studUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();

                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(Main_LoginUI.this,"Password incorrect","Login Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(Main_LoginUI.this, "User ID does not exist","Login Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
            
        catch(Exception exc){
            JOptionPane.showMessageDialog(Main_LoginUI.this,"Login Failed: "+exc.getMessage(),"Login Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtn_LoginActionPerformed

    private void jCheckBox_ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_ShowPasswordActionPerformed
        if(jCheckBox_ShowPassword.isSelected()){
            jpf_Password.setEchoChar((char)0);
        }
        else{
            jpf_Password.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox_ShowPasswordActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Main_RegisterUI register = new Main_RegisterUI();
        this.setVisible(false);
        register.setVisible(true);
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jpf_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpf_PasswordKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String userID = jtxt_UserID.getText().trim();
        String pass = jpf_Password.getText().trim();
        
        try{
            if(userID.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(Main_LoginUI.this,"Fill in all fields","Login Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(accDAO.checkIfExist(userID)){
                    if(accDAO.checkUserCredentials(userID, pass)){
                        if(accDAO.checkIfBlocked(userID)){
                            JOptionPane.showMessageDialog(Main_LoginUI.this, "Your account has been blocked!","Login Failed",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            if(accDAO.checkIfAdmin(userID)){
                                /* Show Account Table */
                                fullname = accDAO.getFullName(userID);
                                String position = accDAO.getUserPosition(userID);
                                accDAO.recordLogin(userID, position);
                                AccountsUI accUI = new AccountsUI(0,userID,fullname);

                                accUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();



                            }
                            else if(accDAO.checkIfStudAsst(userID)){
                                /* show user account with issued books */

                                fullname = accDAO.getFullName(userID);
                                String position = accDAO.getUserPosition(userID);
                                accDAO.recordLogin(userID, position);
                                Asst_BooksUI asstUI = new Asst_BooksUI(1,userID,fullname);
 
                                asstUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();

                            }
                            else{
                                fullname = accDAO.getFullName(userID);
                                Student_ProfileUI studUI = new Student_ProfileUI(2,userID,fullname);

                                studUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();

                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(Main_LoginUI.this,"Password incorrect","Login Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(Main_LoginUI.this, "User ID does not exist","Login Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
            
        catch(Exception exc){
            JOptionPane.showMessageDialog(Main_LoginUI.this,"Login Failed: "+exc.getMessage(),"Login Error",JOptionPane.ERROR_MESSAGE);
            
        }
        }
    }//GEN-LAST:event_jpf_PasswordKeyPressed

    private void jtxt_UserIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_UserIDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String userID = jtxt_UserID.getText().trim();
            String pass = jpf_Password.getText().trim();
        
        try{
            if(userID.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(Main_LoginUI.this,"Fill in all fields","Login Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(accDAO.checkIfExist(userID)){
                    if(accDAO.checkUserCredentials(userID, pass)){
                        if(accDAO.checkIfBlocked(userID)){
                            JOptionPane.showMessageDialog(Main_LoginUI.this, "Your account has been blocked!","Login Failed",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            if(accDAO.checkIfAdmin(userID)){
                                /* Show Account Table */
                                fullname = accDAO.getFullName(userID);
                                String position = accDAO.getUserPosition(userID);
                                accDAO.recordLogin(userID, position);
                                AccountsUI accUI = new AccountsUI(0,userID,fullname);

                                accUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();



                            }
                            else if(accDAO.checkIfStudAsst(userID)){
                                /* show user account with issued books */

                                fullname = accDAO.getFullName(userID);
                                String position = accDAO.getUserPosition(userID);
                                accDAO.recordLogin(userID, position);
                                Asst_BooksUI asstUI = new Asst_BooksUI(1,userID,fullname);
 
                                asstUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();

                            }
                            else{
                                fullname = accDAO.getFullName(userID);
                                Student_ProfileUI studUI = new Student_ProfileUI(2,userID,fullname);

                                studUI.setVisible(true);
                                this.setVisible(false);
                                this.dispose();

                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(Main_LoginUI.this,"Password incorrect","Login Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(Main_LoginUI.this, "User ID does not exist","Login Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
            
        catch(Exception exc){
            JOptionPane.showMessageDialog(Main_LoginUI.this,"Login Failed: "+exc.getMessage(),"Login Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_jtxt_UserIDKeyPressed

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
            java.util.logging.Logger.getLogger(Main_LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox_ShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtn_Login;
    private javax.swing.JPasswordField jpf_Password;
    private javax.swing.JTextField jtxt_UserID;
    // End of variables declaration//GEN-END:variables
}