package Polyell_Von_Stochastika;


public class Reiter {
    private boolean imSattel = true;
    private double probability;

    public Reiter(double probability) {
        this.probability = probability;
    }

    public boolean stossen() {
        if(Math.random() < probability) {
            imSattel = false;
            return false;
        }
        return true;
    }

    public boolean istImSattel() {
        return imSattel;
    }

}
