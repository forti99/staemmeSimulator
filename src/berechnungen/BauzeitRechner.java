package berechnungen;

import datenverarbeitung.DataProcessor;
import util.Bauzeit;

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

        hgfaktoren[0] = 0.9100;
        hgfaktoren[1] = 0.8729;
        hgfaktoren[2] = 0.8372;
        hgfaktoren[3] = 0.7995;
        hgfaktoren[4] = 0.7608;
        hgfaktoren[5] = 0.7242;
        hgfaktoren[6] = 0.6898;
        hgfaktoren[7] = 0.6570;
        hgfaktoren[8] = 0.6254;
        hgfaktoren[9] = 0.590000000;
        hgfaktoren[10] = 0.5666;
        hgfaktoren[11] = 0.5398;
        hgfaktoren[12] = 0.5141;
        hgfaktoren[13] = 0.4897;
        hgfaktoren[14] = 0.4663;
        hgfaktoren[15] = 0.4442;
        hgfaktoren[16] = 0.4230;
        hgfaktoren[17] = 0.4028;
        hgfaktoren[18] = 0.3837;
        hgfaktoren[19] = 0.3654;
        hgfaktoren[20] = 0.3480;
        hgfaktoren[21] = 0.3314;
        hgfaktoren[22] = 0.3156;
        hgfaktoren[23] = 0.3006;
        hgfaktoren[24] = 0.2862;
        hgfaktoren[25] = 0.2725;
        hgfaktoren[26] = 0.2596;
        hgfaktoren[27] = 0.2473;
        hgfaktoren[28] = 0.2355;
        hgfaktoren[29] = 0.2236;
    }

    private final double[] gesamtfaktoren = new double[30];
    private final double[] hgfaktoren = new double[30];

    public Bauzeit berechneReineBauzeitAusbauplan(int[] startStufenGebaeude, int[] ausbauplan) {
        double gesamtbauzeit = 0;

        for (int gebaeudeId : ausbauplan) {
            int stufeHg = startStufenGebaeude[0];
            startStufenGebaeude[gebaeudeId - 1]++;
            gesamtbauzeit += berechneBauzeitInSekunden(gebaeudeId, stufeHg, startStufenGebaeude[gebaeudeId-1]);
        }
        return Bauzeit.secondsToBauzeit((int) Math.round(gesamtbauzeit));
    }

    public double berechneBauzeitInSekunden(int gebaeudeId, int stufeHg, int stufeGebaeudeNachAusbau) {
        double grundbauzeit = DataProcessor.getGebaeudeDaten().get(gebaeudeId).getBuildTime();
        return grundbauzeit * hgfaktoren[stufeHg - 1] * gesamtfaktoren[stufeGebaeudeNachAusbau - 1];
    }

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
