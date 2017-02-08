package moodleusers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveFunction extends TableFunction {

    private final String charDelimiter = ";";

    SaveFunction(JTable table) {
        super(table);
    }

    @Override
    public void excute() {
        if (!checkRequiredFields()) {
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
                file.write(getStringToLoad());
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

    public String getStringToLoad() {
        ArrayList<String> rowsTable = new ArrayList<String>();
        rowsTable.add(String.join(charDelimiter, "username", "password", "lastname", "firstname", "email", "city", "cohort1"));
        for (int i = 0; i < model.getRowCount(); i++) {
            rowsTable.add(String.join(charDelimiter, model.getDataRow(i)));
        }
        return String.join("\n", rowsTable);
    }
}