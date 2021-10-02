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
public class Books {
    private String Category;
    private String BookID;
    private String BookTitle;
    private String BookAuthor;
    private int YearPublished;
    private int Quantity;
    private int Rack;
    
    public Books(String cat, String id, String title, String author,int rack, int year, int qty ){
        super();
        this.Category = cat;
        this.BookID = id;
        this.BookTitle = title;
        this.BookAuthor = author;
        this.Rack = rack;
        this.YearPublished = year;
        this.Quantity = qty;
    }
    
    public void setBookCategory(String cat){
        this.Category = cat;
    }
    
    public void setBookID(String id){
        this.BookID = id;
    }
    
    public void setBookTitle(String title){
        this.BookTitle = title;
    }
    
    public void setBookAuthor(String author){
        this.BookAuthor = author;
    }
    
    public void setYearPublished(int year){
        this.YearPublished = year;
    }
    
    public void setQuantity(int qty){
        this.Quantity = qty;
    }
    
    public void setRack(int rack){
        this.Rack = rack;
    }
    
    /* Getter methods */
    
    public String getBookCategory(){
        return Category;
    }
    
    public String getBookID(){
        return BookID;
    }
    
    public String getBookTitle(){
        return BookTitle;
    }
    
    public String getBookAuthor(){
        return BookAuthor;
    }
    
    public int getYearPublished(){
        return YearPublished;
    }
    
    public int getQuantity(){
        return Quantity;
    }
    
    public int getRack(){
        return Rack;
    }
}
    

