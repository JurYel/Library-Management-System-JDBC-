/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.gui;

/**
 *
 * @author Jur Yel
 */
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.dbms.jdbc.mysql.core.IssuedBooks;
public class IssuedBooksTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int BOOK_ID_COL = 0;
    private static final int BOOK_TITLE_COL = 1;
    private static final int USERID_COL = 2;
    private static final int DATE_BORROWED_COL = 3;
    private static final int DATE_DUE_COL = 4;
    
    private String[] columnNames = {"Book ID","Book Title","User ID","Date Borrowed","Date Due"};
    private ArrayList<IssuedBooks> issuedBooks;
    
    public IssuedBooksTableModel(ArrayList<IssuedBooks> list){
        this.issuedBooks = list;
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return issuedBooks.size();
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col){
        IssuedBooks issued = issuedBooks.get(row);
        
        switch(col){
            case BOOK_ID_COL:
                return issued.getBookID();
            case BOOK_TITLE_COL:
                return issued.getBookTitle();
            case USERID_COL:
                return issued.getUserID();
            case DATE_BORROWED_COL:
                return issued.getDateBorrowed();
            case DATE_DUE_COL:
                return issued.getDateDue();
            case OBJECT_COL:
                return issued;
            default: 
                return issued.getBookID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
}

