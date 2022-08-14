package berechnungen;


import gebaeude.Speicher;

import java.util.*;

public class Simulator {

    public Dorf dorfZufaelligAusbauenMaxAusbauZeit(Dorf dorf, double maxAusbauzeit, int maxStufeHauptgebaeude, int maxStufeKaserne, int maxStufeStall, int maxStufeWerkstatt, int maxStufeAdelshof, int maxStufeSchmiede, int maxStufeMarktplatz, int maxStufeHolzfaeller, int maxStufeLehmgrube, int maxStufeEisenmine, int maxStufeBauernhof, int maxStufeWall) {
        int i = 1;
        Dorf dorfNeu = null;
        double ausbauzeit = maxAusbauzeit;
        while (ausbauzeit >= maxAusbauzeit) {
            dorfNeu = new Dorf("Dorf " + i, dorf.isBelohnungenAktiv(), dorf.getHauptgebaeude().getStufe(), dorf.getKaserne().getStufe(), dorf.getStall().getStufe(), dorf.getWerkstatt().getStufe(), dorf.getAdelshof().getStufe(), dorf.getSchmiede().getStufe(), dorf.getMarktplatz().getStufe(), dorf.getHolzfaeller().getStufe(), dorf.getLehmgrube().getStufe(), dorf.getEisenmine().getStufe(), dorf.getBauernhof().getStufe(), new Speicher(1, 500, 500, 400), dorf.getWall().getStufe());
            dorfNeu.nachPlanAusbauen(zufaelligenAusbauplanGenerieren(dorf, maxStufeHauptgebaeude, maxStufeKaserne, maxStufeStall, maxStufeWerkstatt, maxStufeAdelshof, maxStufeSchmiede, maxStufeMarktplatz, maxStufeHolzfaeller, maxStufeLehmgrube, maxStufeEisenmine, maxStufeBauernhof, maxStufeWall));
            System.out.println("generierte Doerfer: " + i);
            i++;
            ausbauzeit = dorfNeu.getBisherigeBauzeit();
        }
        return dorfNeu;
    }

    public Dorf dorfZufaelligAusbauenDoerferAnzahl(Dorf dorf, int doerferAnzahl, int maxStufeHauptgebaeude, int maxStufeKaserne, int maxStufeStall, int maxStufeWerkstatt, int maxStufeAdelshof, int maxStufeSchmiede, int maxStufeMarktplatz, int maxStufeHolzfaeller, int maxStufeLehmgrube, int maxStufeEisenmine, int maxStufeBauernhof, int maxStufeWall) {
        int i = 1;
        Dorf dorfNeu;
        Dorf bestesDorf = new Dorf(Double.MAX_VALUE);
        while (i <= doerferAnzahl) {
            dorfNeu = new Dorf("Dorf " + i, dorf.isBelohnungenAktiv(), dorf.getHauptgebaeude().getStufe(), dorf.getKaserne().getStufe(), dorf.getStall().getStufe(), dorf.getWerkstatt().getStufe(), dorf.getAdelshof().getStufe(), dorf.getSchmiede().getStufe(), dorf.getMarktplatz().getStufe(), dorf.getHolzfaeller().getStufe(), dorf.getLehmgrube().getStufe(), dorf.getEisenmine().getStufe(), dorf.getBauernhof().getStufe(), new Speicher(1, 500, 500, 400), dorf.getWall().getStufe());
            dorfNeu.nachPlanAusbauen(zufaelligenAusbauplanGenerieren(dorf, maxStufeHauptgebaeude, maxStufeKaserne, maxStufeStall, maxStufeWerkstatt, maxStufeAdelshof, maxStufeSchmiede, maxStufeMarktplatz, maxStufeHolzfaeller, maxStufeLehmgrube, maxStufeEisenmine, maxStufeBauernhof, maxStufeWall));
            System.out.println("generierte Doerfer: " + i);
            if (dorfNeu.getBisherigeBauzeit() < bestesDorf.getBisherigeBauzeit()) {
                bestesDorf = dorfNeu;
            }
            i++;
        }
        return bestesDorf;
    }

    public List<Integer> zufaelligenAusbauplanGenerieren(Dorf dorf, int maxStufeHauptgebaeude, int maxStufeKaserne, int maxStufeStall, int maxStufeWerkstatt, int maxStufeAdelshof, int maxStufeSchmiede, int maxStufeMarktplatz, int maxStufeHolzfaeller, int maxStufeLehmgrube, int maxStufeEisenmine, int maxStufeBauernhof, int maxStufeWall) {
        ArrayList<Integer> gebaeudeIDs = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13, 16));
        int stufeHauptgebaeude = dorf.getHauptgebaeude().getStufe();
        int stufeKaserne = dorf.getKaserne().getStufe();
        int stufeStall = dorf.getStall().getStufe();
        int stufeWerkstatt = dorf.getWerkstatt().getStufe();
        int stufeAdelshof = dorf.getAdelshof().getStufe();
        int stufeSchmiede = dorf.getSchmiede().getStufe();
        int stufeMarktplatz = dorf.getMarktplatz().getStufe();
        int stufeHolzfaeller = dorf.getHolzfaeller().getStufe();
        int stufeLehmgrube = dorf.getLehmgrube().getStufe();
        int stufeEisenmine = dorf.getEisenmine().getStufe();
        int stufeBauernhof = dorf.getBauernhof().getStufe();
        int stufeWall = dorf.getWall().getStufe();

        List<Integer> randomAusbauplan = new ArrayList<>();
        int randomGebaeudeId;
        int i = 0;

        while (stufeHauptgebaeude < maxStufeHauptgebaeude || stufeKaserne < maxStufeKaserne || stufeStall < maxStufeStall || stufeWerkstatt < maxStufeWerkstatt || stufeAdelshof < maxStufeAdelshof || stufeSchmiede < maxStufeSchmiede || stufeMarktplatz < maxStufeMarktplatz || stufeHolzfaeller < maxStufeHolzfaeller || stufeLehmgrube < maxStufeLehmgrube || stufeEisenmine < maxStufeEisenmine || stufeBauernhof < maxStufeBauernhof || stufeWall < maxStufeWall) {
            randomGebaeudeId = gebaeudeIDs.get(new Random().nextInt(gebaeudeIDs.size()));
            randomAusbauplan.add(randomGebaeudeId);
            i++;

            switch (randomGebaeudeId) {
                case 1 -> stufeHauptgebaeude++;
                case 2 -> stufeKaserne++;
                case 3 -> stufeStall++;
                case 4 -> stufeWerkstatt++;
                case 5 -> stufeAdelshof++;
                case 6 -> stufeSchmiede++;
                case 9 -> stufeMarktplatz++;
                case 10 -> stufeHolzfaeller++;
                case 11 -> stufeLehmgrube++;
                case 12 -> stufeEisenmine++;
                case 13 -> stufeBauernhof++;
                case 16 -> stufeWall++;
            }

            if (stufeHauptgebaeude == maxStufeHauptgebaeude) {
                gebaeudeIDs.removeAll(Collections.singleton(1));
            }
            if (stufeKaserne == maxStufeKaserne) {
                gebaeudeIDs.removeAll(Collections.singleton(2));
            }
            if (stufeStall == maxStufeStall) {
                gebaeudeIDs.removeAll(Collections.singleton(3));
            }
            if (stufeWerkstatt == maxStufeWerkstatt) {
                gebaeudeIDs.removeAll(Collections.singleton(4));
            }
            if (stufeAdelshof == maxStufeAdelshof) {
                gebaeudeIDs.removeAll(Collections.singleton(5));
            }
            if (stufeSchmiede == maxStufeSchmiede) {
                gebaeudeIDs.removeAll(Collections.singleton(6));
            }
            if (stufeMarktplatz == maxStufeMarktplatz) {
                gebaeudeIDs.removeAll(Collections.singleton(9));
            }
            if (stufeHolzfaeller == maxStufeHolzfaeller) {
                gebaeudeIDs.removeAll(Collections.singleton(10));
            }
            if (stufeLehmgrube == maxStufeLehmgrube) {
                gebaeudeIDs.removeAll(Collections.singleton(11));
            }
            if (stufeEisenmine == maxStufeEisenmine) {
                gebaeudeIDs.removeAll(Collections.singleton(12));
            }
            if (stufeBauernhof == maxStufeBauernhof) {
                gebaeudeIDs.removeAll(Collections.singleton(13));
            }
            if (stufeWall == maxStufeWall) {
                gebaeudeIDs.removeAll(Collections.singleton(16));
            }
        }

        return randomAusbauplan;
    }
}
