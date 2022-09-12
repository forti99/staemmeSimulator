package berechnungen;


import gebaeude.GebaeudeDaten;
import gebaeude.GebaeudeTypen;
import gebaeude.gebaeudeSonderfunktion.Speicher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static gebaeude.GebaeudeTypen.*;

public class Dorf {

    private final String name;
    private double bisherigeBauzeit = 0;
    private final boolean belohnungenAktiv;
    private final List<GebaeudeTypen> ausgebauteGebaeude = new ArrayList<>();
    private final GebaeudeDaten gebaeudeDaten;
    private final int[] gebaeudeStufen;
    private final Speicher speicher;

    public Dorf(String name, boolean belohnungenAktiv, int[] gebaeudeStufen, Speicher speicher) {
        this.name = name;
        this.belohnungenAktiv = belohnungenAktiv;
        this.speicher = speicher;
        this.gebaeudeStufen = Arrays.copyOf(gebaeudeStufen, gebaeudeStufen.length);
        gebaeudeDaten = new GebaeudeDaten();
    }

    public double genauNachStufenAusbauen(int[] gebaeudeStufen) {
        double bauzeit = 0;
        while (!Arrays.equals(this.gebaeudeStufen, gebaeudeStufen)) {
            ArrayList<GebaeudeTypen> ausbauMoeglichUndNoetig = new ArrayList<>();
            List<GebaeudeTypen> moeglicheGebaeudeTypen = getMoeglicheGebaeudeTypen();
            for (GebaeudeTypen typ : nochAuszubauendeGebaeudeIds(gebaeudeStufen)) {
                if (moeglicheGebaeudeTypen.contains(typ)) {
                    ausbauMoeglichUndNoetig.add(typ);
                }
            }

            GebaeudeTypen ausbauTyp = ausbauMoeglichUndNoetig.get(new Random().nextInt(ausbauMoeglichUndNoetig.size()));
            bauzeit += gebaeudeAusbauen(ausbauTyp);
        }
        return bauzeit;
    }

    /**
     * Ermittelt die Gebaeudetypen die noch entsprechend der Vorgabe ausgebaut werden muessen
     *
     * @param vorgabeGebaeudeStufen Vorgabe, welche Gebaeudestufe jeweils im Dorf vorhanden sein sollen
     * @return Liste der Gebauedetypen die jeweils noch ausgebaut werden muessen
     */
    public List<GebaeudeTypen> nochAuszubauendeGebaeudeIds(int[] vorgabeGebaeudeStufen) {
        List<GebaeudeTypen> gebaeudeIds = new ArrayList<>();
        int i = 0;
        for (int gebaeudeStufe : gebaeudeStufen) {
            if (gebaeudeStufe < vorgabeGebaeudeStufen[i]) {
                gebaeudeIds.add(GebaeudeTypen.getById(i + 1));
            }
            i++;
        }
        return gebaeudeIds;
    }

    /**
     * Ermittelt die Ids der Gebäude, für die das Dorf die nötigen Voraussetzungen erfuellt (Entsprechende Rohstoffe muessen nicht vorhanden sein!)
     *
     * @return Liste der Gebauede-Ids fuer die die Voraussetzungen erfuellt sind
     */
    public List<GebaeudeTypen> getMoeglicheGebaeudeTypen() {
        List<GebaeudeTypen> gebaeudeTypen = new ArrayList<>();

        for (GebaeudeTypen gebaeudeTyp : GebaeudeTypen.values()) {
            if (gebaeudeStufen[gebaeudeTyp.getId() - 1] < gebaeudeTyp.getMaxStufe() && speicher.passenBaukostenInSpeicher(gebaeudeTyp, gebaeudeStufen[gebaeudeTyp.getId() - 1]) && voraussetzungErfuellt(gebaeudeTyp)) {
                gebaeudeTypen.add(gebaeudeTyp);
            }
        }
        return gebaeudeTypen;
    }

    /**
     * Baut ein Gebaeude um eine Stufe aus. Sollten die noetigen Rohstoffe nicht in den Speicher passen, wird dieser vorher ausgebaut. Es wird dann gewartet bis genuegend Rohstoffe im Speicher vorhanden sind.
     * Dann werden die Baukosten (+ Kosten des Speichers) von den vorhandenen Rohstoffen abgezogen und dann die Stufe des entsprechende Gebaeudes erhoeht
     *
     * @param gebaeudeTyp Typ des Gebaeudes das ausgebaut werden soll
     * @return Zeit, die gewartet werden muss, bis das Gebaeude gebaut werden kann
     */
    public double gebaeudeAusbauen(GebaeudeTypen gebaeudeTyp) {
        Rohstoffe fehlendeRohstoffe = new Rohstoffe();
        double verbleibendeZeit = 0;
        
        int neueStufe = gebaeudeStufen[gebaeudeTyp.getId() - 1] + 1;
        Rohstoffe baukosten = gebaeudeDaten.getBaukosten(gebaeudeTyp, neueStufe);   
        
        int baukostenHolz = baukosten.getHolz();
        int baukostenLehm = baukosten.getLehm();
        int baukostenEisen = baukosten.getEisen();
        int speicherHolzvorrat =  speicher.getHolzvorrat();
        int speicherLehmvorrat = speicher.getLehmvorrat();
        int speicherEisenvorrat = speicher.getEisenvorrat();
       
        if (!speicher.passenBaukostenInSpeicher(gebaeudeTyp, neueStufe)) {
            verbleibendeZeit += speicherFuerGebaeudeAusbauen(gebaeudeTyp, neueStufe);
        }
        
        if (baukostenHolz > speicherHolzvorrat) {
            fehlendeRohstoffe.setHolz(baukostenHolz - speicherHolzvorrat);
        } else {
            fehlendeRohstoffe.setHolz(0);
        }

        if (baukostenLehm > speicherLehmvorrat) {
            fehlendeRohstoffe.setLehm(baukostenLehm - speicherLehmvorrat);
        } else {
            fehlendeRohstoffe.setLehm(0);
        }

        if (baukostenEisen > speicherEisenvorrat) {
            fehlendeRohstoffe.setEisen(baukostenEisen - speicherEisenvorrat);
        } else {
            fehlendeRohstoffe.setEisen(0);
        }

        //Fehlende Zeit bis genuegend Rohstoffe vorhanden sind wird berechnet. Ausschlaggebend ist dabei der Rohstoff auf den am laengsten "gewartet" werden muss.
        double verbleibendeZeitHolz = fehlendeRohstoffe.getHolz() / (double) getProduktionHolz();
        double verbleibendeZeitLehm = fehlendeRohstoffe.getLehm() / (double) getProduktionLehm();
        double verbleibendeZeitEisen = fehlendeRohstoffe.getEisen() / (double) getProduktionEisen();
        verbleibendeZeit += Math.max(Math.max(verbleibendeZeitHolz, verbleibendeZeitLehm), verbleibendeZeitEisen);

        //Inhalt des Speichers wird entsprechend aktualisiert. Dabei werden die in der Wartezeit erzeugten Rohstoffe eingelagert,
        //aber gleichzeitig die Baukosten des Gebaeudes direkt wieder abgezogen
        speicher.addHolz(((int) Math.ceil(verbleibendeZeit * getProduktionHolz())) - baukostenHolz);
        speicher.addLehm(((int) Math.ceil(verbleibendeZeit * getProduktionLehm())) - baukostenLehm);
        speicher.addEisen(((int) Math.ceil(verbleibendeZeit * getProduktionEisen())) - baukostenEisen);

        //Rohstoffe für den abgeschlossenen Bau werden hinzugefuegt (falls Belohnungen aktiv sind) und die Stufe des Gebaeudes erhoeht
        gebaeudeStufen[id - 1] += 1;
        if (gebaeudeTyp == SPEICHER) {
            speicher.setStufe(neueStufe);
        }
        if (belohnungenAktiv) {
            speicher.addRohstoffe(Einstellungen.getBelohnung(gebaeudeTyp, neueStufe));
        }

        ausgebauteGebaeude.add(gebaeudeTyp);

        this.bisherigeBauzeit += verbleibendeZeit;
        return verbleibendeZeit;
    }

    /**
     * Baut den Speicher des Dorfes so aus, dass die fuer das uebergebene Gebaeude und Stufe benoetigten Rohstoffe in den Speicher passen
     *
     * @param gebaeudeTyp Gebaeude dessen Rohstoffkosten in den Speicher passen sollen
     * @param stufe       Stufe des Gebaeudes
     * @return bauzeit fuer Speicherbau
     */
    public double speicherFuerGebaeudeAusbauen(GebaeudeTypen gebaeudeTyp, int stufe) {
        double bauzeit = 0;
        while (!speicher.passenBaukostenInSpeicher(gebaeudeTyp, stufe)) {
            bauzeit += gebaeudeAusbauen(SPEICHER);
        }
        return bauzeit;
    }

    /**
     * Ueberprueft ob das Dorf die Voraussetzungen für den jeweiligen Gebaeudetyp erfuellt
     *
     * @param gebaeudeTyp Gebaeudetyp
     * @return Aussage od die Voraussetzungen erfüllt sind
     */
    private boolean voraussetzungErfuellt(GebaeudeTypen gebaeudeTyp) {
        int[] voraussetzungen = gebaeudeDaten.getGebaeudeVoraussetzung(gebaeudeTyp);
        if (gebaeudeStufen.length != voraussetzungen.length) {
            throw new IllegalArgumentException("Anzahl/Länge der Gebäudestufen und der der Voraussetzungen passen nicht zusammen");
        } else {
            int i = 0;
            while (i < voraussetzungen.length) {
                if (gebaeudeStufen[i] != 0) {
                    if (gebaeudeStufen[i] < voraussetzungen[i]) {
                        return false;
                    }
                }
                i++;
            }
            return true;
        }
    }

    public Dorf dorfKopierenSpeicherZuruecksetzen(Speicher speicher) {
        return new Dorf(name, belohnungenAktiv, gebaeudeStufen, speicher);
    }

    public int getProduktionHolz() {
        return Einstellungen.produktionsraten[gebaeudeStufen[HOLZFAELLER.getId() - 1]] * Einstellungen.weltengeschwindigkeit * Einstellungen.minengeschwindigkeit;
    }

    public int getProduktionLehm() {
        return Einstellungen.produktionsraten[gebaeudeStufen[LEHMGRUBE.getId() - 1]] * Einstellungen.weltengeschwindigkeit * Einstellungen.minengeschwindigkeit;
    }

    public int getProduktionEisen() {
        return Einstellungen.produktionsraten[gebaeudeStufen[EISENMINE.getId() - 1]] * Einstellungen.weltengeschwindigkeit * Einstellungen.minengeschwindigkeit;
    }

    public Speicher getSpeicher() {
        return speicher;
    }

    public String getName() {
        return name;
    }

    public double getBisherigeBauzeit() {
        return bisherigeBauzeit;
    }

    public boolean isBelohnungenAktiv() {
        return belohnungenAktiv;
    }

    public int[] getGebaeudeStufen() {
        return gebaeudeStufen;
    }

    public GebaeudeDaten getGebaeudeDaten() {
        return gebaeudeDaten;
    }

    public List<GebaeudeTypen> getAusgebauteGebaeude() {
        return ausgebauteGebaeude;
    }

    @Override
    public String toString() {
        return "\n Dorfname:               " + name +
                "\n Speicherinhalt:         " + (getSpeicher()).getRohstoffvorrat() +
                "\n verlorene Rohstoffe:    " + (getSpeicher()).getUebergelaufeneRohstoffe() +
                "\n Stufe Hauptgebaeude:    " + gebaeudeStufen[HAUPTGEBAEUDE.getId() - 1] +
                "\n Stufe Kaserne:          " + gebaeudeStufen[KASERNE.getId() - 1] +
                "\n Stufe Stall:            " + gebaeudeStufen[STALL.getId() - 1] +
                "\n Stufe Werkstatt:        " + gebaeudeStufen[WERKSTATT.getId() - 1] +
                "\n Stufe Adelshof:         " + gebaeudeStufen[ADELSHOF.getId() - 1] +
                "\n Stufe Schmiede:         " + gebaeudeStufen[SCHMIEDE.getId() - 1] +
                "\n Stufe Versammlungsplatz:" + gebaeudeStufen[VERSAMMLUNGSPLATZ.getId() - 1] +
                "\n Stufe Statue:           " + gebaeudeStufen[STATUE.getId() - 1] +
                "\n Stufe Marktplatz:       " + gebaeudeStufen[MARKTPLATZ.getId() - 1] +
                "\n Stufe Holzfaeller:      " + gebaeudeStufen[HOLZFAELLER.getId() - 1] +
                "\n Stufe Lehmgrube:        " + gebaeudeStufen[LEHMGRUBE.getId() - 1] +
                "\n Stufe Eisenmine:        " + gebaeudeStufen[EISENMINE.getId() - 1] +
                "\n Stufe Bauernhof:        " + gebaeudeStufen[BAUERNHOF.getId() - 1] +
                "\n Stufe Speicher:         " + gebaeudeStufen[SPEICHER.getId() - 1] +
                "\n Stufe Versteck:         " + gebaeudeStufen[VERSTECK.getId() - 1] +
                "\n Stufe Wall:             " + gebaeudeStufen[WALL).getId( - 1] +
                "\n Gebäudestufen gesamt:   " + Arrays.toString(gebaeudeStufen) +
                "\n Ausgebaute Gebäude:     " + ausgebauteGebaeude +
                "\n Bauzeit (in h):         " + bisherigeBauzeit;
    }
}
