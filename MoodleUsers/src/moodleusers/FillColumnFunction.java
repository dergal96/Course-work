package moodleusers;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public abstract class FillColumnFunction extends TableFunction {

    String titleshowInputDialog;
    int numberColumn;

    public FillColumnFunction(JTable table, String titleshowInputDialog) {
        super(table);
        this.titleshowInputDialog = titleshowInputDialog;
    }

    @Override
    public void excute() {
        String userInput = JOptionPane.showInputDialog(titleshowInputDialog);
        if (!validateUserInput(userInput)) {
            JOptionPane.showMessageDialog(null, "Неверно введены данные!");
        } else {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(formatData(userInput, i), i, getColumnToFillNumber());
            }
        }
    }

    public abstract boolean validateUserInput(String userInput);

    public abstract String formatData(String userInput, int indexRow);

    public abstract int getColumnToFillNumber();
}