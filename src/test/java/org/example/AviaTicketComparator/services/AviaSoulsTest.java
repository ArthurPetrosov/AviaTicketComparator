package org.example.AviaTicketComparator.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Yerevan", "Los Angeles", 500, 10, 22);
    Ticket ticket2 = new Ticket("Yerevan", "Los Angeles", 700, 8, 22);
    Ticket ticket3 = new Ticket("Los Angeles", "New York", 700, 15, 19);
    Ticket ticket4 = new Ticket("London", "Los Angeles", 200, 12, 16);
    Ticket ticket5 = new Ticket("Yerevan", "Los Angeles", 600, 6, 10);
    Ticket ticket6 = new Ticket("Prague", "Lisbon", 550, 10, 22);


    @Test
    public void shouldTestCompareToEqual() {

        int expected = 0;
        int actual = ticket3.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestCompareTo1() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestCompareTo2() {

        int expected = -1;
        int actual = ticket4.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestSearchWithCompare() {

        AviaSouls aSouls = new AviaSouls();

        aSouls.add(ticket1);
        aSouls.add(ticket2);
        aSouls.add(ticket3);
        aSouls.add(ticket4);
        aSouls.add(ticket5);
        aSouls.add(ticket6);

        Ticket[] actual = aSouls.search("Yerevan", "Los Angeles");
        Ticket[] expected = {ticket1, ticket2, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestSearchWithComparator() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        AviaSouls aSouls = new AviaSouls();

        aSouls.add(ticket1);
        aSouls.add(ticket2);
        aSouls.add(ticket3);
        aSouls.add(ticket4);
        aSouls.add(ticket5);
        aSouls.add(ticket6);

        Ticket[] actual = aSouls.searchAndSortBy("Yerevan", "Los Angeles", timeComparator);
        Ticket[] expected = {ticket5, ticket1, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

}
