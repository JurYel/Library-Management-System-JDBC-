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
import com.dbms.jdbc.mysql.core.LoginHistory;

public class LoginHistoryDAO {
    private Connection myConn;
    
    public LoginHistoryDAO()throws SQLException{
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
    
    public ArrayList<LoginHistory> getLoginHistory()throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<LoginHistory> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT log.UserID,acc.First_Name,acc.Last_Name, "
                    + "log.position, DATE_FORMAT(datetime,'%M %e, %Y - %l:%i %p') as datetime FROM login_history as log, accounts as acc "
                    + "WHERE log.UserID = acc.UserID ORDER BY datetime DESC");
            
            rs = pst.executeQuery();
            while(rs.next()){
                LoginHistory login = convertRowToHistory(rs);
                list.add(login);
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
    
    public ArrayList<LoginHistory> searchLoginHistory(String key)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<LoginHistory> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT log.UserID,acc.First_Name,acc.Last_Name, "
                    + "log.position,DATE_FORMAT(datetime,'%M %e, %Y - %l:%i %p') as datetime FROM login_history as log,accounts as acc "
                    + "WHERE CONCAT(log.UserID,acc.First_Name,acc.Last_Name,log.Position) "
                    + "like '%"+key+"%' AND log.UserID = acc.UserID ORDER BY datetime DESC");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                LoginHistory login = convertRowToHistory(rs);
                list.add(login);
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
    
    private LoginHistory convertRowToHistory(ResultSet rs)throws SQLException{
        String userID = rs.getString("log.UserID");
        String first = rs.getString("acc.First_Name");
        String last = rs.getString("acc.Last_Name");
        String position = rs.getString("log.position");
        String loginTime = rs.getString("datetime");
//        java.util.Date datetime = convertSQLToUtil(rs.getTimestamp("datetime"));
        
        LoginHistory history = new LoginHistory(userID,first,last,position,null);
        history.setLoginTime(loginTime);
        
        return history;
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
