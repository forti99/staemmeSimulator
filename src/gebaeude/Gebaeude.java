package gebaeude;


import berechnungen.Rohstoffe;

public interface Gebaeude {

    Rohstoffe getBaukosten(int stufe);

    int getStufe();

    void setStufe(int stufe);

    int getId();
}
