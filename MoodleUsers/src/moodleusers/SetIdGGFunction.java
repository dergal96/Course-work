package moodleusers;


import javax.swing.JOptionPane;

public class SetIdGGFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String nameIdGG = JOptionPane.showInputDialog("������� �������� ID ����������");
        for (int i = 0; i < model.getRowCount();i++) {
            model.setValueAt(nameIdGG, i, 6);
        }
        
    }
}