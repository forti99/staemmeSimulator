package berechnungen;

import gebaeude.gebaeudeSonderfunktion.Speicher;

import java.util.Arrays;

public class SimErgebnis {
    private final int durchlaeufe;
    private int durchlaeufMitOptimalemDorf;
    private Dorf optimalesDorf;
    private long laufzeit;

    public SimErgebnis(int durchlaeufe, int durchlaeufMitOptimalemDorf, Dorf optimalesDorf, long laufzeit) {
        this.durchlaeufe = durchlaeufe;
        this.durchlaeufMitOptimalemDorf = durchlaeufMitOptimalemDorf;
        this.optimalesDorf = optimalesDorf;
        this.laufzeit = laufzeit;
    }

    public void setDurchlaeufMitOptimalemDorf(int durchlaeufMitOptimalemDorf) {
        this.durchlaeufMitOptimalemDorf = durchlaeufMitOptimalemDorf;
    }

    public void setOptimalesDorf(Dorf optimalesDorf) {
        this.optimalesDorf = optimalesDorf;
    }

    public void setLaufzeit(long laufzeit) {
        this.laufzeit = laufzeit;
    }

    @Override
    public String toString() {
        return "\n Anzahl Durchläufe:                      " + durchlaeufe +
                "\n Durchlaufzeit (in ms):                  " + laufzeit +
                "\n Laufzeit pro Dorfberechnung (in ms):    " + laufzeit / (float) durchlaeufe +
                "\n Durchlauf mit optimalem Dorf:           " + durchlaeufMitOptimalemDorf +
                "\n Dorfname:                               " + optimalesDorf.getName() +
                "\n Speicherinhalt:                         " + ((Speicher) optimalesDorf.getSpeicher()).getRohstoffvorrat() +
                "\n verlorene Rohstoffe:                    " + ((Speicher) optimalesDorf.getSpeicher()).getUebergelaufeneRohstoffe() +
                "\n Stufe Hauptgebaeude:                    " + optimalesDorf.getHauptgebaeude().getStufe() +
                "\n Stufe Kaserne:                          " + optimalesDorf.getKaserne().getStufe() +
                "\n Stufe Stall:                            " + optimalesDorf.getStall().getStufe() +
                "\n Stufe Werkstatt:                        " + optimalesDorf.getWerkstatt().getStufe() +
                "\n Stufe Adelshof:                         " + optimalesDorf.getAdelshof().getStufe() +
                "\n Stufe Schmiede:                         " + optimalesDorf.getSchmiede().getStufe() +
                "\n Stufe Versammlungsplatz:                " + optimalesDorf.getVersammlungsplatz().getStufe() +
                "\n Stufe Statue:                           " + optimalesDorf.getStatue().getStufe() +
                "\n Stufe Marktplatz:                       " + optimalesDorf.getMarktplatz().getStufe() +
                "\n Stufe Holzfaeller:                      " + optimalesDorf.getHolzfaeller().getStufe() +
                "\n Stufe Lehmgrube:                        " + optimalesDorf.getLehmgrube().getStufe() +
                "\n Stufe Eisenmine:                        " + optimalesDorf.getEisenmine().getStufe() +
                "\n Stufe Bauernhof:                        " + optimalesDorf.getBauernhof().getStufe() +
                "\n Stufe Speicher:                         " + optimalesDorf.getSpeicher().getStufe() +
                "\n Stufe Versteck:                         " + optimalesDorf.getVersteck().getStufe() +
                "\n Stufe Wall:                             " + optimalesDorf.getWall().getStufe() +
                "\n Gebäudestufen gesamt:                   " + Arrays.toString(optimalesDorf.getGebaeudeStufen()) +
                "\n Ausgebaute Gebäude:                     " + optimalesDorf.getAusgebauteGebaeude() +
                "\n Bauzeit (in h):                         " + optimalesDorf.getBisherigeBauzeit();
    }
}
