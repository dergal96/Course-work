package moodleusers;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SaveFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        JFileChooser myJFileChooser = new JFileChooser();
        myJFileChooser.setDialogTitle("���������");


        String nameSave = JOptionPane.showInputDialog("��������� ���");
        System.out.println(nameSave);

    }
}
