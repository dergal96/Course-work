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

    private static final String NAME_BUTTON_AddUsers = "Ввести список пользователей";
    private static final String NAME_BUTTON_SetCity = "Установить город";
    private static final String NAME_BUTTON_SetIdGG = "Установить ID глобгруппе";
    private static final String NAME_BUTTON_SetEndPasswords = "Заполнить пароли";
    private static final String NAME_BUTTON_Save = "Сохранить как";
    private JPanel contentPane; //панель, в которую мы все запихиваем
    private GridBagConstraints gbc_scrollPane;
    private JScrollPane scrollPane;//прокрутка, на которуюмы будем помещатьтаблицу
    private JTable table;//JTable внутри себя не содержит данные, а служит только для их отображения
    private TableModelExp model;//реализует интерфейс
    //хранит данные ячеек таблицы и дополнительную служебную информацию об этих ячейках 
    private JPanel panel;//панельдля кнопок
    private GridBagConstraints gbc_panel;

    MainFrame() {
        super("MoodleUsers");//устанавливаю заголовок 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//завершение работы после закрытия окна
        //setBounds(100, 100, 600, 600);//размер окна
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//установка рамки
        setContentPane(contentPane);//установить у этого окна панель

        GridBagLayout myGridBagLayout = new GridBagLayout();
      myGridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 132, 0, 0};
        //Это поле содержит переопределения к ширине минимума столбца.
      myGridBagLayout.rowHeights = new int[]{23, 0, 111, 0, 0, 0, 0, 0, 0, 0};
        
       myGridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        //Это поле содержит переопределения к весам столбца.
      myGridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(myGridBagLayout);//установить для панели способ размещения


        gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
        /*Поле insets позволяет задать для компонента 
         отступы от краев выделенной ему области. 
         По умолчанию такие отступы отсутствуют.*/

        gbc_scrollPane.gridheight = 1;
        gbc_scrollPane.gridwidth = 7;
        /*Поля gridwidth и gridheight определяют 
         количество ячеек, занимаемых добавляемым компонентом.
         Если же компонент должен занимать, например, 
         * две смежные ячейки в одной строке, то для gridwidth нужно задать значение, равное двум,*/

        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        /*Поле fill определяет стратегию распределения компоненту свободного пространства ячейки или ячеек) таблицы, 
         * если размеры компонента меньше размеров выделенного для него места.
         * BOTH - Изменяется высота и ширина, причем таким образом, 
         * чтобы компонент занимал все отведенное для него пространство*/

        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        /*Поля gridx и gridy задают, соответственно, 
         * номер столбца и номер строки для ячейки, 
         * в которую будет помещен компонент. 
         * Верхней левой ячейке соответствуют нулевые значения.*/

        model = new TableModelExp();//создание модели
        model.setTable(15, 8);
        table = new JTable(model);//установка модели таблице
        //установка таблицы на прокрутку
        contentPane.add(new JScrollPane(table), gbc_scrollPane);

        panel = new JPanel();
        gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(5, 5, 5, 5);
        gbc_panel.gridheight = 1;
        gbc_panel.gridwidth = 2;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 8;
        gbc_panel.gridy = 0;

        contentPane.add(panel, gbc_panel);


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton buttonSetCity = newFunctionButton(NAME_BUTTON_SetCity, new SetCityFunction());
        JButton buttonSetIdGG = newFunctionButton(NAME_BUTTON_SetIdGG, new SetIdGGFunction());
        JButton buttonAddUsers = newFunctionButton(NAME_BUTTON_AddUsers, new AddUsersFunction());

        setVisible(true);//сделать видимым
        pack();
    }

    public JButton newFunctionButton(final String nameButton, final TableFunction myTableFunction) {
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
