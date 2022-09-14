package berechnungen;

import java.util.Arrays;

import static gebaeude.GebaeudeTypen.*;

public class SimErgebnis {
    private final int durchlaeufe;
    private final Dorf optimalesDorf;
    private final long laufzeit;

    public SimErgebnis(int durchlaeufe, Dorf optimalesDorf, long laufzeit) {
        this.durchlaeufe = durchlaeufe;
        this.optimalesDorf = optimalesDorf;
        this.laufzeit = laufzeit;
    }

    @Override
    public String toString() {
        int[] gebaeudeStufen = optimalesDorf.getGebaeudeStufen();

        return "\n Anzahl Durchläufe:                      " + durchlaeufe +
                "\n Durchlaufzeit (in ms):                  " + laufzeit +
                "\n Laufzeit pro Dorfberechnung (in ms):    " + laufzeit / (float) durchlaeufe +
                "\n Dorfname:                               " + optimalesDorf.getName() +
                "\n Speicherinhalt:                         " + (optimalesDorf.getSpeicher()).getRohstoffvorrat() +
                "\n verlorene Rohstoffe:                    " + (optimalesDorf.getSpeicher()).getUebergelaufeneRohstoffe() +
                "\n Stufe Hauptgebaeude:                    " + gebaeudeStufen[HAUPTGEBAEUDE.getId()] +
                "\n Stufe Kaserne:                          " + gebaeudeStufen[KASERNE.getId()] +
                "\n Stufe Stall:                            " + gebaeudeStufen[STALL.getId()] +
                "\n Stufe Werkstatt:                        " + gebaeudeStufen[WERKSTATT.getId()] +
                "\n Stufe Adelshof:                         " + gebaeudeStufen[ADELSHOF.getId()] +
                "\n Stufe Schmiede:                         " + gebaeudeStufen[SCHMIEDE.getId()] +
                "\n Stufe Versammlungsplatz:                " + gebaeudeStufen[VERSAMMLUNGSPLATZ.getId()] +
                "\n Stufe Statue:                           " + gebaeudeStufen[STATUE.getId()] +
                "\n Stufe Marktplatz:                       " + gebaeudeStufen[MARKTPLATZ.getId()] +
                "\n Stufe Holzfaeller:                      " + gebaeudeStufen[HOLZFAELLER.getId()] +
                "\n Stufe Lehmgrube:                        " + gebaeudeStufen[LEHMGRUBE.getId()] +
                "\n Stufe Eisenmine:                        " + gebaeudeStufen[EISENMINE.getId()] +
                "\n Stufe Bauernhof:                        " + gebaeudeStufen[BAUERNHOF.getId()] +
                "\n Stufe Speicher:                         " + gebaeudeStufen[SPEICHER.getId()] +
                "\n Stufe Versteck:                         " + gebaeudeStufen[VERSTECK.getId()] +
                "\n Stufe Wall:                             " + gebaeudeStufen[WALL.getId()] +
                "\n Gebäudestufen gesamt:                   " + Arrays.toString(gebaeudeStufen) +
                "\n Ausgebaute Gebäude:                     " + optimalesDorf.getAusgebauteGebaeude() +
                "\n Bauzeit (in h):                         " + optimalesDorf.getBisherigeBauzeit();
    }
}
