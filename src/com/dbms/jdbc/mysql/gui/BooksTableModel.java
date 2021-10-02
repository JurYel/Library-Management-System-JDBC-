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
import com.dbms.jdbc.mysql.core.Books;
import javax.swing.table.AbstractTableModel;
public class BooksTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int CATEGORY_COL = 0;
    private static final int BOOK_ID_COL = 1;
    private static final int BOOK_TITLE_COL = 2;
    private static final int BOOK_AUTHOR_COL = 3;
    private static final int RACK_COL = 4;
    private static final int YEARPUBLISHED_COL = 5;
    private static final int QUANTITY_COL = 6;
   
    private String[] columnNames = {"Category","Book ID","Book Title","Book Author","Rack","Year Published","Quantity"};
    private ArrayList<Books> books;
    
    public BooksTableModel(ArrayList<Books> list){
        this.books = list;
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return books.size();
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row, int col){
        Books book = books.get(row);
        
        switch(col){
            case CATEGORY_COL:
                return book.getBookCategory();
            case BOOK_ID_COL:
                return book.getBookID();
            case BOOK_TITLE_COL:
                return book.getBookTitle();
            case BOOK_AUTHOR_COL:
                return book.getBookAuthor();
            case RACK_COL:
                return book.getRack();
            case YEARPUBLISHED_COL:
                return book.getYearPublished();
            case QUANTITY_COL:
                return book.getQuantity();
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
