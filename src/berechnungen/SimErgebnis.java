package berechnungen;

import gebaeude.GebaeudeDaten;

import java.util.Arrays;

import static gebaeude.GebaeudeTypen.*;

public class SimErgebnis {
    private final int durchlaeufe;
    private final Dorf optimalesDorf;
    private final GebaeudeDaten gebaeudeDaten;
    private final long laufzeit;

    public SimErgebnis(int durchlaeufe, Dorf optimalesDorf, long laufzeit) {
        this.durchlaeufe = durchlaeufe;
        this.optimalesDorf = optimalesDorf;
        this.gebaeudeDaten = this.optimalesDorf.getGebaeudeDaten();
        this.laufzeit = laufzeit;
    }

    @Override
    public String toString() {
        return "\n Anzahl Durchläufe:                      " + durchlaeufe +
                "\n Durchlaufzeit (in ms):                  " + laufzeit +
                "\n Laufzeit pro Dorfberechnung (in ms):    " + laufzeit / (float) durchlaeufe +
                "\n Dorfname:                               " + optimalesDorf.getName() +
                "\n Speicherinhalt:                         " + (optimalesDorf.getSpeicher()).getRohstoffvorrat() +
                "\n verlorene Rohstoffe:                    " + (optimalesDorf.getSpeicher()).getUebergelaufeneRohstoffe() +
                "\n Stufe Hauptgebaeude:                    " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(HAUPTGEBAEUDE) - 1] +
                "\n Stufe Kaserne:                          " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(KASERNE) - 1] +
                "\n Stufe Stall:                            " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(STALL) - 1] +
                "\n Stufe Werkstatt:                        " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(WERKSTATT) - 1] +
                "\n Stufe Adelshof:                         " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(ADELSHOF) - 1] +
                "\n Stufe Schmiede:                         " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(SCHMIEDE) - 1] +
                "\n Stufe Versammlungsplatz:                " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(VERSAMMLUNGSPLATZ) - 1] +
                "\n Stufe Statue:                           " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(STATUE) - 1] +
                "\n Stufe Marktplatz:                       " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(MARKTPLATZ) - 1] +
                "\n Stufe Holzfaeller:                      " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(HOLZFAELLER) - 1] +
                "\n Stufe Lehmgrube:                        " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(LEHMGRUBE) - 1] +
                "\n Stufe Eisenmine:                        " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(EISENMINE) - 1] +
                "\n Stufe Bauernhof:                        " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(BAUERNHOF) - 1] +
                "\n Stufe Speicher:                         " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(SPEICHER) - 1] +
                "\n Stufe Versteck:                         " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(VERSTECK) - 1] +
                "\n Stufe Wall:                             " + optimalesDorf.getGebaeudeStufen()[gebaeudeDaten.getId(WALL) - 1] +
                "\n Gebäudestufen gesamt:                   " + Arrays.toString(optimalesDorf.getGebaeudeStufen()) +
                "\n Ausgebaute Gebäude:                     " + optimalesDorf.getAusgebauteGebaeude() +
                "\n Bauzeit (in h):                         " + optimalesDorf.getBisherigeBauzeit();
    }
}
