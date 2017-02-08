package moodleusers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.BadLocationException;

public class MainFrame extends JFrame {

    private static final String NAME_BUTTON_AddUsers = "Ввести пользователей";
    private static final String NAME_BUTTON_SetCity = "Установить город";
    private static final String NAME_BUTTON_SetIdGG = "Установить ID глобгруппе";
    private static final String NAME_BUTTON_SetEndPasswords = "Заполнить пароль";
    private static final String NAME_BUTTON_RemoveRow = "Удалить строку(и)";
    private static final String NAME_BUTTON_AddRow = "Добавить строку";
    private static final String NAME_BUTTON_Save = "Сохранить как";
    private final JTable table;
    private final TableModelExp model;

    MainFrame() {
        super("MoodleUsers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 300);

        GridBagLayout myGridBagLayout = new GridBagLayout();
        //содержит переопределение к весам столбцов
        myGridBagLayout.columnWeights = new double[]{2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};

        //содержит переопределение к минимальной ширине столбца
        myGridBagLayout.columnWidths = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1};

        //содержит переопределения к ряду минимальных высот
        myGridBagLayout.rowHeights = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

        //содержит переопределения к весам строки
        myGridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, Double.MIN_VALUE};

        setLayout(myGridBagLayout);

        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.anchor = GridBagConstraints.CENTER;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
        gbc_scrollPane.gridheight = 8;
        gbc_scrollPane.gridwidth = 12;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        gbc_scrollPane.weightx = 1.0;
        gbc_scrollPane.weighty = 1.0;

        model = new TableModelExp();
        model.setCountRowDefault(10);
        table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);//запрет менять местами колонки

        JScrollPane myJScrollPane = new JScrollPane();
        myJScrollPane.setViewportView(table);

        myGridBagLayout.setConstraints(myJScrollPane, gbc_scrollPane);
        add(myJScrollPane);

        //Button BUTTON_AddUsers = new Button(new ImageIcon("AddUsers.png"), new AddUsersFunction(table));
        //BUTTON_AddUsers.setPreferredSize(new Dimension(192, 48));
        
        
        Button BUTTON_AddUsers = new Button(NAME_BUTTON_AddUsers, new AddUsersFunction(table));
        Button BUTTON_SetCity = new Button(NAME_BUTTON_SetCity, new SetCityFunction(table, "Введите название города"));
        Button BUTTON_SetIdGG = new Button(NAME_BUTTON_SetIdGG, new SetIdGGFunction(table, "Введите название ID глобгруппы"));
        Button BUTTON_SetEndPasswords = new Button(NAME_BUTTON_SetEndPasswords, new SetEndPasswordsFunction(table, "Введите окончание пароля"));
        Button BUTTON_RemoveRow = new Button(NAME_BUTTON_RemoveRow, new RemoveRowsFunction(table));
        Button BUTTON_AddRow = new Button(NAME_BUTTON_AddRow, new AddRowsFunction(table));
        Button BUTTON_Save = new Button(NAME_BUTTON_Save, new SaveFunction(table));

        GridBagConstraints gbcBUTTON_AddUsers = new GridBagConstraints();
        gbcBUTTON_AddUsers.anchor = GridBagConstraints.CENTER;
        gbcBUTTON_AddUsers.fill = GridBagConstraints.BOTH;
        gbcBUTTON_AddUsers.gridheight = 1;
        gbcBUTTON_AddUsers.gridwidth = 6;
        gbcBUTTON_AddUsers.gridx = 12;
        gbcBUTTON_AddUsers.gridy = 0;
        gbcBUTTON_AddUsers.insets = new Insets(0, 0, 0, 0);
        //gbcBUTTON_AddUsers.ipadx = 0;
        //gbcBUTTON_AddUsers.ipady = 0;
        gbcBUTTON_AddUsers.weightx = 0.0;
        gbcBUTTON_AddUsers.weighty = 0.0;
        myGridBagLayout.setConstraints(BUTTON_AddUsers, gbcBUTTON_AddUsers);
        add(BUTTON_AddUsers);

        GridBagConstraints gbcBUTTON_SetCity = new GridBagConstraints();
        gbcBUTTON_SetCity.anchor = GridBagConstraints.CENTER;
        gbcBUTTON_SetCity.fill = GridBagConstraints.BOTH;
        gbcBUTTON_SetCity.gridheight = 1;
        gbcBUTTON_SetCity.gridwidth = 2;
        gbcBUTTON_SetCity.gridx = 12;
        gbcBUTTON_SetCity.gridy = 1;
        gbcBUTTON_SetCity.insets = new Insets(0, 0, 0, 0);
        //gbcBUTTON_SetCity.ipadx = 0;
        //gbcBUTTON_SetCity.ipady = 0;
        gbcBUTTON_SetCity.weightx = 0.0;
        gbcBUTTON_SetCity.weighty = 0.0;
        myGridBagLayout.setConstraints(BUTTON_SetCity, gbcBUTTON_SetCity);
        add(BUTTON_SetCity);

        GridBagConstraints gbcBUTTON_SetIdGG = new GridBagConstraints();
        gbcBUTTON_SetIdGG.anchor = GridBagConstraints.CENTER;
        gbcBUTTON_SetIdGG.fill = GridBagConstraints.BOTH;
        gbcBUTTON_SetIdGG.gridheight = 1;
        gbcBUTTON_SetIdGG.gridwidth = 2;
        gbcBUTTON_SetIdGG.gridx = 14;
        gbcBUTTON_SetIdGG.gridy = 1;
        gbcBUTTON_SetIdGG.insets = new Insets(0, 0, 0, 0);
        //gbcBUTTON_SetIdGG.ipadx = 0;
        //gbcBUTTON_SetIdGG.ipady = 0;
        //gbcBUTTON_SetIdGG.weightx = 0.0;
        //gbcBUTTON_SetIdGG.weighty = 0.0;
        myGridBagLayout.setConstraints(BUTTON_SetIdGG, gbcBUTTON_SetIdGG);
        add(BUTTON_SetIdGG);

        GridBagConstraints gbcBUTTON_SetEndPasswords = new GridBagConstraints();
        gbcBUTTON_SetEndPasswords.anchor = GridBagConstraints.CENTER;
        gbcBUTTON_SetEndPasswords.fill = GridBagConstraints.BOTH;
        gbcBUTTON_SetEndPasswords.gridheight = 1;
        gbcBUTTON_SetEndPasswords.gridwidth = 2;
        gbcBUTTON_SetEndPasswords.gridx = 16;
        gbcBUTTON_SetEndPasswords.gridy = 1;
        gbcBUTTON_SetEndPasswords.insets = new Insets(0, 0, 0, 0);
        //gbcBUTTON_SetEndPasswords.ipadx = 0;
        //gbcBUTTON_SetEndPasswords.ipady = 0;
        gbcBUTTON_SetEndPasswords.weightx = 0.0;
        gbcBUTTON_SetEndPasswords.weighty = 0.0;
        myGridBagLayout.setConstraints(BUTTON_SetEndPasswords, gbcBUTTON_SetEndPasswords);
        add(BUTTON_SetEndPasswords);

        GridBagConstraints gbcBUTTON_RemoveRow = new GridBagConstraints();
        gbcBUTTON_RemoveRow.anchor = GridBagConstraints.CENTER;
        gbcBUTTON_RemoveRow.fill = GridBagConstraints.BOTH;
        gbcBUTTON_RemoveRow.gridheight = 1;
        gbcBUTTON_RemoveRow.gridwidth = 3;
        gbcBUTTON_RemoveRow.gridx = 12;
        gbcBUTTON_RemoveRow.gridy = 2;
        gbcBUTTON_RemoveRow.insets = new Insets(0, 0, 0, 0);
        //gbcBUTTON_RemoveRow.ipadx = 0;
        //gbcBUTTON_RemoveRow.ipady = 0;
        gbcBUTTON_RemoveRow.weightx = 0.0;
        gbcBUTTON_RemoveRow.weighty = 0.0;
        myGridBagLayout.setConstraints(BUTTON_RemoveRow, gbcBUTTON_RemoveRow);
        add(BUTTON_RemoveRow);

        GridBagConstraints gbcBUTTON_AddRow = new GridBagConstraints();
        gbcBUTTON_AddRow.anchor = GridBagConstraints.CENTER;
        gbcBUTTON_AddRow.fill = GridBagConstraints.BOTH;
        gbcBUTTON_AddRow.gridheight = 1;
        gbcBUTTON_AddRow.gridwidth = 3;
        gbcBUTTON_AddRow.gridx = 15;
        gbcBUTTON_AddRow.gridy = 2;
        gbcBUTTON_AddRow.insets = new Insets(0, 0, 0, 0);
        //gbcBUTTON_RemoveRow.ipadx = 0;
        //gbcBUTTON_RemoveRow.ipady = 0;
        gbcBUTTON_RemoveRow.weightx = 0.0;
        gbcBUTTON_RemoveRow.weighty = 0.0;
        myGridBagLayout.setConstraints(BUTTON_AddRow, gbcBUTTON_AddRow);
        add(BUTTON_AddRow);

        GridBagConstraints gbcBUTTON_Save = new GridBagConstraints();
        gbcBUTTON_Save.anchor = GridBagConstraints.CENTER;
        gbcBUTTON_Save.fill = GridBagConstraints.BOTH;
        gbcBUTTON_Save.gridheight = 1;
        gbcBUTTON_Save.gridwidth = 6;
        gbcBUTTON_Save.gridx = 12;
        gbcBUTTON_Save.gridy = 3;
        gbcBUTTON_Save.insets = new Insets(0, 0, 0, 0);
        //gbcBUTTON_AddUsers.ipadx = 0;
        //gbcBUTTON_AddUsers.ipady = 0;
        gbcBUTTON_AddUsers.weightx = 0.0;
        gbcBUTTON_AddUsers.weighty = 0.0;
        myGridBagLayout.setConstraints(BUTTON_Save, gbcBUTTON_Save);
        add(BUTTON_Save);

        setVisible(true);
        //pack();
    }

    public static void main(String[] args) throws BadLocationException {
        MainFrame myMainFrame = new MainFrame();
    }
}
