package berechnungen;

public class Rohstoffe {
    private int holz;
    private int lehm;
    private int eisen;

    public Rohstoffe() {
        this.holz = 0;
        this.lehm = 0;
        this.eisen = 0;
    }

    public Rohstoffe(int holz, int lehm, int eisen) {
        this.holz = holz;
        this.lehm = lehm;
        this.eisen = eisen;
    }

    public void addHolz(int holzmenge) {
        this.holz += holzmenge;
    }

    public void addLehm(int lehmmenge) {
        this.lehm += lehmmenge;
    }

    public void addEisen(int eisenmenge) {
        this.eisen += eisenmenge;
    }

    public int getHolz() {
        return holz;
    }

    public void setHolz(int holz) {
        this.holz = holz;
    }

    public int getLehm() {
        return lehm;
    }

    public void setLehm(int lehm) {
        this.lehm = lehm;
    }

    public int getEisen() {
        return eisen;
    }

    public void setEisen(int eisen) {
        this.eisen = eisen;
    }

    @Override
    public String toString() {
        return "Holz: " + holz + ", Lehm: " + lehm + ", Eisen: " + eisen;
    }
}
