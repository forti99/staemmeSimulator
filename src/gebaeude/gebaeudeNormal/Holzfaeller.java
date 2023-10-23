package gebaeude.gebaeudeNormal;


import util.Rohstoffe;
import gebaeude.Gebaeude;

public class Holzfaeller implements Gebaeude {

    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[30];

    public Holzfaeller(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(50, 60, 40);
        baukosten[1] = new Rohstoffe(63, 77, 50);
        baukosten[2] = new Rohstoffe(78, 98, 62);
        baukosten[3] = new Rohstoffe(98, 124, 77);
        baukosten[4] = new Rohstoffe(122, 159, 96);
        baukosten[5] = new Rohstoffe(153, 202, 120);
        baukosten[6] = new Rohstoffe(191, 258, 149);
        baukosten[7] = new Rohstoffe(238, 329, 185);
        baukosten[8] = new Rohstoffe(298, 419, 231);
        baukosten[9] = new Rohstoffe(373, 534, 287);
        baukosten[10] = new Rohstoffe(466, 681, 358);
        baukosten[11] = new Rohstoffe(582, 868, 446);
        baukosten[12] = new Rohstoffe(728, 1107, 555);
        baukosten[13] = new Rohstoffe(909, 1412, 691);
        baukosten[14] = new Rohstoffe(1137, 1800, 860);
        baukosten[15] = new Rohstoffe(1421, 2295, 1071);
        baukosten[16] = new Rohstoffe(1776, 2926, 1333);
        baukosten[17] = new Rohstoffe(2220, 3731, 1659);
        baukosten[18] = new Rohstoffe(2776, 4757, 2066);
        baukosten[19] = new Rohstoffe(3469, 6065, 2572);
        baukosten[20] = new Rohstoffe(4337, 7733, 3202);
        baukosten[21] = new Rohstoffe(5421, 9860, 3987);
        baukosten[22] = new Rohstoffe(6776, 12571, 4963);
        baukosten[23] = new Rohstoffe(8470, 16028, 6180);
        baukosten[24] = new Rohstoffe(10588, 20436, 7694);
        baukosten[25] = new Rohstoffe(13235, 26056, 9578);
        baukosten[26] = new Rohstoffe(16544, 33221, 11925);
        baukosten[27] = new Rohstoffe(20680, 42357, 14847);
        baukosten[28] = new Rohstoffe(25849, 54005, 18484);
        baukosten[29] = new Rohstoffe(32312, 68857, 23013);
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
        return 10;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
