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
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class BooksHistoryTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int BOOK_ID_COL = 0;
    private static final int ACTION_COL = 1;
    private static final int ADMIN_ID_COL = 2;
    private static final int DATETIME_COL = 3;
    
    private String[] columnNames = {"Book ID","Action","Admin ID","Date/Time"};
    private ArrayList<BooksHistory> list;
    
    public BooksHistoryTableModel(ArrayList<BooksHistory> theList){
        this.list = theList;
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row, int col){
        BooksHistory history = list.get(row);
        
        switch(col){
            case BOOK_ID_COL:
                return history.getBookID();
            case ACTION_COL:
                return history.getAction();
            case ADMIN_ID_COL:
                return history.getAdminID();
            case DATETIME_COL:
                return history.getDateTime();
            case OBJECT_COL:
                return history;
            default:
                return history.getBookID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
}
