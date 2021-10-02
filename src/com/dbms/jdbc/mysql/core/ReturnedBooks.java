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
public class ReturnedBooks {
    private String UserID;
    private String Status;
    private String BookID;
    private Date DateReturned;
    
    public ReturnedBooks(String userID, String stat, String bookID, Date returned){
        super();
        this.UserID = userID;
        this.Status = stat;
        this.BookID = bookID;
        this.DateReturned = returned;
    }
    
    public void setUserID(String userID){
        this.UserID = userID;
    }
    
    public void setStatus(String status){
        this.Status = status;
    }
    
    public void setBookID(String bookID){
        this.BookID = bookID;
    }
    
    public void setDateReturned(Date returned){
        this.DateReturned = returned;
    }
    
    /* Getter methods */
    
    public String getUserID(){
        return UserID;
    }
    
    public String getBookStatus(){
        return Status;
    }
    
    public String getBookID(){
        return BookID;
    }
    
    public Date getDateReturned(){
        return DateReturned;
    }
}
