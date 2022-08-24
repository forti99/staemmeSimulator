package berechnungen;

import gebaeude.GebaeudeDaten;
import gebaeude.GebaeudeTypen;

public class Einstellungen {
    public static final int weltengeschwindigkeit = 2;
    public static final int minengeschwindigkeit = 2;
    public static final int[] produktionsraten = {10, 30, 35, 41, 47, 55, 64, 74, 86, 100, 117, 136, 158, 184, 214, 249, 289, 337, 391, 455, 530, 616, 717, 833, 969, 1127, 1311, 1525, 1774, 2063, 2400};

    public static Rohstoffe getBelohnung(GebaeudeTypen gebaeudeTyp, int stufe) {
        GebaeudeDaten gebaeudeDaten = new GebaeudeDaten();
        Rohstoffe belohnung = gebaeudeDaten.getBaukosten(gebaeudeTyp, stufe);

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
}
