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
import com.dbms.jdbc.mysql.core.AccountsHistory;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class AccountsHistoryTableModel extends AbstractTableModel{
    public static final int OBJECT_COL = -1;
    private static final int USERID_COL = 0;
    private static final int ACTION_COL = 1;
    private static final int ADMIN_ID_COL = 2;
    private static final int DATETIME_COL = 3;
    
    private String[] columnNames = {"User ID","Action","Admin ID","Date/Time"};
    private ArrayList<AccountsHistory> list;
    
    public AccountsHistoryTableModel(ArrayList<AccountsHistory> arryList){
        this.list = arryList;
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
        AccountsHistory history = list.get(row);
        
        switch(col){
            case USERID_COL:
                return history.getUserID();
            case ACTION_COL:
                return history.getAction();
            case ADMIN_ID_COL:
                return history.getAdminID();
            case DATETIME_COL:
                return history.getAlterTime();
            case OBJECT_COL:
                return history;
            default:
                return history.getUserID();
        }
    }
    
    @Override
    public Class getColumnClass(int c){
        return getValueAt(0,c).getClass();
    }
    
}
