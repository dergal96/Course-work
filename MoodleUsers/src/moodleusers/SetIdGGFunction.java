package moodleusers;


import javax.swing.JOptionPane;

public class SetIdGGFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String nameIdGG = JOptionPane.showInputDialog("Введите ID глобгруппы ");
        System.out.println(nameIdGG);
        
    }
}