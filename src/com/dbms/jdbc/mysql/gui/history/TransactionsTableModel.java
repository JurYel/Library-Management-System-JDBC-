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
import com.dbms.jdbc.mysql.core.Transactions;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class TransactionsTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int USERID_COL = 0;
    private static final int TRANSACTION_COL = 1;
    private static final int BOOK_ID_COL = 2;
    private static final int ADMIN_ID_COL = 3;
    private static final int DATE_TRANSACION_COL = 4;
    
    private String[] columnNames = {"User ID","Transaction","Book ID","Admin ID","Transaction Date"};
    private ArrayList<Transactions> transactions;
    
    public TransactionsTableModel(ArrayList<Transactions> list){
        this.transactions = list;
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return transactions.size();
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row,int col){
        Transactions transaction = transactions.get(row);
        
        switch(col){
            case USERID_COL:
                return transaction.getUserID();
            case TRANSACTION_COL:
                return transaction.getTransaction();
            case BOOK_ID_COL:
                return transaction.getBookID();
            case ADMIN_ID_COL:
                return transaction.getAdminID();
            case DATE_TRANSACION_COL:
                return transaction.getDateTime();
            case OBJECT_COL:
                return transaction;
            default:
                return transaction.getUserID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
}
