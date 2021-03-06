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
import com.dbms.jdbc.mysql.core.BooksHistory;
import com.dbms.jdbc.mysql.dao.BooksHistoryDAO;
import com.dbms.jdbc.mysql.gui.BooksUI;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BooksHistoryUI extends javax.swing.JFrame {

    /**
     * Creates new form BooksHistoryUI
     */
    private BooksHistoryDAO bkHisDAO;
    private BooksUI bookUI;
    
    public BooksHistoryUI(String name,BooksUI ui){
        try{
            bkHisDAO = new BooksHistoryDAO();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(BooksHistoryUI.this,"DAO Failed: "+exc.getMessage(),"DAO Error",JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setLocationRelativeTo(ui);
        bookUI = ui;
        jlbl_Online.setText(name);
        populateTable();
        
    }
    
    public BooksHistoryUI() {
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
        jtbl_BooksHistory = new javax.swing.JTable();
        jbtn_Okay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LBMS: Books History");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbl_Online)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Label)
                    .addComponent(jlbl_Online))
                .addContainerGap())
        );

        jtxt_Search.setFont(new java.awt.Font("Josefin Sans", 0, 16)); // NOI18N
        jtxt_Search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxt_Search.setText("Search Book...");
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

        jtbl_BooksHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbl_BooksHistory);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jbtn_Okay.setBackground(new java.awt.Color(0, 0, 0));
        jbtn_Okay.setFont(new java.awt.Font("Josefin Sans", 0, 14)); // NOI18N
        jbtn_Okay.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_Okay.setText("Okay");
        jbtn_Okay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_OkayActionPerformed(evt);
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
                        .addComponent(jbtn_Okay)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtxt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_Okay)
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

    private void jtxt_SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseEntered
        if(jtxt_Search.getText().contains("Search Book...")){
            jtxt_Search.setText("");
        }
        
    }//GEN-LAST:event_jtxt_SearchMouseEntered

    private void jbtn_OkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_OkayActionPerformed
        setVisible(false);
        bookUI.setVisible(true);
    }//GEN-LAST:event_jbtn_OkayActionPerformed

    private void jtxt_SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxt_SearchMouseExited
       if(jtxt_Search.getText().isEmpty()){
           jtxt_Search.setText("Search Book...");
       }
    }//GEN-LAST:event_jtxt_SearchMouseExited

    private void jtxt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_SearchKeyTyped
        String search = jtxt_Search.getText().trim();
        try{
            if(search.isEmpty()){
                ArrayList<BooksHistory> list = bkHisDAO.getBooksHistory();
                BooksHistoryTableModel model = new BooksHistoryTableModel(list);
                jtbl_BooksHistory.setModel(model);
            }
            else{
                ArrayList<BooksHistory> list = bkHisDAO.searchBookHistory(search);
                BooksHistoryTableModel model = new BooksHistoryTableModel(list);
                jtbl_BooksHistory.setModel(model);
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(BooksHistoryUI.this,"Search Failed: "+exc.getMessage(),"Search Error",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(BooksHistoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooksHistoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooksHistoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooksHistoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BooksHistoryUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_Okay;
    private javax.swing.JLabel jlbl_Label;
    private javax.swing.JLabel jlbl_Online;
    private javax.swing.JTable jtbl_BooksHistory;
    private javax.swing.JTextField jtxt_Search;
    // End of variables declaration//GEN-END:variables

    private void populateTable(){
        try{
            ArrayList<BooksHistory> list = bkHisDAO.getBooksHistory();
            BooksHistoryTableModel model = new BooksHistoryTableModel(list);
            jtbl_BooksHistory.setModel(model);
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(BooksHistoryUI.this,"Load Failed: "+exc.getMessage(),"Load Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
