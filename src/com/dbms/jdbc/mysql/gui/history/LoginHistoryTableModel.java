/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.gui.history;

/**
 *
 * @author Jur Yel
 */
import com.dbms.jdbc.mysql.core.LoginHistory;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
        
public class LoginHistoryTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int USER_ID_COL = 0;
    private static final int FULLNAME_COL = 1;
    private static final int POSITION_COL = 2;
    private static final int DATETIME_COL = 3;
    
    private String[] columnNames = {"User ID","User Name","Position","Date/Time"};
    private ArrayList<LoginHistory> list;
    
    public LoginHistoryTableModel(ArrayList<LoginHistory> theList){
        this.list = theList;
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row,int col){
        LoginHistory login = list.get(row);
        
        switch(col){
            case USER_ID_COL:
                return login.getUserID();
            case FULLNAME_COL:
                return login.getFullName();
            case POSITION_COL:
                return login.getPosition();
            case DATETIME_COL:
                return login.getLoginTime();
            case OBJECT_COL:
                return login;
            default:
                return login.getUserID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
}
