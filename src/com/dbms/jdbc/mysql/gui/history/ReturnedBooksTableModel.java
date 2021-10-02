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
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.dbms.jdbc.mysql.core.ReturnedBooks;
public class ReturnedBooksTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int USER_ID_COL = 0;
    private static final int STATUS_COL = 1;
    private static final int BOOK_ID_COL = 2;
    private static final int DATE_RETURNED_COL = 3;
    
    private String[] columnNames = {"User ID","Status","Book ID","Date Returned"};
    private ArrayList<ReturnedBooks> returnedBooks;
    
    public ReturnedBooksTableModel(ArrayList<ReturnedBooks> list){
        this.returnedBooks = list;
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return returnedBooks.size();
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row,int col){
        ReturnedBooks book = returnedBooks.get(row);
        
        switch(col){
            case USER_ID_COL:
                return book.getUserID();
            case STATUS_COL:
                return book.getBookStatus();
            case BOOK_ID_COL:
                return book.getBookID();
            case DATE_RETURNED_COL:
                return book.getDateReturned();
            case OBJECT_COL:
                return book;
            default: 
                return book.getBookID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
}
