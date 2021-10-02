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
import com.dbms.jdbc.mysql.core.OverduedBooks;
public class OverduedBooksTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int USERID_COL = 0;
    private static final int OVERDUED_COL = 1;
    private static final int BOOK_ID_COL = 2;
     private static final int DAYS_DUE_COL = 3;
    private static final int DUE_DATE_COL = 4;
    private static final int DATE_BORROWED_COL = 5;
   
    
    private String[] columnNames = {"User ID","Overdued","Book ID","Days Due","Date Due","Date Borrowed"};
    private ArrayList<OverduedBooks> overduedBooks;
    
    public OverduedBooksTableModel(ArrayList<OverduedBooks> list){
        this.overduedBooks = list;
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return overduedBooks.size();
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row, int col){
        OverduedBooks overdued = overduedBooks.get(row);
        
        switch(col){
            case USERID_COL:
                return overdued.getUserID();
            case OVERDUED_COL:
                return overdued.getOverdued();
            case BOOK_ID_COL:
                return overdued.getBookID();
            case DAYS_DUE_COL:
                return overdued.getDaysDue();
            case DUE_DATE_COL:
                return overdued.getDateDue();
            case DATE_BORROWED_COL:
                return overdued.getDateBorrowed();
            case OBJECT_COL:
                return overdued;
            default: 
                return overdued.getBookID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
}
