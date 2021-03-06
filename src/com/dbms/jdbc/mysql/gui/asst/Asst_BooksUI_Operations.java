/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.gui.asst;

/**
 *
 * @author Jur Yel
 */
import com.dbms.jdbc.mysql.core.Books;
import com.dbms.jdbc.mysql.dao.BooksDAO;
import javax.swing.JOptionPane;
public class Asst_BooksUI_Operations extends javax.swing.JDialog {

    /**
     * Creates new form Asst_BooksUI_Add
     */
    private Books theBook;
    private BooksDAO bookDAO;
    private Asst_BooksUI bookUI;
    private String User_ID;
    private String operation;
    
    public Asst_BooksUI_Operations(String oprtn,String userID,Books book,BooksDAO dao,Asst_BooksUI ui){
        initComponents();
        setLocationRelativeTo(ui);
        theBook = book;
        bookDAO = dao;
        bookUI = ui;
        User_ID = userID;
        operation = oprtn;
        
        if(operation.equalsIgnoreCase("add")){
            setTitle("Add Book");
            jbtn_Submit.setText("Add Book");
        }
        else if(operation.equalsIgnoreCase("update")){
            setTitle("Update Book");
            jbtn_Submit.setText("Update Book");
            jtxt_BookID.setEnabled(false);
            populateGUI(theBook);
        }
    }
    
    public Asst_BooksUI_Operations(java.awt.Frame parent, boolean modal) {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_Category = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtxt_BookID = new javax.swing.JTextField();
        jtxt_BookTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxt_BookAuthor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSpinner_Rack = new javax.swing.JSpinner();
        jtxt_Year = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinner_Quantity = new javax.swing.JSpinner();
        jbtn_Submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel2.setText("Category:");

        jComboBox_Category.setBackground(new java.awt.Color(204, 204, 255));
        jComboBox_Category.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jComboBox_Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Studies", "Engineering and Architecture", "Arts and Sciences", "Business Management", "Politics", "Literature", "History" }));

        jLabel3.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel3.setText("Book ID:");

        jtxt_BookID.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_BookID.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtxt_BookTitle.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_BookTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel4.setText("Book Title:");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel5.setText("Book Author:");

        jtxt_BookAuthor.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_BookAuthor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel6.setText("Rack:");
        jLabel6.setToolTipText("");

        jSpinner_Rack.setModel(new javax.swing.SpinnerNumberModel(1, 1, 14, 1));

        jtxt_Year.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_Year.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_Year.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel7.setText("Year Published:");

        jLabel8.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jLabel8.setText("Quantity:");

        jSpinner_Quantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jbtn_Submit.setBackground(new java.awt.Color(102, 102, 255));
        jbtn_Submit.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jbtn_Submit.setText("Add Book");
        jbtn_Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtn_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxt_Year, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jtxt_BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jtxt_BookID, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtxt_BookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner_Rack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jbtn_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_BookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_BookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_BookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_Rack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jbtn_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if(operation.equalsIgnoreCase("add")){
            addBook();
        }
        else if(operation.equalsIgnoreCase("update")){
            updateBook();
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
            java.util.logging.Logger.getLogger(Asst_BooksUI_Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asst_BooksUI_Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asst_BooksUI_Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asst_BooksUI_Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Asst_BooksUI_Operations dialog = new Asst_BooksUI_Operations(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jComboBox_Category;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner_Quantity;
    private javax.swing.JSpinner jSpinner_Rack;
    private javax.swing.JButton jbtn_Submit;
    private javax.swing.JTextField jtxt_BookAuthor;
    private javax.swing.JTextField jtxt_BookID;
    private javax.swing.JTextField jtxt_BookTitle;
    private javax.swing.JTextField jtxt_Year;
    // End of variables declaration//GEN-END:variables
    
    private void addBook(){
        String cat = jComboBox_Category.getSelectedItem().toString();
        String bookID = jtxt_BookID.getText().trim();
        String title = jtxt_BookTitle.getText().trim();
        String author = jtxt_BookAuthor.getText().trim();
        int rack = Integer.parseInt(jSpinner_Rack.getValue().toString());
        int year = Integer.parseInt(jtxt_Year.getText().trim());
        int qty = Integer.parseInt(jSpinner_Quantity.getValue().toString());
        
        try{
            if(bookDAO.checkBookID(bookID)){
                bookDAO.AddToQuantity(bookID);
                bookUI.refreshBooksTable();
                setVisible(false);
                dispose();
                JOptionPane.showMessageDialog(bookUI,"Book added successfully!","Add Success",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                Books theBook = new Books(cat,bookID,title,author,rack,year,qty);
                bookDAO.AddBooks(theBook,User_ID);
                bookUI.refreshBooksTable();
                setVisible(false);
                dispose();
                JOptionPane.showMessageDialog(bookUI,"Book added successfully!","Add Success",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_BooksUI_Operations.this,"Add Failed: "+exc.getMessage(),"Add Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void updateBook(){
        String cat = jComboBox_Category.getSelectedItem().toString();
        String id = jtxt_BookID.getText().trim();
        String title = jtxt_BookTitle.getText().trim();
        String author = jtxt_BookAuthor.getText().trim();
        int rack = Integer.parseInt(jSpinner_Rack.getValue().toString());
        int year = Integer.parseInt(jtxt_Year.getText().trim());
        int qty = Integer.parseInt(jSpinner_Quantity.getValue().toString());
        
        try{
            Books theBook = new Books(cat,id,title,author,rack,year,qty);
            
            bookDAO.UpdateBooks(theBook,User_ID);
            bookUI.refreshBooksTable();
            setVisible(false);
            dispose();
            JOptionPane.showMessageDialog(bookUI,"Book updated successfully!","Update Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_BooksUI_Operations.this,"Update Failed: "+exc.getMessage(),"Update Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void populateGUI(Books book){
        jComboBox_Category.setSelectedItem(book.getBookCategory());
        jtxt_BookID.setText(book.getBookID());
        jtxt_BookTitle.setText(book.getBookTitle());
        jtxt_BookAuthor.setText(book.getBookAuthor());
        jSpinner_Rack.setValue(book.getRack());
        jtxt_Year.setText(String.valueOf(book.getYearPublished()));
        jSpinner_Quantity.setValue(book.getQuantity());
    }
    
    private void disableAll(){
        jComboBox_Category.setEnabled(false);
        jtxt_BookID.setEnabled(false);
        jtxt_BookTitle.setEnabled(false);
        jtxt_BookAuthor.setEnabled(false);
        jSpinner_Rack.setEnabled(false);
        jtxt_Year.setEnabled(false);
        jSpinner_Quantity.setEnabled(false);
    }
}
