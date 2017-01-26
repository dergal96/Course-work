package moodleusers;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AddUsersFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        final JFrame frameAddUsers = new JFrame("Добавление списка пользователей");
        frameAddUsers.setBounds(200, 120, 500, 600);
        frameAddUsers.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameAddUsers.setVisible(true);

        final JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Courier", Font.PLAIN, 20));
        frameAddUsers.getContentPane().setLayout(new BorderLayout());
        frameAddUsers.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton buttonSaveUsers = new JButton("Сохранить");
        frameAddUsers.getContentPane().add(buttonSaveUsers, BorderLayout.SOUTH);


        buttonSaveUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(textArea.getText());
                frameAddUsers.dispose();

            }
        });



    }
}
