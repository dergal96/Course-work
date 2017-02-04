package moodleusers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;

public class SetIdGGFunction extends FillColumnFunction {

    SetIdGGFunction(JTable table, String titleshowInputDialog) {
        super(table, titleshowInputDialog);
    }

    @Override
    public boolean validateUserInput(String userInput) {
        Pattern pattern = Pattern.compile("[A-Za-z\\d_]*");
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }

    @Override
    public String formatData(String userInput, int indexRow) {
        return userInput;
    }

    @Override
    public int getColumnToFillNumber() {
        return Columns.COHORT;
    }
}
