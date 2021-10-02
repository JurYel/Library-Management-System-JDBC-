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
import com.dbms.jdbc.mysql.core.ReturnedBooks;
import com.dbms.jdbc.mysql.dao.ReturnedBooksDAO;
import com.dbms.jdbc.mysql.gui.history.ReturnedBooksTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Asst_ReturnedBooksUI extends javax.swing.JFrame {

    /**
     * Creates new form Asst_ReturnedBooks
     */
    private ReturnedBooksDAO returnDAO;
    private String UserName;
    private Asst_IssuedBooksUI issuedUI;
    
    public Asst_ReturnedBooksUI(String name,Asst_IssuedBooksUI ui){
        try{
            returnDAO = new ReturnedBooksDAO();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_ReturnedBooksUI.this,"DAO Failed: "+exc.getMessage(),"DAO Error",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setLocationRelativeTo(ui);
        UserName = name;
        issuedUI = ui;
        populateTable();
        jlbl_Online.setText(UserName);
    }
    
    public Asst_ReturnedBooksUI() {
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
        jlbl_Online = new javax.swing.JLabel();
        jtxt_Search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_ReturnedBooks = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LBMS: Returned Books");

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jLabel1.setText("Asst:");

        jlbl_Online.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jlbl_Online.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbl_Online)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlbl_Online))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jtbl_ReturnedBooks.setBackground(new java.awt.Color(204, 204, 255));
        jtbl_ReturnedBooks.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_ReturnedBooks);

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton1)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtxt_SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseEntered
        if(jtxt_Search.getText().contains(("Search Book"))){
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
                ArrayList<ReturnedBooks> list = returnDAO.getReturnedBooks();
                ReturnedBooksTableModel model = new ReturnedBooksTableModel(list);
                jtbl_ReturnedBooks.setModel(model);
            }
            else{
                ArrayList<ReturnedBooks> list = returnDAO.searchReturnedBook(search);
                ReturnedBooksTableModel model = new ReturnedBooksTableModel(list);
                jtbl_ReturnedBooks.setModel(model);
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_ReturnedBooksUI.this,"Search Failed: "+exc.getMessage(),"Search Error",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Asst_ReturnedBooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asst_ReturnedBooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asst_ReturnedBooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asst_ReturnedBooksUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asst_ReturnedBooksUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbl_Online;
    private javax.swing.JTable jtbl_ReturnedBooks;
    private javax.swing.JTextField jtxt_Search;
    // End of variables declaration//GEN-END:variables

    private void populateTable(){
        try{
            ArrayList<ReturnedBooks> list = returnDAO.getReturnedBooks();
            ReturnedBooksTableModel model = new ReturnedBooksTableModel(list);
            jtbl_ReturnedBooks.setModel(model);
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(Asst_ReturnedBooksUI.this,"Load Failed: "+exc.getMessage(),"Load Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}

