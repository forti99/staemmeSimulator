package gebaeude;


import berechnungen.Rohstoffe;

public class Adelshof implements Gebaeude{
    private int stufe;
    private final int id = 5;
    private final Rohstoffe[] baukosten = new Rohstoffe[1];

    public Adelshof(int stufe) {
        this.stufe = stufe;

        baukosten[0] = new Rohstoffe(15000, 25000, 10000);
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
