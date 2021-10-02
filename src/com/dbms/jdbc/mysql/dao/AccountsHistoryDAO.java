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
import com.dbms.jdbc.mysql.core.AccountsHistory;
import java.sql.Timestamp;

public class AccountsHistoryDAO {
    private Connection myConn;
    
    public AccountsHistoryDAO(){
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
    
    public ArrayList<AccountsHistory> getAllAccountsHistory()throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<AccountsHistory> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT acc_history_id,user_id,action,admin_id, "
                    + "DATE_FORMAT(datetime,'%M %e, %Y - %l:%i %p')as datetime FROM account_history ORDER BY datetime DESC");
            rs = pst.executeQuery();
            
            while(rs.next()){
                AccountsHistory history = convertRowToHistory(rs);
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
    
    public ArrayList<AccountsHistory> getUserHistory(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<AccountsHistory> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT acc_history_id,user_id,action,admin_id, "
                    + "DATE_FORMAT(datetime,'%M %e, %Y - %l:%i %p')as datetime FROM account_history WHERE user_id = ? ORDER BY datetime DESC");
            pst.setString(1,userID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                AccountsHistory history = convertRowToHistory(rs);
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
    
    public ArrayList<AccountsHistory> searchAccountHistory(String key)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<AccountsHistory> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT acc_history_id,user_id,action,admin_id, "
                    + "DATE_FORMAT(datetime,'%M %e, %Y - %l:%i %p') as datetime FROM account_history WHERE CONCAT(user_id,action,admin_id,datetime) "
                    + "like '%"+key+"%' ORDER BY datetime DESC ");
           rs = pst.executeQuery();
           
           while(rs.next()){
               AccountsHistory history = convertRowToHistory(rs);
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
    
    private Date convertSQLToUtil(Timestamp timestamp){
        Date uDate = new Date(timestamp.getTime());
        return uDate;
    }
    
    private AccountsHistory convertRowToHistory(ResultSet rs)throws SQLException{
        String userID = rs.getString("User_ID");
        String action = rs.getString("Action");
        String adminID = rs.getString("Admin_ID");
//        Date datetime = convertSQLToUtil(rs.getTimestamp("DateTime
        String alterTime = rs.getString("datetime");
        
        AccountsHistory history = new AccountsHistory(userID,action,adminID,null);
        history.setAlterTime(alterTime);
        return history;
        
    }
    
    private void close(PreparedStatement pst, ResultSet rs)throws SQLException{
        if(pst!= null){
            pst.close();
        }
        if(rs!=null){
            rs.close();
        }
    }
}
