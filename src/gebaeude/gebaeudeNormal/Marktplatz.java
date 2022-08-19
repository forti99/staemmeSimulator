package gebaeude.gebaeudeNormal;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Marktplatz implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[25];

    public Marktplatz(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(100, 100, 100);
        baukosten[1] = new Rohstoffe(126, 128, 126);
        baukosten[2] = new Rohstoffe(159, 163, 159);
        baukosten[3] = new Rohstoffe(200, 207, 200);
        baukosten[4] = new Rohstoffe(252, 264, 252);
        baukosten[5] = new Rohstoffe(318, 337, 318);
        baukosten[6] = new Rohstoffe(400, 430, 400);
        baukosten[7] = new Rohstoffe(504, 548, 504);
        baukosten[8] = new Rohstoffe(635, 698, 635);
        baukosten[9] = new Rohstoffe(800, 890, 800);
        baukosten[10] = new Rohstoffe(1009, 1135, 1009);
        baukosten[11] = new Rohstoffe(1271, 1447, 1271);
        baukosten[12] = new Rohstoffe(1601, 1846, 1601);
        baukosten[13] = new Rohstoffe(2018, 2353, 2018);
        baukosten[14] = new Rohstoffe(2542, 3000, 2542);
        baukosten[15] = new Rohstoffe(3203, 3825, 3203);
        baukosten[16] = new Rohstoffe(4036, 4877, 4036);
        baukosten[17] = new Rohstoffe(5085, 6218, 5085);
        baukosten[18] = new Rohstoffe(6407, 7928, 6407);
        baukosten[19] = new Rohstoffe(8073, 10109, 8073);
        baukosten[20] = new Rohstoffe(10172, 12889, 10172);
        baukosten[21] = new Rohstoffe(12817, 16433, 12817);
        baukosten[22] = new Rohstoffe(16149, 20952, 16149);
        baukosten[23] = new Rohstoffe(20348, 26714, 20348);
        baukosten[24] = new Rohstoffe(25639, 34060, 25639);
    }

    @Override
    public Rohstoffe getBaukosten(int stufe) {
        return baukosten[stufe - 1];
    }

    @Override
    public int getStufe() {
        return stufe;
    }

    @Override
    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    @Override
    public int getId() {
        return 9;
    }
}
