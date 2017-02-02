package moodleusers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetEndPasswordsFunction extends FillColumnFunction {

    SetEndPasswordsFunction(TableModelExp model, String titleshowInputDialog) {
        super(model, titleshowInputDialog);
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
