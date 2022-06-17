import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.managerTicket;

public class managerTicketTest {

    Ticket ticket1 = new Ticket(01, 1500, "MOSCOW", "KAZAN", 120);
    Ticket ticket2 = new Ticket(03, 1000, "MOSCOW", "SARATOV", 100);
    Ticket ticket3 = new Ticket(07, 16500, "DUBAI", "MOSCOW", 450);
    Ticket ticket4 = new Ticket(05, 1300, "KAZAN", "MOSCOW", 120);
    Ticket ticket5 = new Ticket(16, 2000, "PITER", "MOSCOW", 110);
    Ticket ticket6 = new Ticket(35, 7000, "OMSK", "PITER", 300);
    Ticket ticket7 = new Ticket(39, 5000, "PITER", "KAZAN", 200);
    Ticket ticket8 = new Ticket(49, 3500, "PITER", "MOSCOW", 100);
    Ticket ticket9 = new Ticket(51, 1600, "OMSK", "MOSCOW", 250);
    Ticket ticket10 = new Ticket(99, 8000, "PITER", "OMSK", 350);


    @Test
    void shouldFindAndSort() {
        managerTicket manager = new managerTicket();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.findAll("", "");
        Ticket[] expected = {ticket2, ticket4, ticket1, ticket9, ticket5, ticket8, ticket7, ticket6, ticket10, ticket3};

        assertArrayEquals(expected, actual);

        Ticket[] actual1 = manager.findAll("MOSCOW", "");
        Ticket[] expected1 = {ticket2, ticket1};

        assertArrayEquals(expected1, actual1);

        Ticket[] actual2 = manager.findAll("", "MOSCOW");
        Ticket[] expected2 = {ticket4, ticket9, ticket5, ticket8, ticket3};

        assertArrayEquals(expected2, actual2);

        Ticket[] actual3 = manager.findAll("PITER", "MOSCOW");
        Ticket[] expected3 = {ticket5, ticket8};

        assertArrayEquals(expected3, actual3);
    }

    @Test
    public void shouldSearchByText() {
        managerTicket manager = new managerTicket();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.searchByText("OMS");
        Ticket[] expected = {ticket6, ticket9, ticket10};

        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldRemoveById() {
        managerTicket manager = new managerTicket();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        manager.removeById(35);

        Ticket[] actual = manager.findAll("", "");
        Ticket[] expected = {ticket2, ticket4, ticket1, ticket9, ticket5, ticket8, ticket7, ticket10, ticket3};

        assertArrayEquals(expected, actual);

    }


}
