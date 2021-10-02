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
public class IssuedBooks {
    private String BookID;
    private String BookTitle;
    private String UserID;
    private Date DateBorrowed;
    private Date DateDue;
    
    public IssuedBooks(String bookID, String title, String userID, Date dateBrwd, Date due){
        super();
        this.BookID = bookID;
        this.BookTitle = title;
        this.UserID = userID;
        this.DateBorrowed = dateBrwd;
        this.DateDue = due;
    }
    
    public void setBookID(String id){
        this.BookID = id;
    }
    
    public void setBookTitle(String title){
        this.BookTitle = title;
    }
    
    public void setUserID(String userID){
        this.UserID = userID;
    }
    
    public void setDateBorrowed(Date date){
        this.DateBorrowed = date;
    }
    
    public void setDateDue(Date due){
        this.DateDue = due;
    }
    
    /* Getter Methods */
    
    public String getBookID(){
        return BookID;
    }
    
    public String getBookTitle(){
        return BookTitle;
    }
    
    public String getUserID(){
        return UserID;
    }
    
    public Date getDateBorrowed(){
        return DateBorrowed;
    }
    
    public Date getDateDue(){
        return DateDue;
    }
    
    public String getBorrowedDate(){
        return DateBorrowed.toGMTString();
    }
    
    public String getDueDate(){
        return DateDue.toGMTString();
    }
}
    

