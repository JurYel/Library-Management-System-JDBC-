/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.dao;

/**
 *
 * @author Jur Yel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.sql.Timestamp;
import com.dbms.jdbc.mysql.core.Books;

public class BooksDAO {
    private Connection myConn;
    
    public BooksDAO()throws SQLException{
        try{
            Properties props = new Properties();
            props.load(new FileInputStream("sql/lbms_db.properties"));
            
            String user = props.getProperty("user");
            String pass = props.getProperty("password");
            String dburl = props.getProperty("dburl");
            
            myConn = DriverManager.getConnection(dburl,user,pass);
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
    
    public void AddBooks(Books book,String adminID)throws SQLException {
        PreparedStatement pst = null;
        try{
            myConn.setAutoCommit(false);
            pst = myConn.prepareStatement("INSERT INTO bookrecords(Category,Book_ID,Book_Title,Book_Author,"
                    + "YearPublished,Quantity) VALUES(?,?,?,?,?,?) ");
            pst.setString(1,book.getBookCategory());
            pst.setString(2,book.getBookID());
            pst.setString(3,book.getBookTitle());
            pst.setString(4,book.getBookAuthor());
            pst.setInt(5,book.getYearPublished());
            pst.setInt(6,book.getQuantity());
            
            pst.executeUpdate();
            
            pst = myConn.prepareStatement("INSERT INTO book_location VALUES(?,?)");
            pst.setString(1,book.getBookID());
            pst.setInt(2,book.getRack());
            
            pst.executeUpdate();
            
            /* Record activity */
             
            pst = myConn.prepareStatement("INSERT INTO book_history(book_id,action,admin_id,datetime) "
                    + "VALUES(?,?,?,?)");
            pst.setString(1,book.getBookID());
            pst.setString(2,"Added New Book");
            pst.setString(3,adminID);
            pst.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
            
            pst.executeUpdate();
            
            myConn.commit();
        }
        catch(Exception exc){
            exc.printStackTrace();
            myConn.rollback();
        }
        finally{
            close(pst,null);
        }
    }
    
    public void DeleteBooks(String bookID)throws SQLException{
        PreparedStatement pst = null;
        try{
            myConn.setAutoCommit(false);
            pst = myConn.prepareStatement("DELETE FROM book_history WHERE book_id = ?");
            pst.setString(1,bookID);
            pst.executeUpdate();
            
            /* Delete first from child table book_location */
            pst = myConn.prepareStatement("DELETE FROM book_location WHERE Book_ID = ?");
            
            pst.setString(1, bookID);
            pst.executeUpdate();
            
            /* Delete from Parent Table Book Records */
            
            pst = myConn.prepareStatement("DELETE FROM bookrecords WHERE Book_ID = ?");
            
            pst.setString(1,bookID);
            pst.executeUpdate();
            
            myConn.commit();
            
            
        }
        catch(Exception exc){
            exc.printStackTrace();
            myConn.rollback();
        }
        finally{
            close(pst,null);
        }
    }
    
    public void UpdateBooks(Books book,String adminID)throws SQLException{
        PreparedStatement pst = null;
        try{
            myConn.setAutoCommit(false);
            
            /* Update first the child table */
            
            pst = myConn.prepareStatement("UPDATE book_location SET rack = ? WHERE book_id = ?");
            pst.setInt(1,book.getRack());
            pst.setString(2,book.getBookID());
            
            pst.executeUpdate();
            
            
            /* Update the parent table */
            
            pst = myConn.prepareStatement("UPDATE bookrecords SET Category = ? , Book_ID = ? , Book_Title = ? , "
                                        + " Book_Author = ? , YearPublished = ? , Quantity = ? WHERE Book_ID = ?");
            pst.setString(1,book.getBookCategory());
            pst.setString(2,book.getBookID());
            pst.setString(3,book.getBookTitle());
            pst.setString(4,book.getBookAuthor());
            pst.setInt(5,book.getYearPublished());
            pst.setInt(6,book.getQuantity());
            pst.setString(7,book.getBookID());
            
            pst.executeUpdate();
            
            /* Record Activity */
            
            pst = myConn.prepareStatement("INSERT INTO book_history(book_id,action,admin_id,datetime) "
                    + "VALUES(?,?,?,?)");
            pst.setString(1,book.getBookID());
            pst.setString(2,"Updated Book");
            pst.setString(3,adminID);
            pst.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
            
            pst.executeUpdate();
            
            myConn.commit();
        }
        catch(Exception exc){
            exc.printStackTrace();
            myConn.rollback();
        }
        finally{
            close(pst,null);
        }
    }
    
    public void AddToQuantity(String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        int qty = 0;
        try{
            myConn.setAutoCommit(false);
            
            pst = myConn.prepareStatement("SELECT Quantity FROM bookrecords WHERE Book_ID = ?");
            pst.setString(1, bookID);
            rs = pst.executeQuery();
            while(rs.next()){
                qty = rs.getInt("Quantity");
            }
            
            /* Increment Quantity */
            
            pst = myConn.prepareStatement("UPDATE bookrecords SET Quantity = ? WHERE Book_ID = ?");
            pst.setInt(1,(qty+1));
            pst.setString(2, bookID);
            pst.executeUpdate();
            
            pst.executeUpdate();
            
        }
        catch(Exception exc){
            exc.printStackTrace();
            myConn.rollback();
        }
        finally{
            close(pst,null);
        }
    }
    
   
    public boolean checkIfBorrowed(String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT Book_ID, UserID FROM issued_books");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("Book_ID").equals(bookID)){
                    return true;
                }
            }
            return false;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return false;
    }
    
    public boolean checkBookID(String bookID)throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT Book_ID FROM bookrecords");
            
            rs = pst.executeQuery();
            while(rs.next()){
                if(rs.getString("Book_ID").equals(bookID)){
                    return true;
                }
                
            }
            return false;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return false;
    }
    
    public String getBookTitle(String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        String title = new String();
        try{
            pst = myConn.prepareStatement("SELECT BookTitle FROM bookrecords WHERE Book_ID = ?");
            pst.setString(1,bookID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                title = rs.getString("BookTitle");
            }
            return title;
            
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return title;
    }
    
    public int getBookQuantity(String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        int total = 0;
        try{
            pst = myConn.prepareStatement("SELECT Quantity FROM bookrecords WHERE Book_ID = ?");
            
            pst.setString(1,bookID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                total = rs.getInt("Quantity");
            }
            
            return total;
            
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        
        return total;
    }
    
    public ArrayList<Books> getAllBooks()throws SQLException{
        PreparedStatement pst  = null;
        ResultSet rs = null;
        ArrayList<Books> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT Category, br.Book_ID, Book_Title, Book_Author, YearPublished, Quantity, Rack "
                                        + "FROM bookrecords as br, book_location as bk WHERE br.Book_ID = bk.book_id "
                                        + "ORDER BY Category ASC");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(!(rs.getInt("Quantity") == 0)){
                    Books book = convertRowToBooks(rs);
                    list.add(book);
                }
                
            }
            return list;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return list;
    }
    
    public ArrayList<Books> searchBook(String key)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Books> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT Category, br.Book_ID, Book_Title, Book_Author, YearPublished, Quantity, Rack "
                                        + "FROM bookrecords as br, book_location as bk "
                                        + "WHERE CONCAT(Category,br.Book_ID,Book_Title,Book_Author,YearPublished,Rack) like '%"+key+"%' "
                                        + "AND br.Book_ID = bk.book_id ORDER BY Category ASC");
            rs = pst.executeQuery();
            
            while(rs.next()){
                 if(!(rs.getInt("Quantity") == 0)){
                    Books book = convertRowToBooks(rs);
                    list.add(book);
                }
            }
            
            return list;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return list;
    }
    
    private Books convertRowToBooks(ResultSet rs)throws SQLException{
        String cat = rs.getString("Category");
        String id = rs.getString("br.Book_ID");
        String title = rs.getString("Book_Title");
        String author = rs.getString("Book_Author");
        int year = rs.getInt("YearPublished");
        int qty = rs.getInt("Quantity");
        int rack = rs.getInt("Rack");
        
        Books book = new Books(cat,id,title,author,rack,year,qty);
        
        return book;
        
    }
    
    private void close(PreparedStatement pst, ResultSet rs)throws SQLException{
        if(pst!=null){
            pst.close();
        }
        if(rs != null){
            rs.close();
        }
    }
}
