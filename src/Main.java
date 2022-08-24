import berechnungen.SimErgebnis;
import berechnungen.Simulator;
import gebaeude.gebaeudeSonderfunktion.Speicher;

public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Speicher speicher = new Speicher(1, 500, 500, 400);
        int[] ausbaustart = new int[]{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, speicher.getStufe(), 0, 0};
        int[] ausbauziel = new int[]{22, 25, 20, 15, 1, 20, 1, 1, 17, 30, 30, 30, 30, 30, 0, 20};

        int anzahlVersuche = 10000;
        boolean belohnungAktiv = true;

        SimErgebnis simErgebnis = simulator.nachStufenAusbauen(ausbaustart, ausbauziel, speicher, anzahlVersuche, belohnungAktiv);
        System.out.println(simErgebnis);
    }
}
