/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.gui.student;

/**
 *
 * @author Jur Yel
 */
import com.dbms.jdbc.mysql.dao.IssuedBooksDAO;
import com.dbms.jdbc.mysql.dao.AccountsDAO;
import com.dbms.jdbc.mysql.core.IssuedBooks;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import com.dbms.jdbc.mysql.gui.Main_LoginUI;
import com.dbms.jdbc.mysql.gui.asst.Asst_BooksUI;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Student_ProfileUI extends javax.swing.JFrame {

    /**
     * Creates new form Student_ProfileUI
     */
    private IssuedBooksDAO issuedDAO;
    private AccountsDAO accDAO;
    private int userLevel;
    private String UserID;
    private String UserName;
    
    
    public Student_ProfileUI(int level, String userID,String userName) {
        try{
            issuedDAO = new IssuedBooksDAO();
            accDAO = new AccountsDAO();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI.this,"DAO Failed: "+exc.getMessage(),"DAO Error",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setLocationRelativeTo(null);
        userLevel = level;
        UserID = userID;
        UserName = userName;
        jlbl_UserID.setText(UserID);
        jlbl_Name.setText(UserName);
        populateTable();
        checkOverduedBooks();
        
    }
    
    public Student_ProfileUI(){
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
        jLabel1 = new javax.swing.JLabel();
        jlbl_UserID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbl_Name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlbl_Logout = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_IssuedBooks = new javax.swing.JTable();
        jbtn_Renew = new javax.swing.JButton();
        jbtn_Return = new javax.swing.JButton();
        jtxt_Search = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LBMS: Student Profile");

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel1.setText("ID:");

        jlbl_UserID.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jlbl_UserID.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel2.setText("Name:");

        jlbl_Name.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jlbl_Name.setText("jLabel2");

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel4.setText("Copyright @ Juriel Botoy");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel5.setText("CS282 Final Project");
        jLabel5.setToolTipText("");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/user-circle-icon.png"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(561, 561));
        jLabel6.setMinimumSize(new java.awt.Dimension(561, 561));
        jLabel6.setPreferredSize(new java.awt.Dimension(561, 561));

        jlbl_Logout.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jlbl_Logout.setForeground(new java.awt.Color(51, 51, 255));
        jlbl_Logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_logout_rounded_left_26px_1.png"))); // NOI18N
        jlbl_Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbl_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_LogoutMouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_event_accepted_tentatively_32px.png"))); // NOI18N
        jLabel9.setToolTipText("");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        jLabel10.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        jLabel10.setText("Issued Books");
        jLabel10.setToolTipText("");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, 170, 40));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_books_26px_3.png"))); // NOI18N
        jLabel7.setToolTipText("");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        jLabel8.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
        jLabel8.setText("Book Records");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, 200, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dbms/jdbc/ico/icons8_student_male_30px_1.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4))
                .addGap(76, 76, 76))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlbl_Logout)
                        .addGap(206, 206, 206)
                        .addComponent(jLabel11))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(jlbl_UserID))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(jlbl_Name)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlbl_Logout))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jlbl_UserID))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jlbl_Name))
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(java.awt.SystemColor.activeCaption);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jtbl_IssuedBooks.setBackground(new java.awt.Color(204, 204, 255));
        jtbl_IssuedBooks.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtbl_IssuedBooks.setForeground(new java.awt.Color(0, 0, 0));
        jtbl_IssuedBooks.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbl_IssuedBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbl_IssuedBooks.setGridColor(new java.awt.Color(0, 0, 0));
        jtbl_IssuedBooks.setSelectionForeground(new java.awt.Color(153, 204, 255));
        jScrollPane1.setViewportView(jtbl_IssuedBooks);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 113, 710, 360));

        jbtn_Renew.setBackground(new java.awt.Color(102, 102, 255));
        jbtn_Renew.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Renew.setText("Renew Book");
        jbtn_Renew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_Renew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_RenewActionPerformed(evt);
            }
        });
        jPanel4.add(jbtn_Renew, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, -1, -1));

        jbtn_Return.setBackground(new java.awt.Color(102, 102, 255));
        jbtn_Return.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Return.setText("Return Book");
        jbtn_Return.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ReturnActionPerformed(evt);
            }
        });
        jPanel4.add(jbtn_Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, -1, -1));

        jtxt_Search.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
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
        jPanel4.add(jtxt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 210, -1));

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel3.setFont(new java.awt.Font("Coolvetica Rg", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Your Issued Books");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel3)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
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

    private void jbtn_RenewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_RenewActionPerformed
        int row = jtbl_IssuedBooks.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(Student_ProfileUI.this,"Select a row","Renew Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            
            String bookID = jtbl_IssuedBooks.getValueAt(row,0).toString();
            String bookTitle = jtbl_IssuedBooks.getValueAt(row,1).toString();
            Date dateBrwd = (Date)jtbl_IssuedBooks.getValueAt(row,2);
            Date datedue = (Date)jtbl_IssuedBooks.getValueAt(row,3);
            
            IssuedBooks issuedBook = new IssuedBooks(bookID,bookTitle,UserID,dateBrwd,datedue);
            Student_ProfileUI_Operations renew = new Student_ProfileUI_Operations("renew",UserID,
                    issuedBook,issuedDAO,Student_ProfileUI.this);
            renew.setVisible(true);
        
        }
    }//GEN-LAST:event_jbtn_RenewActionPerformed

    private void jbtn_ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ReturnActionPerformed
        int row = jtbl_IssuedBooks.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(Student_ProfileUI.this,"Select a row","Return Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String bookID = jtbl_IssuedBooks.getValueAt(row,0).toString();
            String bookTitle = jtbl_IssuedBooks.getValueAt(row,1).toString();
            Date dateBrwd = (Date)jtbl_IssuedBooks.getValueAt(row,2);
            Date datedue = (Date)jtbl_IssuedBooks.getValueAt(row,3);
            
            IssuedBooks issuedBook = new IssuedBooks(bookID,bookTitle,UserID,dateBrwd,datedue);
            Student_ProfileUI_Operations returnUI = new Student_ProfileUI_Operations("return",UserID,
                    issuedBook,issuedDAO,Student_ProfileUI.this);
            returnUI.setVisible(true);
        }
    }//GEN-LAST:event_jbtn_ReturnActionPerformed

    private void jlbl_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_LogoutMouseClicked
        Main_LoginUI login = new Main_LoginUI();
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jlbl_LogoutMouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
       panelColor(jPanel3);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        resetPanelColor(jPanel3);
    }//GEN-LAST:event_jPanel3MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        panelColor(jPanel3);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        resetPanelColor(jPanel3);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        panelColor(jPanel3);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        panelColor(jPanel3);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Student_BooksUI books = new Student_BooksUI(userLevel,UserID,UserName);
        setVisible(false);
        books.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Student_BooksUI books = new Student_BooksUI(userLevel,UserID,UserName);
        setVisible(false);
        books.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        Student_BooksUI books = new Student_BooksUI(userLevel,UserID,UserName);
        setVisible(false);
        books.setVisible(true);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        try{
            if(accDAO.checkIfStudAsst(UserID)){
                if(JOptionPane.showConfirmDialog(Student_ProfileUI.this,
                    "You are a Student\n"
                            + "Do you want to switch to \nStudent Assistant mode?","Switch Mode",
                            JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.OK_OPTION){
                    Asst_BooksUI asstUI = new Asst_BooksUI(userLevel,UserID,UserName);
                    setVisible(false);
                    asstUI.setVisible(true);

                }
            }
            else{
                JOptionPane.showMessageDialog(Student_ProfileUI.this,"You are a Student","Prompt Message",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI.this,"Switch Failed: "+exc.getMessage(),"Switch Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jtxt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_SearchKeyTyped
        String search = jtxt_Search.getText().trim();
        try{
            if(search.isEmpty()){
                ArrayList<IssuedBooks> list = issuedDAO.getIssuedBooksByUser(UserID);
                Student_ProfileTableModel model = new Student_ProfileTableModel(list);
                jtbl_IssuedBooks.setModel(model);
            }
            else{
                ArrayList<IssuedBooks> list = issuedDAO.searchIssuedBookOfUser(search, UserID);
                Student_ProfileTableModel model = new Student_ProfileTableModel(list);
                jtbl_IssuedBooks.setModel(model);
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI.this,"Search Failed: "+exc.getMessage(),"Search Error",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Student_ProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_ProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_ProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_ProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_ProfileUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_Renew;
    private javax.swing.JButton jbtn_Return;
    private javax.swing.JLabel jlbl_Logout;
    private javax.swing.JLabel jlbl_Name;
    private javax.swing.JLabel jlbl_UserID;
    private javax.swing.JTable jtbl_IssuedBooks;
    private javax.swing.JTextField jtxt_Search;
    // End of variables declaration//GEN-END:variables
    
    public void refreshIssuedBooksTable(){
        try{
            ArrayList<IssuedBooks> list = issuedDAO.getIssuedBooksByUser(UserID);
            Student_ProfileTableModel model = new Student_ProfileTableModel(list);
            jtbl_IssuedBooks.setModel(model);
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI.this,"Refresh Failed: "+exc.getMessage(),"Refresh Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void populateTable(){
        try{
            ArrayList<IssuedBooks> list = issuedDAO.getIssuedBooksByUser(UserID);
            Student_ProfileTableModel model = new Student_ProfileTableModel(list);
            jtbl_IssuedBooks.setModel(model);
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI.this,"Load Failed: "+exc.getMessage(),"Load Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    private void checkOverduedBooks(){
        try{
            ArrayList<IssuedBooks> list = issuedDAO.getIssuedBooksByUser(UserID);
            
            for(int i = 0;i<list.size();i++){
                if(issuedDAO.checkIfOverdued(UserID, list.get(i).getBookID())){
                    
                    if((JOptionPane.showConfirmDialog(Student_ProfileUI.this,
                            "This book is overdued; \n\n "
                          + "\tBook ID: "+list.get(i).getBookID() + "\n"
                          + "\tTitle: " +list.get(i).getBookTitle() + "\n"
                          + "\tDate Borrowed: " + convertUtilToSQL(list.get(i).getDateBorrowed()) + "\n"
                          + "\tDate Due: " + convertUtilToSQL(list.get(i).getDateDue()) + "\n\n"
                          + "Do you want to renew book?","Book Overdued",
                            JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION))
                    {
                        Student_ProfileUI_Operations renew = new Student_ProfileUI_Operations("renew",UserID,
                        list.get(i),issuedDAO,Student_ProfileUI.this);
                        renew.setVisible(true);
                    }
                }
            }
            
            
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI.this,"Checking Failed: "+exc.getMessage(),"Check Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private java.sql.Date convertUtilToSQL(Date uDate){
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
    private void panelColor(JPanel panel){
        panel.setBackground(new java.awt.Color(204,204,255));
    }
    
    private void resetPanelColor(JPanel panel){
        panel.setBackground(new java.awt.Color(153,204,255));
    }
}
