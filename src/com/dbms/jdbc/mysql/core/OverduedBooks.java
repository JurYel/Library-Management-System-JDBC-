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
public class OverduedBooks {
    private String UserID;
    private String Overdued;
    private String BookID;
    private Date DateDue;
    private Date DateBorrowed;
    private String DaysDue;
    
    public OverduedBooks(String userID,String overdued, 
            String bookID, Date due, Date brwd, String daysdue){
        super();
        this.UserID = userID;
        this.Overdued = overdued;
        this.BookID = bookID;
        this.DateDue = due;
        this.DateBorrowed = brwd;
        this.DaysDue = daysdue;
    }
    
    public void setUserID(String userID){
        this.UserID = userID;
    }
    
    public void setOverdued(String dued){
        this.Overdued = dued;
    }
    
    public void setBookID(String bkID){
        this.BookID = bkID;
    }
    
    public void setDateDue(Date due){
        this.DateDue = due;
    }
    
    public void setDateBorrowed(Date brwd){
        this.DateBorrowed = brwd;
    }
    
    public void setDaysDue(String days){
        this.DaysDue = days;
    }
    
    /* Getter methods */
    
    public String getUserID(){
        return UserID;
    }
    
    public String getOverdued(){
        return Overdued;
    }
    
    public String getBookID(){
        return BookID;
    }
    
    public Date getDateDue(){
        return DateDue;
    }
    
    public Date getDateBorrowed(){
        return DateBorrowed;
    }
    
    public String getDaysDue(){
        return DaysDue;
    }
}
