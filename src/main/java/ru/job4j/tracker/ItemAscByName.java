package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item left, Item rigth) {
        return left.getName().compareTo(rigth.getName());
    }
}
