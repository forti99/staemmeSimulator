package berechnungen;

import gebaeude.GebaeudeDaten;
import gebaeude.GebaeudeTypen;

public class Einstellungen {
    private final int weltengeschwindigkeit;
    private final int minengeschwindigkeit;
    private final boolean belohnungenAktiv;
    private final int[] produktionsraten = {10, 30, 35, 41, 47, 55, 64, 74, 86, 100, 117, 136, 158, 184, 214, 249, 289, 337, 391, 455, 530, 616, 717, 833, 969, 1127, 1311, 1525, 1774, 2063, 2400};

    public Einstellungen(int weltengeschwindigkeit, int minengeschwindigkeit, boolean belohnungenAktiv) {
        this.weltengeschwindigkeit = weltengeschwindigkeit;
        this.minengeschwindigkeit = minengeschwindigkeit;
        this.belohnungenAktiv = belohnungenAktiv;
    }

    //Berechnet die Belohnungen die fuer das erstmalige Bauen einer Gebaeudestufe erhalten werden (10% der Baukosten aber mindestens 150 Holz, 150 Lehm und 100 Eisen und maximal 2000 pro Rohstoff)
    public Rohstoffe getBelohnung(GebaeudeTypen gebaeudeTyp, int stufe) {
        Rohstoffe baukosten = new GebaeudeDaten().getBaukosten(gebaeudeTyp, stufe);
        Rohstoffe belohnung = new Rohstoffe();

        belohnung.setHolz(Math.min(2000, Math.max(150, (int) (baukosten.getHolz() * 0.1))));
        belohnung.setLehm(Math.min(2000, Math.max(150, (int) (baukosten.getLehm() * 0.1))));
        belohnung.setEisen(Math.min(2000, Math.max(100, (int) (baukosten.getEisen() * 0.1))));

        return belohnung;
    }

    public int getProduktionsrate(int gebaeudeStufe) {
        return produktionsraten[gebaeudeStufe] * weltengeschwindigkeit * minengeschwindigkeit;
    }

    public int getWeltengeschwindigkeit() {
        return weltengeschwindigkeit;
    }

    public int getMinengeschwindigkeit() {
        return minengeschwindigkeit;
    }

    public boolean isBelohnungenAktiv() {
        return belohnungenAktiv;
    }
}
