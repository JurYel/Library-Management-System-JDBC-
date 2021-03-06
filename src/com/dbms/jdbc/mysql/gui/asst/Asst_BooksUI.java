/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.gui.asst;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.dbms.jdbc.mysql.core.Books;
import com.dbms.jdbc.mysql.dao.BooksDAO;
import com.dbms.jdbc.mysql.gui.BooksTableModel;
import com.dbms.jdbc.mysql.gui.Main_LoginUI;
import com.dbms.jdbc.mysql.gui.student.Student_ProfileUI;
import java.util.ArrayList;

/**
 *
 * @author Jur Yel
 */
public class Asst_BooksUI extends javax.swing.JFrame {

    /**
     * Creates new form Asst_BooksUI
     */
    
    private BooksDAO bookDAO;
    private int userLevel;
    private String UserID;
    private String UserName;
    
    public Asst_BooksUI(int level, String id, String name){
        try{
            bookDAO = new BooksDAO();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_BooksUI.this,"DAO Failed: "+exc.getMessage(),"DAO Error",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setLocationRelativeTo(null);
        userLevel = level;
        UserID = id;
        UserName = name;
        jlbl_UserID1.setText(UserID);
        jlbl_Name1.setText(UserName);
        populateTable();
    }
    
    public Asst_BooksUI() {
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
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlbl_UserID1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlbl_Name1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jlbl_Logout1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Books = new javax.swing.JTable();
        jtxt_Search = new javax.swing.JTextField();
        jbtn_Update = new javax.swing.JButton();
        jbtn_Add1 = new javax.swing.JButton();
        jbtn_Borrow1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LBMS: Book Records");

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel3.setText("ID:");

        jlbl_UserID1.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jlbl_UserID1.setText("jLabel2");

        jLabel12.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel12.setText("Name:");

        jlbl_Name1.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jlbl_Name1.setText("jLabel2");

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel13.setText("Copyright @ Juriel Botoy");
        jLabel13.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel14.setText("CS282 Final Project");
        jLabel14.setToolTipText("");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/user-circle-icon.png"))); // NOI18N
        jLabel15.setMaximumSize(new java.awt.Dimension(561, 561));
        jLabel15.setMinimumSize(new java.awt.Dimension(561, 561));
        jLabel15.setPreferredSize(new java.awt.Dimension(561, 561));

        jlbl_Logout1.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jlbl_Logout1.setForeground(new java.awt.Color(51, 51, 255));
        jlbl_Logout1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_Logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_logout_rounded_left_26px_1.png"))); // NOI18N
        jlbl_Logout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_Logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_Logout1MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_event_accepted_tentatively_32px.png"))); // NOI18N
        jLabel16.setToolTipText("");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        jLabel17.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        jLabel17.setText("Issued Books");
        jLabel17.setToolTipText("");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, 170, 40));

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_books_26px_3.png"))); // NOI18N
        jLabel18.setToolTipText("");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        jLabel19.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        jLabel19.setText("Book Records");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, 200, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_technical_support_30px.png"))); // NOI18N
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_ledger_30px.png"))); // NOI18N
        jLabel21.setToolTipText("");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        jLabel22.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        jLabel22.setText("Transactions");
        jLabel22.setToolTipText("");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, 170, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlbl_Logout1)
                .addGap(24, 24, 24)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jlbl_UserID1))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addGap(12, 12, 12)
                .addComponent(jlbl_Name1))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel14))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlbl_Logout1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jlbl_UserID1))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jlbl_Name1))
                .addGap(42, 42, 42)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(23, 23, 23))
        );

        jPanel9.setBackground(java.awt.SystemColor.activeCaption);
        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));

        jLabel23.setFont(new java.awt.Font("Coolvetica Rg", 0, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 255));
        jLabel23.setText("Book Records");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel23)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jtbl_Books.setBackground(new java.awt.Color(204, 204, 255));
        jtbl_Books.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_Books);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 780, 370));

        jtxt_Search.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_Search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_Search.setText("Search Book");
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
        jPanel9.add(jtxt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 240, 40));

        jbtn_Update.setBackground(new java.awt.Color(102, 102, 255));
        jbtn_Update.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Update.setText("Update Book");
        jbtn_Update.setToolTipText("");
        jbtn_Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_UpdateActionPerformed(evt);
            }
        });
        jPanel9.add(jbtn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, 110, 30));

        jbtn_Add1.setBackground(new java.awt.Color(102, 102, 255));
        jbtn_Add1.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Add1.setText("Add Book");
        jbtn_Add1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_Add1ActionPerformed(evt);
            }
        });
        jPanel9.add(jbtn_Add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 90, 30));

        jbtn_Borrow1.setBackground(new java.awt.Color(102, 102, 255));
        jbtn_Borrow1.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Borrow1.setText("Borrow Book");
        jbtn_Borrow1.setToolTipText("");
        jbtn_Borrow1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_Borrow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_Borrow1ActionPerformed(evt);
            }
        });
        jPanel9.add(jbtn_Borrow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 110, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

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

    private void jlbl_Logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_Logout1MouseClicked
        Main_LoginUI login = new Main_LoginUI();
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jlbl_Logout1MouseClicked

    private void jbtn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_UpdateActionPerformed
         int row = jtbl_Books.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(Asst_BooksUI.this,"Select a row","Update Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String cat = jtbl_Books.getValueAt(row,0).toString();
            String id = jtbl_Books.getValueAt(row,1).toString();
            String title = jtbl_Books.getValueAt(row,2).toString();
            String author = jtbl_Books.getValueAt(row,3).toString();
            int rack = Integer.parseInt(jtbl_Books.getValueAt(row,4).toString());
            int year = Integer.parseInt(jtbl_Books.getValueAt(row,5).toString());
            int qty = Integer.parseInt(jtbl_Books.getValueAt(row,6).toString());
            
            Books theBook = new Books(cat,id,title,author,rack,year,qty);
            
            Asst_BooksUI_Operations update = new Asst_BooksUI_Operations("update",UserID,theBook,bookDAO,Asst_BooksUI.this);
            update.setVisible(true);
        }
    }//GEN-LAST:event_jbtn_UpdateActionPerformed

    private void jbtn_Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_Add1ActionPerformed
        Asst_BooksUI_Operations addBook = new Asst_BooksUI_Operations("add",UserID,null,bookDAO,Asst_BooksUI.this);
        addBook.setVisible(true);
    }//GEN-LAST:event_jbtn_Add1ActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        if(JOptionPane.showConfirmDialog(Asst_BooksUI.this,
                "You are a Student Assistant\n"
                        + "Do you want to switch to Student mode?","Switch Mode",
                        JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION){
            Student_ProfileUI studUI = new Student_ProfileUI(userLevel,UserID,UserName);
            setVisible(false);
            studUI.setVisible(true);
            
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jtxt_SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseEntered
       if(jtxt_Search.getText().contains("Search Book")){
           jtxt_Search.setText("");
       }
    }//GEN-LAST:event_jtxt_SearchMouseEntered

    private void jtxt_SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseExited
        if(jtxt_Search.getText().isEmpty()){
            jtxt_Search.setText("Search Book");
        }
    }//GEN-LAST:event_jtxt_SearchMouseExited

    private void jtxt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_SearchKeyTyped
        String search = jtxt_Search.getText().trim();
        try{
            if(search.isEmpty()){
                ArrayList<Books> list = bookDAO.getAllBooks();
                BooksTableModel model = new BooksTableModel(list);
                jtbl_Books.setModel(model);
            }
            else{
                ArrayList<Books> list = bookDAO.searchBook(search);
                BooksTableModel model = new BooksTableModel(list);
                jtbl_Books.setModel(model);
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_BooksUI.this,"Search Failed: "+exc.getMessage(),"Search Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtxt_SearchKeyTyped

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        panelColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        resetPanelColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
       panelColor(jPanel6);
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
       resetPanelColor(jPanel6);
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        panelColor(jPanel6);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        resetPanelColor(jPanel6);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        panelColor(jPanel8);
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        resetPanelColor(jPanel8);
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        panelColor(jPanel8);
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        resetPanelColor(jPanel8);
    }//GEN-LAST:event_jLabel21MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        panelColor(jPanel8);
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        resetPanelColor(jPanel8);
    }//GEN-LAST:event_jPanel8MouseExited

    private void jbtn_Borrow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_Borrow1ActionPerformed
        int row = jtbl_Books.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(Asst_BooksUI.this,"Select a row","Borrow Error",JOptionPane.ERROR_MESSAGE);
            
        }
        else{
            String cat = jtbl_Books.getValueAt(row,0).toString();
            String id = jtbl_Books.getValueAt(row,1).toString();
            String title = jtbl_Books.getValueAt(row,2).toString();
            String author = jtbl_Books.getValueAt(row,3).toString();
            int rack = Integer.parseInt(jtbl_Books.getValueAt(row,4).toString());
            int year = Integer.parseInt(jtbl_Books.getValueAt(row,5).toString());
            int qty = Integer.parseInt(jtbl_Books.getValueAt(row,6).toString());
            
            Books theBook = new Books(cat,id,title,author,rack,year,qty);
            
            Asst_BooksUI_Borrow borrow = new Asst_BooksUI_Borrow(userLevel,UserID,theBook,bookDAO,Asst_BooksUI.this);
            borrow.setVisible(true);
        }
    }//GEN-LAST:event_jbtn_Borrow1ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        Asst_IssuedBooksUI issuedUI = new Asst_IssuedBooksUI(userLevel,UserID,UserName);
        setVisible(false);
        issuedUI.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
       Asst_IssuedBooksUI issuedUI = new Asst_IssuedBooksUI(userLevel,UserID,UserName);
        setVisible(false);
        issuedUI.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        Asst_IssuedBooksUI issuedUI = new Asst_IssuedBooksUI(userLevel,UserID,UserName);
        setVisible(false);
        issuedUI.setVisible(true);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        Asst_TransactionsUI transUI = new Asst_TransactionsUI(userLevel,UserID,UserName);
        setVisible(false);
        transUI.setVisible(true);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        Asst_TransactionsUI transUI = new Asst_TransactionsUI(userLevel,UserID,UserName);
        setVisible(false);
        transUI.setVisible(true);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
       Asst_TransactionsUI transUI = new Asst_TransactionsUI(userLevel,UserID,UserName);
        setVisible(false);
        transUI.setVisible(true);
    }//GEN-LAST:event_jLabel21MouseClicked

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
            java.util.logging.Logger.getLogger(Asst_BooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asst_BooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asst_BooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asst_BooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asst_BooksUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_Add1;
    private javax.swing.JButton jbtn_Borrow1;
    private javax.swing.JButton jbtn_Update;
    private javax.swing.JLabel jlbl_Logout1;
    private javax.swing.JLabel jlbl_Name1;
    private javax.swing.JLabel jlbl_UserID1;
    private javax.swing.JTable jtbl_Books;
    private javax.swing.JTextField jtxt_Search;
    // End of variables declaration//GEN-END:variables

    public void refreshBooksTable(){
        try{
            ArrayList<Books> list = bookDAO.getAllBooks();
            BooksTableModel model = new BooksTableModel(list);
            jtbl_Books.setModel(model);
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_BooksUI.this,"Refresh Failed: "+exc.getMessage(),"Refresh Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void populateTable(){
        try{
            ArrayList<Books> list = bookDAO.getAllBooks();
            BooksTableModel model = new BooksTableModel(list);
            jtbl_Books.setModel(model);
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_BooksUI.this,"Load Failed: "+exc.getMessage(),"Load Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private void panelColor(JPanel panel){
        panel.setBackground(new java.awt.Color(204,204,255));
    }
    
    private void resetPanelColor(JPanel panel){
        panel.setBackground(new java.awt.Color(153,204,255));
    }
}
