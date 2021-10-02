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
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.io.FileInputStream;
import com.dbms.jdbc.mysql.core.ReturnedBooks;
public class ReturnedBooksDAO {
    private Connection myConn;
    
    public ReturnedBooksDAO()throws SQLException{
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
    
    public ArrayList<ReturnedBooks> getReturnedBooks()throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ReturnedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM returned_books");
            rs = pst.executeQuery();
            
            while(rs.next()){
                ReturnedBooks book = convertRowToReturnedBook(rs);
                list.add(book);
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
    
    public ArrayList<ReturnedBooks> searchReturnedBook(String search)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ReturnedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM returned_books "
                    + "WHERE CONCAT(user_id,book_id,date_returned) like '%"+search+"%'");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                ReturnedBooks book = convertRowToReturnedBook(rs);
                list.add(book);
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
    
    private java.sql.Date convertUtilToSQL(Date uDate){
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
    private ReturnedBooks convertRowToReturnedBook(ResultSet rs)throws SQLException{
        String userID = rs.getString("user_id");
        String status = rs.getString("book_status");
        String bookID = rs.getString("book_id");
        Date returned = rs.getDate("date_returned");
        
        ReturnedBooks returnedBook = new ReturnedBooks(userID,status,bookID,returned);
        return returnedBook;
    }
            
    
    private void close(PreparedStatement pst, ResultSet rs )throws SQLException{
        if(pst!=null){
            pst.close();
        }
        if(rs!=null){
            rs.close();
        }
    }
}
