package berechnungen;


public class Simulator {

    public double nachStufenAusbauen(Dorf dorf, int[] gebaeudeStufen, int anzahlVersuche) {
        Dorf dorfFuerAusbau;
        double minBauzeit = Double.MAX_VALUE;
        double bauzeit;
        for (int i = 0; i < anzahlVersuche; i++) {
            dorfFuerAusbau = dorf.dorfKopieren();
            bauzeit = dorfFuerAusbau.genauNachStufenAusbauen(gebaeudeStufen);
            if (bauzeit < minBauzeit) {
                minBauzeit = bauzeit;
            }
        }
        return minBauzeit;
    }
}
