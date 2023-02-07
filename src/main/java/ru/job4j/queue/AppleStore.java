package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String winner = "";
        int index = count;
        for (Customer customer : queue) {
            if (queue.poll().equals(null) || count == 0) {
                break;
            }
            winner = queue.poll().name();
            queue.poll();
            index--;
        }
        return winner;
    }

    public String getFirstUpsetCustomer() {
        String winner = "";

        return " ";
    }

}
