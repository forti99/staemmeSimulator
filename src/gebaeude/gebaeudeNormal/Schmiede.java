package gebaeude.gebaeudeNormal;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Schmiede implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[20];

    public Schmiede(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(220, 180, 240);
        baukosten[1] = new Rohstoffe(277, 230, 302);
        baukosten[2] = new Rohstoffe(349, 293, 381);
        baukosten[3] = new Rohstoffe(440, 373, 480);
        baukosten[4] = new Rohstoffe(555, 476, 650);
        baukosten[5] = new Rohstoffe(699, 606, 762);
        baukosten[6] = new Rohstoffe(880, 773, 960);
        baukosten[7] = new Rohstoffe(1109, 986, 1210);
        baukosten[8] = new Rohstoffe(1398, 1257, 1525);
        baukosten[9] = new Rohstoffe(1761, 1603, 1921);
        baukosten[10] = new Rohstoffe(2219, 2043, 2421);
        baukosten[11] = new Rohstoffe(2796, 2605, 3050);
        baukosten[12] = new Rohstoffe(3523, 3322, 3843);
        baukosten[13] = new Rohstoffe(4439, 4236, 4842);
        baukosten[14] = new Rohstoffe(5593, 5400, 6101);
        baukosten[15] = new Rohstoffe(7047, 6885, 7687);
        baukosten[16] = new Rohstoffe(8879, 8779, 9686);
        baukosten[17] = new Rohstoffe(11187, 11193, 12204);
        baukosten[18] = new Rohstoffe(14096, 14271, 15377);
        baukosten[19] = new Rohstoffe(17761, 18196, 19375);
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
        return 6;
    }
}
