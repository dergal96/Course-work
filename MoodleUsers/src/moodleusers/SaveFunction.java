package moodleusers;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SaveFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        JFileChooser myJFileChooser = new JFileChooser();
        myJFileChooser.setDialogTitle("Сохранить");


        String nameSave = JOptionPane.showInputDialog("Сохранить как");
        System.out.println(nameSave);

    }
}
