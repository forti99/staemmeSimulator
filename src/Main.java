import berechnungen.BauzeitRechner;
import berechnungen.Dorf;
import berechnungen.SimErgebnis;
import berechnungen.Simulator;
import datenverarbeitung.DataProcessor;
import gebaeude.gebaeudeSonderfunktion.Speicher;
import util.Gebaeudeumwandlung;

import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {
        Simulator simulator = new Simulator();

       /* Dorf dorf3 = new Dorf("GoldStar", true, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, new Speicher(1,500,500,400),0, 0);
        SimErgebnis simErgebnis = simulator.nachStufenAusbauen(dorf3, new int[]{20, 0, 0, 0, 1, 20, 1, 0, 0, 21, 21, 21, 20, 21, 0, 0},10000);
        System.out.println(simErgebnis);*/

        BauzeitRechner bauzeitRechner = new BauzeitRechner();

        System.out.println(bauzeitRechner.berechneHgFaktor("0:38:51", 900, 9));

        /*DataProcessor.loadGebaeudeInfos("214");
        int[] startStufenGebaeude = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] ausbauplan = new int[]{1, 1};
        System.out.println(bauzeitRechner.berechneReineBauzeitAusbauplan(startStufenGebaeude, ausbauplan));*/
    }

}


