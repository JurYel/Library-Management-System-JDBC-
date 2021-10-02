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
import com.dbms.jdbc.mysql.core.IssuedBooks;
import com.dbms.jdbc.mysql.dao.IssuedBooksDAO;
import com.dbms.jdbc.mysql.dao.BooksDAO;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Student_ProfileUI_Operations extends javax.swing.JDialog {

    /**
     * Creates new form Student_ProfileUI_Operations
     */
    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    private IssuedBooks issuedBook;
    private IssuedBooksDAO issuedDAO;
    private BooksDAO bookDAO;
    private String UserID;
    private Student_ProfileUI studUI;
    private String operation;
    
    public Student_ProfileUI_Operations(String oprtn,String userID,IssuedBooks book,
            IssuedBooksDAO dao, Student_ProfileUI ui){
        try{
            bookDAO = new BooksDAO();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI_Operations.this,"DAO Failed: "+exc.getMessage(),"DAO Error",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setLocationRelativeTo(ui);
        studUI = ui;
        issuedBook = book;
        UserID = userID;
        issuedDAO = dao;
        operation = oprtn;
        populateGUI(issuedBook);
        disableAll();
        if(operation.equalsIgnoreCase("return")){
            setTitle("Return Book");
            jbtn_Submit.setText("Return Book");
            
        }
        else if(operation.equalsIgnoreCase("renew")){
            setTitle("Renew Book");
            jbtn_Submit.setText("Renew Book");
        }
    }
    
    public Student_ProfileUI_Operations(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        jLabel1 = new javax.swing.JLabel();
        jtxt_BookID = new javax.swing.JTextField();
        jtxt_Title = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxt_UserID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_DateBorrowed = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_DateDue = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jbtn_Submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel1.setText("Book ID:");

        jtxt_BookID.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_BookID.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtxt_Title.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_Title.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel2.setText("Book Title:");

        jtxt_UserID.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_UserID.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel3.setText("User ID:");

        jComboBox_DateBorrowed.setBackground(new java.awt.Color(204, 204, 255));
        jComboBox_DateBorrowed.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel4.setText("Date Borrowed:");

        jComboBox_DateDue.setBackground(new java.awt.Color(153, 204, 255));
        jComboBox_DateDue.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel5.setText("Date Due:");

        jbtn_Submit.setBackground(new java.awt.Color(102, 102, 255));
        jbtn_Submit.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jbtn_Submit.setText("Renew Book");
        jbtn_Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_Title)
                    .addComponent(jtxt_BookID)
                    .addComponent(jComboBox_DateBorrowed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_DateDue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxt_UserID, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_Submit)
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_UserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxt_BookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxt_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_DateBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_DateDue, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addComponent(jbtn_Submit, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(18, 18, 18))
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

    private void jbtn_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_SubmitActionPerformed
        if(operation.equalsIgnoreCase("renew")){
            renewBook();
        }
        else if(operation.equalsIgnoreCase("return")){
            returnBook();
        }
    }//GEN-LAST:event_jbtn_SubmitActionPerformed

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
            java.util.logging.Logger.getLogger(Student_ProfileUI_Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_ProfileUI_Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_ProfileUI_Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_ProfileUI_Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Student_ProfileUI_Operations dialog = new Student_ProfileUI_Operations(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox_DateBorrowed;
    private javax.swing.JComboBox<String> jComboBox_DateDue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtn_Submit;
    private javax.swing.JTextField jtxt_BookID;
    private javax.swing.JTextField jtxt_Title;
    private javax.swing.JTextField jtxt_UserID;
    // End of variables declaration//GEN-END:variables
    
    private void returnBook(){
        String userID = jtxt_UserID.getText();
        String bookID = jtxt_BookID.getText();
        try{
            int quantity = bookDAO.getBookQuantity(bookID);
            issuedDAO.returnBook(UserID,userID, bookID,quantity);
            studUI.refreshIssuedBooksTable();
            setVisible(false);
            JOptionPane.showMessageDialog(studUI,"Book returned successfully!","Return Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI_Operations.this,"Return Failed: "+exc.getMessage(),"Return Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void renewBook(){
        String bookID = jtxt_BookID.getText();
        String userID = UserID;
        Date brwd = issuedBook.getDateBorrowed();
        Date due = issuedBook.getDateDue();
        Date curDay = new Date();
        
        int brwdDay = brwd.getDate();
        int dueDay = due.getDate();
        try{
            
                if((dueDay - curDay.getDate()) != 0){
                    setVisible(false);
                    JOptionPane.showMessageDialog(studUI,"Renewal is only allowed on due date","Renewal Error",JOptionPane.ERROR_MESSAGE);
                }
                else{

                        String title = issuedDAO.getBookTitleByUserID(bookID);
                        IssuedBooks issued = new IssuedBooks(bookID,title,userID,brwd,due);
                        issuedDAO.renewBook(issued,UserID);
                        studUI.refreshIssuedBooksTable();
                        setVisible(false);
                        JOptionPane.showMessageDialog(studUI,"Book renewed successfully!","Renewal Success",JOptionPane.INFORMATION_MESSAGE);

                }
            
            
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Student_ProfileUI_Operations.this,"Renewal Failed: "+exc.getMessage(),"Renewal Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void populateGUI(IssuedBooks book){
        jtxt_UserID.setText(book.getUserID());
        jtxt_BookID.setText(book.getBookID());
        jtxt_Title.setText(book.getBookTitle());
        jComboBox_DateBorrowed.addItem(sdf.format(book.getDateBorrowed()));
        jComboBox_DateDue.addItem(sdf.format(book.getDateDue()));
    }
    
    private void disableAll(){
        jtxt_UserID.setEnabled(false);
        jtxt_BookID.setEnabled(false);
        jtxt_Title.setEnabled(false);
        jComboBox_DateBorrowed.setEnabled(false);
        jComboBox_DateDue.setEnabled(false);
    }
}
