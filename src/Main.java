

import berechnungen.Dorf;
import berechnungen.Simulator;
import gebaeude.gebaeudeSonderfunktion.Speicher;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();

        Dorf dorf0 = new Dorf("AllStar", true, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Speicher(1, 500, 500, 400), 0);
        dorf0.nachPlanAusbauen(Arrays.asList(12, 10, 13, 11, 16, 4, 10, 12, 2, 11, 1, 10, 9, 13, 13, 11, 16, 11, 10, 9, 11, 12, 9, 12, 2, 3, 12, 10, 9, 4, 13, 9, 1, 13, 11, 6, 1, 9, 1, 10, 12, 12, 13, 11, 11, 1, 4, 10, 10, 13, 12, 11, 12, 13, 11, 13, 1, 4, 11, 12, 16, 3, 1, 4, 10, 10, 16, 5, 2, 1, 10, 10, 10, 3, 11, 16, 12, 6, 10, 16, 11, 11, 16, 10, 12, 3, 12, 2, 16, 10, 11, 2, 2, 11, 10, 16, 6, 9, 3, 11, 6, 3, 1, 11, 9, 13, 6, 9, 16, 11, 2, 6, 11, 16, 11, 9, 3, 9, 6, 9, 1, 9, 10, 11, 16, 13, 16, 6, 9, 16, 13, 11, 10, 12, 12, 10, 12, 12, 2, 10, 10, 2, 9, 6, 13, 1, 1, 1, 1, 13, 11, 13, 10, 2, 13, 12, 1, 12, 12, 11, 12, 1, 12, 6, 10, 2, 2, 6, 12, 12, 6, 3, 10, 16, 16, 2, 3, 2, 6, 3, 1, 2, 13, 6, 1, 16, 13, 16, 1, 16, 1, 6, 1, 12, 16, 1, 13, 13, 13, 1, 1, 13, 6, 13, 13, 13, 6, 6, 6, 6));
        System.out.println(dorf0.getBisherigeBauzeit());
        System.out.println(dorf0);

        /*long start1 = System.currentTimeMillis();
        Dorf dorf1 = new Dorf("Repater", true, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Speicher(1, 500, 500, 400), 0);
        Dorf schnellstesDorf1 = simulator.dorfZufaelligAusbauenMaxAusbauZeit(dorf1, 258, 25, 15, 10, 5, 1, 20, 15, 25, 25, 25, 25, 20);
        long end1 = System.currentTimeMillis();
        System.out.println(schnellstesDorf1.getBisherigeBauzeit());
        System.out.println(schnellstesDorf1);
        System.out.println("Dauer der Suche/Generierung (in Sek, abgerunded): " + (end1 - start1) / 1000);*/

        long start2 = System.currentTimeMillis();
        Dorf dorf2 = new Dorf("GoldStar", true, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Speicher(1, 500, 500, 400), 0);
        Dorf schnellstesDorf2 = simulator.dorfZufaelligAusbauenDoerferAnzahl(dorf2, 10000, 25, 15, 10, 5, 1, 20, 15, 25, 25, 25, 25, 20);
        long end2 = System.currentTimeMillis();
        System.out.println(schnellstesDorf2);
        System.out.println("Dauer der Suche/Generierung (in Millisekunden) : " + (end2 - start2) );
    }
}
