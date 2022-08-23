package gebaeude;

import gebaeude.gebaeudeNormal.*;
import gebaeude.gebaeudeSonderfunktion.Speicher;

public class GebaeudeFabrik {
    public Gebaeude erzeugeGebaeude(GebaeudeTypen typ, int stufe) {
        switch (typ) {
            case ADELSHOF -> {
                return new Adelshof(stufe);
            }
            case BAUERNHOF -> {
                return new Bauernhof(stufe);
            }
            case EISENMINE -> {
                return new Eisenmine(stufe);
            }
            case HAUPTGEBAEUDE -> {
                return new Hauptgebaeude(stufe);
            }
            case HOLZFAELLER -> {
                return new Holzfaeller(stufe);
            }
            case KASERNE -> {
                return new Kaserne(stufe);
            }
            case LEHMGRUBE -> {
                return new Lehmgrube(stufe);
            }
            case MARKTPLATZ -> {
                return new Marktplatz(stufe);
            }
            case SCHMIEDE -> {
                return new Schmiede(stufe);
            }
            case SPEICHER -> {
                return new Speicher(stufe);
            }
            case STALL -> {
                return new Stall(stufe);
            }
            case WALL -> {
                return new Wall(stufe);
            }
            case WERKSTATT -> {
                return new Werkstatt(stufe);
            }
            case STATUE -> {
                return new Statue(stufe);
            }
            case VERSAMMLUNGSPLATZ -> {
                return new Versammlungsplatz(stufe);
            }

            case VERSTECK ->{
                return new Versteck(stufe);
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
