package gebaeude.gebaeudeNormal;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Stall implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[20];

    public Stall(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(270, 240, 260);
        baukosten[1] = new Rohstoffe(340, 307, 328);
        baukosten[2] = new Rohstoffe(429, 393, 413);
        baukosten[3] = new Rohstoffe(540, 503, 520);
        baukosten[4] = new Rohstoffe(681, 644, 655);
        baukosten[5] = new Rohstoffe(857, 825, 826);
        baukosten[6] = new Rohstoffe(1080, 1056, 1040);
        baukosten[7] = new Rohstoffe(1361, 1351, 1311);
        baukosten[8] = new Rohstoffe(1715, 1729, 1652);
        baukosten[9] = new Rohstoffe(2161, 2214, 2081);
        baukosten[10] = new Rohstoffe(2723, 2833, 2622);
        baukosten[11] = new Rohstoffe(3431, 3627, 3304);
        baukosten[12] = new Rohstoffe(4323, 4642, 4163);
        baukosten[13] = new Rohstoffe(5447, 5942, 5246);
        baukosten[14] = new Rohstoffe(6864, 7606, 6609);
        baukosten[15] = new Rohstoffe(8648, 9736, 8328);
        baukosten[16] = new Rohstoffe(10897, 12462, 10493);
        baukosten[17] = new Rohstoffe(13730, 15951, 13221);
        baukosten[18] = new Rohstoffe(17300, 20417, 16659);
        baukosten[19] = new Rohstoffe(21797, 26134, 20990);
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
        return 3;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{10, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
