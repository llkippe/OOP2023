package Banditspiel;

import de.oop2023.util.UserInterface;


/**
 * Die Banditspiel-Klasse ist die Hauptklasse des Spiels. Sie enthält die main-Methode,
 * die den Game Loop steuert.
 */
public class Banditspiel {
    /**
     * Die main-Methode ist der Game Loop.
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] options = {"ja","nein"};
        int iOption;

        do {
            int anzahl = UserInterface.in.requestInt("Mit wie viel Wuerfen moechtest du die Banditspiel Simulation starten?", 1);
            Simulation simulation = new Simulation(anzahl);
            iOption = UserInterface.in.requestChoice("Willst du weitere Berechnungen durchfuehren?", options);
        } while (iOption == 0);
    }
}
