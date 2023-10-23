package berechnungen;

public class BauzeitRechner {
    public BauzeitRechner() {
        gesamtfaktoren[0] = 0.008;
        gesamtfaktoren[1] = 0.008;
        gesamtfaktoren[2] = 0.167;
        gesamtfaktoren[3] = 0.516;
        gesamtfaktoren[4] = 0.985;
        gesamtfaktoren[5] = 1.554;
        gesamtfaktoren[6] = 2.224;
        gesamtfaktoren[7] = 3.013;
        gesamtfaktoren[8] = 3.942;
        gesamtfaktoren[9] = 5.042;
        gesamtfaktoren[10] = 6.347;
        gesamtfaktoren[11] = 7.902;
        gesamtfaktoren[12] = 9.741;
        gesamtfaktoren[13] = 11.930;
        gesamtfaktoren[14] = 14.531;
        gesamtfaktoren[15] = 17.628;
        gesamtfaktoren[16] = 21.307;
        gesamtfaktoren[17] = 25.685;
        gesamtfaktoren[18] = 30.888;
        gesamtfaktoren[19] = 37.070;
        gesamtfaktoren[20] = 44.420;
        gesamtfaktoren[21] = 53.140;
        gesamtfaktoren[22] = 63.497;
        gesamtfaktoren[23] = 75.790;
        gesamtfaktoren[24] = 90.382;
        gesamtfaktoren[25] = 107.708;
        gesamtfaktoren[26] = 128.270;
        gesamtfaktoren[27] = 152.532;
        gesamtfaktoren[28] = 181.376;
        gesamtfaktoren[29] = 215.554;
    }

    private final double[] gesamtfaktoren = new double[30];

    public double berechneHgFaktor(String bauzeitstring, double grundbauzeit, int stufeGebaeudenachAusbau) {
        return bauzeitStringZuSekunden(bauzeitstring) / (grundbauzeit * gesamtfaktoren[stufeGebaeudenachAusbau - 1]);
    }

    private double bauzeitStringZuSekunden(String bauzeitstring) {
        String[] bauzeitensplits = bauzeitstring.split(":");
        double stundenInSekunden = Double.parseDouble(bauzeitensplits[0]) * 60 * 60;
        double minutenInSekunden = Double.parseDouble(bauzeitensplits[1]) * 60;
        double sekunden = Double.parseDouble(bauzeitensplits[2]);
        return stundenInSekunden + minutenInSekunden + sekunden;
    }
}
