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
                "\n Stufe Hauptgebaeude:                    " + gebaeudeStufen[HAUPTGEBAEUDE.getId() - 1] +
                "\n Stufe Kaserne:                          " + gebaeudeStufen[KASERNE.getId() - 1] +
                "\n Stufe Stall:                            " + gebaeudeStufen[STALL.getId() - 1] +
                "\n Stufe Werkstatt:                        " + gebaeudeStufen[WERKSTATT.getId() - 1] +
                "\n Stufe Adelshof:                         " + gebaeudeStufen[ADELSHOF.getId() - 1] +
                "\n Stufe Schmiede:                         " + gebaeudeStufen[SCHMIEDE.getId() - 1] +
                "\n Stufe Versammlungsplatz:                " + gebaeudeStufen[VERSAMMLUNGSPLATZ.getId() - 1] +
                "\n Stufe Statue:                           " + gebaeudeStufen[STATUE.getId() - 1] +
                "\n Stufe Marktplatz:                       " + gebaeudeStufen[MARKTPLATZ.getId() - 1] +
                "\n Stufe Holzfaeller:                      " + gebaeudeStufen[HOLZFAELLER.getId() - 1] +
                "\n Stufe Lehmgrube:                        " + gebaeudeStufen[LEHMGRUBE.getId() - 1] +
                "\n Stufe Eisenmine:                        " + gebaeudeStufen[EISENMINE.getId() - 1] +
                "\n Stufe Bauernhof:                        " + gebaeudeStufen[BAUERNHOF.getId() - 1] +
                "\n Stufe Speicher:                         " + gebaeudeStufen[SPEICHER.getId() - 1] +
                "\n Stufe Versteck:                         " + gebaeudeStufen[VERSTECK.getId() - 1] +
                "\n Stufe Wall:                             " + gebaeudeStufen[WALL.getId() - 1] +
                "\n Gebäudestufen gesamt:                   " + Arrays.toString(gebaeudeStufen) +
                "\n Ausgebaute Gebäude:                     " + optimalesDorf.getAusgebauteGebaeude() +
                "\n Bauzeit (in h):                         " + optimalesDorf.getBisherigeBauzeit();
    }
}
