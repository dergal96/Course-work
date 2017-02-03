package moodleusers;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class TableModelExp extends DefaultTableModel {

    private String[] columnName = {"username*", "password*",
        "lastname*", "firstname*", "email*", "city", "cohort"};

    public Class<?> getColumnClass(int columnIndex) {
        //все ячейки имеют строковые значения
        return String.class;
    }

    public void setCountRowDefault(int row) {
        //уставливаю количество строк поумалчанию
        //устанавливаю названия колонок
        setColumnIdentifiers(columnName);
        //добавляю строки в таблицу в соотвествии с числом row
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            addRow(new Object[getColumnCount()]);
        }
    }

    public void clearTable() {

        for (int i = getRowCount(); i != 0; i--) {
            removeRow(i - 1);

        }
    }

   
    public void setValueAt(Object aValue, int row, int column) {
        Vector rowVector = (Vector) dataVector.elementAt(row);
        rowVector.setElementAt(aValue, column);
        if (column==Columns.USERNAME) {
            rowVector.setElementAt(aValue+"@mail.ru", Columns.EMAIL);
        }
        fireTableCellUpdated(row, column);
    }
}
