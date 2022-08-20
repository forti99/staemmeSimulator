package gebaeude.gebaeudeNormal;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Kaserne implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[25];

    public Kaserne(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(200, 170, 90);
        baukosten[1] = new Rohstoffe(252, 218, 113);
        baukosten[2] = new Rohstoffe(318, 279, 143);
        baukosten[3] = new Rohstoffe(400, 357, 180);
        baukosten[4] = new Rohstoffe(504, 456, 227);
        baukosten[5] = new Rohstoffe(635, 584, 286);
        baukosten[6] = new Rohstoffe(800, 748, 360);
        baukosten[7] = new Rohstoffe(1008, 957, 454);
        baukosten[8] = new Rohstoffe(1271, 1225, 572);
        baukosten[9] = new Rohstoffe(1601, 1568, 720);
        baukosten[10] = new Rohstoffe(2017, 2007, 908);
        baukosten[11] = new Rohstoffe(2542, 2569, 1144);
        baukosten[12] = new Rohstoffe(3202, 3288, 1441);
        baukosten[13] = new Rohstoffe(4035, 4209, 1816);
        baukosten[14] = new Rohstoffe(5084, 5388, 2288);
        baukosten[15] = new Rohstoffe(6406, 6896, 2883);
        baukosten[16] = new Rohstoffe(8072, 8827, 3632);
        baukosten[17] = new Rohstoffe(10170, 11298, 4577);
        baukosten[18] = new Rohstoffe(12814, 14462, 5767);
        baukosten[19] = new Rohstoffe(16146, 18511, 7266);
        baukosten[20] = new Rohstoffe(20344, 23695, 9155);
        baukosten[21] = new Rohstoffe(25634, 30329, 11535);
        baukosten[22] = new Rohstoffe(32298, 38821, 14534);
        baukosten[23] = new Rohstoffe(40696, 49691, 18313);
        baukosten[24] = new Rohstoffe(51277, 63605, 23075);
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
        return 25;
    }

    @Override
    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
