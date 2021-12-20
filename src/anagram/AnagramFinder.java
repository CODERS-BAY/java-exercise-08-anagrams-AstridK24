package anagram;

import java.util.Locale;

public class AnagramFinder {

    public static void main(String[] args) {
        anagram("Ampel", "Palme");
        anagram("Bert", "Paul");
        anagram("Hallo Kinder", "Hallodri Ken!");
        anagram("Bier", "Wein");
        anagram("351", "135");

    }

    public static boolean areAnagrams(String string1, String string2) {
        String clearStr1 = string1.replaceAll("[^a-zA-ZüöäÜÖÄß0-9]", "").toLowerCase();
        String clearStr2 = string2.replaceAll("[^a-zA-ZüöäÜÖÄß0-9]", "").toLowerCase();
        for (int i = 0; i < clearStr1.length(); i++) {
            int pos = clearStr2.indexOf(clearStr1.charAt(i));
            if (pos < 0) {
                return false;
            } else {
                StringBuilder str = new StringBuilder();
                str.append(clearStr2);
                str.deleteCharAt(pos);
                clearStr2 = str.toString();
            }
        }
        if (clearStr2.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void anagram(String string1, String string2) {
        System.out.print("Die Ausdrücke \"" + string1 + "\" und \"" + string2 + "\" sind ");
        if (areAnagrams(string1, string2)) {
            System.out.println("Anagramme.");
        } else {
            System.out.println("keine Anagramme.");
        }
    }
}
