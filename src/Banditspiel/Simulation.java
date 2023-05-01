package Banditspiel;
/**
 * Simulation Klasse laesst viele Versuche laufen und wertet diese Stochastisch aus
 */
public class Simulation {
    /**
     * Wie oft Versuch gestartet wird
     */
    private int anzahlWuerfe;
    /**
     * Die mathematisch berechnete Wahrscheinlichkeit fuer das Ergeinis das 3 Zahlen gleich sind
     */

    private final double mathProbabilityDrei = 0.1;
    /**
     * Die mathematisch berechnete Wahrscheinlichkeit fuer das Ergeinis das 2 Zahlen gleich sind
     */
    private final double mathProbabilityZwei = 3 * (1 * 0.1 * 0.9);

    /**
     * Zaehler fuer die Hauefigkeit 3 gleich
     */
    private int absHaeufigkeitDrei = 0;
    /**
     * Zaehler fuer die Hauefigkeit 2 gleich
     */
    private int absHaeufigkeitZwei = 0;

    private Versuch versuch = new Versuch();

    /**
     * startet Simulation
     * @param anzahlWuerfe
     */
    public Simulation(int anzahlWuerfe){
        this.anzahlWuerfe = anzahlWuerfe;
        runSimulation();
    }
    /**
        laesst anzahlWuerfe Versuche laufen und wertet diese Stochastisch aus
     */
    public void runSimulation () {
        for(int i = 0; i < anzahlWuerfe; i++) {
            versuch.createVersuch();
            if(versuch.getDreiGleich()){
                absHaeufigkeitDrei++;
            }
            if(versuch.getZweiGleich()) absHaeufigkeitZwei++;
        }

        printResults(getRelHaeufigkeiten(), getAbsFehler(), getRelFehler());
    }

    /**
     * Gibt die Ergebnisse an die Konsole aus
     * @param relHaeufigkeiten fuer jedes Ereignis
     * @param absFehler fuer jedes Ereignis
     * @param relFehler fuer jedes Ereignis
     */
      public void printResults(double[] relHaeufigkeiten, double[] absFehler, double[] relFehler){

          System.out.println("Ergebnisse fuer "+anzahlWuerfe+" Wuerfe.");
          System.out.println("   Ereignis: Alle Zahlen der Wuerfel gleich");
          System.out.println("      simulierte relative Haeufigkeit: "+relHaeufigkeiten[0]);
          System.out.println("      berechnete Wahrscheinlichkeit: "+mathProbabilityDrei);
          System.out.println("      absoluter Fehler: " + absFehler[0]);
          System.out.println("      relativer Fehler: " + relFehler[0]);
          System.out.println("   Ereignis: 2 Zahlen der Wuerfel gleich");
          System.out.println("      simulierte relative Haeufigkeit: "+relHaeufigkeiten[1]);
          System.out.println("      berechnete Wahrscheinlichkeit: "+mathProbabilityZwei);
          System.out.println("      absoluter Fehler: " + absFehler[1]);
          System.out.println("      relativer Fehler: " + relFehler[1]);
          System.out.println("");
      }

    /**
     * Berechnet die relative Haeufigkeit fuer jedes Ereignis
     * @return relative Haeufigkeit fuer jedes Ereignis
     */
    public double[] getRelHaeufigkeiten(){
        double relHaeufigkeitDrei = absHaeufigkeitDrei / (double) anzahlWuerfe;
        double relHaeufigkeitZwei = absHaeufigkeitZwei / (double) anzahlWuerfe;
        double[] relHaeufigkeit = {relHaeufigkeitDrei, relHaeufigkeitZwei};
        return relHaeufigkeit;
    }

    /**
     * Berechnet den relativen Fehler fuer jedes Ereignis
     * @return relativer Fehler fuer jedes Ereignis
     */
    private double[] getRelFehler(){
        double relFehlerDrei = Math.abs(absHaeufigkeitDrei / (double) anzahlWuerfe - mathProbabilityDrei);
        double relFehlerZwei = Math.abs(absHaeufigkeitZwei / (double) anzahlWuerfe - mathProbabilityZwei);

        double[] relFehler = {relFehlerDrei, relFehlerZwei};
        return relFehler;
      }

    /**
     * Berechnet den absoluten Fehler fuer jedes Ereignis
     * @return absoluten Fehler fuer jedes Ereignis
     */
      public double[] getAbsFehler(){
        double absFehlerDrei = absHaeufigkeitDrei / (double) anzahlWuerfe - mathProbabilityDrei;
        double absFehlerZwei = absHaeufigkeitZwei / (double) anzahlWuerfe - mathProbabilityZwei;
        double[] absFehler = {absFehlerDrei, absFehlerZwei};
        return absFehler;
      }
}
