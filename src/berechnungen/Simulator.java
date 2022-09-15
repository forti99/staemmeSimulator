package berechnungen;


import gebaeude.gebaeudeSonderfunktion.Speicher;

public class Simulator {
    private int anzahlDurchlaeufe = 0;
    private int optimalesDorf = null;
    private long laufzeit = 0;

    public void nachStufenAusbauen(int[] gebaeudeStufenAusbaustart, int[] gebaeudeStufenAusbauziel, Speicher speicher, int anzahlVersuche, Einstellungen einstellungen) {
        anzahlDurchlaeufe = anzahlVersuche;
        double minBauzeit = Double.MAX_VALUE;
        double bauzeit;
        Dorf dorfFuerAusbau;
        
        final long timeStart = System.currentTimeMillis();
        for (int i = 0; i < anzahlDurchlaeufe; i++) {
            dorfFuerAusbau = new Dorf("Dorf " + (i + 1), gebaeudeStufenAusbaustart, speicher, einstellungen);
            bauzeit = dorfFuerAusbau.genauNachStufenAusbauen(gebaeudeStufenAusbauziel);
            System.out.println("Durchläufe im Simulator: " + i);
            if (bauzeit < minBauzeit) {
                minBauzeit = bauzeit;
                optimalesDorf = dorfFuerAusbau;
            }
        }
        final long timeStop = System.currentTimeMillis();
        laufzeit = timeStop - timeStart;
    }
    
    public void ergebnisseDarstellen(){
        int[] gebaeudeStufen = optimalesDorf.getGebaeudeStufen();
        Einstellungen einstellungen = optimalesDorf.getEinstellungen();

        System.out.println(
                "\n Anzahl Durchläufe:                      " + anzahlDurchlaeufe +
                "\n Durchlaufzeit (in ms):                  " + laufzeit +
                "\n Laufzeit pro Dorfberechnung (in ms):    " + laufzeit / (float) anzahlDurchlaeufe +
                "\n                                         " +
                "\n Weltengeschwindigkeit:                  " + einstellungen.getWeltengeschwindigkeit() +
                "\n Minengeschwindigkeit:                   " + einstellungen.getMinengeschwindigkeit() +
                "\n Belohnungssystem aktiv?                 " + einstellungen.isBelohnungenAktiv() +
                "\n                                         " +
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
                "\n Bauzeit (in h):                         " + optimalesDorf.getBisherigeBauzeit()
            )
    }  
}
