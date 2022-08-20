package gebaeude.gebaeudeSonderfunktion;


import berechnungen.Rohstoffe;
import gebaeude.Gebaeude;

public class Speicher implements Gebaeude {
    private int stufe;
    private final Rohstoffe[] baukosten = new Rohstoffe[30];
    private final int[] kapazitaet = new int[30];
    private final Rohstoffe rohstoffvorrat = new Rohstoffe(500, 500, 400); //Bei Weltenstart startet man mit den initialisierten Rohstoffen
    private final Rohstoffe uebergelaufeneRohstoffe = new Rohstoffe(0, 0, 0);

    public Speicher(int stufe, int holzvorrat, int lehmvorrat, int eisenvorrat) {
        this.stufe = stufe;
        rohstoffvorrat.setHolz(holzvorrat);
        rohstoffvorrat.setLehm(lehmvorrat);
        rohstoffvorrat.setEisen(eisenvorrat);

        setBaukostenAndKapazitaet();
    }

    public Speicher(int stufe) {
        this.stufe = stufe;
        setBaukostenAndKapazitaet();
    }

    private void setBaukostenAndKapazitaet() {
        baukosten[0] = new Rohstoffe(60, 50, 40);
        baukosten[1] = new Rohstoffe(76, 64, 50);
        baukosten[2] = new Rohstoffe(96, 81, 62);
        baukosten[3] = new Rohstoffe(121, 102, 77);
        baukosten[4] = new Rohstoffe(154, 130, 96);
        baukosten[5] = new Rohstoffe(194, 165, 120);
        baukosten[6] = new Rohstoffe(246, 210, 149);
        baukosten[7] = new Rohstoffe(311, 266, 185);
        baukosten[8] = new Rohstoffe(393, 338, 231);
        baukosten[9] = new Rohstoffe(498, 430, 287);
        baukosten[10] = new Rohstoffe(630, 546, 358);
        baukosten[11] = new Rohstoffe(796, 693, 446);
        baukosten[12] = new Rohstoffe(1007, 880, 555);
        baukosten[13] = new Rohstoffe(1274, 1118, 691);
        baukosten[14] = new Rohstoffe(1612, 1420, 860);
        baukosten[15] = new Rohstoffe(2039, 1803, 1071);
        baukosten[16] = new Rohstoffe(2580, 2290, 1333);
        baukosten[17] = new Rohstoffe(3264, 2908, 1659);
        baukosten[18] = new Rohstoffe(4128, 3693, 2066);
        baukosten[19] = new Rohstoffe(5222, 4691, 2572);
        baukosten[20] = new Rohstoffe(6606, 5957, 3202);
        baukosten[21] = new Rohstoffe(8357, 7566, 3987);
        baukosten[22] = new Rohstoffe(10572, 9608, 4963);
        baukosten[23] = new Rohstoffe(13373, 12203, 6180);
        baukosten[24] = new Rohstoffe(16917, 15497, 7694);
        baukosten[25] = new Rohstoffe(21400, 19682, 9578);
        baukosten[26] = new Rohstoffe(27071, 24996, 11925);
        baukosten[27] = new Rohstoffe(34245, 31745, 14847);
        baukosten[28] = new Rohstoffe(43320, 40316, 18484);
        baukosten[29] = new Rohstoffe(54799, 51201, 23013);

        kapazitaet[0] = 1000;
        kapazitaet[1] = 1229;
        kapazitaet[2] = 1512;
        kapazitaet[3] = 1859;
        kapazitaet[4] = 2285;
        kapazitaet[5] = 2810;
        kapazitaet[6] = 3454;
        kapazitaet[7] = 4247;
        kapazitaet[8] = 5222;
        kapazitaet[9] = 6420;
        kapazitaet[10] = 7893;
        kapazitaet[11] = 9705;
        kapazitaet[12] = 11932;
        kapazitaet[13] = 14670;
        kapazitaet[14] = 18037;
        kapazitaet[15] = 22177;
        kapazitaet[16] = 27266;
        kapazitaet[17] = 33523;
        kapazitaet[18] = 41217;
        kapazitaet[19] = 50675;
        kapazitaet[20] = 62305;
        kapazitaet[21] = 76604;
        kapazitaet[22] = 94184;
        kapazitaet[23] = 115798;
        kapazitaet[24] = 142372;
        kapazitaet[25] = 175047;
        kapazitaet[26] = 215219;
        kapazitaet[27] = 264611;
        kapazitaet[28] = 325337;
        kapazitaet[29] = 400000;
    }

    public void addRohstoffe(Rohstoffe rohstoffe) {
        addHolz(rohstoffe.getHolz());
        addLehm(rohstoffe.getLehm());
        addEisen(rohstoffe.getEisen());
    }

    public void addHolz(int menge) {
        rohstoffvorrat.addHolz(menge);
        if (getHolzvorrat() > kapazitaet[stufe - 1]) {
            int zuvieleRohstoffe = getHolzvorrat() - kapazitaet[stufe - 1];
            uebergelaufeneRohstoffe.addHolz(zuvieleRohstoffe);
            setHolz(kapazitaet[stufe - 1]);
        } else if (getHolzvorrat() < -1) { //-1 ist wegen Rundungsfehlern erlaubt
            throw new ArithmeticException("Speicherinhalt negativ");
        }
    }

    public void addLehm(int menge) {
        rohstoffvorrat.addLehm(menge);
        if (getLehmvorrat() > kapazitaet[stufe - 1]) {
            int zuvieleRohstoffe = getLehmvorrat() - kapazitaet[stufe - 1];
            uebergelaufeneRohstoffe.addLehm(zuvieleRohstoffe);
            setLehm(kapazitaet[stufe - 1]);
        } else if (getLehmvorrat() < -1) {//-1 ist wegen Rundungsfehlern erlaubt
            throw new ArithmeticException("Speicherinhalt negativ");
        }
    }

    public void addEisen(int menge) {
        rohstoffvorrat.addEisen(menge);
        if (getEisenvorrat() > kapazitaet[stufe - 1]) {
            int zuvieleRohstoffe = getEisenvorrat() - kapazitaet[stufe - 1];
            uebergelaufeneRohstoffe.addEisen(zuvieleRohstoffe);
            setEisen(kapazitaet[stufe - 1]);
        } else if (getEisenvorrat() < -1) {//-1 ist wegen Rundungsfehlern erlaubt
            throw new ArithmeticException("Speicherinhalt negativ");
        }
    }

    public void setHolz(int menge) {
        this.rohstoffvorrat.setHolz(menge);
    }

    public void setLehm(int menge) {
        this.rohstoffvorrat.setLehm(menge);
    }

    public void setEisen(int menge) {
        this.rohstoffvorrat.setEisen(menge);
    }

    public int getHolzvorrat() {
        return rohstoffvorrat.getHolz();
    }

    public int getLehmvorrat() {
        return rohstoffvorrat.getLehm();
    }

    public int getEisenvorrat() {
        return rohstoffvorrat.getEisen();
    }

    public int getKapazizaet() {
        return kapazitaet[stufe - 1];
    }

    public Rohstoffe getRohstoffvorrat() {
        return rohstoffvorrat;
    }

    public Rohstoffe getUebergelaufeneRohstoffe() {
        return uebergelaufeneRohstoffe;
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
        return 14;
    }

    @Override
    public int[] getVoraussetzungen() {
        return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    @Override
    public String toString() {
        return "Speicher{" +
                "stufe=" + stufe +
                ", rohstoffvorrat=" + rohstoffvorrat +
                ", uebergelaufeneRohstoffe=" + uebergelaufeneRohstoffe +
                '}';
    }
}
