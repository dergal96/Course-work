package moodleusers;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveFunction extends TableFunction {

    SaveFunction(JTable table) {
        super(table);
    }

    @Override
    public void excute() {
        if (checkRequiredFields()) {
            JOptionPane.showMessageDialog(null, "Заполните обязательные поля!");
            return;
        }

        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "*.txt");
        JFileChooser myJFileChooser = new JFileChooser();
        myJFileChooser.setDialogTitle("Сохранить");
        myJFileChooser.setFileFilter(filter);

        if (myJFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                PrintWriter file = new PrintWriter(myJFileChooser.getSelectedFile() + ".txt", "UTF-8");
                file.println("username;password;lastname;firstname;email;city;cohort1");
                for (int j, i = 0; i < model.getRowCount(); i++) {
                    for (j = 0; j < model.getColumnCount() - 1; j++) {
                        if (model.getValueAt(i, j) == null) {
                            file.write("Благовещенск;");
                        } else {
                            file.write(model.getValueAt(i, j) + ";");
                        }
                    }
                    if (model.getValueAt(i, j) == null) {
                        file.println();
                    } else {
                        file.println((String) model.getValueAt(i, j));
                    }
                }
                file.flush();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ошибка!");
                System.err.println(e);
            }
        }
    }

    public boolean checkRequiredFields() {
        
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < Columns.CITY; j++) {
                if (model.getValueAt(i, j) == null) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
