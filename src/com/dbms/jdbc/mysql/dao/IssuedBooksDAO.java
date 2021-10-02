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
import java.util.Properties;
import java.io.FileInputStream;
import java.util.ArrayList;
import com.dbms.jdbc.mysql.core.IssuedBooks;
import java.lang.Math;
import java.util.Date;
import java.sql.Timestamp;

public class IssuedBooksDAO {
    private Connection myConn;
    private int overduedCount;
    
    public IssuedBooksDAO()throws SQLException{
        try{
            Properties props = new Properties();
            props.load(new FileInputStream("sql/lbms_db.properties"));
            
            String user = props.getProperty("user");
            String pass = props.getProperty("pass");
            String dburl = props.getProperty("dburl");
            
            myConn = DriverManager.getConnection(dburl,user,pass);
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
    
    public void IssueBook(IssuedBooks issuedBook,String adminID,int qty)throws SQLException{
        PreparedStatement pst = null;
        try{
            
            myConn.setAutoCommit(false);
            
            /* Save issued book */
            
            pst = myConn.prepareStatement("INSERT INTO issued_books (Book_ID,UserID,DateBorrowed,DueDate) "
                    + "VALUES(?,?,?,?)");
            pst.setString(1,issuedBook.getBookID());
            pst.setString(2,issuedBook.getUserID());
            pst.setDate(3,convertUtilToSQL(issuedBook.getDateBorrowed()));
            pst.setDate(4,convertUtilToSQL(issuedBook.getDateDue()));
            
            pst.executeUpdate();
            
            /* Decrement Quantity */
            
            pst = myConn.prepareStatement("UPDATE bookrecords SET Quantity = ? WHERE Book_ID = ?");
            pst.setInt(1,(qty-1));
            pst.setString(2,issuedBook.getBookID());
            
            pst.executeUpdate();
            
           /* Record Activity */
           
           pst = myConn.prepareStatement("INSERT INTO transactions(user_id,transaction,book_id,admin_id,date_transaction) "
                   + "VALUES(?,?,?,?,?)");
           pst.setString(1,issuedBook.getUserID());
           pst.setString(2,"Issued Book");
           pst.setString(3,issuedBook.getBookID());
           pst.setString(4,adminID);
           pst.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
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
    
    public void renewBook(IssuedBooks issued,String adminID)throws SQLException{
        PreparedStatement pst = null;
        Date brwd = new Date();
        Date due = new Date();
        try{
            myConn.setAutoCommit(false);
            pst = myConn.prepareStatement("UPDATE issued_books SET DateBorrowed = ? , DueDate = ? "
                    + "WHERE UserID = ? AND Book_ID = ?");
            
            int year = brwd.getYear();
            int month = brwd.getMonth();
            int day = brwd.getDate();
            
            due.setYear(year);
            due.setMonth(month);
            due.setDate((day+5));
            
            pst.setDate(1,convertUtilToSQL(brwd));
            pst.setDate(2,convertUtilToSQL(due));
            pst.setString(3,issued.getUserID());
            pst.setString(4,issued.getBookID());
            
            pst.executeUpdate();
            
            /* Record activity */
            
            pst = myConn.prepareStatement("INSERT INTO transactions(user_id,transaction,book_id,admin_id,date_transaction) "
                    + "VALUES(?,?,?,?,?)");
            pst.setString(1,issued.getUserID());
            pst.setString(2,"Renewed Book");
            pst.setString(3, issued.getBookID());
            pst.setString(4,adminID);
            pst.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
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
    
    public void returnBook(String adminID,String userID, String bookID,int qty)throws SQLException {
        PreparedStatement pst = null;
        try{
            myConn.setAutoCommit(false);
            pst = myConn.prepareStatement("DELETE FROM issued_books WHERE UserID = ? AND Book_ID = ?");
            pst.setString(1,userID);
            pst.setString(2,bookID);
            pst.executeUpdate();
            
            /* */
            pst = myConn.prepareStatement("UPDATE bookrecords SET Quantity = ? WHERE Book_ID = ?");
            pst.setInt(1,(qty+1));
            pst.setString(2,bookID);
            pst.executeUpdate();
            
            /* Record activity */
            
            pst = myConn.prepareStatement("INSERT INTO transactions(user_id,transaction,book_id,admin_id,date_transaction) "
                    + "VALUES(?,?,?,?,?)");
            
            pst.setString(1,userID);
            pst.setString(2,"Returned Book");
            pst.setString(3,bookID);
            pst.setString(4,adminID);
            pst.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
            
            /* Save in Returned Books History */
            
            pst = myConn.prepareStatement("INSERT INTO returned_books(user_id,book_status,book_id,date_returned) "
                    + "VALUES(?,?,?,?)");
            Date returned = new Date();
            
            pst.setString(1,userID);
            pst.setString(2,"Returned");
            pst.setString(3, bookID);
            pst.setDate(4,convertUtilToSQL(returned));
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
    
    public void overduedBooks()throws SQLException{
        PreparedStatement pst = null;
        Date curDate = new Date();
        int count = 0;
        try{
            myConn.setAutoCommit(false);
            ArrayList<IssuedBooks> issuedBooks = this.getAllIssuedBooks();
            for(int i=0;i<issuedBooks.size();i++){
                int curDay = (int) curDate.getTime();
                int Dday = (int) issuedBooks.get(i).getDateDue().getTime();
                if((curDay - Dday) > 0){
                   if((this.checkIfOverdued(issuedBooks.get(i).getUserID(), issuedBooks.get(i).getBookID()))){
                        pst = myConn.prepareStatement("UPDATE overdued_books SET days_due = ? "
                                + "WHERE user_id = ? AND book_id = ?");
                        pst.setString(1,String.format("%d %s",
                                convertMillisecondsToDays(curDay - Dday),
                                (convertMillisecondsToDays(curDay - Dday) == 1)? "day" : "days"));
                        pst.setString(2,issuedBooks.get(i).getUserID());
                        pst.setString(3,issuedBooks.get(i).getBookID());
                        pst.executeUpdate();
                    }
                   else{
                        pst = myConn.prepareStatement("INSERT INTO overdued_books (user_id,overdued,"
                            + "book_id,due_date,date_borrowed,days_due) VALUES(?,?,?,?,?,?)");
                        pst.setString(1,issuedBooks.get(i).getUserID());
                        pst.setString(2,"Overdued");
                        pst.setString(3, issuedBooks.get(i).getBookID());
                        pst.setDate(4,convertUtilToSQL(issuedBooks.get(i).getDateDue()));
                        pst.setDate(5,convertUtilToSQL(issuedBooks.get(i).getDateBorrowed()));
                        pst.setString(6,String.format("%d %s",
                                convertMillisecondsToDays(curDay - Dday),
                                (convertMillisecondsToDays(curDay - Dday) == 1)? "day" : "days"));
                        pst.executeUpdate();
                        count++;
                    }
                   
                }
                
            }
            overduedCount = count;
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
    
    public void overduedBooksOfUser(String userID)throws SQLException{
        PreparedStatement pst = null;
        Date curDate = new Date();
        int count = 0;
        overduedCount = count;
        try{
            myConn.setAutoCommit(false);
            ArrayList<IssuedBooks> issuedBooks = this.getIssuedBooksByUser(userID);
            for(int i=0;i<issuedBooks.size();i++){
                int curDay = (int) curDate.getTime();
                int Dday = (int) issuedBooks.get(i).getDateDue().getTime();
                if((curDay - Dday) > 0){
                    if((this.checkIfOverdued(userID, issuedBooks.get(i).getBookID()))){
                        pst = myConn.prepareStatement("UPDATE overdued_books SET days_due = ? "
                                + "WHERE user_id = ? AND book_id = ?");
                        pst.setString(1,String.format("%d %s",
                                convertMillisecondsToDays(curDay - Dday),
                                (convertMillisecondsToDays(curDay - Dday) == 1)? "day" : "days"));
                        pst.setString(2,userID);
                        pst.setString(3,issuedBooks.get(i).getBookID());
                        pst.executeUpdate();
                    }
                   else{
                        pst = myConn.prepareStatement("INSERT INTO overdued_books (user_id,overdued,"
                            + "book_id,due_date,date_borrowed,days_due) VALUES(?,?,?,?,?,?)");
                        pst.setString(1,userID);
                        pst.setString(2,"Overdued");
                        pst.setString(3, issuedBooks.get(i).getBookID());
                        pst.setDate(4,convertUtilToSQL(issuedBooks.get(i).getDateDue()));
                        pst.setDate(5,convertUtilToSQL(issuedBooks.get(i).getDateBorrowed()));
                        pst.setString(6,String.format("%d %s",
                                convertMillisecondsToDays(curDay - Dday),
                                (convertMillisecondsToDays(curDay - Dday) == 1)? "day" : "days"));
                        pst.executeUpdate();
                        count++;
                    }
                   
                }
                
            }
            overduedCount = count;
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
    
    public void retrieveIssuedBook(String bookID)throws SQLException{
        PreparedStatement pst = null;
        try{
            pst = myConn.prepareStatement("DELETE FROM issued_books WHERE Book_ID = ?");
            pst.setString(1,bookID);
            
            pst.executeUpdate();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,null);
        }
    }
    
    public void retrieveIssuedBooksByUser(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        BooksDAO bookDAO = new BooksDAO();
        ArrayList<String> bookIDs = new ArrayList<>();
        ArrayList<Integer> qty = new ArrayList<>();
        int i = 0;
        try{
            myConn.setAutoCommit(false);
            pst = myConn.prepareStatement("SELECT Book_ID FROM issued_books WHERE UserID = ?");
            pst.setString(1,userID);
            rs = pst.executeQuery();
            while(rs.next()){
                bookIDs.add(rs.getString("Book_ID"));
            }
            
            /* Get the quantity of each book */
            for(i=0;i<bookIDs.size();i++){
                qty.add(bookDAO.getBookQuantity(bookIDs.get(i)));
            }
            
            /* Delete from overdued_books */
            
            pst = myConn.prepareStatement("DELETE FROM overdued_books WHERE user_id = ?");
            pst.setString(1,userID);
            pst.executeUpdate();
            
            /* Delete from returned_books */
            
            pst = myConn.prepareStatement("DELETE FROM returned_books WHERE user_id = ?");
            pst.setString(1,userID);
            pst.executeUpdate();
            
            /* Retrieve all issued books from user */
            
            pst = myConn.prepareStatement("DELETE FROM issued_books WHERE UserID = ?");
            pst.setString(1,userID);
            pst.executeUpdate();
            
            /* Increment Quantity */
            
           for(i=0;i<bookIDs.size();i++){
               bookDAO.AddToQuantity(bookIDs.get(i));
           }
            
            myConn.commit();
            
        }
        catch(Exception exc){
            exc.printStackTrace();
            myConn.rollback();
        }
        finally{
            close(pst,rs);
        }
    }
    
    public boolean checkIfOverdued(String userID, String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT user_id, book_id FROM overdued_books");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("user_id").equals(userID) &&
                        rs.getString("book_id").equals(bookID)){
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
    
    public boolean checkIfReturned(String userID, String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT * FROM returned_books");
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("user_id").equals(userID) &&
                        rs.getString("book_id").equals(bookID)){
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
    
    public boolean checkIfUserBorrowed(String userID)throws SQLException{
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
    
    public boolean checkIfAlreadyBorrowed(String userID,String bookID)throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = myConn.prepareStatement("SELECT UserID, Book_ID FROM issued_books");
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("UserID").equals(userID)){
                    if(rs.getString("Book_ID").equals(bookID)){
                        return true;
                    }
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
    
    public int getNumberOfBooksBorrowed(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        int total = 1;
        
        try{
            pst = myConn.prepareStatement("SELECT UserID FROM issued_books WHERE UserID = ?");
            
            pst.setString(1,userID);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                String id = rs.getString("UserID");
                total++;
            }
            
            return total;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return total;
    }
    
    public ArrayList<IssuedBooks> getBookBorrowers(String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<IssuedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT * FROM issued_books WHERE Book_ID = ?");
            pst.setString(1,bookID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                IssuedBooks issuedBook = convertRowToIssuedBooks(rs);
                list.add(issuedBook);
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
    
    
    public String getBookTitleByUserID(String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        String bkTitle = new String();
        try{
            pst = myConn.prepareStatement("SELECT Book_Title FROM bookrecords WHERE Book_ID = ?");
            pst.setString(1,bookID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                bkTitle = rs.getString("Book_Title");
            }
            return bkTitle;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return bkTitle;
    }
    
    public String getBookDateBorrowed(String userID,String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        String brwd = new String();
        try{
            pst = myConn.prepareStatement("SELECT DATE_FORMAT(DateBorrowed,'%M %d, %Y') as DateBorrowed FROM issued_books "
                    + "WHERE Book_ID = ? AND UserID = ?");
            pst.setString(1,bookID);
            pst.setString(2,userID);
            
            rs = pst.executeQuery();
            while(rs.next()){
                brwd = rs.getString("DateBorrowed");
            }
            return brwd;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return brwd;
    }
    
    public String getBookDateDue(String userID, String bookID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        String due = new String();
        try{
            pst = myConn.prepareStatement("SELECT DATE_FORMAT(DueDate,'%M %d, %Y') as DueDate FROM issued_books "
                    + "WHERE Book_ID = ? AND UserID = ?");
            pst.setString(1,bookID);
            pst.setString(2,userID);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                due = rs.getString("DueDate");
            }
            
            return due;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        finally{
            close(pst,rs);
        }
        return due;
    }
    
    public ArrayList<IssuedBooks> getAllIssuedBooks()throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<IssuedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT ib.Book_ID,Book_Title,UserID,DateBorrowed,DueDate "
                    + "FROM issued_books as ib, bookrecords as br WHERE ib.Book_ID = br.Book_ID");
            rs = pst.executeQuery();
            
            while(rs.next()){
                IssuedBooks issued = convertRowToIssuedBooks(rs);
                list.add(issued);
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
    
    public int getBooksOverdued()throws SQLException{
        int booksOverdued = 0;
        try{
            this.overduedBooks();
            booksOverdued = overduedCount;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        return booksOverdued;
    }
    
    public int getBooksOverduedUser(String userID)throws SQLException{
        int bookOverdued = 0;
        try{
            this.overduedBooksOfUser(userID);
            bookOverdued = overduedCount;
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        return bookOverdued;
    }
    
     public ArrayList<IssuedBooks> getIssuedBooksByUser(String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<IssuedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT ib.Book_ID, Book_Title, UserID, DateBorrowed, DueDate "
                    + "FROM issued_books as ib, bookrecords as br WHERE UserID = ? "
                    + "AND ib.Book_ID = br.Book_ID");
            pst.setString(1,userID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                IssuedBooks issued = convertRowToIssuedBooks(rs);
                list.add(issued);
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
     
    public ArrayList<IssuedBooks> searchIssuedBookOfUser(String key,String userID)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<IssuedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT ib.Book_ID, Book_Title, UserID,DateBorrowed,DateDue "
                    + "FROM issued_books as ib, bookrecords as br "
                    + "WHERE CONCAT(Book_Title,Book_ID) like '%"+key+"%' "
                    + "AND ib.Book_ID = br.Book_ID AND UserID = ?");
            pst.setString(1,userID);
            rs = pst.executeQuery();
            
            while(rs.next()){
                IssuedBooks issued = convertRowToIssuedBooks(rs);
                list.add(issued);
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
     
    public ArrayList<IssuedBooks> searchIssuedBook(String key)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<IssuedBooks> list = new ArrayList<>();
        try{
            pst = myConn.prepareStatement("SELECT ib.Book_ID,UserID,Book_Title,DateBorrowed,DueDate FROM issued_books as ib , bookrecords as br "
                    + " WHERE CONCAT(ib.Book_ID,UserID,Book_Title) like '%"+key+"%' AND ib.Book_ID = br.Book_ID");
            
            rs = pst.executeQuery();
            while(rs.next()){
                IssuedBooks issued = convertRowToIssuedBooks(rs);
                list.add(issued);
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
    
    private int convertMillisecondsToDays(int milliseconds){
        
        int days = (int) Math.ceil(milliseconds/(1000*60*60*24))+1;
        
        return days;
    }
    
    private java.sql.Date convertUtilToSQL(Date uDate){
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
   
    private Date convertSQLToUtil(java.sql.Date sDate){
        Date uDate = new Date(sDate.getTime());
        return uDate;
    }
    
    private IssuedBooks convertRowToIssuedBooks(ResultSet rs)throws SQLException{
        String bookID = rs.getString("ib.Book_ID");
        String bookTitle = rs.getString("Book_Title");
        String userID = rs.getString("UserID");
        Date dateBorrowed = rs.getDate("DateBorrowed");
        Date dateDue = rs.getDate("DueDate");
        
        IssuedBooks issued = new IssuedBooks(bookID,bookTitle,userID,dateBorrowed,dateDue);
        
        return issued;
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
