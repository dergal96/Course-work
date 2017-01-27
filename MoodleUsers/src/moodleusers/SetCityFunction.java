package moodleusers;

import javax.swing.JOptionPane;

public class SetCityFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String nameCity = JOptionPane.showInputDialog("¬ведите название города");
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(nameCity, i, 5);
        }
    }
}
