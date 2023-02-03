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
        int index = count;
        String rsl = " ";
        for (int i = 1; index > 0; index--) {
            if (queue.peek() == null) {
                break;
            }
            rsl = queue.peek().name();
            queue.poll();
        }
        return rsl;
    }

    public String getFirstUpsetCustomer() {
        int index = count;
        String rsl = " ";
        for (int i = 1; index >= 0; index--) {
            if (queue.peek() == null) {
                break;
            }
            rsl = queue.peek().name();
            queue.poll();
        }
        return rsl;
    }
}
