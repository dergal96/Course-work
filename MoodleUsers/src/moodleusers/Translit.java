package moodleusers;

import java.util.HashMap;

public class Translit {
    private static final HashMap<String, String> letters = new HashMap<>();
    static {
        letters.put("À", "A");
        letters.put("Á", "B");
        letters.put("Â", "V");
        letters.put("Ã", "G");
        letters.put("Ä", "D");
        letters.put("Å", "E");
        letters.put("¨", "E");
        letters.put("Æ", "ZH");
        letters.put("Ç", "Z");
        letters.put("È", "I");
        letters.put("É", "I");
        letters.put("Ê", "K");
        letters.put("Ë", "L");
        letters.put("Ì", "M");
        letters.put("Í", "N");
        letters.put("Î", "O");
        letters.put("Ï", "P");
        letters.put("Ğ", "R");
        letters.put("Ñ", "S");
        letters.put("Ò", "T");
        letters.put("Ó", "U");
        letters.put("Ô", "F");
        letters.put("Õ", "KH");
        letters.put("Ö", "TS");
        letters.put("×", "CH");
        letters.put("Ø", "SH");
        letters.put("Ù", "SHCH");
        letters.put("Ú", "");
        letters.put("Û", "Y");
        letters.put("Ü", "");
        letters.put("İ", "E");
        letters.put("Ş", "YU");
        letters.put("ß", "YA");
        letters.put("à", "a");
        letters.put("á", "b");
        letters.put("â", "v");
        letters.put("ã", "g");
        letters.put("ä", "d");
        letters.put("å", "e");
        letters.put("¸", "e");
        letters.put("æ", "zh");
        letters.put("ç", "z");
        letters.put("è", "i");
        letters.put("é", "i");
        letters.put("ê", "k");
        letters.put("ë", "l");
        letters.put("ì", "m");
        letters.put("í", "n");
        letters.put("î", "o");
        letters.put("ï", "p");
        letters.put("ğ", "r");
        letters.put("ñ", "s");
        letters.put("ò", "t");
        letters.put("ó", "u");
        letters.put("ô", "f");
        letters.put("õ", "kh");
        letters.put("ö", "ts");
        letters.put("÷", "ch");
        letters.put("ø", "sh");
        letters.put("ù", "shch");
        letters.put("ú", "");
        letters.put("û", "y");
        letters.put("ü", "");
        letters.put("ı", "e");
        letters.put("ş", "yu");
        letters.put("ÿ", "ya");
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
