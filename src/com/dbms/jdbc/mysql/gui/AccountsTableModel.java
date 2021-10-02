/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.gui;

/**
 *
 * @author Jur Yel
 */
import com.dbms.jdbc.mysql.core.Accounts;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AccountsTableModel extends AbstractTableModel {
    public static final int OBJECT_COL = -1;
    private static final int USERID_COL = 0;
    private static final int LAST_NAME_COL = 2;
    private static final int FIRST_NAME_COL = 1;
    private static final int PASSWORD_COL = 3;
    private static final int POSITION_COL = 4;
    private static final int STATUS_COL = 5;
    
    private String[] columnNames = {"User ID","First Name","Last Name","Password","Position","Status"};
    private ArrayList<Accounts> accounts;
    
    public AccountsTableModel(ArrayList<Accounts> list){
        this.accounts = list;
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        return accounts.size();
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row,int col){
        Accounts acc = accounts.get(row);
        
        switch(col){
            case USERID_COL:
                return acc.getUserID();
            case FIRST_NAME_COL:
                return acc.getUserFirstName();
            case LAST_NAME_COL:
                return acc.getUserLastName();
            case PASSWORD_COL:
                return acc.getUserPassword();
            case POSITION_COL:
                return acc.getUserPosition();
            case STATUS_COL:
                try{
                    return acc.getStatus(acc.getUserID());
                }
                catch(Exception exc){
                    exc.printStackTrace();
                }
            case OBJECT_COL: 
                return acc;
            default:
                return acc.getUserID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
}
