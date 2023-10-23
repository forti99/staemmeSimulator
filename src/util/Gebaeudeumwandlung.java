package util;

import java.util.HashMap;
import java.util.Map;

public class Gebaeudeumwandlung {
    private static final Map<String, Integer> gebaeudeNummern = new HashMap<>();
    private static final Map<Integer, String> nummernGebaeude = new HashMap<>();

    static {
        gebaeudeNummern.put("Hauptgebäude", 1);
        gebaeudeNummern.put("Kaserne", 2);
        gebaeudeNummern.put("Stall", 3);
        gebaeudeNummern.put("Werkstatt", 4);
        gebaeudeNummern.put("Kirche", 5);
        gebaeudeNummern.put("Erste Kirche", 6);
        gebaeudeNummern.put("Wachturm", 7);
        gebaeudeNummern.put("Adelshof", 8);
        gebaeudeNummern.put("Schmiede", 9);
        gebaeudeNummern.put("Versammlungsplatz", 10);
        gebaeudeNummern.put("Statue", 11);
        gebaeudeNummern.put("Marktplatz", 12);
        gebaeudeNummern.put("Holzfäller", 13);
        gebaeudeNummern.put("Lehmgrube", 14);
        gebaeudeNummern.put("Eisenmine", 15);
        gebaeudeNummern.put("Bauernhof", 16);
        gebaeudeNummern.put("Speicher", 17);
        gebaeudeNummern.put("Versteck", 18);
        gebaeudeNummern.put("Wall", 19);

        for (Map.Entry<String, Integer> entry : gebaeudeNummern.entrySet()) {
            nummernGebaeude.put(entry.getValue(), entry.getKey());
        }
    }

    public static int getGebaeudeNummer(String gebaeudeName) {
        return gebaeudeNummern.getOrDefault(gebaeudeName, -1);
    }

    public static String getGebaeudeName(int gebaeudeNummer) {
        return nummernGebaeude.getOrDefault(gebaeudeNummer, "Unbekannt");
    }
}