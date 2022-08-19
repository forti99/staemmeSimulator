package berechnungen;


import java.util.ArrayList;
import java.util.List;
import gebaeude.*;
import gebaeude.gebaeudeSonderfunktion.Speicher;

public class Dorf implements Comparable{

    private String name;
    private double bisherigeBauzeit = 0;
    private boolean belohnungenAktiv;
    private final GebaeudeFabrik fabrik = new GebaeudeFabrik();
    private List<Integer> ausbauplan = new ArrayList<>();
    private List<Integer> ausgebauteGebaeude = new ArrayList<>();
    private Gebaeude hauptgebaeude = fabrik.erzeugeGebaeude(GebaeudeTypen.HAUPTGEBAEUDE,0);
    private Gebaeude kaserne = fabrik.erzeugeGebaeude(GebaeudeTypen.KASERNE,0);
    private Gebaeude stall = fabrik.erzeugeGebaeude(GebaeudeTypen.STALL,0);
    private Gebaeude werkstatt = fabrik.erzeugeGebaeude(GebaeudeTypen.WERKSTATT,0);
    private Gebaeude adelshof = fabrik.erzeugeGebaeude(GebaeudeTypen.ADELSHOF,0);
    private Gebaeude schmiede = fabrik.erzeugeGebaeude(GebaeudeTypen.SCHMIEDE,0);
    private Gebaeude marktplatz = fabrik.erzeugeGebaeude(GebaeudeTypen.MARKTPLATZ,0);
    private Gebaeude holzfaeller = fabrik.erzeugeGebaeude(GebaeudeTypen.HOLZFAELLER,0);
    private Gebaeude lehmgrube = fabrik.erzeugeGebaeude(GebaeudeTypen.LEHMGRUBE,0);
    private Gebaeude eisenmine = fabrik.erzeugeGebaeude(GebaeudeTypen.EISENMINE,0);
    private Gebaeude bauernhof = fabrik.erzeugeGebaeude(GebaeudeTypen.BAUERNHOF,0);
    private Speicher speicher;
    private Gebaeude wall = fabrik.erzeugeGebaeude(GebaeudeTypen.WALL,0);

    public Dorf(String name, boolean belohnungenAktiv, int stufeHauptgebaeude, int stufeKaserne, int stufeStall, int stufeWerkstatt, int stufeAdelshof, int stufeSchmiede, int stufeMarktplatz, int stufeHolzfaeller, int stufeLehmgrube, int stufeEisenmine, int stufeBauernhof, Speicher speicher, int stufeWall) {
        this.name = name;
        this.belohnungenAktiv = belohnungenAktiv;
        hauptgebaeude = fabrik.erzeugeGebaeude(GebaeudeTypen.HAUPTGEBAEUDE,stufeHauptgebaeude);
        kaserne = fabrik.erzeugeGebaeude(GebaeudeTypen.KASERNE,stufeKaserne);
        stall = fabrik.erzeugeGebaeude(GebaeudeTypen.STALL,stufeStall);
        werkstatt = fabrik.erzeugeGebaeude(GebaeudeTypen.WERKSTATT,stufeWerkstatt);
        adelshof = fabrik.erzeugeGebaeude(GebaeudeTypen.ADELSHOF,stufeAdelshof);
        schmiede = fabrik.erzeugeGebaeude(GebaeudeTypen.SCHMIEDE,stufeSchmiede);
        marktplatz = fabrik.erzeugeGebaeude(GebaeudeTypen.MARKTPLATZ,stufeMarktplatz);
        holzfaeller = fabrik.erzeugeGebaeude(GebaeudeTypen.HOLZFAELLER,stufeHolzfaeller);
        lehmgrube = fabrik.erzeugeGebaeude(GebaeudeTypen.LEHMGRUBE,stufeLehmgrube);
        eisenmine = fabrik.erzeugeGebaeude(GebaeudeTypen.EISENMINE,stufeEisenmine);
        bauernhof = fabrik.erzeugeGebaeude(GebaeudeTypen.BAUERNHOF,stufeBauernhof);
        this.speicher = speicher;
        wall = fabrik.erzeugeGebaeude(GebaeudeTypen.WALL,stufeWall);
    }

    public Dorf(double bisherigeBauzeit) {
        this.bisherigeBauzeit = bisherigeBauzeit;
    }

    public double nachPlanAusbauen() {
        for (Integer integer : ausbauplan) {
            bisherigeBauzeit += gebaeudeAusbauen(integer);
        }
        return bisherigeBauzeit;
    }

    public double nachPlanAusbauen(List<Integer> ausbauplan) {
        this.ausbauplan = ausbauplan;
        for (Integer integer : ausbauplan) {
            bisherigeBauzeit += gebaeudeAusbauen(integer);
        }
        return bisherigeBauzeit;
    }

    /**
     * Baut ein Gebaeude um eine Stufe aus. Sollten die noetigen Rohstoffe nicht in den Speicher passen, wird dieser vorher ausgebaut. Es wird dann gewartet bis genuegend Rohstoffe im Speicher vorhanden sind.
     * Dann werden die Baukosten (+ Kosten des Speichers) von den vorhandenen Rohstoffen abgezogen und dann die Stufe des entsprechende Gebaeudes erhoeht
     *
     * @param gebaeudeId Id des Gebaeudes das ausgebaut werden soll
     * @return Zeit, die gewartet werden muss, bis das Gebaeude gebaut werden kann
     */
    public double gebaeudeAusbauen(int gebaeudeId) {
        Gebaeude gebaeude;
        switch (gebaeudeId) {
            case 1 -> gebaeude = this.hauptgebaeude;
            case 2 -> gebaeude = this.kaserne;
            case 3 -> gebaeude = this.stall;
            case 4 -> gebaeude = this.werkstatt;
            case 5 -> gebaeude = this.adelshof;
            case 6 -> gebaeude = this.schmiede;
            case 9 -> gebaeude = this.marktplatz;
            case 10 -> gebaeude = this.holzfaeller;
            case 11 -> gebaeude = this.lehmgrube;
            case 12 -> gebaeude = this.eisenmine;
            case 13 -> gebaeude = this.bauernhof;
            case 14 -> gebaeude = this.speicher;
            case 16 -> gebaeude = this.wall;
            default -> {
                gebaeude = null;
                System.out.println("Fehler beim Gebaeudeausbau");
            }
        }

        assert gebaeude != null;
        int neueStufe = gebaeude.getStufe() + 1;
        Rohstoffe fehlendeRohstoffe = new Rohstoffe();
        double verbleibendeZeit = 0;
        if (!passenBaukostenInSpeicher(gebaeude, neueStufe)) {
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

        //Stufe des Gebaeudes wird erhoeht und die Rohstoffe für den abgeschlossenen Bau hinzugefueggt (falls Belohnungen aktiv sind)
        gebaeude.setStufe(neueStufe);
        if (belohnungenAktiv) {
            speicher.addRohstoffe(getBelohnung(gebaeude));
        }
        ausgebauteGebaeude.add(gebaeude.getId());

        return verbleibendeZeit;
    }

    /**
     * Baut den Speicher des Dorfes so aus, dass die fuer das uebergebene Gebaeude und Stufe benoetigten Rohstoffe in den Speicher passen
     *
     * @param gebaeude Gebaeude dessen Rohstoffkosten in den Speicher passen sollen
     * @param stufe    Stufe des Gebaeudes
     */
    public double speicherFuerGebaeudeAusbauen(Gebaeude gebaeude, int stufe) {
        double bauzeit = 0;
        while (!passenBaukostenInSpeicher(gebaeude, stufe)) {
            bauzeit += gebaeudeAusbauen(14);
        }
        return bauzeit;
    }

    public boolean passenBaukostenInSpeicher(Gebaeude gebaeude, int stufe) {
        int holzkosten = gebaeude.getBaukosten(stufe).getHolz();
        int lehmkosten = gebaeude.getBaukosten(stufe).getLehm();
        int eisenkosten = gebaeude.getBaukosten(stufe).getEisen();
        int hoechsteKosten = Math.max(Math.max(holzkosten, lehmkosten), eisenkosten);

        return speicher.getKapazizaet() >= hoechsteKosten;
    }

    private Rohstoffe getBelohnung(Gebaeude gebaeude) {
        Rohstoffe belohnung = gebaeude.getBaukosten(gebaeude.getStufe());

        belohnung.setHolz((int) (belohnung.getHolz() * 0.1));
        if (belohnung.getHolz() < 150) {
            belohnung.setHolz(150);
        }

        belohnung.setLehm((int) (belohnung.getLehm() * 0.1));
        if (belohnung.getLehm() < 150) {
            belohnung.setLehm(150);
        }

        belohnung.setEisen((int) (belohnung.getEisen() * 0.1));
        if (belohnung.getEisen() < 150) {
            belohnung.setEisen(150);
        }

        return belohnung;
    }

    public Dorf dorfKopieren() {
        return new Dorf(name, belohnungenAktiv, holzfaeller.getStufe(), kaserne.getStufe(), stall.getStufe(), werkstatt.getStufe(), adelshof.getStufe(), schmiede.getStufe(), marktplatz.getStufe(), holzfaeller.getStufe(), lehmgrube.getStufe(), eisenmine.getStufe(), bauernhof.getStufe(), speicher, wall.getStufe());
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

    public String getName() {
        return name;
    }

    public boolean isBelohnungenAktiv() {
        return belohnungenAktiv;
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

    public Gebaeude getSpeicher() {
        return speicher;
    }

    public Gebaeude getWall() {
        return wall;
    }

    public double getBisherigeBauzeit() {
        return bisherigeBauzeit;
    }

    public List<Integer> getAusbauplan() {
        return ausbauplan;
    }

    public List<Integer> getAusgebauteGebaeude() {
        return ausgebauteGebaeude;
    }

    public void setAusbauplan(List<Integer> ausbauplan) {
        this.ausbauplan = ausbauplan;
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
                "\n Stufe Marktplatz:       " + marktplatz.getStufe() +
                "\n Stufe Holzfaeller:      " + holzfaeller.getStufe() +
                "\n Stufe Lehmgrube:        " + lehmgrube.getStufe() +
                "\n Stufe Eisenmine:        " + eisenmine.getStufe() +
                "\n Stufe Bauernhof:        " + bauernhof.getStufe() +
                "\n Stufe Speicher:         " + speicher.getStufe() +
                "\n Stufe Wall:             " + wall.getStufe() +
                "\n Ausbauplan:             " + ausbauplan +
                "\n Ausgebaute Gebäude:     " + ausgebauteGebaeude +
                "\n Bauzeit:                " + bisherigeBauzeit;
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
