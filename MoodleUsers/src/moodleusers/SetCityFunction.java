package moodleusers;

import javax.swing.JOptionPane;

public class SetCityFunction extends TableFunction {

    SetCityFunction(TableModelExp model) {
        super(model);}

    @Override
    public void excute() {
        String nameCity = JOptionPane.showInputDialog("������� �������� ������");
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(nameCity, i, 5);
        }
    }
}
