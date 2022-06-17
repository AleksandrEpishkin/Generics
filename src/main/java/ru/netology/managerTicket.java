package ru.netology;
import java.util.Arrays;

public class managerTicket{
    private repoTicket repository = new repoTicket();


    public void add(Ticket newTicket){
        repository.save(newTicket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] searchByText(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            if (matches(product, text, "") || matches(product, "", text)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        if (ticket.matchesFrom(searchFrom) && ticket.matchesTo(searchTo)) {
            return true;
        } else {
            return false;
        }
    }

    public void removeById(int removeId) {
        repository.removeById(removeId);
    }
}
