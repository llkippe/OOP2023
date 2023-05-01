package Polyell_Von_Stochastika;

public class Simulation {

    private int anzahl;
    private int[] absHauefigkeiten;
    private double[] relHauefigkeiten;
    Polyell polyell;

    public Simulation(double[] probabilities, int anzahl) {
        this.anzahl = anzahl;
        absHauefigkeiten = new int[probabilities.length];
        relHauefigkeiten = new double[probabilities.length];
        polyell = new Polyell(probabilities, false);
        simulieren();
        ausgeben();
    }

    public void simulieren() {
        for(int i = 0; i < anzahl; i++){
            absHauefigkeiten[polyell.polyellAustragen()]++;
            polyell.initReiter();
        }
        for(int i = 0; i < absHauefigkeiten.length; i++){
            relHauefigkeiten[i] = (double)absHauefigkeiten[i] / anzahl;
        }
    }

    public void ausgeben(){
        for(int i = 0; i < absHauefigkeiten.length; i++){
            System.out.println("Reiter Nr:"+ i + ":  Abs. Häufigkeit " + absHauefigkeiten[i] + ":  Rel. Häufigkeit " + relHauefigkeiten[i]);
        }
    }
}
