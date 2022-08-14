package gebaeude;


import berechnungen.Rohstoffe;

public class Hauptgebaeude implements Gebaeude {
    private int stufe;
    private final int id = 1;
    private final Rohstoffe[] baukosten = new Rohstoffe[30];

    public Hauptgebaeude(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(90, 80, 70);
        baukosten[1] = new Rohstoffe(113, 102, 88);
        baukosten[2] = new Rohstoffe(143, 130, 111);
        baukosten[3] = new Rohstoffe(180, 166, 140);
        baukosten[4] = new Rohstoffe(227, 211, 176);
        baukosten[5] = new Rohstoffe(286, 270, 222);
        baukosten[6] = new Rohstoffe(360, 344, 280);
        baukosten[7] = new Rohstoffe(454, 438, 353);
        baukosten[8] = new Rohstoffe(572, 559, 445);
        baukosten[9] = new Rohstoffe(720, 712, 560);
        baukosten[10] = new Rohstoffe(908, 908, 706);
        baukosten[11] = new Rohstoffe(1144, 1158, 890);
        baukosten[12] = new Rohstoffe(1441, 1476, 1121);
        baukosten[13] = new Rohstoffe(1816, 1882, 1412);
        baukosten[14] = new Rohstoffe(2288, 2400, 1779);
        baukosten[15] = new Rohstoffe(2883, 3060, 2242);
        baukosten[16] = new Rohstoffe(3632, 3902, 2825);
        baukosten[17] = new Rohstoffe(4577, 4975, 3560);
        baukosten[18] = new Rohstoffe(5767, 6343, 4485);
        baukosten[19] = new Rohstoffe(7266, 8087, 5651);
        baukosten[20] = new Rohstoffe(9155, 10311, 7120);
        baukosten[21] = new Rohstoffe(11535, 13146, 8972);
        baukosten[22] = new Rohstoffe(14534, 16762, 11304);
        baukosten[23] = new Rohstoffe(18313, 21371, 14244);
        baukosten[24] = new Rohstoffe(23075, 27248, 17947);
        baukosten[25] = new Rohstoffe(29074, 34741, 22613);
        baukosten[26] = new Rohstoffe(36633, 44295, 28493);
        baukosten[27] = new Rohstoffe(46158, 56476, 35901);
        baukosten[28] = new Rohstoffe(58159, 72007, 45235);
        baukosten[29] = new Rohstoffe(73280, 91809, 56996);
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
        return id;
    }
}

