package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    /*
    private final Item[] items = new Item[100];
    */
    private final List<Item> items = new ArrayList<>();

    private int ids = 1;
    /*
    private int size = 0;
     */

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }
/*
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }
*/

    public List<Item> findAll() {
        return List.copyOf(items);
    }
/*
    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                rsl[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }
*/

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                rsl.add(item);
            }
        }
        return List.copyOf(rsl);
    }
/*
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }
*/

    public Item findById(int id) {
        int index = indexOf(id);
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    /*
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
    */

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }
/*
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }
*/

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }
/*
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
*/

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(indexOf(id));
        }
        return rsl;
    }
}