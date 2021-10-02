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
import java.util.Date;
public class AccountsHistory {
    private String UserID;
    private String Action;
    private String AdminID;
    private Date DateTime;
    private String alterTime;
    
    public AccountsHistory(String userID, String action, String adminID, Date datetime){
        super();
        this.UserID = userID;
        this.Action = action;
        this.AdminID = adminID;
        this.DateTime = datetime;
    }
    
    public void setUseriD(String userID){
        this.UserID = userID;
    }
    
    public void setAction(String act){
        this.Action = act;
    }
    
    public void setAdminID(String adminID){
        this.AdminID = adminID;
    }
    
    public void setDateTime(Date date){
        this.DateTime = date;
    }
    
    public void setAlterTime(String time){
        this.alterTime = time;
    }
    
    /* Getter Methods */
    
    public String getUserID(){
        return UserID;
    }
    
    public String getAction(){
        return Action;
    }
    
    public String getAdminID(){
        return AdminID;
    }
    
    public String getDateTime(){
        return DateTime.toLocaleString();
    }
    
    public String getAlterTime(){
        return alterTime;
    }
}
    

