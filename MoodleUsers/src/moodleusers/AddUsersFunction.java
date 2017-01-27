package moodleusers;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AddUsersFunction implements TableFunction {

    @Override
    public void excute(final TableModelExp model) {
        final JFrame frameAddUsers = new JFrame("ƒобавление списка пользователей");
        frameAddUsers.setBounds(200, 120, 500, 600);
        frameAddUsers.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameAddUsers.setVisible(true);

        final JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Courier", Font.PLAIN, 20));
        frameAddUsers.getContentPane().setLayout(new BorderLayout());
        frameAddUsers.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton buttonSaveUsers = new JButton("—охранить");
        frameAddUsers.getContentPane().add(buttonSaveUsers, BorderLayout.SOUTH);


        buttonSaveUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //model.removeRow(0);//разобратьс€с удалением строки!

                StringTokenizer st = new StringTokenizer(textArea.getText(), "\n");
                int kolstr = 0;
                while (st.hasMoreTokens()) {

                    System.out.println(st.nextToken());
                    kolstr++;
                }
                //если диалоговое окно закрыть,закрываетс€ и окно ввода пользователей
                //надо подумать!!!!
                if (kolstr == 0) {
                    JOptionPane.showMessageDialog(frameAddUsers, "¬ведите список пользователей!");
                }



                if (kolstr < model.getcountRow()) {
                    for (int i = model.getcountRow(); i > kolstr; i--) {
                        model.removeRow(i - 1);
                    }

                } else if (kolstr > model.getcountRow()) {
                    for (int i = 0; i < kolstr - model.getcountRow(); i++) {
                        model.addRow(new Object[model.getColumnCount()]);
                    }
                }








                /*int i = 2;
                 StringTokenizer st = new StringTokenizer(textArea.getText(), " ");
                 while (st.hasMoreTokens() & i < 4) {
                 model.setValueAt(st.nextToken(), 0, i);
                 //System.out.println(st.nextToken());
                 i++;
                 }*/ //textArea.getText();
                {
                    frameAddUsers.dispose();
                }
                //model.setValueAt(textArea.getText(),1, 1);

            }
        });



    }

    public void parsLine(String str) {
    }
}
