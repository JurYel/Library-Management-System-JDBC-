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
import java.util.Properties;
import java.io.FileInputStream;
import java.util.Date;
import com.dbms.jdbc.mysql.core.OverduedBooks;

public class OverduedBooksDAO {
    private Connection myConn;
    
    public OverduedBooksDAO()throws SQLException{
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
    
    public ArrayList<OverduedBooks> getOveduedBooks()throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<OverduedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM overdued_books");
            
            rs = pst.executeQuery();
            while(rs.next()){
                OverduedBooks overdued = convertRowToOverduedBook(rs);
                list.add(overdued);
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
    
    public ArrayList<OverduedBooks> searchOverduedBook(String key)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<OverduedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM overdued_books "
                    + "WHERE CONCAT(user_id,book_id) like '%"+key+"%'");
            
            rs = pst.executeQuery();
            while(rs.next()){
                OverduedBooks overdued = convertRowToOverduedBook(rs);
                list.add(overdued);
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
    
    private OverduedBooks convertRowToOverduedBook(ResultSet rs )throws SQLException{
        String userID = rs.getString("user_id");
        String overdued = rs.getString("overdued");
        String bookID = rs.getString("book_id");
        Date due = rs.getDate("due_date");
        Date brwd = rs.getDate("date_borrowed");
        String days_due = rs.getString("days_due");
        
        OverduedBooks overduedBook = new OverduedBooks(userID,overdued,bookID,due,brwd,days_due);
        
        return overduedBook;
    }
            
    
    private void close(PreparedStatement pst, ResultSet rs)throws SQLException{
        if(pst!=null){
            pst.close();
        }
        if(rs!=null){
            rs.close();
        }
    }
}
