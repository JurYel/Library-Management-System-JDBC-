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
import com.dbms.jdbc.mysql.core.BooksHistory;

public class BooksHistoryDAO {
    private Connection myConn;
    
    public BooksHistoryDAO()throws SQLException {
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
    
    public ArrayList<BooksHistory> getBooksHistory()throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<BooksHistory> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM book_history");
            rs = pst.executeQuery();
            
            while(rs.next()){
                BooksHistory history = convertRowToHistory(rs);
                list.add(history);
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
    
    public ArrayList<BooksHistory> searchBookHistory(String key)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<BooksHistory> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM book_history WHERE CONCAT(book_id,action,admin_id)"
                    + " like '%"+key+"%'");
            rs = pst.executeQuery();
            
            while(rs.next()){
                BooksHistory history = convertRowToHistory(rs);
                list.add(history);
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
    
    private java.util.Date convertSQLToUtil(Timestamp timestamp){
        java.util.Date uDate = new java.util.Date(timestamp.getTime());
        return uDate;
    }
    
    private BooksHistory convertRowToHistory(ResultSet rs)throws SQLException{
        String bookID = rs.getString("book_id");
        String action = rs.getString("action");
        String admin_id = rs.getString("admin_id");
        java.util.Date datetime = convertSQLToUtil(rs.getTimestamp("datetime"));
        
        BooksHistory history = new BooksHistory(bookID,action,admin_id,datetime);
        
        return history;
    }
    
    private void close(PreparedStatement pst, ResultSet rs)throws SQLException {
        if(pst!= null){
            pst.close();
        }
        if(rs!=null){
            rs.close();
        }
    }
    
}
