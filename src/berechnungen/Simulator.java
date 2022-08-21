package berechnungen;


public class Simulator {

    public SimErgebnis nachStufenAusbauen(Dorf dorf, int[] gebaeudeStufen, int anzahlVersuche) {
        Dorf dorfFuerAusbau;
        Dorf optimalesDorf = null;
        SimErgebnis simErgebnis = new SimErgebnis(anzahlVersuche, 0, dorf, 0);
        double minBauzeit = Double.MAX_VALUE;
        double bauzeit;
        final long timeStart = System.currentTimeMillis();
        for (int i = 0; i < anzahlVersuche; i++) {
            dorfFuerAusbau = dorf.dorfKopieren();
            bauzeit = dorfFuerAusbau.genauNachStufenAusbauen(gebaeudeStufen);
            System.out.println("Durchläufe im Simulator: " + i);
            if (bauzeit < minBauzeit) {
                minBauzeit = bauzeit;
                optimalesDorf = dorfFuerAusbau;
                simErgebnis.setDurchlaeufMitOptimalemDorf(i + 1);

            }
        }
        final long timeStop = System.currentTimeMillis();

        simErgebnis.setLaufzeit(timeStop - timeStart);
        simErgebnis.setOptimalesDorf(optimalesDorf);
        return simErgebnis;
    }
}
