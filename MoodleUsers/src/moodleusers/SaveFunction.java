package moodleusers;

import java.awt.Choice;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SaveFunction extends TableFunction {

    SaveFunction(TableModelExp model) {
        super(model);}

    @Override
    public void excute() {

       


        /*String dataUsers = "username;password;lastname;firstname;email;city;cohort1\n";
        
         for (int j, i = 0 ; i < model.getRowCount(); i++) {
         for (j = 0; j < model.getColumnCount() - 1; j++) {
         dataUsers += model.getValueAt(i, j) + ";";
         }
         dataUsers += model.getValueAt(i, j) + "\n";
         }
         System.out.println(dataUsers);*/


        /*
         JFileChooser myJFileChooser = new JFileChooser();
         myJFileChooser.setDialogTitle("Сохранить");//создаем объект класса JFileChooser
         int k = myJFileChooser.showOpenDialog(null);
         if (k == JFileChooser.APPROVE_OPTION) {

           
         }
         */



    }
}
