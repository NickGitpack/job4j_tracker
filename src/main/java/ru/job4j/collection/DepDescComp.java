package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] array1 = o1.split("/");
        String[] array2 = o2.split("/");
        for (int i = 0; i < Math.min(array1.length, array2.length); i++) {
            if (!array1[i].equals(array2[i]) && i == 0) {
                return array2[i].compareTo(array1[i]);
            } else if (!array1[i].equals(array2[i]) && i > 0) {
                return array1[i].compareTo(array2[i]);
            }
        }
        return Integer.compare(array1.length, array2.length);
    }
}
