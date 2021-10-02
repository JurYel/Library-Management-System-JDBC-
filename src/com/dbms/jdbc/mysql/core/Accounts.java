/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.core;

/**
 *
 * @author Jur Yel
 */
import com.dbms.jdbc.mysql.dao.AccountsDAO;
import java.sql.SQLException;

public class Accounts extends AccountsDAO {
    private String UserID;
    private String LastName;
    private String FirstName;
    private String Position;
    private String Password;
    private boolean Status;
    
    public Accounts(String id,String last, String first,
                     String pass, String pos,boolean stat)throws SQLException{
        super();
        this.UserID = id;
        this.LastName = last;
        this.FirstName = first;
        this.Password = pass;
        this.Position = pos;
        this.Status = stat;
    }
    
    public void setUserID(String id){
        this.UserID = id;
    }
    
    public void setUserLastName(String last){
        this.LastName = last;
    }
    
    public void setUserFirstName(String first){
        this.FirstName = first;
    }
    
    public void setUserPosition(String pos){
        this.Position = pos;
    }
    
    public void setUserPassword(String pass){
        this.Password = pass;
    }
    
    public void setUserStatus(boolean stat){
        this.Status = stat;
    }
    
    /* Get Methods */
    
    public String getUserID(){
        return UserID;
    }
    
    public String getUserLastName(){
        return LastName;
    }
    
    public String getUserFirstName(){
        return FirstName;
    }
    
    public String getUserPosition(){
        return Position;
    }
    
    public String getUserPassword(){
        return Password;
    }
    
    public boolean getUserStatus(){
        return Status;
    }
    
    public String getStatus(String userID)throws SQLException{
        return (super.getFullStatus(userID));
    }
}
