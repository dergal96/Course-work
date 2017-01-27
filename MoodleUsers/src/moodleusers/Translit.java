package moodleusers;

import java.util.HashMap;

public class Translit {
    private static final HashMap<String, String> letters = new HashMap<>();
    static {
        letters.put("�", "A");
        letters.put("�", "B");
        letters.put("�", "V");
        letters.put("�", "G");
        letters.put("�", "D");
        letters.put("�", "E");
        letters.put("�", "E");
        letters.put("�", "ZH");
        letters.put("�", "Z");
        letters.put("�", "I");
        letters.put("�", "I");
        letters.put("�", "K");
        letters.put("�", "L");
        letters.put("�", "M");
        letters.put("�", "N");
        letters.put("�", "O");
        letters.put("�", "P");
        letters.put("�", "R");
        letters.put("�", "S");
        letters.put("�", "T");
        letters.put("�", "U");
        letters.put("�", "F");
        letters.put("�", "KH");
        letters.put("�", "TS");
        letters.put("�", "CH");
        letters.put("�", "SH");
        letters.put("�", "SHCH");
        letters.put("�", "");
        letters.put("�", "Y");
        letters.put("�", "");
        letters.put("�", "E");
        letters.put("�", "YU");
        letters.put("�", "YA");
        letters.put("�", "a");
        letters.put("�", "b");
        letters.put("�", "v");
        letters.put("�", "g");
        letters.put("�", "d");
        letters.put("�", "e");
        letters.put("�", "e");
        letters.put("�", "zh");
        letters.put("�", "z");
        letters.put("�", "i");
        letters.put("�", "i");
        letters.put("�", "k");
        letters.put("�", "l");
        letters.put("�", "m");
        letters.put("�", "n");
        letters.put("�", "o");
        letters.put("�", "p");
        letters.put("�", "r");
        letters.put("�", "s");
        letters.put("�", "t");
        letters.put("�", "u");
        letters.put("�", "f");
        letters.put("�", "kh");
        letters.put("�", "ts");
        letters.put("�", "ch");
        letters.put("�", "sh");
        letters.put("�", "shch");
        letters.put("�", "");
        letters.put("�", "y");
        letters.put("�", "");
        letters.put("�", "e");
        letters.put("�", "yu");
        letters.put("�", "ya");
    }



    public static String toTranslit(String text) {
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i<text.length(); i++) {
            String simbol = text.substring(i, i+1);
            if (letters.containsKey(simbol)) {
                sb.append(letters.get(simbol));
            }
            else {
                sb.append(simbol);
            }
        }
        return sb.toString();
    }
}
