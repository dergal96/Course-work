package moodleusers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button {

    public JButton createButton(String nameButton, final TableFunction myTableFunction, final TableModelExp model) {
        JButton button = new JButton(nameButton);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTableFunction.excute(model);
            }
        });
        return button;

    }
}
