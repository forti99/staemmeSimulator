package gebaeude.gebaeudeNormal;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Eisenmine implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[30];

    public Eisenmine(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(75, 65, 70);
        baukosten[1] = new Rohstoffe(94, 83, 87);
        baukosten[2] = new Rohstoffe(118, 106, 108);
        baukosten[3] = new Rohstoffe(147, 135, 133);
        baukosten[4] = new Rohstoffe(184, 172, 165);
        baukosten[5] = new Rohstoffe(231, 219, 205);
        baukosten[6] = new Rohstoffe(289, 279, 254);
        baukosten[7] = new Rohstoffe(362, 356, 316);
        baukosten[8] = new Rohstoffe(453, 454, 391);
        baukosten[9] = new Rohstoffe(567, 579, 485);
        baukosten[10] = new Rohstoffe(710, 738, 602);
        baukosten[11] = new Rohstoffe(889, 941, 746);
        baukosten[12] = new Rohstoffe(1113, 1200, 925);
        baukosten[13] = new Rohstoffe(1393, 1529, 1147);
        baukosten[14] = new Rohstoffe(1744, 1950, 1422);
        baukosten[15] = new Rohstoffe(2183, 2486, 1764);
        baukosten[16] = new Rohstoffe(2734, 3170, 2187);
        baukosten[17] = new Rohstoffe(3422, 4042, 2712);
        baukosten[18] = new Rohstoffe(4285, 5153, 3363);
        baukosten[19] = new Rohstoffe(5365, 6571, 4170);
        baukosten[20] = new Rohstoffe(6717, 8378, 5170);
        baukosten[21] = new Rohstoffe(8409, 10681, 6411);
        baukosten[22] = new Rohstoffe(10528, 13619, 7950);
        baukosten[23] = new Rohstoffe(13181, 17346, 9858);
        baukosten[24] = new Rohstoffe(16503, 22139, 12224);
        baukosten[25] = new Rohstoffe(20662, 28227, 15158);
        baukosten[26] = new Rohstoffe(25869, 35990, 18796);
        baukosten[27] = new Rohstoffe(32388, 45887, 23307);
        baukosten[28] = new Rohstoffe(40549, 58506, 28900);
        baukosten[29] = new Rohstoffe(50768, 74595, 35837);
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
        return 12;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
