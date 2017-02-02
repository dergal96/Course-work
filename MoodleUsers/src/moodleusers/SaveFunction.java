package moodleusers;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveFunction extends TableFunction {

    SaveFunction(TableModelExp model) {
        super(model);
    }

    @Override
    public void excute() {
        if (!FillRequiredCollumn()) {
            JOptionPane.showMessageDialog(null, "Заполните обязательные поля!");
        } else {

            FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "*.txt*");
            JFileChooser myJFileChooser = new JFileChooser();
            myJFileChooser.setDialogTitle("Сохранить");
            myJFileChooser.setFileFilter(filter);

            if (myJFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    PrintWriter myfile = new PrintWriter(myJFileChooser.getSelectedFile() + ".txt", "UTF-8");
                    myfile.println("username;password;lastname;firstname;email;city;cohort1");
                    for (int j, i = 0; i < model.getRowCount(); i++) {
                        for (j = 0; j < model.getColumnCount() - 1; j++) {
                            if (model.getValueAt(i, j) == null) {
                                myfile.write("Благовещенск;");
                            } else {
                                myfile.write(model.getValueAt(i, j) + ";");
                            }
                        }
                        if (model.getValueAt(i, j) == null) {
                            myfile.println();
                        } else {
                            myfile.println((String) model.getValueAt(i, j));
                        }
                    }
                    myfile.flush();
                } catch (IOException e) {
                }
            }
        }
    }

    public boolean FillRequiredCollumn() {
        boolean otvet = true;
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < 5; j++) {
                if (model.getValueAt(i, j) == null) {
                    otvet = false;
                    break;

                }

            }

        }
        return otvet;

    }
}
