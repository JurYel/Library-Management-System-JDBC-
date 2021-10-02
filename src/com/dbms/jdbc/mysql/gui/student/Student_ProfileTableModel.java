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
import java.util.ArrayList;
import com.dbms.jdbc.mysql.core.IssuedBooks;
import javax.swing.table.AbstractTableModel;
public class Student_ProfileTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int BOOK_ID_COL = 0;
    private static final int BOOK_TITLE_COL = 1;
    private static final int DATE_BORROWED_COL = 2;
    private static final int DATE_DUE_COL = 3;
    
    private String[] columnNames = {"Book ID","Book Title","Date Borrowed","Date Due"};
    private ArrayList<IssuedBooks> issuedBooks;
    
    public Student_ProfileTableModel(ArrayList<IssuedBooks> list){
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
        IssuedBooks issuedBook = issuedBooks.get(row);
        
        switch(col){
            case BOOK_ID_COL:
                return issuedBook.getBookID();
            case BOOK_TITLE_COL:
                return issuedBook.getBookTitle();
            case DATE_BORROWED_COL:
                return issuedBook.getDateBorrowed();
            case DATE_DUE_COL:
                return issuedBook.getDateDue();
            case OBJECT_COL:
                return issuedBook;
            default: 
                return issuedBook.getBookID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
}
