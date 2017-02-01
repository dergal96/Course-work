package moodleusers;

import javax.swing.JOptionPane;

public class SetEndPasswordsFunction extends TableFunction {

    SetEndPasswordsFunction(TableModelExp model) {
        super(model);}

    @Override
    public void excute() {
        String nameEndPasswords = JOptionPane.showInputDialog("Введите окончание пароля");

        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(model.getValueAt(i, 0) + nameEndPasswords, i, 1);

//model.setValueAt(formatValue(), i, 1);
        }
        
    }
}
