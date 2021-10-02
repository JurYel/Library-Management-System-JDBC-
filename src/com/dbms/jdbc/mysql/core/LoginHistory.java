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
public class LoginHistory {
    private String UseriD;
    private String FirstName;
    private String LastName;
    private String Position;
    private Date DateTime;
    private String loginTime;
    
    public LoginHistory(String userID,String first, String last,String pos,Date datetime){
        super();
        this.UseriD = userID;
        this.FirstName = first;
        this.LastName = last;
        this.Position = pos;
        this.DateTime = datetime;
    }
    
    /* Setter Methods */
    
    public void setUserID(String userID){
        this.UseriD = userID;
    }
    
    public void setFirstName(String first){
        this.FirstName = first;
    }
    
    public void setLastName(String last){
        this.LastName = last;
    }
    
    public void setPosition(String position){
        this.Position = position;
    }
    
    public void setDateTime(Date datetime){
        this.DateTime = datetime;
        
    }
    
    public void setLoginTime(String time){
        this.loginTime = time;
    }
    
    /* Getter Methods */
    
    public String getUserID(){
        return UseriD;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    
    public String getLastName(){
        return LastName;
    }
    
    public String getFullName(){
        return String.format("%s %s",FirstName,LastName);
    }
    
    public String getPosition(){
        return Position;
    }
    
    public String getDateTime(){
        return DateTime.toLocaleString();
    }
    
    public String getLoginTime(){
        return loginTime;
    }
    
}
