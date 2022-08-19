package gebaeude.gebaeudeNormal;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Werkstatt implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[15];

    public Werkstatt(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(300, 240, 260);
        baukosten[1] = new Rohstoffe(378, 307, 328);
        baukosten[2] = new Rohstoffe(476, 393, 413);
        baukosten[3] = new Rohstoffe(600, 503, 520);
        baukosten[4] = new Rohstoffe(756, 644, 655);
        baukosten[5] = new Rohstoffe(953, 825, 826);
        baukosten[6] = new Rohstoffe(1200, 1056, 1040);
        baukosten[7] = new Rohstoffe(1513, 1351, 1311);
        baukosten[8] = new Rohstoffe(1906, 1729, 1652);
        baukosten[9] = new Rohstoffe(2401, 2214, 2081);
        baukosten[10] = new Rohstoffe(3026, 2833, 2622);
        baukosten[11] = new Rohstoffe(3812, 3627, 3304);
        baukosten[12] = new Rohstoffe(4804, 4642, 4163);
        baukosten[13] = new Rohstoffe(6053, 5942, 5246);
        baukosten[14] = new Rohstoffe(7626, 7606, 6609);

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
        return 4;
    }
}
