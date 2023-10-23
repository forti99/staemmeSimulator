package gebaeude.gebaeudeNormal;


import util.Rohstoffe;
import gebaeude.Gebaeude;

public class Wall implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[20];

    public Wall(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(50, 100, 20);
        baukosten[1] = new Rohstoffe(63, 128, 25);
        baukosten[2] = new Rohstoffe(79, 163, 32);
        baukosten[3] = new Rohstoffe(100, 207, 40);
        baukosten[4] = new Rohstoffe(126, 264, 50);
        baukosten[5] = new Rohstoffe(159, 337, 64);
        baukosten[6] = new Rohstoffe(200, 430, 80);
        baukosten[7] = new Rohstoffe(252, 548, 101);
        baukosten[8] = new Rohstoffe(318, 698, 127);
        baukosten[9] = new Rohstoffe(400, 890, 160);
        baukosten[10] = new Rohstoffe(504, 1135, 202);
        baukosten[11] = new Rohstoffe(635, 1447, 254);
        baukosten[12] = new Rohstoffe(801, 1846, 320);
        baukosten[13] = new Rohstoffe(1009, 2353, 404);
        baukosten[14] = new Rohstoffe(1271, 3000, 508);
        baukosten[15] = new Rohstoffe(1602, 3825, 641);
        baukosten[16] = new Rohstoffe(2018, 4877, 807);
        baukosten[17] = new Rohstoffe(2543, 6218, 1017);
        baukosten[18] = new Rohstoffe(3204, 7928, 1281);
        baukosten[19] = new Rohstoffe(4037, 10109, 1615);
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
        return 20;
    }

    @Override
    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    @Override
    public int getId() {
        return 16;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
