package moodleusers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

public class MainFrame extends JFrame {

    private static final String NAME_BUTTON_AddUsers = "Ввести пользователей";
    private static final String NAME_BUTTON_SetCity = "Установитьгород";
    private static final String NAME_BUTTON_SetIdGG = "Установить ID глобгруппе";
    private static final String NAME_BUTTON_SetEndPasswords = "Заполнить пароль";
    private static final String NAME_BUTTON_Save = "Сохранить как";
    private GridBagConstraints gbc_scrollPane;
    private JTable table;
    private TableModelExp model; 
    private JPanel panel;
    private GridBagConstraints gbc_panel;

    MainFrame() {
        super("MoodleUsers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
       
        GridBagLayout myGridBagLayout = new GridBagLayout();
        myGridBagLayout.columnWidths = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};
        myGridBagLayout.rowHeights = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        myGridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        myGridBagLayout.rowWeights = new double[]{1.0};
        setLayout(myGridBagLayout);

        gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(5, 5, 5, 1);
        gbc_scrollPane.gridheight = 1;
        gbc_scrollPane.gridwidth = 7;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        

        model = new TableModelExp();
        model.setCountRowDefault(10);
        table = new JTable(model);
        add(new JScrollPane(table), gbc_scrollPane);

        panel = new JPanel();
        gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(5, 1, 5, 5);
        gbc_panel.gridheight = 1;
        gbc_panel.gridwidth = 2;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 8;
        gbc_panel.gridy = 0;

        add(panel, gbc_panel);


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton buttonAddUsers = newFunctionButton(NAME_BUTTON_AddUsers, new AddUsersFunction(), model);
        JButton buttonSetCity = newFunctionButton(NAME_BUTTON_SetCity, new SetCityFunction(), model);
        JButton buttonSetIdGG = newFunctionButton(NAME_BUTTON_SetIdGG, new SetIdGGFunction(), model);
        JButton buttonSetEndPasswords = newFunctionButton(NAME_BUTTON_SetEndPasswords, new SetEndPasswordsFunction(), model);
        JButton buttonSave = newFunctionButton(NAME_BUTTON_Save, new SaveFunction(), model);


        setVisible(true);
        //pack();
    }

    public JButton newFunctionButton(final String nameButton, final TableFunction myTableFunction, final TableModelExp model) {
        JButton button = new JButton(nameButton);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTableFunction.excute(model);
            }
        });
        panel.add(button);
        return button;
    }

    public static void main(String[] args) throws BadLocationException {
        MainFrame myMainFrame = new MainFrame();
    }
}
