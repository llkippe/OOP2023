package Banditspiel;

/**
 * Die Klasse kann einzelen Versuche (fuer die beiden Ereignisse) rstellen.
 */
public class Versuch {
    /**
     * 3 Wuerfel die fuer ein Versuch benoetigt werden
     */
    private Wuerfel[] wuerfel = new Wuerfel[3];
    /**
     * Erstes Ereignis: 3 Augenzahlen gleich
     */
    private boolean dreiGleich = false;
    /**
     * Zweites Ereignis: 2 Augenzahlen gleich (aber nicht 3)
     */
    private boolean zweiGleich = false;

    /**
     * Konstuktor erstellt initialisiert alle Wuerfel
     */
    public Versuch() {
        for(int i = 0; i < wuerfel.length; i++) wuerfel[i] = new Wuerfel();
    }

    /**
     * Erstellt ein neuen Versuch und ermittelt ob und welches es ein Ereignis zutrifft.
     */
    public void createVersuch() {
        dreiGleich = false;
        zweiGleich = false;

        for (int i = 0; i < wuerfel.length; i++) wuerfel[i].wuerfeln();

        if (wuerfel[0].getAugenzahl() == wuerfel[1].getAugenzahl() && wuerfel[1].getAugenzahl() == wuerfel[2].getAugenzahl())
            dreiGleich = true;

        if ((wuerfel[0].getAugenzahl() == wuerfel[1].getAugenzahl() || wuerfel[1].getAugenzahl() == wuerfel[2].getAugenzahl() || wuerfel[0].getAugenzahl() == wuerfel[2].getAugenzahl()) && !dreiGleich) {
            zweiGleich = true;
        }
    }
    /**
    * gibt an ob das Ereignis dreiGleich zutrifft
     * @return true, wenn drei Augenzahlen gleich sind, false wenn nicht
     */
     public boolean getDreiGleich() {
        return dreiGleich;
     }
    /**
     * gibt an ob das Ereignis zweiGleich zutrifft
     * @return true, wenn zwei Augenzahlen gleich sind, false wenn nicht
     */
     public boolean getZweiGleich() {
        return zweiGleich;
     }
}
