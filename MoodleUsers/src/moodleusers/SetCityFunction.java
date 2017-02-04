package moodleusers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;

public class SetCityFunction extends FillColumnFunction {

    SetCityFunction(JTable table, String titleshowInputDialog) {
        super(table, titleshowInputDialog);
    }

    @Override
    public boolean validateUserInput(String userInput) {
        Pattern pattern = Pattern.compile("[à-ÿÀ-ß¸¨]*");
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
    }

    @Override
    public String formatData(String userInput, int indexRow) {
        return userInput;
    }

    @Override
    public int getColumnToFillNumber() {
        return Columns.CITY;
    }
}
