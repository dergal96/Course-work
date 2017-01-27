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
import javax.swing.JTextArea;

public class AddUsersFunction implements TableFunction {

    ArrayList<String> strUser = null;
    TableModelExp model = null;
    Translit tr = null;

    @Override
    public void excute(final TableModelExp model) {
        this.model = model;
        tr = new Translit();
        final JFrame frameAddUsers = new JFrame("���������� ������ �������������");
        frameAddUsers.setBounds(200, 120, 500, 600);
        frameAddUsers.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameAddUsers.setVisible(true);

        final JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Courier", Font.PLAIN, 20));
        frameAddUsers.getContentPane().setLayout(new BorderLayout());
        frameAddUsers.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton buttonSaveUsers = new JButton("���������");
        frameAddUsers.getContentPane().add(buttonSaveUsers, BorderLayout.SOUTH);
        buttonSaveUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strUser = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(textArea.getText(), "\n");
                int kolstr = 0;
                while (st.hasMoreTokens()) {
                    strUser.add(st.nextToken());
                    kolstr++;
                }
                //���� ���������� ���� �������,����������� � ���� ����� �������������
                //���� ��������!!!!
                if (kolstr == 0) {
                    JOptionPane.showMessageDialog(frameAddUsers, "������� ������ �������������!");
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

                for (int i = 0; i < kolstr; i++) {
                    parsLine(i);
                }
                frameAddUsers.dispose();
            }
        });
    }

    public void parsLine(int index) {
        int i = 2;
        StringTokenizer st = new StringTokenizer(strUser.get(index), " ");
        while (st.hasMoreTokens() & i < 4) {
            String slovo = st.nextToken();
            if (i == 2) {//if slovo is family name
                model.setValueAt(tr.toTranslit(slovo).toLowerCase(), index, i - 2);//������ ������� �� ���� � 1�����
                model.setValueAt(slovo, index, i);
                model.setValueAt(tr.toTranslit(slovo).toLowerCase()+"@mail.ru", index, i+2);
            }
            else model.setValueAt(slovo, index, i); //if slovo is name
            i++;
        }


    }
}
