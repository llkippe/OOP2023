package Polyell_Von_Stochastika;

import java.util.Arrays;

public class Polyell {
    private int n;
    private boolean protokollieren;
    private int anzahlImSattel;
    private Reiter[] reiter;

    private double[] reiterProbabilities;

    public Polyell(double[] reiterProbabilities, boolean protokollieren) {
        this.protokollieren = protokollieren;
        Arrays.sort(reiterProbabilities);
        this.reiterProbabilities = reiterProbabilities;

        n = reiterProbabilities.length;
        reiter = new Reiter[n];
        initReiter();

    }

    public void initReiter() {
        anzahlImSattel = n;
        for (int i = 0; i < n; i++) {
            reiter[i] = new Reiter(reiterProbabilities[i]);
        }
    }

    public int polyellAustragen() {
        int currentIndex = 0;

        while (anzahlImSattel>1) {
            if(reiter[currentIndex].istImSattel()) {
                if(!reiter[currentIndex].stossen()) {
                    if(protokollieren) System.out.println("Reiter Nr:" + currentIndex + " wurde vom Sattel gestossen");
                    anzahlImSattel--;
                }else{
                    if(protokollieren) System.out.println("Reiter Nr:" + currentIndex + " wurde nicht vom Sattel gestossen");
                }
            }

            currentIndex++;
            if(currentIndex == n) currentIndex = 0;

        }
        if(protokollieren) System.out.println("Winner: Reiter" + getIndexOfWinner());
        return getIndexOfWinner();
    }

    public int getIndexOfWinner() {
        if(anzahlImSattel == 1) {
            for (int i = 0; i < n; i++) {
                if(reiter[i].istImSattel()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
