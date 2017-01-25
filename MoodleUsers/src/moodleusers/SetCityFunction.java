package moodleusers;


import javax.swing.JOptionPane;

public class SetCityFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String nameCity = JOptionPane.showInputDialog("¬ведите название города");
        System.out.println(nameCity);
    }
}
