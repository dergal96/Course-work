package moodleusers;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AddRowsFunction extends TableFunction {

    AddRowsFunction(JTable table) {
        super(table);
    }

    @Override
    public void excute() {
        model.addRow(new Object[model.getColumnCount()]);
    }
}
