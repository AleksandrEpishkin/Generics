package ru.netology;

import lombok.Data;


@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int coast;
    private String from;
    private String to;
    private int timeFly;


    public Ticket(int id, int coast, String departure, String arrival, int timeFly) {
        this.id = id;
        this.coast = coast;
        this.from = departure;
        this.to = arrival;
        this.timeFly = timeFly;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (this.coast < otherTicket.coast) {
            return -1;
        }
        if (this.coast > otherTicket.coast) {
            return 1;
        }
        return 0;
    }

    public boolean matchesFrom(String search) {
        if (this.getFrom().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesTo(String search) {
        if (this.getTo().contains(search)) {
            return true;
        } else {
            return false;
        }
    }


}
