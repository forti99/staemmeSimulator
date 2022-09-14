package gebaeude;

public enum GebaeudeTypen {
    HAUPTGEBAEUDE(0, 30),
    KASERNE(1, 25),
    STALL(2, 20),
    WERKSTATT(3, 15),
    ADELSHOF(4, 1),
    SCHMIEDE(5, 20),
    VERSAMMLUNGSPLATZ(6, 1),
    STATUE(7, 1),
    MARKTPLATZ(8, 25),
    HOLZFAELLER(9, 30),
    LEHMGRUBE(10, 30),
    EISENMINE(11, 30),
    BAUERNHOF(12, 30),
    SPEICHER(13, 30),
    VERSTECK(14, 10),
    WALL(15, 20);

    private final int id;
    private final int maxStufe;

    GebaeudeTypen(int id, int maxStufe) {
        this.id = id;
        this.maxStufe = maxStufe;
    }

    public int getId() {
        return id;
    }

    public int getMaxStufe() {
        return maxStufe;
    }

    public static GebaeudeTypen getById(int id) {
        for (GebaeudeTypen e : values()) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("Ungueltige Id bei den GebaeudeTypen");
    }
}
