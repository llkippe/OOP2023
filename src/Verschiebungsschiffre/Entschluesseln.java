package Verschiebungsschiffre;



import java.util.HashMap;

public class Entschluesseln {
    final static char[] highestOccurrenceDE = {'e', 'n', 'i', 's', 'r', 'a', 't', 'd', 'h', 'u', 'l', 'c', 'g', 'm', 'o', 'b', 'w', 'f', 'k', 'z', 'p','v','j','y', 'x', 'q'};

    public static String verschluesseln(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = traverse(chars[i], key);
        }
        return new String(chars);
    }

    // mit Schluessel
    public static String entschluesseln(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = traverse(chars[i], -key);
        }
        return new String(chars);
    }

    // ohne Schluessel
    public static String entschluesseln(String text) {
        char[] chars = text.toCharArray();
        HashMap<Character,Integer> occurrences = countOccurrences(chars);
        char highestOccurrence = getHighestOccurrence(occurrences);
        int key = highestOccurrence - highestOccurrenceDE[0];
        System.out.println(highestOccurrence + " " + highestOccurrenceDE[0] + " " +key);
        return entschluesseln(text, key);
    }

    private static HashMap<Character, Integer> countOccurrences(char[] chars) {
        HashMap<Character, Integer> occurrences = new HashMap<>();
        for(int i = 0; i < chars.length; i++) {
            if(occurrences.containsKey(chars[i])) {
                occurrences.put(chars[i], occurrences.get(chars[i]) + 1);
            } else occurrences.put(chars[i], 1);
        }
        return occurrences;
    }

    private static char getHighestOccurrence(HashMap<Character, Integer> occurrences) {
        int max = 0;
        char c = ' ';
        for(char key : occurrences.keySet()) {
            if(occurrences.get(key) > max) {
                max = occurrences.get(key);
                c = key;
            }
        }
        return c;
    }

    private static char traverse(char character, int key) {
        if(character <= 'z' && character >= 'a') {
            character += key;
            if (character > 'z') character -= 26;
            else if (character < 'a') character += 26;
        }
       return character;
    }
}
