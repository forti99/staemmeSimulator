package gebaeude;

public enum GebaeudeTypen {
    HAUPTGEBAEUDE(1), 
    KASERNE(2),
    STALL(3),
    WERKSTATT(4),
    ADELSHOF(5),
    SCHMIEDE(6),
    VERSAMMLUNGSPLATZ(7),
    STATUE(8),
    MARKTPLATZ(9),
    HOLZFAELLER(10),
    LEHMGRUBE(11),
    EISENMINE(12),
    BAUERNHOF(13),
    SPEICHER(14),
    VERSTECK(15),
    WALL(16);
        
    public final int id;
    
    private GebaeudeTypen(int id){
        this.id = id;
    }
}
