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
import java.sql.Timestamp;
import com.dbms.jdbc.mysql.core.Accounts;
import com.dbms.jdbc.mysql.core.AccountsHistory;
import com.dbms.jdbc.mysql.core.EncryptPassword;

public class AccountsDAO extends EncryptPassword {
    private Connection myConn;
    
    public AccountsDAO()throws SQLException{
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
    
    public void RegisterAccount(Accounts acc)throws SQLException {
        PreparedStatement pst = null;
        try{
            
            pst = myConn.prepareStatement("INSERT INTO Accounts(UserID,Last_Name,First_Name,Password,Position,Status,Level) "
                    + " VALUES(?,?,?,?,?,?,?)");
            
            pst.setString(1,acc.getUserID());
            pst.setString(2,acc.getUserLastName());
            pst.setString(3,acc.getUserFirstName());
            pst.setString(4,getHash(acc.getUserPassword().getBytes(),"MD5"));
            pst.setString(5,acc.getUserPosition());
            pst.setBoolean(6,acc.getUserStatus());
            pst.setInt(7,1);
            
            pst.executeUpdate();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,null);
        }
    }
    
    public void DeleteAccount(String userID)throws SQLException{
        PreparedStatement pst = null;
        try{
            myConn.setAutoCommit(false);
            
            /* Delete from existing child tables */
            
            pst = myConn.prepareStatement("DELETE FROM account_history WHERE user_id = ?");
            pst.setString(1,userID);
            pst.executeUpdate();
            
            pst = myConn.prepareStatement("DELETE FROM login_history WHERE UserID = ?");
            pst.setString(1,userID);
            pst.executeUpdate();
            
            pst = myConn.prepareStatement("DELETE FROM book_history WHERE admin_id = ?");
            pst.setString(1,userID);
            pst.executeUpdate();
            
            /* Then delete from accounts table */
            
            pst = myConn.prepareStatement("DELETE FROM Accounts WHERE UserID = ?");
            
            pst.setString(1,userID);
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
    
    public void BlockAccount(String userID,String adminID,boolean block)throws SQLException{
        PreparedStatement pst = null;
        try{
            myConn.setAutoCommit(false);
            pst = myConn.prepareStatement("UPDATE Accounts Set Status = ?  WHERE UserID = ?");
            
            pst.setBoolean(1, block);
            pst.setString(2,userID);
            
            pst.executeUpdate();
            
            /* Record action */
            
            pst = myConn.prepareStatement("INSERT INTO account_history (user_id,action,admin_id,datetime) "
                    + "VALUES(?,?,?,?)");
            
            pst.setString(1,userID);
            if(block){
                pst.setString(2,"Blocked Account");
            }
            else{
                pst.setString(2,"Unblocked Account");
            }
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
    
    public void AssignStudent(String userID,String adminID, String pos)throws SQLException{
        PreparedStatement pst = null;
        try{
            myConn.setAutoCommit(false);
            pst = myConn.prepareStatement("UPDATE Accounts SET Position = ? , Level = ? WHERE UserID = ?");
            pst.setString(1, pos);
            switch(pos){
                case "Administrator":
                    pst.setInt(2,3);
                    break;
                case "Student Assistant":
                    pst.setInt(2,2);
                    break;
                case "Student":
                    pst.setInt(2,1);
                    break;
            }
            pst.setString(3,userID);
            
            pst.executeUpdate();
            
            /* Record action */
            
            pst = myConn.prepareStatement("INSERT INTO account_history (user_id,action,admin_id,datetime) "
                    + "VALUES(?,?,?,?)");
            
            pst.setString(1,userID);
            pst.setString(2,"Assigned as " + pos);
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
    
    public void ChangePassword(String userID,String adminID,String newPass)throws SQLException{
        PreparedStatement pst = null;
        try{
            myConn.setAutoCommit(false);
            pst = myConn.prepareStatement("UPDATE Accounts SET Password = ? WHERE UserID = ?");
            
            pst.setString(1,getHash(newPass.getBytes(),"MD5"));
            pst.setString(2,userID);
            
            pst.executeUpdate();
            /* Record action */
            
            pst = myConn.prepareStatement("INSERT INTO account_history (user_id,action,admin_id,datetime) "
                    + "VALUES(?,?,?,?)");
            
            pst.setString(1,userID);
            pst.setString(2,"Reset Password");
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
    
    public void recordLogin(String userID,String pos)throws SQLException{
        PreparedStatement pst = null;
        try{
            pst = myConn.prepareStatement("INSERT INTO login_history VALUES(?,?,?)");
            pst.setString(1,userID);
            pst.setString(2,pos);
            pst.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
            
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,null);
        }
    }
    
    public String getFullName(String userID)throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String fullname = new String();
        try{
            pst = myConn.prepareStatement("SELECT First_Name, Last_Name FROM Accounts WHERE UserID = ?");
            
            pst.setString(1, userID);
            rs = pst.executeQuery();
           
            while(rs.next()){
                fullname = rs.getString("First_Name") + " " + rs.getString("Last_Name");
            }
             
            
            return fullname;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        
        return fullname;
    }
    
    public String getUserPosition(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        String pos = new String();
        try{
            pst = myConn.prepareStatement("SELECT Position FROM accounts WHERE UserID = ?");
            pst.setString(1,userID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                pos = rs.getString("Position");
            }
            return pos;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return pos;
    }
    
    public boolean checkIfStudAsst(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT Position FROM Accounts WHERE UserID = ?");
            
            pst.setString(1, userID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("Position").equals("Student Assistant")){
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
    
    public boolean checkIfAdmin(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT Position FROM Accounts WHERE UserID = ?");
            
            pst.setString(1,userID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                    if(rs.getString("Position").equals("Administrator")){
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
    
    public boolean checkIfBlocked(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT Status FROM Accounts WHERE UserID = ?");
            
            pst.setString(1,userID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getBoolean("Status") == true){
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
    
    public boolean checkIfExist(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT UserID FROM Accounts");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("UserID").equals(userID)){
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
    
    public boolean checkUserCredentials(String userID,String pass)throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT UserID, Password FROM Accounts");
            
            rs = pst.executeQuery();
            while(rs.next()){
                if(rs.getString("UserID").equals(userID) 
                   && getHash(pass.getBytes(),"MD5").equals(rs.getString("Password"))){
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
    
    public boolean checkIfBorrowed(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT UserID FROM issued_books");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("UserID").equals(userID)){
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
    
    public String getFullStatus(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        String status = new String();
        try{
            pst = myConn.prepareStatement("SELECT Status FROM Accounts WHERE UserID = ?");
            
            pst.setString(1, userID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getBoolean("Status")){
                    status = "Blocked";
                }
                else{
                    status = "Active";
                }
            }
            
            return status;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        
        return status;
    }
    
    
    public ArrayList<Accounts> getAllAccounts()throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Accounts> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM accounts ORDER BY Level DESC");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                Accounts acc = convertRowToAccount(rs);
                list.add(acc);
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
    
    public ArrayList<Accounts> searchAccount(String search)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Accounts> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM accounts WHERE CONCAT(UserID,First_Name,Last_Name) "
                    + "like '%"+search+"%' ORDER BY Level DESC");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                Accounts acc = convertRowToAccount(rs);
                list.add(acc);
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
    
    private Accounts convertRowToAccount(ResultSet rs)throws SQLException{
        String userID = rs.getString("UserID");
        String lastName = rs.getString("Last_Name");
        String firstName = rs.getString("First_Name");
        String password = rs.getString("Password");
        String position = rs.getString("Position");
        boolean status = rs.getBoolean("Status");
        
        Accounts account = new Accounts(userID,lastName,firstName,password,position,status);
        
        return account;
        
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
