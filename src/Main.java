import berechnungen.BauzeitRechner;
import berechnungen.Dorf;
import berechnungen.SimErgebnis;
import berechnungen.Simulator;
import datenverarbeitung.DataProcessor;
import gebaeude.gebaeudeSonderfunktion.Speicher;

public class Main {

    public static void main(String[] args) throws Exception {
        Simulator simulator = new Simulator();

        Dorf dorf3 = new Dorf("GoldStar", true, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, new Speicher(1,500,500,400),0, 0);
        SimErgebnis simErgebnis = simulator.nachStufenAusbauen(dorf3, new int[]{20, 0, 0, 0, 1, 20, 1, 0, 0, 21, 21, 21, 20, 21, 0, 0},10000);
        System.out.println(simErgebnis);

        BauzeitRechner bauzeitRechner = new BauzeitRechner();
        System.out.println(bauzeitRechner.berechneHgFaktor("1:06:43",562.5,15));

        DataProcessor.loadGebaeudeInfos("214");
        System.out.println(DataProcessor.getGebaeudeDaten());

    }

}


