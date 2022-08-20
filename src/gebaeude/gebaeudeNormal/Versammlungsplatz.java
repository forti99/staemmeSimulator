package gebaeude.gebaeudeNormal;

import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Versammlungsplatz implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[1];

    public Versammlungsplatz(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(10, 40, 30);
    }

    @Override
    public Rohstoffe getBaukosten(int stufe) {
        if (stufe == 0) {
            return new Rohstoffe();
        } else {
            return baukosten[stufe - 1];
        }
    }

    @Override
    public int getStufe() {
        return stufe;
    }

    @Override
    public int getMaxStufe() {
        return 1;
    }

    @Override
    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    @Override
    public int getId() {
        return 7;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}

