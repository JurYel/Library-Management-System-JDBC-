/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.gui.history;

/**
 *
 * @author Jur Yel
 */
import com.dbms.jdbc.mysql.core.AccountsHistory;
import com.dbms.jdbc.mysql.dao.AccountsHistoryDAO;
import com.dbms.jdbc.mysql.gui.AccountsUI;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class AccountsHistoryGUI extends javax.swing.JFrame {

    /**
     * Creates new form AccountsHistoryGUI
     */
    private AccountsHistory accHistory;
    private AccountsHistoryDAO accHistoryDAO;
    private AccountsUI accUI;
    private int userLevel;
    private String UserID;
    private String UserName;
    
    public AccountsHistoryGUI(int level,AccountsUI ui,String name,String id){
        try{
            accHistoryDAO = new AccountsHistoryDAO();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(AccountsHistoryGUI.this,"DAO Failed: " + exc.getMessage(),"DAO Error",JOptionPane.ERROR_MESSAGE);;
        }
        initComponents();
        setLocationRelativeTo(null);
        UserName = name;
        userLevel = level;
        accUI = ui;
        UserID = id;
        if(userLevel == 0){
            jlbl_Label.setText("Admin: ");
        }
        else if(userLevel == 2){
            jlbl_Label.setText("User: ");
        }
        jlbl_Online.setText(name);
        populateTable(userLevel);
    }
    
    public AccountsHistoryGUI() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlbl_Label = new javax.swing.JLabel();
        jlbl_Online = new javax.swing.JLabel();
        jtxt_Search = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_AccountsHistory = new javax.swing.JTable();
        jbtn_Return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LBMS: Accounts History");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlbl_Label.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jlbl_Label.setText("Admin:");
        jlbl_Label.setToolTipText("");

        jlbl_Online.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jlbl_Online.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_Online)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_Online))
                .addContainerGap())
        );

        jtxt_Search.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_Search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_Search.setText("Search Account");
        jtxt_Search.setToolTipText("");
        jtxt_Search.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtxt_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtxt_SearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtxt_SearchMouseExited(evt);
            }
        });
        jtxt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxt_SearchKeyTyped(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtbl_AccountsHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbl_AccountsHistory);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );

        jbtn_Return.setBackground(new java.awt.Color(0, 0, 0));
        jbtn_Return.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Return.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_Return.setText("Okay");
        jbtn_Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtn_Return)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_Return)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jtxt_SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseEntered
        if(jtxt_Search.getText().contains("Search Account")){
            jtxt_Search.setText("");
        }
    }//GEN-LAST:event_jtxt_SearchMouseEntered

    private void jtxt_SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseExited
        if(jtxt_Search.getText().isEmpty()){
            jtxt_Search.setText("Search Account");
        }
    }//GEN-LAST:event_jtxt_SearchMouseExited

    private void jbtn_ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ReturnActionPerformed
        setVisible(false);
        accUI.setVisible(true);
    }//GEN-LAST:event_jbtn_ReturnActionPerformed

    private void jtxt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_SearchKeyTyped
        String search = jtxt_Search.getText().trim();
        try{
            if(search.isEmpty()){
                ArrayList<AccountsHistory> list = accHistoryDAO.getAllAccountsHistory();
                AccountsHistoryTableModel model = new AccountsHistoryTableModel(list);
                jtbl_AccountsHistory.setModel(model);
            }
            else{
                ArrayList<AccountsHistory> list = accHistoryDAO.searchAccountHistory(search);
                AccountsHistoryTableModel model = new AccountsHistoryTableModel(list);
                jtbl_AccountsHistory.setModel(model);
            }
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }//GEN-LAST:event_jtxt_SearchKeyTyped

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
            java.util.logging.Logger.getLogger(AccountsHistoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountsHistoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountsHistoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountsHistoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountsHistoryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_Return;
    private javax.swing.JLabel jlbl_Label;
    private javax.swing.JLabel jlbl_Online;
    private javax.swing.JTable jtbl_AccountsHistory;
    private javax.swing.JTextField jtxt_Search;
    // End of variables declaration//GEN-END:variables

    private void populateTable(int level){
        try{
            if(level == 0){
                ArrayList<AccountsHistory> list = accHistoryDAO.getAllAccountsHistory();
                AccountsHistoryTableModel model = new AccountsHistoryTableModel(list);
                jtbl_AccountsHistory.setModel(model);
            }
            else if(level == 2){
                ArrayList<AccountsHistory> list = accHistoryDAO.getUserHistory(UserID);
                AccountsHistoryTableModel model = new AccountsHistoryTableModel(list);
                jtbl_AccountsHistory.setModel(model);
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(AccountsHistoryGUI.this,"Load Failed: "+exc.getMessage(),"Load Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
