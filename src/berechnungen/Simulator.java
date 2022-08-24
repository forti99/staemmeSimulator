package berechnungen;


import gebaeude.gebaeudeSonderfunktion.Speicher;

public class Simulator {

    public SimErgebnis nachStufenAusbauen(int[] gebaeudeStufenAusbaustart, int[] gebaeudeStufenAusbauziel, Speicher speicher, int anzahlVersuche, boolean belohnungAktiv) {
        Dorf dorfFuerAusbau;
        Dorf optimalesDorf = null;

        double minBauzeit = Double.MAX_VALUE;
        double bauzeit;
        final long timeStart = System.currentTimeMillis();
        for (int i = 0; i < anzahlVersuche; i++) {
            dorfFuerAusbau = new Dorf("Dorf " + (i + 1), belohnungAktiv, gebaeudeStufenAusbaustart, speicher);
            bauzeit = dorfFuerAusbau.genauNachStufenAusbauen(gebaeudeStufenAusbauziel);
            System.out.println("Durchläufe im Simulator: " + i);
            if (bauzeit < minBauzeit) {
                minBauzeit = bauzeit;
                optimalesDorf = dorfFuerAusbau;
            }
        }
        final long timeStop = System.currentTimeMillis();
        return new SimErgebnis(anzahlVersuche, optimalesDorf, timeStop - timeStart);
    }
}
