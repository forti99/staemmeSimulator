package berechnungen;


import gebaeude.Gebaeude;
import gebaeude.GebaeudeFabrik;
import gebaeude.GebaeudeTypen;
import gebaeude.gebaeudeSonderfunktion.Speicher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dorf implements Comparable {

    private final String name;
    private double bisherigeBauzeit = 0;
    private final boolean belohnungenAktiv;
    private final List<Integer> ausgebauteGebaeude = new ArrayList<>();
    private final List<Gebaeude> gebaeudeListe;
    private final int[] gebaeudeStufen = new int[16];
    private final Gebaeude hauptgebaeude, kaserne, stall, werkstatt, adelshof, schmiede, versammlungsplatz, statue, marktplatz, holzfaeller, lehmgrube, eisenmine, bauernhof, wall, versteck;
    private final Speicher speicher;

    public Dorf(String name, boolean belohnungenAktiv, int stufeHauptgebaeude, int stufeKaserne, int stufeStall, int stufeWerkstatt, int stufeAdelshof, int stufeSchmiede, int stufeVersammlungsplatz, int stufeStatue, int stufeMarktplatz, int stufeHolzfaeller, int stufeLehmgrube, int stufeEisenmine, int stufeBauernhof, Speicher speicher, int stufeVersteck, int stufeWall) {
        this.name = name;
        this.belohnungenAktiv = belohnungenAktiv;
        GebaeudeFabrik fabrik = new GebaeudeFabrik();
        hauptgebaeude = fabrik.erzeugeGebaeude(GebaeudeTypen.HAUPTGEBAEUDE, stufeHauptgebaeude);
        gebaeudeStufen[hauptgebaeude.getId() - 1] = stufeHauptgebaeude;

        kaserne = fabrik.erzeugeGebaeude(GebaeudeTypen.KASERNE, stufeKaserne);
        gebaeudeStufen[kaserne.getId() - 1] = stufeKaserne;

        stall = fabrik.erzeugeGebaeude(GebaeudeTypen.STALL, stufeStall);
        gebaeudeStufen[stall.getId() - 1] = stufeStall;

        werkstatt = fabrik.erzeugeGebaeude(GebaeudeTypen.WERKSTATT, stufeWerkstatt);
        gebaeudeStufen[werkstatt.getId() - 1] = stufeWerkstatt;

        adelshof = fabrik.erzeugeGebaeude(GebaeudeTypen.ADELSHOF, stufeAdelshof);
        gebaeudeStufen[adelshof.getId() - 1] = stufeAdelshof;

        schmiede = fabrik.erzeugeGebaeude(GebaeudeTypen.SCHMIEDE, stufeSchmiede);
        gebaeudeStufen[schmiede.getId() - 1] = stufeSchmiede;

        versammlungsplatz = fabrik.erzeugeGebaeude(GebaeudeTypen.VERSAMMLUNGSPLATZ, stufeVersammlungsplatz);
        gebaeudeStufen[versammlungsplatz.getId() - 1] = stufeVersammlungsplatz;

        statue = fabrik.erzeugeGebaeude(GebaeudeTypen.STATUE, stufeStatue);
        gebaeudeStufen[statue.getId() - 1] = stufeStatue;

        marktplatz = fabrik.erzeugeGebaeude(GebaeudeTypen.MARKTPLATZ, stufeMarktplatz);
        gebaeudeStufen[marktplatz.getId() - 1] = stufeMarktplatz;

        holzfaeller = fabrik.erzeugeGebaeude(GebaeudeTypen.HOLZFAELLER, stufeHolzfaeller);
        gebaeudeStufen[holzfaeller.getId() - 1] = stufeHolzfaeller;

        lehmgrube = fabrik.erzeugeGebaeude(GebaeudeTypen.LEHMGRUBE, stufeLehmgrube);
        gebaeudeStufen[lehmgrube.getId() - 1] = stufeLehmgrube;

        eisenmine = fabrik.erzeugeGebaeude(GebaeudeTypen.EISENMINE, stufeEisenmine);
        gebaeudeStufen[eisenmine.getId() - 1] = stufeEisenmine;

        bauernhof = fabrik.erzeugeGebaeude(GebaeudeTypen.BAUERNHOF, stufeBauernhof);
        gebaeudeStufen[bauernhof.getId() - 1] = stufeBauernhof;

        this.speicher = speicher;
        gebaeudeStufen[speicher.getId() - 1] = speicher.getStufe();

        versteck = fabrik.erzeugeGebaeude(GebaeudeTypen.VERSTECK, stufeVersteck);
        gebaeudeStufen[versteck.getId() - 1] = stufeVersteck;

        wall = fabrik.erzeugeGebaeude(GebaeudeTypen.WALL, stufeWall);
        gebaeudeStufen[wall.getId() - 1] = stufeWall;

        gebaeudeListe = Arrays.asList(hauptgebaeude, kaserne, stall, werkstatt, adelshof, schmiede, versammlungsplatz, statue, marktplatz, holzfaeller, lehmgrube, eisenmine, bauernhof, this.speicher, wall);
    }

    public double genauNachStufenAusbauen(int[] gebaeudeStufen) {
        double bauzeit = 0;
        while (!Arrays.equals(this.gebaeudeStufen, gebaeudeStufen)) {
            ArrayList<Integer> ausbauMoeglichUndNoetig = new ArrayList<>();
            List<Integer> moeglicheGebaeudeIds = getMoeglicheGebaeudeIds();
            for (int i : nochAuszubauendeGebaeudeIds(gebaeudeStufen)) {
                if (moeglicheGebaeudeIds.contains(i)) {
                    ausbauMoeglichUndNoetig.add(i);
                }
            }
            int ausbauId = ausbauMoeglichUndNoetig.get(new Random().nextInt(ausbauMoeglichUndNoetig.size()));
            bauzeit += gebaeudeAusbauen(ausbauId);
        }
        return bauzeit;
    }

    /**
     * Ermittelt die Gebaeude-Ids die noch entsprechende der Vorgabe ausgebaut werden muessen
     *
     * @param vorgabeGebaeudeStufen Vorgabe, welche Gebaeudestufe jeweils im Dorf vorhanden sein sollen
     * @return Liste der Gebauede-Ids die jeweils noch ausgebaut werden muessen
     */
    public List<Integer> nochAuszubauendeGebaeudeIds(int[] vorgabeGebaeudeStufen) {
        List<Integer> gebaeudeIds = new ArrayList<>();
        for (Gebaeude gebaeude : gebaeudeListe) {
            if (gebaeude.getStufe() < vorgabeGebaeudeStufen[gebaeude.getId() - 1]) {
                gebaeudeIds.add(gebaeude.getId());
            }
        }
        return gebaeudeIds;
    }

    /**
     * Ermittelt die Ids der Gebäude, für die das Dorf die nötigen Voraussetzungen erfuellt (Entsprechende Rohstoffe muessen nicht vorhanden sein!)
     *
     * @return Liste der Gebauede-Ids fuer die die Voraussetzungen erfuellt sind
     */
    public List<Integer> getMoeglicheGebaeudeIds() {
        List<Integer> gebaeudeIds = new ArrayList<>();

        for (Gebaeude gebaeude : gebaeudeListe) {
            if (gebaeude.getStufe() < gebaeude.getMaxStufe() && speicher.passenBaukostenInSpeicher(gebaeude, gebaeude.getStufe()) && voraussetzungErfuellt(gebaeude)) {
                gebaeudeIds.add(gebaeude.getId());
            }
        }
        return gebaeudeIds;
    }

    /**
     * Baut ein Gebaeude um eine Stufe aus. Sollten die noetigen Rohstoffe nicht in den Speicher passen, wird dieser vorher ausgebaut. Es wird dann gewartet bis genuegend Rohstoffe im Speicher vorhanden sind.
     * Dann werden die Baukosten (+ Kosten des Speichers) von den vorhandenen Rohstoffen abgezogen und dann die Stufe des entsprechende Gebaeudes erhoeht
     *
     * @param gebaeudeId Id des Gebaeudes das ausgebaut werden soll
     * @return Zeit, die gewartet werden muss, bis das Gebaeude gebaut werden kann
     */
    public double gebaeudeAusbauen(int gebaeudeId) {
        Gebaeude gebaeude = getGebaeude(gebaeudeId);

        int neueStufe = gebaeude.getStufe() + 1;
        Rohstoffe fehlendeRohstoffe = new Rohstoffe();
        double verbleibendeZeit = 0;

        if (!speicher.passenBaukostenInSpeicher(gebaeude, neueStufe)) {
            verbleibendeZeit += speicherFuerGebaeudeAusbauen(gebaeude, neueStufe);
        }

        if (gebaeude.getBaukosten(neueStufe).getHolz() > speicher.getHolzvorrat()) {
            fehlendeRohstoffe.setHolz(gebaeude.getBaukosten(neueStufe).getHolz() - speicher.getHolzvorrat());
        } else {
            fehlendeRohstoffe.setHolz(0);
        }

        if (gebaeude.getBaukosten(neueStufe).getLehm() > speicher.getLehmvorrat()) {
            fehlendeRohstoffe.setLehm(gebaeude.getBaukosten(neueStufe).getLehm() - speicher.getLehmvorrat());
        } else {
            fehlendeRohstoffe.setLehm(0);
        }

        if (gebaeude.getBaukosten(neueStufe).getEisen() > speicher.getEisenvorrat()) {
            fehlendeRohstoffe.setEisen(gebaeude.getBaukosten(neueStufe).getEisen() - speicher.getEisenvorrat());
        } else {
            fehlendeRohstoffe.setEisen(0);
        }


        double verbleibendeZeitHolz = fehlendeRohstoffe.getHolz() / (double) getProduktionHolz();
        double verbleibendeZeitLehm = fehlendeRohstoffe.getLehm() / (double) getProduktionLehm();
        double verbleibendeZeitEisen = fehlendeRohstoffe.getEisen() / (double) getProduktionEisen();
        verbleibendeZeit += Math.max(Math.max(verbleibendeZeitHolz, verbleibendeZeitLehm), verbleibendeZeitEisen);

        speicher.addHolz((int) Math.ceil(verbleibendeZeit * getProduktionHolz()));
        speicher.addLehm((int) Math.ceil(verbleibendeZeit * getProduktionLehm()));
        speicher.addEisen((int) Math.ceil(verbleibendeZeit * getProduktionEisen()));

        speicher.addHolz(-gebaeude.getBaukosten(neueStufe).getHolz());
        speicher.addLehm(-gebaeude.getBaukosten(neueStufe).getLehm());
        speicher.addEisen(-gebaeude.getBaukosten(neueStufe).getEisen());

        //Stufe des Gebaeudes wird erhoeht und die Rohstoffe für den abgeschlossenen Bau hinzugefuegt (falls Belohnungen aktiv sind)
        gebaeude.setStufe(neueStufe);
        if (belohnungenAktiv) {
            speicher.addRohstoffe(Einstellungen.getBelohnung(gebaeude));
        }

        ausgebauteGebaeude.add(gebaeude.getId());
        gebaeudeStufen[gebaeude.getId() - 1]++;

        this.bisherigeBauzeit += verbleibendeZeit;
        return verbleibendeZeit;
    }

    private Gebaeude getGebaeude(int gebaeudeId) {
        Gebaeude gebaeude;
        switch (gebaeudeId) {
            case 1 -> gebaeude = this.hauptgebaeude;
            case 2 -> gebaeude = this.kaserne;
            case 3 -> gebaeude = this.stall;
            case 4 -> gebaeude = this.werkstatt;
            case 5 -> gebaeude = this.adelshof;
            case 6 -> gebaeude = this.schmiede;
            case 7 -> gebaeude = this.versammlungsplatz;
            case 8 -> gebaeude = this.statue;
            case 9 -> gebaeude = this.marktplatz;
            case 10 -> gebaeude = this.holzfaeller;
            case 11 -> gebaeude = this.lehmgrube;
            case 12 -> gebaeude = this.eisenmine;
            case 13 -> gebaeude = this.bauernhof;
            case 14 -> gebaeude = this.speicher;
            case 15 -> gebaeude = this.versteck;
            case 16 -> gebaeude = this.wall;
            default -> throw new IllegalArgumentException("Falsche ID beim Gebäudebau übergeben!");

        }
        return gebaeude;
    }

    /**
     * Baut den Speicher des Dorfes so aus, dass die fuer das uebergebene Gebaeude und Stufe benoetigten Rohstoffe in den Speicher passen
     *
     * @param gebaeude Gebaeude dessen Rohstoffkosten in den Speicher passen sollen
     * @param stufe    Stufe des Gebaeudes
     */
    public double speicherFuerGebaeudeAusbauen(Gebaeude gebaeude, int stufe) {
        double bauzeit = 0;
        while (!speicher.passenBaukostenInSpeicher(gebaeude, stufe)) {
            bauzeit += gebaeudeAusbauen(14);
        }
        return bauzeit;
    }

    private boolean voraussetzungErfuellt(Gebaeude gebaeude) {
        if (gebaeudeStufen.length != gebaeude.getVoraussetzungen().length) {
            throw new IllegalArgumentException("Anzahl/Länge der Gebäudestufen und der der Voraussetzungen passen nicht zusammen");
        } else {
            int i = 0;
            while (i < gebaeude.getVoraussetzungen().length) {
                if (gebaeudeStufen[i] != 0) {
                    if (gebaeudeStufen[i] < gebaeude.getVoraussetzungen()[i]) {
                        return false;
                    }
                }
                i++;
            }
            return true;
        }
    }

    public Dorf dorfKopierenSpeicherZuruecksetzen(Speicher speicher) {
        return new Dorf(name, belohnungenAktiv, holzfaeller.getStufe(), kaserne.getStufe(), stall.getStufe(), werkstatt.getStufe(), adelshof.getStufe(), schmiede.getStufe(), versammlungsplatz.getStufe(), statue.getStufe(), marktplatz.getStufe(), holzfaeller.getStufe(), lehmgrube.getStufe(), eisenmine.getStufe(), bauernhof.getStufe(), speicher, versteck.getStufe(), wall.getStufe());
    }

    public int getProduktionHolz() {
        return Einstellungen.produktionsraten[holzfaeller.getStufe()] * Einstellungen.weltengeschwindigkeit * Einstellungen.minengeschwindigkeit;
    }

    public int getProduktionLehm() {
        return Einstellungen.produktionsraten[lehmgrube.getStufe()] * Einstellungen.weltengeschwindigkeit * Einstellungen.minengeschwindigkeit;
    }

    public int getProduktionEisen() {
        return Einstellungen.produktionsraten[eisenmine.getStufe()] * Einstellungen.weltengeschwindigkeit * Einstellungen.minengeschwindigkeit;
    }

    public Gebaeude getSpeicher() {
        return speicher;
    }

    public String getName() {
        return name;
    }

    public double getBisherigeBauzeit() {
        return bisherigeBauzeit;
    }

    public List<Integer> getAusgebauteGebaeude() {
        return ausgebauteGebaeude;
    }

    public int[] getGebaeudeStufen() {
        return gebaeudeStufen;
    }

    public Gebaeude getHauptgebaeude() {
        return hauptgebaeude;
    }

    public Gebaeude getKaserne() {
        return kaserne;
    }

    public Gebaeude getStall() {
        return stall;
    }

    public Gebaeude getWerkstatt() {
        return werkstatt;
    }

    public Gebaeude getAdelshof() {
        return adelshof;
    }

    public Gebaeude getSchmiede() {
        return schmiede;
    }

    public Gebaeude getVersammlungsplatz() {
        return versammlungsplatz;
    }

    public Gebaeude getStatue() {
        return statue;
    }

    public Gebaeude getMarktplatz() {
        return marktplatz;
    }

    public Gebaeude getHolzfaeller() {
        return holzfaeller;
    }

    public Gebaeude getLehmgrube() {
        return lehmgrube;
    }

    public Gebaeude getEisenmine() {
        return eisenmine;
    }

    public Gebaeude getBauernhof() {
        return bauernhof;
    }

    public Gebaeude getWall() {
        return wall;
    }

    public Gebaeude getVersteck() {
        return versteck;
    }

    @Override
    public String toString() {
        return "\n Dorfname:               " + name +
                "\n Speicherinhalt:         " + ((Speicher) getSpeicher()).getRohstoffvorrat() +
                "\n verlorene Rohstoffe:    " + ((Speicher) getSpeicher()).getUebergelaufeneRohstoffe() +
                "\n Stufe Hauptgebaeude:    " + hauptgebaeude.getStufe() +
                "\n Stufe Kaserne:          " + kaserne.getStufe() +
                "\n Stufe Stall:            " + stall.getStufe() +
                "\n Stufe Werkstatt:        " + werkstatt.getStufe() +
                "\n Stufe Adelshof:         " + adelshof.getStufe() +
                "\n Stufe Schmiede:         " + schmiede.getStufe() +
                "\n Stufe Versammlungsplatz:" + versammlungsplatz.getStufe() +
                "\n Stufe Statue:           " + statue.getStufe() +
                "\n Stufe Marktplatz:       " + marktplatz.getStufe() +
                "\n Stufe Holzfaeller:      " + holzfaeller.getStufe() +
                "\n Stufe Lehmgrube:        " + lehmgrube.getStufe() +
                "\n Stufe Eisenmine:        " + eisenmine.getStufe() +
                "\n Stufe Bauernhof:        " + bauernhof.getStufe() +
                "\n Stufe Speicher:         " + speicher.getStufe() +
                "\n Stufe Versteck:         " + versteck.getStufe() +
                "\n Stufe Wall:             " + wall.getStufe() +
                "\n Gebäudestufen gesamt:   " + Arrays.toString(gebaeudeStufen) +
                "\n Ausgebaute Gebäude:     " + ausgebauteGebaeude +
                "\n Bauzeit (in h):         " + bisherigeBauzeit;
    }

    @Override
    public int compareTo(Object o) {
        Dorf dorf2 = (Dorf) o;
        double diff = this.bisherigeBauzeit - dorf2.bisherigeBauzeit;

        if (diff == 0) {
            return 0;
        } else {
            if (diff < 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
