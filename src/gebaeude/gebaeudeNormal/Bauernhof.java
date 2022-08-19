package gebaeude.gebaeudeNormal;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Bauernhof implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[30];

    public Bauernhof(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(45, 40, 30);
        baukosten[1] = new Rohstoffe(59, 53, 39);
        baukosten[2] = new Rohstoffe(76, 70, 50);
        baukosten[3] = new Rohstoffe(99, 92, 64);
        baukosten[4] = new Rohstoffe(129, 121, 83);
        baukosten[5] = new Rohstoffe(167, 160, 107);
        baukosten[6] = new Rohstoffe(217, 212, 138);
        baukosten[7] = new Rohstoffe(282, 279, 178);
        baukosten[8] = new Rohstoffe(367, 369, 230);
        baukosten[9] = new Rohstoffe(477, 487, 297);
        baukosten[10] = new Rohstoffe(620, 642, 383);
        baukosten[11] = new Rohstoffe(806, 848, 494);
        baukosten[12] = new Rohstoffe(1048, 1119, 637);
        baukosten[13] = new Rohstoffe(1363, 1477, 822);
        baukosten[14] = new Rohstoffe(1772, 1950, 1060);
        baukosten[15] = new Rohstoffe(2303, 2574, 1368);
        baukosten[16] = new Rohstoffe(2994, 3398, 1764);
        baukosten[17] = new Rohstoffe(3893, 4486, 2276);
        baukosten[18] = new Rohstoffe(5060, 5921, 2936);
        baukosten[19] = new Rohstoffe(6579, 7816, 3787);
        baukosten[20] = new Rohstoffe(8552, 10317, 4886);
        baukosten[21] = new Rohstoffe(11118, 13618, 6302);
        baukosten[22] = new Rohstoffe(14453, 17976, 8130);
        baukosten[23] = new Rohstoffe(18789, 23728, 10488);
        baukosten[24] = new Rohstoffe(24426, 31321, 13529);
        baukosten[25] = new Rohstoffe(31754, 41344, 17453);
        baukosten[26] = new Rohstoffe(41280, 54574, 22514);
        baukosten[27] = new Rohstoffe(53664, 72037, 29043);
        baukosten[28] = new Rohstoffe(69763, 95089, 37466);
        baukosten[29] = new Rohstoffe(90692, 125517, 48331);
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
        return 30;
    }

    @Override
    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    @Override
    public int getId() {
        return 13;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
