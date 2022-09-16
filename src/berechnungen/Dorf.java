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
    private final List<GebaeudeTypen> ausgebauteGebaeude = new ArrayList<>();
    private final GebaeudeDaten gebaeudeDaten;
    private final int[] gebaeudeStufen;
    private final Speicher speicher;
    private final Einstellungen einstellungen;

    public Dorf(String name, int[] gebaeudeStufen, Speicher speicher, Einstellungen einstellungen) {
        this.name = name;
        this.speicher = speicher;
        this.gebaeudeStufen = Arrays.copyOf(gebaeudeStufen, gebaeudeStufen.length);
        gebaeudeDaten = new GebaeudeDaten();
        this.einstellungen = einstellungen;
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
                gebaeudeIds.add(GebaeudeTypen.getById(i));
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
            if (gebaeudeStufen[gebaeudeTyp.getId()] < gebaeudeTyp.getMaxStufe() && speicher.passenBaukostenInSpeicher(gebaeudeTyp, gebaeudeStufen[gebaeudeTyp.getId()]) && voraussetzungErfuellt(gebaeudeTyp)) {
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

        int neueStufe = gebaeudeStufen[gebaeudeTyp.getId()] + 1;
        Rohstoffe baukosten = gebaeudeDaten.getBaukosten(gebaeudeTyp, neueStufe);

        int baukostenHolz = baukosten.getHolz();
        int baukostenLehm = baukosten.getLehm();
        int baukostenEisen = baukosten.getEisen();
        int speicherHolzvorrat = speicher.getHolzvorrat();
        int speicherLehmvorrat = speicher.getLehmvorrat();
        int speicherEisenvorrat = speicher.getEisenvorrat();

        if (!speicher.passenBaukostenInSpeicher(gebaeudeTyp, neueStufe)) {
            verbleibendeZeit += speicherFuerGebaeudeAusbauen(gebaeudeTyp, neueStufe);
        }

        //Es wird ermittelt ob noch Rohstoffe für den Bau des Gebaeudes fehlen. Wen nicht wird der entsprechende Wert auf "0" gesetzt
        fehlendeRohstoffe.setHolz(Math.max(baukostenHolz - speicherHolzvorrat, 0));
        fehlendeRohstoffe.setLehm(Math.max(baukostenLehm - speicherLehmvorrat, 0));
        fehlendeRohstoffe.setEisen(Math.max(baukostenEisen - speicherEisenvorrat, 0));

        //Fehlende Zeit bis genuegend Rohstoffe vorhanden sind wird berechnet. Ausschlaggebend ist dabei der Rohstoff auf den am laengsten "gewartet" werden muss.
        double verbleibendeZeitHolz = fehlendeRohstoffe.getHolz() / (double) getProduktion(HOLZFAELLER);
        double verbleibendeZeitLehm = fehlendeRohstoffe.getLehm() / (double) getProduktion(LEHMGRUBE);
        double verbleibendeZeitEisen = fehlendeRohstoffe.getEisen() / (double) getProduktion(EISENMINE);
        verbleibendeZeit += Math.max(Math.max(verbleibendeZeitHolz, verbleibendeZeitLehm), verbleibendeZeitEisen);

        //Inhalt des Speichers wird entsprechend aktualisiert. Dabei werden die in der Wartezeit erzeugten Rohstoffe eingelagert,
        //aber gleichzeitig die Baukosten des Gebaeudes direkt wieder abgezogen
        speicher.addHolz((int) Math.ceil(verbleibendeZeit * getProduktion(HOLZFAELLER)));
        speicher.addLehm((int) Math.ceil(verbleibendeZeit * getProduktion(LEHMGRUBE)));
        speicher.addEisen((int) Math.ceil(verbleibendeZeit * getProduktion(EISENMINE)));
        speicher.addHolz(-baukostenHolz);
        speicher.addLehm(-baukostenLehm);
        speicher.addEisen(-baukostenEisen);

        //Nach dem abgeschlossenen Bau wird die Stufe des Gebaeudes erhoeht
        gebaeudeStufen[gebaeudeTyp.getId()] += 1;
        if (gebaeudeTyp == SPEICHER) {
            speicher.setStufe(neueStufe);
        }

        //Ueberprueft ob Belohungen aktiv sind und fuegt dann entsprechende Rohstoffe zum Speicher hinzu
        if (einstellungen.isBelohnungenAktiv()) {
            speicher.addRohstoffe(einstellungen.getBelohnung(gebaeudeTyp, neueStufe));
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
     * @return Bauzeit fuer den Speicherbau
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
     * @return Aussage ob die Voraussetzungen erfüllt sind
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

    //Liefert die Produktion fuer das uebergebene Rohstoffgebaeude zurueck
    public int getProduktion(GebaeudeTypen gebaeudeTyp) {
        return einstellungen.getProduktionsrate(gebaeudeStufen[gebaeudeTyp.getId()]);
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

    public int[] getGebaeudeStufen() {
        return gebaeudeStufen;
    }

    public List<GebaeudeTypen> getAusgebauteGebaeude() {
        return ausgebauteGebaeude;
    }

    public Einstellungen getEinstellungen() {
        return einstellungen;
    }

    @Override
    public String toString() {
        return "\n Dorfname:               " + name +
                "\n Speicherinhalt:         " + (getSpeicher()).getRohstoffvorrat() +
                "\n verlorene Rohstoffe:    " + (getSpeicher()).getUebergelaufeneRohstoffe() +
                "\n Stufe Hauptgebaeude:    " + gebaeudeStufen[HAUPTGEBAEUDE.getId()] +
                "\n Stufe Kaserne:          " + gebaeudeStufen[KASERNE.getId()] +
                "\n Stufe Stall:            " + gebaeudeStufen[STALL.getId()] +
                "\n Stufe Werkstatt:        " + gebaeudeStufen[WERKSTATT.getId()] +
                "\n Stufe Adelshof:         " + gebaeudeStufen[ADELSHOF.getId()] +
                "\n Stufe Schmiede:         " + gebaeudeStufen[SCHMIEDE.getId()] +
                "\n Stufe Versammlungsplatz:" + gebaeudeStufen[VERSAMMLUNGSPLATZ.getId()] +
                "\n Stufe Statue:           " + gebaeudeStufen[STATUE.getId()] +
                "\n Stufe Marktplatz:       " + gebaeudeStufen[MARKTPLATZ.getId()] +
                "\n Stufe Holzfaeller:      " + gebaeudeStufen[HOLZFAELLER.getId()] +
                "\n Stufe Lehmgrube:        " + gebaeudeStufen[LEHMGRUBE.getId()] +
                "\n Stufe Eisenmine:        " + gebaeudeStufen[EISENMINE.getId()] +
                "\n Stufe Bauernhof:        " + gebaeudeStufen[BAUERNHOF.getId()] +
                "\n Stufe Speicher:         " + gebaeudeStufen[SPEICHER.getId()] +
                "\n Stufe Versteck:         " + gebaeudeStufen[VERSTECK.getId()] +
                "\n Stufe Wall:             " + gebaeudeStufen[WALL.getId()] +
                "\n Gebäudestufen gesamt:   " + Arrays.toString(gebaeudeStufen) +
                "\n Ausgebaute Gebäude:     " + ausgebauteGebaeude +
                "\n Bauzeit (in h):         " + bisherigeBauzeit;
    }
}
