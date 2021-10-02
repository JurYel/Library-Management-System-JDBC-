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
public class Transactions {
    private String UserID;
    private String Transaction;
    private String BookID;
    private String AdminID;
    private Date DateTransaction;
    private String datetime;
    
    public Transactions(String userID,String trans,String bookID,String adminID,Date dateTrans){
        super();
        this.UserID = userID;
        this.Transaction = trans;
        this.BookID = bookID;
        this.AdminID = adminID;
        this.DateTransaction = dateTrans;
    }
    
    public void setUserID(String userID){
        this.UserID = userID;
    }
    
    public void setTransaction(String trans){
        this.Transaction = trans;
    }
    
    public void setBookID(String bookID){
        this.BookID = bookID;
    }
    
    public void setAdminID(String adminID){
        this.AdminID = adminID;
    }
    
    public void setDateTransaction(Date date){
        this.DateTransaction = date;
    }
    
    public void setDateTime(String time){
        this.datetime = time;
    }
    
    /* Getter Methods */
    
    public String getUserID(){
        return UserID;
    }
    
    public String getTransaction(){
        return Transaction;
    }
    
    public String getBookID(){
        return BookID;
    }
    
    public String getAdminID(){
        return AdminID;
    }
    
    public Date getDateTransaction(){
        return DateTransaction;
    }
    
    public String getTransactionTimestamp(){
        return DateTransaction.toLocaleString();
    }
    
    public String getDateTime(){
        return datetime;
    }
}
