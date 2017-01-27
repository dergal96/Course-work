package moodleusers;

import javax.swing.JOptionPane;

public class SetEndPasswordsFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String nameEndPasswords = JOptionPane.showInputDialog("Введите окончание пароля");

        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(model.getValueAt(i, 0) + nameEndPasswords, i, 1);
        }
        
    }
}
