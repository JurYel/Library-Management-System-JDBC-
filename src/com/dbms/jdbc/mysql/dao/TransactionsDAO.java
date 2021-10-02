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
import java.sql.Timestamp;
import java.io.FileInputStream;
import com.dbms.jdbc.mysql.core.Transactions;

public class TransactionsDAO {
    private Connection myConn;
    
    public TransactionsDAO()throws SQLException{
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
    
    public ArrayList<Transactions> getTransactions()throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Transactions> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT trans_id,user_id,transaction,book_id,admin_id, "
                    + "DATE_FORMAT(date_transaction,'%M %e, %Y - %l:%i %p') as date_transaction FROM transactions ORDER BY date_transaction DESC");
            rs = pst.executeQuery();
            
            while(rs.next()){
                Transactions transaction = convertRowToTransaction(rs);
                list.add(transaction);
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
    
    public ArrayList<Transactions> searchTransactions(String key )throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Transactions> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT trans_id,user_id,transaction,book_id,admin_id, "
                    + "DATE_FORMAT(date_transaction,'%M %e, %Y - %l:%i %p') as date_transaction FROM transactions "
                    + "WHERE CONCAT(user_id,transaction,book_id,admin_id) like '%"+key+"%' "
                            + "ORDER BY date_transaction DESC");
            rs = pst.executeQuery();
            
            while(rs.next()){
                Transactions transaction = convertRowToTransaction(rs);
                list.add(transaction);
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
    
    private Transactions convertRowToTransaction(ResultSet rs)throws SQLException{
        String UserID = rs.getString("user_id");
        String transaction = rs.getString("transaction");
        String bookID = rs.getString("book_id");
        String adminID = rs.getString("admin_id");
//        java.util.Date dateTransaction = convertSQLToUtil(rs.getTimestamp("date_transaction"));
        String datetime = rs.getString("date_transaction");
        
        Transactions trans = new Transactions(UserID,transaction,bookID,adminID,null);
        trans.setDateTime(datetime);
        return trans;
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
