package moodleusers;

import java.util.Vector;
import javax.swing.event.TableModelListener;
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

    public void setValueAt(Object value, int row, int column) {
        Vector rowVector = (Vector) dataVector.elementAt(row);
        rowVector.setElementAt(value, column);
        if (column == Columns.USERNAME & !value.equals("")) {
            rowVector.setElementAt(value + "@mail.ru", Columns.EMAIL);
        }
        fireTableCellUpdated(row, column);
    }

    public String[] getDataRow(int index) {
        String[] dataRow = new String[getColumnCount()];
        for (int j = 0; j < getColumnCount(); j++) {
            dataRow[j] = (String) getValueAt(index, j);
        }
        return dataRow;
    }
}
