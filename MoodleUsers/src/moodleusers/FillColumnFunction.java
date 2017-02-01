package moodleusers;

import javax.swing.JOptionPane;

//public abstract class FillColumnFunction extends TableFunction {
public class FillColumnFunction extends TableFunction {
    String titleshowInputDialog;
    int numberColumn;

    //public FillColumnFunction(TableModelExp model) {
    public FillColumnFunction(String titleshowInputDialog, int numberColumn, TableModelExp model) {
        super(model);
        this.numberColumn = numberColumn;
        this.titleshowInputDialog = titleshowInputDialog;
    }

    @Override
    public void excute() {
        String nameIdGG = JOptionPane.showInputDialog(titleshowInputDialog);
        for (int i = 0; i < model.getRowCount(); i++) {
                      model.setValueAt(nameIdGG, i, numberColumn);
//model.setValueAt(formatValue(), i, getColumn());
        }

    }
    
   // abstract formatValue();
    //abstract getColumn();
}