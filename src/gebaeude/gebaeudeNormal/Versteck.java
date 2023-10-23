package gebaeude.gebaeudeNormal;

import util.Rohstoffe;
import gebaeude.Gebaeude;

public class Versteck implements Gebaeude {

    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[10];

    public Versteck(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(50, 60, 50);
        baukosten[1] = new Rohstoffe(63, 75, 63);
        baukosten[2] = new Rohstoffe(78, 94, 78);
        baukosten[3] = new Rohstoffe(98, 117, 98);
        baukosten[4] = new Rohstoffe(122, 146, 122);
        baukosten[5] = new Rohstoffe(153, 183, 153);
        baukosten[6] = new Rohstoffe(191, 229, 191);
        baukosten[7] = new Rohstoffe(238, 286, 238);
        baukosten[8] = new Rohstoffe(298, 358, 298);
        baukosten[9] = new Rohstoffe(373, 447, 373);
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
        return 10;
    }

    @Override
    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    @Override
    public int getId() {
        return 15;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
