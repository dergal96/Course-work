package moodleusers;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class AddUsersFunction extends TableFunction {

    ArrayList<String> usersNames = null;
    Translit tr = null;

    AddUsersFunction (JTable table) {
        super(table);
    }

    @Override
    public void excute() {

        tr = new Translit();
        final JFrame frameAddUsers = new JFrame("Добавление списка пользователей");
        frameAddUsers.setBounds(200, 120, 500, 600);
        frameAddUsers.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        final JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Courier", Font.PLAIN, 20));
        frameAddUsers.getContentPane().setLayout(new BorderLayout());
        frameAddUsers.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton buttonSaveUsers = new JButton("Сохранить");
        frameAddUsers.getContentPane().add(buttonSaveUsers, BorderLayout.SOUTH);
        buttonSaveUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usersNames = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(textArea.getText(), "\n\r");
                while (st.hasMoreTokens()) {
                    usersNames.add(st.nextToken());
                }
                //если диалоговое окно закрыть,закрывается и окно ввода пользователей
                //надо подумать!!!!
                if (usersNames.isEmpty()) {
                    JOptionPane.showMessageDialog(frameAddUsers, "Введите список пользователей!");
                } else {
                    model.clearTable();
                    for (int i = 0; i < usersNames.size(); i++) {
                        model.addRow(new Object[model.getColumnCount()]);
                        parsLine(i);
                    }
                }
                frameAddUsers.dispose();
            }
        });
        frameAddUsers.setVisible(true);
    }

    public void parsLine(int index) {

        /* StringTokenizer st = new StringTokenizer(usersNames.get(index), " ");
         String slovo = st.nextToken();
         model.setValueAt(tr.toTranslit(slovo).toLowerCase(), index, Columns.USERNAME);
         model.setValueAt(slovo, index, Columns.LASTNAME);
         model.setValueAt(tr.toTranslit(slovo).toLowerCase() + "@mail.ru", index, Columns.EMAIL);
         slovo = st.nextToken();
         model.setValueAt(slovo, index, Columns.FIRSTNAME);
         model.setValueAt("Благовещенск", index, Columns.CITY);

         */


        int i = 2;
        StringTokenizer st = new StringTokenizer(usersNames.get(index), " ");
        while (st.hasMoreTokens() & i < 4) {
            String slovo = st.nextToken();
            if (i == 2) {
                model.setValueAt(tr.toTranslit(slovo).toLowerCase(), index, i - 2);//запись фамилии на англ в 1столб
                model.setValueAt(slovo, index, i);
                model.setValueAt(tr.toTranslit(slovo).toLowerCase() + "@mail.ru", index, i + 2);
            } else {
                model.setValueAt(slovo, index, i);
                model.setValueAt("Благовещенск", index, i + 2);//set city default
            }
            i++;
        }

    }
}
