package moodleusers;

import javax.swing.JOptionPane;

public class SetEndPasswordsFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String nameEndPasswords = JOptionPane.showInputDialog("������� ��������� ������");
        System.out.println(nameEndPasswords);
        
    }
}
