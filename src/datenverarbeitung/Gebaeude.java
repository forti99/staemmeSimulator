package datenverarbeitung;

import berechnungen.Rohstoffe;

import java.util.Map;

public class Gebaeude {
    private Map<Integer, Rohstoffe> baukostenProStufe;
    private Map<Integer, Integer> bevoelkerungskostenProStufe;
    private String name;
    private int maxLevel;
    private int minLevel;
    private int wood;
    private int stone;
    private int iron;
    private int pop;
    private double woodFactor;
    private double stoneFactor;
    private double ironFactor;
    private double popFactor;
    private double buildTime;

    public Map<Integer, Rohstoffe> getBaukostenProStufe() {
        return baukostenProStufe;
    }

    public void setBaukostenProStufe(Map<Integer, Rohstoffe> baukostenProStufe) {
        this.baukostenProStufe = baukostenProStufe;
    }

    public Map<Integer, Integer> getBevoelkerungskostenProStufe() {
        return bevoelkerungskostenProStufe;
    }

    public void setBevoelkerungskostenProStufe(Map<Integer, Integer> bevoelkerungskostenProStufe) {
        this.bevoelkerungskostenProStufe = bevoelkerungskostenProStufe;
    }

    public Gebaeude(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public double getWoodFactor() {
        return woodFactor;
    }

    public void setWoodFactor(double woodFactor) {
        this.woodFactor = woodFactor;
    }

    public double getStoneFactor() {
        return stoneFactor;
    }

    public void setStoneFactor(double stoneFactor) {
        this.stoneFactor = stoneFactor;
    }

    public double getIronFactor() {
        return ironFactor;
    }

    public void setIronFactor(double ironFactor) {
        this.ironFactor = ironFactor;
    }

    public double getPopFactor() {
        return popFactor;
    }

    public void setPopFactor(double popFactor) {
        this.popFactor = popFactor;
    }

    public double getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(double buildTime) {
        this.buildTime = buildTime;
    }


    @Override
    public String toString() {
        return "Gebaeude{" +
                "baukostenProStufe=" + baukostenProStufe +
                ", bevoelkerungskostenProStufe=" + bevoelkerungskostenProStufe +
                ", name='" + name + '\'' +
                ", maxLevel=" + maxLevel +
                ", minLevel=" + minLevel +
                ", wood=" + wood +
                ", stone=" + stone +
                ", iron=" + iron +
                ", pop=" + pop +
                ", woodFactor=" + woodFactor +
                ", stoneFactor=" + stoneFactor +
                ", ironFactor=" + ironFactor +
                ", popFactor=" + popFactor +
                ", buildTime=" + buildTime +
                '}';
    }
}
