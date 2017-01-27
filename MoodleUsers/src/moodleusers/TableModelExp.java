package moodleusers;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class TableModelExp extends DefaultTableModel {

    private String[] columnName = {"username", "password",
        "lastname", "firstname", "email", "city", "cohort"};
    private int countRow = 0;

    public Class<?> getColumnClass(int columnIndex) {
        //��� ������ ����� ��������� ��������
        return String.class;
    }

    public void setCountRowDefault(int row) {
        //���������� ���������� ����� �����������
        //������������ �������� �������
        setColumnIdentifiers(columnName);
        countRow = row;
        //�������� ������ � ������� � ����������� � ������ row
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            addRow(new Object[getColumnCount()]);
        }
    }

    public int getcountRow() {
        return countRow;
    }
}
