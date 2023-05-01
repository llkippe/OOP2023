package Polyell_Von_Stochastika;
import de.oop2023.util.UserInterface;


public class Polyell_Von_Stochastika {
    public static void main(String[] args) {
        int indexO = UserInterface.in.requestChoice("Polyell_Von_Stochastika", "Polyell", "Simulation", "Exit");
        if(indexO == 2) {
            System.exit(0);
        }
        int anzahlTeilnehmer = UserInterface.in.requestInt("Anzahl der Teilnehmer", 1);


        double[] wahrscheinlichkeiten = new double[anzahlTeilnehmer];
        for(int i = 0; i < anzahlTeilnehmer; i++) {
            wahrscheinlichkeiten[i] = UserInterface.in.requestDouble("Wahrscheinlichkeit aus dem Sattel zu fallen fuer Reiter Nr:" + i, 0,1);
        }

        if(indexO == 0) {
            Polyell polyell = new Polyell(wahrscheinlichkeiten, true);
            polyell.polyellAustragen();
        }
        if(indexO == 1) {
            int polyellAnzahl = UserInterface.in.requestInt("Anzahl der zusimulierden Polyells", 1);
            Simulation simulation = new Simulation(wahrscheinlichkeiten, polyellAnzahl);
        }
    }
}
