package moodleusers;


import javax.swing.JOptionPane;

public class AddUsersFunction implements TableFunction {

    @Override
    public void excute(TableModelExp model) {
        String nameUser = JOptionPane.showInputDialog("Введите пользователя");
        System.out.println(nameUser);
        
    }
}

