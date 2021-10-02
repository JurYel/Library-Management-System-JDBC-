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

import com.dbms.jdbc.mysql.core.Accounts;
import com.dbms.jdbc.mysql.dao.AccountsDAO;
import com.dbms.jdbc.mysql.gui.history.LoginHistoryUI;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.dbms.jdbc.mysql.gui.history.AccountsHistoryGUI;
import com.dbms.jdbc.mysql.gui.history.TransactionsUI;

public class AccountsUI extends javax.swing.JFrame {

    /**
     * Creates new form AccountsUI
    private Accounts account;
     */
    private AccountsDAO accDAO;
    private String User_ID;
    private String UserName;
    private int userLevel;
    
    public AccountsUI(int level, String userID, String fullname) {
        try{
            accDAO = new AccountsDAO();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(AccountsUI.this,"DAO Error: "+exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setLocationRelativeTo(null);
        populateTable();
        User_ID = userID;
        UserName = fullname;
        userLevel = level;
        switch(level){
            case 0:
                jlbl_Label.setText("Admin: ");
                jlbl_Online.setText(fullname);
                break;
            case 1: 
                jlbl_Label.setText("Asst: ");
                jlbl_Online.setText(fullname);
                break;
            case 2:
                jlbl_Label.setText("Online: ");
                jlbl_Online.setText(fullname);
                break;
        }
    }
    
    public AccountsUI(){
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
        jlbl_Label = new javax.swing.JLabel();
        jlbl_Online = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Accounts = new javax.swing.JTable();
        jtxt_Search = new javax.swing.JTextField();
        jbtn_Assign = new javax.swing.JButton();
        jbtn_Delete = new javax.swing.JButton();
        jbtn_Block = new javax.swing.JButton();
        jbtn_ChangePassword = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LBMS: Accounts");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlbl_Label.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jlbl_Label.setText("Online:");

        jlbl_Online.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jlbl_Online.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbl_Online)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Label)
                    .addComponent(jlbl_Online))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtbl_Accounts.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbl_Accounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_AccountsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_Accounts);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtxt_Search.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jtxt_Search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_Search.setText("Search Name...");
        jtxt_Search.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtxt_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtxt_SearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtxt_SearchMouseExited(evt);
            }
        });
        jtxt_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_SearchActionPerformed(evt);
            }
        });
        jtxt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxt_SearchKeyTyped(evt);
            }
        });

        jbtn_Assign.setBackground(new java.awt.Color(0, 0, 0));
        jbtn_Assign.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Assign.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_Assign.setText("Assign Student");
        jbtn_Assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_AssignActionPerformed(evt);
            }
        });

        jbtn_Delete.setBackground(new java.awt.Color(0, 0, 0));
        jbtn_Delete.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Delete.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_Delete.setText("Delete Account");
        jbtn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_DeleteActionPerformed(evt);
            }
        });

        jbtn_Block.setBackground(new java.awt.Color(0, 0, 0));
        jbtn_Block.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Block.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_Block.setText("Block Account");
        jbtn_Block.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_BlockActionPerformed(evt);
            }
        });

        jbtn_ChangePassword.setBackground(new java.awt.Color(0, 0, 0));
        jbtn_ChangePassword.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_ChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_ChangePassword.setText("Reset Password");
        jbtn_ChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 111, Short.MAX_VALUE)
                .addComponent(jbtn_Assign)
                .addGap(32, 32, 32)
                .addComponent(jbtn_Delete)
                .addGap(32, 32, 32)
                .addComponent(jbtn_Block)
                .addGap(38, 38, 38)
                .addComponent(jbtn_ChangePassword)
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtxt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jtxt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_Delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtn_Assign, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtn_ChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtn_Block, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jMenu1.setText("File");

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        jMenuItem3.setText("Book Records");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Issued Books");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("History");

        jMenuItem6.setText("Transactions");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);
        jMenu3.add(jSeparator2);

        jMenuItem5.setText("Accounts History");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem7.setText("Login History");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxt_SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseEntered
        if(jtxt_Search.getText().contains("Search Name...")){
            jtxt_Search.setText("");
        }
    }//GEN-LAST:event_jtxt_SearchMouseEntered

    private void jtxt_SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseExited
        if(jtxt_Search.getText().isEmpty()){
            jtxt_Search.setText("Search Name...");
        }
    }//GEN-LAST:event_jtxt_SearchMouseExited

    private void jtxt_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_SearchActionPerformed

    private void jbtn_AssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_AssignActionPerformed
        int row = jtbl_Accounts.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(AccountsUI.this,"Select a row","Assign Error",JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            String userID = jtbl_Accounts.getValueAt(row, 0).toString();
            String first = jtbl_Accounts.getValueAt(row, 1).toString();
            String last = jtbl_Accounts.getValueAt(row,2).toString();
            String pass = jtbl_Accounts.getValueAt(row,3).toString();
            String position = jtbl_Accounts.getValueAt(row,4).toString();
            String status = jtbl_Accounts.getValueAt(row,5).toString();
            boolean stat = (status.equals("Active"))? false : true;
            if(userID.equals(User_ID)){
                JOptionPane.showMessageDialog(AccountsUI.this,"Cannot Perform Operation on Oneself","Assign Error",JOptionPane.ERROR_MESSAGE);
            }else{
                if(position.equals("Student")){
                    if(status.equals("Blocked")){
                        JOptionPane.showMessageDialog(AccountsUI.this,"Account has been blocked!","Assign Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        try{
                            Accounts acc = new Accounts(userID,first,last,pass,position,stat);

                            AccountsUI_Update assign = new AccountsUI_Update("assign",User_ID,acc,accDAO,AccountsUI.this);
                            assign.setVisible(true);

                        }
                        catch(Exception exc){
                            JOptionPane.showMessageDialog(AccountsUI.this,"Assignment Failed: "+exc.getMessage(),"Assign Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(AccountsUI.this,"Only students can be assigned","Assign Error",JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
        }
    }//GEN-LAST:event_jbtn_AssignActionPerformed

    private void jtxt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_SearchKeyTyped
        String search = jtxt_Search.getText().trim();
        
        try{
            if(search.isEmpty()){
                ArrayList<Accounts> list = accDAO.getAllAccounts();
                AccountsTableModel model = new AccountsTableModel(list);
                jtbl_Accounts.setModel(model);
            }
            else{
                ArrayList<Accounts> list = accDAO.searchAccount(search);
                AccountsTableModel model = new AccountsTableModel(list);
                jtbl_Accounts.setModel(model);
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(AccountsUI.this,"Search Failed: "+exc.getMessage(),"Search Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtxt_SearchKeyTyped

    private void jbtn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_DeleteActionPerformed
        int row = jtbl_Accounts.getSelectedRow();
        if(row < 0 ){
            JOptionPane.showMessageDialog(AccountsUI.this,"Select a row","Delete Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String userID = jtbl_Accounts.getValueAt(row,0).toString();
            String first = jtbl_Accounts.getValueAt(row,1).toString();
            String last = jtbl_Accounts.getValueAt(row,2).toString();
            String pass = jtbl_Accounts.getValueAt(row,3).toString();
            String position = jtbl_Accounts.getValueAt(row,4).toString();
            String status = jtbl_Accounts.getValueAt(row,5).toString();
            boolean stat = (status.equals("Active"))? false : true;
            if(userID.equals(User_ID)){
                JOptionPane.showMessageDialog(AccountsUI.this,"Cannot delete own account","Delete Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    Accounts account = new Accounts(userID,first,last,pass,position,stat);
                
                    AccountsUI_Update delete = new AccountsUI_Update("delete",User_ID,account,accDAO,AccountsUI.this);
                    delete.setVisible(true);
                }
                catch(Exception exc){
                    JOptionPane.showMessageDialog(AccountsUI.this,"Delete Failed: " + exc.getMessage(),"Delete Error",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }//GEN-LAST:event_jbtn_DeleteActionPerformed

    private void jbtn_BlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_BlockActionPerformed
        int row = jtbl_Accounts.getSelectedRow();
        if(row < 0 ){
            JOptionPane.showMessageDialog(AccountsUI.this,"Select a row","Block Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String userID = jtbl_Accounts.getValueAt(row,0).toString();
            String first = jtbl_Accounts.getValueAt(row,1).toString();
            String last = jtbl_Accounts.getValueAt(row,2).toString();
            String pass = jtbl_Accounts.getValueAt(row,3).toString();
            String position = jtbl_Accounts.getValueAt(row,4).toString();
            String status = jtbl_Accounts.getValueAt(row,5).toString();
            boolean stat = (status.equals("Active"))? false : true;
            
            if(userID.equals(User_ID)){
                JOptionPane.showMessageDialog(AccountsUI.this,"Cannot block own account","Block Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(status.equals("Blocked")){
                    
                        try{
                            Accounts account = new Accounts(userID,first,last,pass,position,stat);
                            
                            AccountsUI_Update unblock = new AccountsUI_Update("unblock",User_ID,account,accDAO,AccountsUI.this);
                            unblock.setVisible(true);
                        }
                        catch(Exception exc){
                            JOptionPane.showMessageDialog(AccountsUI.this,"Block Failed: "+ exc.getMessage(),"Block Error",JOptionPane.ERROR_MESSAGE);
                        }
                    
                }
                else{
                    try{
                        Accounts account = new Accounts(userID,first,last,pass,position,stat);

                        AccountsUI_Update block = new AccountsUI_Update("block",User_ID,account,accDAO,AccountsUI.this);
                        block.setVisible(true);
                    }
                    catch(Exception exc){
                        JOptionPane.showMessageDialog(AccountsUI.this,"Block Failed: "+ exc.getMessage(),"Block Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            }
        }
    }//GEN-LAST:event_jbtn_BlockActionPerformed

    private void jbtn_ChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ChangePasswordActionPerformed
       int row = jtbl_Accounts.getSelectedRow();
       if(row < 0 ){
           JOptionPane.showMessageDialog(AccountsUI.this, "Select a row","Reset Error",JOptionPane.ERROR_MESSAGE);
       }
       else{
           String userID = jtbl_Accounts.getValueAt(row,0).toString();
           String last = jtbl_Accounts.getValueAt(row,2).toString();
           String status = jtbl_Accounts.getValueAt(row, 5).toString();
           
           if(status.equals("Blocked")){
               JOptionPane.showMessageDialog(AccountsUI.this,"Unable to reset password \nof blocked account","Reset Error",JOptionPane.ERROR_MESSAGE);
           }
           else{
               try{
                   
                   if((JOptionPane.showConfirmDialog(AccountsUI.this,
                           "Reset Password for "+userID+"?","Confirm Reset",
                           JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE)) == JOptionPane.OK_OPTION){
                       accDAO.ChangePassword(userID,User_ID, last.toLowerCase());
                    refreshAccountsTable();
                    JOptionPane.showMessageDialog(AccountsUI.this,"Password has been reset","Reset Success",JOptionPane.INFORMATION_MESSAGE);
                   }
                   
               }
               catch(Exception exc){
                   JOptionPane.showMessageDialog(AccountsUI.this,"Reset Failed: "+exc.getMessage(),"Reset Error",JOptionPane.ERROR_MESSAGE);
                }
               
           }
          
       }
    }//GEN-LAST:event_jbtn_ChangePasswordActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Main_LoginUI login = new Main_LoginUI();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        BooksUI bookUI = new BooksUI(userLevel,User_ID,UserName);
        setVisible(false);
        bookUI.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        IssuedBooksUI issuedUI = new IssuedBooksUI(userLevel,User_ID, UserName);
        
        setVisible(false);
        issuedUI.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jtbl_AccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_AccountsMouseClicked
        if((evt.getClickCount() == 2) && (evt.getButton() == MouseEvent.BUTTON1)){
            int row = jtbl_Accounts.getSelectedRow();
            if(row < 0){
                JOptionPane.showMessageDialog(AccountsUI.this,"Select a row","Load Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                String userID = jtbl_Accounts.getValueAt(row,0).toString();
                String first = jtbl_Accounts.getValueAt(row, 1).toString();
                String last = jtbl_Accounts.getValueAt(row,2).toString();
                String fullname = first + last;
                
                
                AccountsHistoryGUI history = new AccountsHistoryGUI(2,AccountsUI.this,fullname,userID);
                setVisible(false);
                history.setVisible(true);
            }
        }
    }//GEN-LAST:event_jtbl_AccountsMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       AccountsHistoryGUI gui = new AccountsHistoryGUI(0,AccountsUI.this,UserName,User_ID);
       setVisible(false);
       gui.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        TransactionsUI trans = new TransactionsUI(userLevel,User_ID,UserName);
        setVisible(false);
        trans.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        LoginHistoryUI historyUI = new LoginHistoryUI(UserName,AccountsUI.this);
        setVisible(false);
        historyUI.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(AccountsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton jbtn_Assign;
    private javax.swing.JButton jbtn_Block;
    private javax.swing.JButton jbtn_ChangePassword;
    private javax.swing.JButton jbtn_Delete;
    private javax.swing.JLabel jlbl_Label;
    private javax.swing.JLabel jlbl_Online;
    private javax.swing.JTable jtbl_Accounts;
    private javax.swing.JTextField jtxt_Search;
    // End of variables declaration//GEN-END:variables

    public void refreshAccountsTable(){
        try{
            ArrayList<Accounts> list = accDAO.getAllAccounts();
            AccountsTableModel model = new AccountsTableModel(list);
            jtbl_Accounts.setModel(model);
            
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(AccountsUI.this,"Refresh Failed: "+exc.getMessage(),"Refresh Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void populateTable(){
        try{
            ArrayList<Accounts> list = accDAO.getAllAccounts();
            AccountsTableModel model = new AccountsTableModel(list);
            jtbl_Accounts.setModel(model);
            
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(AccountsUI.this,"Load Failed: "+ exc.getMessage(),"Load Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}