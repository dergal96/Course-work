package moodleusers;

import javax.swing.JFileChooser;

public class SaveFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String dataUsers = "";
        
         for (int j, i = 0 ; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount() - 1; j++) {
                    dataUsers += model.getValueAt(i, j) + ";";
                }
                dataUsers += model.getValueAt(i, j) + "\n";
            }
            System.out.println(dataUsers);
        
        
        /*
             JFileChooser myJFileChooser = new JFileChooser();
        myJFileChooser.setDialogTitle("���������");//������� ������ ������ JFileChooser
        int k = myJFileChooser.showOpenDialog(null);
        if (k == JFileChooser.APPROVE_OPTION) {

           
        }
            */
        
        
       
    }
}

