import berechnungen.Dorf;
import berechnungen.Simulator;
import gebaeude.gebaeudeSonderfunktion.Speicher;

public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator();

        Dorf dorf3 = new Dorf("GoldStar", true, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, new Speicher(1), 0);
        double dauer = simulator.nachStufenAusbauen(dorf3, new int[]{22, 25, 20, 15, 1, 20, 1, 1, 17, 30, 30, 30, 30, 30, 0, 20},1000);
        System.out.println(dauer);
    }
}
