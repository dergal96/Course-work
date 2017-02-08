package moodleusers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {

    public Button(String nameButton, final TableFunction myTableFunction) {
        super(nameButton);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTableFunction.excute();
            }
        });
    }

   /* public Button(ImageIcon icon, final TableFunction myTableFunction) {
        super(icon);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTableFunction.excute();
            }
        });
    }*/
}
