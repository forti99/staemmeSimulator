package gebaeude;

public enum GebaeudeTypen {
    HAUPTGEBAEUDE(1, 30), 
    KASERNE(2, 25),
    STALL(3, 20),
    WERKSTATT(4, 15),
    ADELSHOF(5, 1),
    SCHMIEDE(6, 20),
    VERSAMMLUNGSPLATZ(7, 1),
    STATUE(8, 1),
    MARKTPLATZ(9, 25),
    HOLZFAELLER(10, 30),
    LEHMGRUBE(11, 30),
    EISENMINE(12, 30),
    BAUERNHOF(13, 30),
    SPEICHER(14, 30),
    VERSTECK(15, 10),
    WALL(16, 20);
        
    private final int id;
    
    private final int maxStufe;
    
    private GebaeudeTypen(int id, int maxStufe){
        this.id = id;
        this.maxStufe = maStufe;
    }
    
    public int getId(){
        return id;
    }
    
    public int getMaxStufe(){
       return maxStufe; 
    }
}
