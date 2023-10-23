package util;


import gebaeude.Gebaeude;

public class Speicher {
    private int stufe;
    private final int[] kapazitaet = new int[30];
    private final Rohstoffe rohstoffvorrat = new Rohstoffe(0, 0, 0); //Bei Weltenstart startet man mit den initialisierten Rohstoffen
    private final Rohstoffe uebergelaufeneRohstoffe = new Rohstoffe(0, 0, 0);

    public Speicher(int stufe, int holzvorrat, int lehmvorrat, int eisenvorrat) {
        this.stufe = stufe;
        rohstoffvorrat.setHolz(holzvorrat);
        rohstoffvorrat.setLehm(lehmvorrat);
        rohstoffvorrat.setEisen(eisenvorrat);

        setKapazität();
    }

    public Speicher(int stufe) {
        this.stufe = stufe;
        setKapazität();
    }

    private void setKapazität() {
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

    public boolean passenBaukostenInSpeicher(Gebaeude gebaeude, int stufe) {
        int holzkosten = gebaeude.getBaukosten(stufe).getHolz();
        int lehmkosten = gebaeude.getBaukosten(stufe).getLehm();
        int eisenkosten = gebaeude.getBaukosten(stufe).getEisen();
        int hoechsteKosten = Math.max(Math.max(holzkosten, lehmkosten), eisenkosten);

        return getKapazitaet() >= hoechsteKosten;
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
        } else if (getHolzvorrat() < 0) {
            throw new ArithmeticException("Speicherinhalt negativ");
        }
    }

    public void addLehm(int menge) {
        rohstoffvorrat.addLehm(menge);
        if (getLehmvorrat() > kapazitaet[stufe - 1]) {
            int zuvieleRohstoffe = getLehmvorrat() - kapazitaet[stufe - 1];
            uebergelaufeneRohstoffe.addLehm(zuvieleRohstoffe);
            setLehm(kapazitaet[stufe - 1]);
        } else if (getLehmvorrat() < 0) {
            throw new ArithmeticException("Speicherinhalt negativ");
        }
    }

    public void addEisen(int menge) {
        rohstoffvorrat.addEisen(menge);
        if (getEisenvorrat() > kapazitaet[stufe - 1]) {
            int zuvieleRohstoffe = getEisenvorrat() - kapazitaet[stufe - 1];
            uebergelaufeneRohstoffe.addEisen(zuvieleRohstoffe);
            setEisen(kapazitaet[stufe - 1]);
        } else if (getEisenvorrat() < 0) {
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

    public int getKapazitaet() {
        return kapazitaet[stufe - 1];
    }

    public Rohstoffe getRohstoffvorrat() {
        return rohstoffvorrat;
    }

    public Rohstoffe getUebergelaufeneRohstoffe() {
        return uebergelaufeneRohstoffe;
    }


    public int getStufe() {
        return stufe;
    }

    public int getMaxStufe() {
        return 30;
    }

    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    public int getId() {
        return 14;
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
