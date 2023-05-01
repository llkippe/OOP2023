package Verschiebungsschiffre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Text {
    private String text;
    public Text(String filename) {
        text = readText(filename);
        text = textBereinigen(text);
    }

    // text bereinigen
    private String textBereinigen(String text) {
        text = text.toLowerCase();
        // regex replace all ä, ö, ß, ü;
        text = text.replaceAll("ä", "ae");
        text = text.replaceAll("ö", "oe");
        text = text.replaceAll("ß", "ss");
        text = text.replaceAll("ü", "ue");
        return text;
    }

    private String readText(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file, "ISO-8859-1");

            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sb.append(line);
                sb.append("\n");
            }
            scanner.close();
            System.out.println("File "+file.getName()+" erfolgreich gelesen");
            return sb.toString();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
            return null;
        }
    }

    public String getText() {
        return text;
    }
}
