package util;

public class Bauzeit implements Comparable<Bauzeit> {
    private final int hours;
    private final int minutes;
    private final int seconds;

    public Bauzeit(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public static Bauzeit secondsToBauzeit(int sec) {
        int remainingSec = sec;
        int hours = sec / 3600;
        remainingSec -= hours * 3600;
        int minutes = remainingSec / 60;
        remainingSec -= minutes * 60;
        int seconds = remainingSec;
        return new Bauzeit(hours, minutes, seconds);
    }

    public int toSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    /**
     * Calculates the difference between this and another entities.Bauzeit
     *
     * @param runtime other entities.Bauzeit
     * @return difference between both Bauzeit
     */
    public Bauzeit difference(Bauzeit runtime) {
        return secondsToBauzeit(toSeconds() - runtime.toSeconds());
    }

    //Getter + Setter
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public int compareTo(Bauzeit otherBauzeit) {
        if (this.hours < otherBauzeit.getHours()) {
            return -1;
        } else {
            if (this.hours > otherBauzeit.getHours()) {
                return 1;
            } else {
                if (this.minutes < otherBauzeit.getMinutes()) {
                    return -1;
                } else {
                    if (this.minutes > otherBauzeit.getMinutes()) {
                        return 1;
                    } else {
                        return Integer.compare(this.seconds, otherBauzeit.getSeconds());
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Runtime: " + hours + ":" + minutes + ":" + seconds;
    }
}
