package gebaeude.gebaeudeNormal;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Adelshof implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[1];

    public Adelshof(int stufe) {
        this.stufe = stufe;
        baukosten[0] = new Rohstoffe(15000, 25000, 10000);
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
        return 5;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{20, 0, 0, 0, 0, 20, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0};
    }
}
