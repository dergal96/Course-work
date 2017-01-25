package moodleusers;

import javax.swing.JOptionPane;

public class SaveFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String nameSave = JOptionPane.showInputDialog("Сохранить как");
        System.out.println(nameSave);
        
    }
}
