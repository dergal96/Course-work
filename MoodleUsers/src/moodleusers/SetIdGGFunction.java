package moodleusers;


import javax.swing.JOptionPane;

public class SetIdGGFunction extends TableFunction {

    SetIdGGFunction(TableModelExp model) {
        super(model);}

    @Override
    public void excute() {
        String nameIdGG = JOptionPane.showInputDialog("¬ведите название ID глобгруппы");
        for (int i = 0; i < model.getRowCount();i++) {
            model.setValueAt(nameIdGG, i, 6);
        }
        
    }
}