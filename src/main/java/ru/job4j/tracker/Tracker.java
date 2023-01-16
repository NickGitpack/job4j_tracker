package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null) {
                rsl[size] = name;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && key == items[i].getName()) {
                rsl[size] = items[i];
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index == -1) {
            return false;
        } else if (findById(index) != null) {
            findById(id).setName(item.getName());
            rsl = true;
        } else if (findById(index) == null) {
            Item it = findById(index);
            it = item;
            findById(id).setName(item.getName());
            rsl = true;
        }
        return rsl;
    }
}