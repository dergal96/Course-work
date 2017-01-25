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

    private static final String NAME_BUTTON_AddUsers = "������ ������ �������������";
    private static final String NAME_BUTTON_SetCity = "���������� �����";
    private static final String NAME_BUTTON_SetIdGG = "���������� ID ����������";
    private static final String NAME_BUTTON_SetEndPasswords = "��������� ������";
    private static final String NAME_BUTTON_Save = "��������� ���";
    private JPanel contentPane; //������, � ������� �� ��� ����������
    private GridBagConstraints gbc_scrollPane;
    private JScrollPane scrollPane;//���������, �� ��������� ����� ���������������
    private JTable table;//JTable ������ ���� �� �������� ������, � ������ ������ ��� �� �����������
    private TableModelExp model;//��������� ���������
    //������ ������ ����� ������� � �������������� ��������� ���������� �� ���� ������� 
    private JPanel panel;//��������� ������
    private GridBagConstraints gbc_panel;

    MainFrame() {
        super("MoodleUsers");//������������ ��������� 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���������� ������ ����� �������� ����
        //setBounds(100, 100, 600, 600);//������ ����
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//��������� �����
        setContentPane(contentPane);//���������� � ����� ���� ������

        GridBagLayout myGridBagLayout = new GridBagLayout();
      myGridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 132, 0, 0};
        //��� ���� �������� ��������������� � ������ �������� �������.
      myGridBagLayout.rowHeights = new int[]{23, 0, 111, 0, 0, 0, 0, 0, 0, 0};
        
       myGridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        //��� ���� �������� ��������������� � ����� �������.
      myGridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(myGridBagLayout);//���������� ��� ������ ������ ����������


        gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
        /*���� insets ��������� ������ ��� ���������� 
         ������� �� ����� ���������� ��� �������. 
         �� ��������� ����� ������� �����������.*/

        gbc_scrollPane.gridheight = 1;
        gbc_scrollPane.gridwidth = 7;
        /*���� gridwidth � gridheight ���������� 
         ���������� �����, ���������� ����������� �����������.
         ���� �� ��������� ������ ��������, ��������, 
         * ��� ������� ������ � ����� ������, �� ��� gridwidth ����� ������ ��������, ������ ����,*/

        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        /*���� fill ���������� ��������� ������������� ���������� ���������� ������������ ������ ��� �����) �������, 
         * ���� ������� ���������� ������ �������� ����������� ��� ���� �����.
         * BOTH - ���������� ������ � ������, ������ ����� �������, 
         * ����� ��������� ������� ��� ���������� ��� ���� ������������*/

        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        /*���� gridx � gridy ������, ��������������, 
         * ����� ������� � ����� ������ ��� ������, 
         * � ������� ����� ������� ���������. 
         * ������� ����� ������ ������������� ������� ��������.*/

        model = new TableModelExp();//�������� ������
        model.setTable(15, 8);
        table = new JTable(model);//��������� ������ �������
        //��������� ������� �� ���������
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

        setVisible(true);//������� �������
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
