package gebaeude.gebaeudeNormal;


import util.Rohstoffe;
import gebaeude.Gebaeude;

public class Lehmgrube implements Gebaeude {

    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[30];

    public Lehmgrube(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(65, 50, 40);
        baukosten[1] = new Rohstoffe(83, 63, 50);
        baukosten[2] = new Rohstoffe(105, 80, 60);
        baukosten[3] = new Rohstoffe(133, 101, 76);
        baukosten[4] = new Rohstoffe(169, 128, 95);
        baukosten[5] = new Rohstoffe(215, 162, 117);
        baukosten[6] = new Rohstoffe(273, 205, 145);
        baukosten[7] = new Rohstoffe(346, 259, 180);
        baukosten[8] = new Rohstoffe(440, 328, 224);
        baukosten[9] = new Rohstoffe(559, 415, 277);
        baukosten[10] = new Rohstoffe(709, 525, 344);
        baukosten[11] = new Rohstoffe(901, 664, 426);
        baukosten[12] = new Rohstoffe(1144, 840, 529);
        baukosten[13] = new Rohstoffe(1453, 1062, 655);
        baukosten[14] = new Rohstoffe(1846, 1343, 813);
        baukosten[15] = new Rohstoffe(2344, 1700, 1008);
        baukosten[16] = new Rohstoffe(2977, 2150, 1250);
        baukosten[17] = new Rohstoffe(3781, 2720, 1550);
        baukosten[18] = new Rohstoffe(4802, 3440, 1922);
        baukosten[19] = new Rohstoffe(6098, 4352, 2383);
        baukosten[20] = new Rohstoffe(7744, 5505, 2955);
        baukosten[21] = new Rohstoffe(9835, 6964, 3664);
        baukosten[22] = new Rohstoffe(12491, 8810, 4543);
        baukosten[23] = new Rohstoffe(15863, 11144, 5633);
        baukosten[24] = new Rohstoffe(20147, 14098, 6985);
        baukosten[25] = new Rohstoffe(25586, 17833, 8662);
        baukosten[26] = new Rohstoffe(32495, 22559, 10740);
        baukosten[27] = new Rohstoffe(41268, 28537, 13318);
        baukosten[28] = new Rohstoffe(52410, 36100, 16515);
        baukosten[29] = new Rohstoffe(66561, 45666, 20478);
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
        return 11;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
