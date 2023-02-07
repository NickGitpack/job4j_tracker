package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item left, Item rigth) {
        return left.getName().compareTo(rigth.getName());
    }

    @Override
    public Comparator<Item> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
