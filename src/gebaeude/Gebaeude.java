package gebaeude;


import berechnungen.Rohstoffe;

public interface Gebaeude {

    Rohstoffe getBaukosten(int stufe);

    int getStufe();

    int getMaxStufe();

    void setStufe(int stufe);

    int getId();

    int[] getVoraussetzungen();
}
