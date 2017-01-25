package moodleusers;


import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class TableModelExp extends DefaultTableModel {

    private String[] columnName = {"username", "password",
        "lastname", "firstname", "email", "city", "cohort","№"};
    private int Count = 0;
public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
    }

    
    public void setTable(int row, int cow)
    {
        for(int cowIndex=0;cowIndex<cow;cowIndex++)
        {
            addColumn();
        }
        for(int rowIndex=0;rowIndex<row;rowIndex++)
        {
            addRow();
        }
        numberColumnZero();
    }
    public void addColumn() {
        if(getColumnCount()==0)  addColumn("", (Vector)null);
        else addColumn(columnName[Count++], (Vector)null);
        if(Count==columnName.length)
        {
            String columnNamesCopy[] = columnName;
            columnName = new String[columnNamesCopy.length+columnNamesCopy.length-1];
            for (int countColumnNames=0, countColumnNames0=0;countColumnNames<columnName.length;countColumnNames++)
            {
                if(countColumnNames<Count)columnName[countColumnNames]=columnNamesCopy[countColumnNames];
                else {if(!(columnName[countColumnNames-25].equals(columnNamesCopy[countColumnNames0]+columnNamesCopy[countColumnNames0])))columnName[countColumnNames]=columnNamesCopy[countColumnNames0]+columnNamesCopy[countColumnNames0]; countColumnNames0++;}
            }
        }
        for(int rowCount=0;rowCount<getRowCount();rowCount++)
        {
            setValueAt("0",rowCount,getColumnCount()-1);
        }
        setColumnCount(getColumnCount());
    }
    public void addColumnSelect(int select)
    {
        addColumn();
        for(int rowCount=0;rowCount<getRowCount();rowCount++){
            for(int cowCount=getColumnCount()-1;cowCount>select;cowCount--) {
                setValueAt(getValueAt(rowCount, cowCount -1), rowCount, cowCount);
        }
        setValueAt("0",rowCount,select);
        }
    }
    public void dellColumn(int select)
    {
        for(int rowCount=0;rowCount<getRowCount();rowCount++)
            for(int cowCount=select;cowCount<getColumnCount()-1;cowCount++)
                setValueAt(getValueAt(rowCount,cowCount+1),rowCount,cowCount);
        setColumnCount(getColumnCount()-1);

    }
    public void addRowSelect(int select)
    {
        addRow();
        for(int rowCount=getRowCount()-1;rowCount>select;rowCount--){
            for(int cowCount=1;cowCount<getColumnCount()-1;cowCount++) {
                setValueAt(getValueAt(rowCount-1, cowCount), rowCount, cowCount);
            }
        }
        for(int cowCount=1;cowCount<getColumnCount()-1;cowCount++)
        {
            setValueAt("0",select,cowCount);
        }
    }
    public void addRow()
    {
        Object[] rowCount = new Object[getColumnCount()];
        for(int countRow=0;countRow<getColumnCount();countRow++)
            rowCount[countRow]="";
        addRow(rowCount);
    }
    public void numberColumnZero()
    {
        for (int countRow=0,numberRow=1;countRow<getRowCount();countRow++,numberRow++) {
            setValueAt(numberRow, countRow, 0);
        }

    }
    public void clearTable()
    {
        setColumnCount(0);
        setRowCount(0);
        Count=0;
        columnName= new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    }
    
}
