package Banditspiel;

/**
 * Die Klasse Wuerfel beschreibt einen Wärfel mit 10 Seiten.
 */
public class Wuerfel {
    /**
     * Die Augenzahl des Wuerfels seit er das letze mal geworfen wurde.
     */
    private int augenzahl;
    public Wuerfel () {
    }

    /**
     * Wuerfelt den Wuerfel und speicher das Ergebnis in augenzahl.
     */
    public void wuerfeln() {
        augenzahl = (int) (Math.random() * 10);
    }

    /**
     * Gibt die Augenzahl des Wuerfels zurueck.
     * @return augenzahl
     */
    public int getAugenzahl() {
        return augenzahl;
    }
}
