package moodleusers;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class RemoveRowsFunction extends TableFunction {

    RemoveRowsFunction(JTable table) {
        super(table);
    }

    @Override
    public void excute() {

        int[] selectRows = table.getSelectedRows();

        if (selectRows.length != 0) {
            for (int i = 0; i < selectRows.length; i++) {
                model.removeRow(selectRows[i] - i);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберете строку(и) для удаления!");
        }


    }
}
