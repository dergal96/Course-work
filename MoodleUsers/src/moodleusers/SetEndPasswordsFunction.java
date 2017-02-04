package moodleusers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;

public class SetEndPasswordsFunction extends FillColumnFunction {

    SetEndPasswordsFunction(JTable table, String titleshowInputDialog) {
        super(table, titleshowInputDialog);
    }

    @Override
    public boolean validateUserInput(String userInput) {
        Pattern pattern = Pattern.compile("[A-Za-z\\d\\p{Punct}]*");  
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }

    @Override
    public String formatData(String userInput, int indexRow) {
        return model.getValueAt(indexRow, Columns.USERNAME) + userInput;
        //return model.getValueAt(indexRow, Columns.PASSWORD) + userInput;
    }

    @Override
    public int getColumnToFillNumber() {
        return Columns.PASSWORD;
    }
}
