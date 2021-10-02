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
public class BooksHistory {
    private String BookID;
    private String Action;
    private String AdminID;
    private Date DateTime;
    
    public BooksHistory(String bkID,String act, String adminID,Date datetime){
        super();
        this.BookID = bkID;
        this.Action = act;
        this.AdminID = adminID;
        this.DateTime = datetime;
    }
    
    /* Setter Methods */
    
    public void setBookID(String bkID){
        this.BookID = bkID;
    }
    
    public void setAction(String act){
        this.Action = act;
    }
    
    public void setAdminID(String adminID){
        this.AdminID = adminID;
    }
    
    public void setDateTime(Date datetime){
        this.DateTime = datetime;
    }
    
    /* Getter Methods */
    
    public String getBookID(){
        return BookID;
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
}
    

