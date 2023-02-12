package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> tmp = new LinkedHashSet<>();
        Iterator<String> iterator = tmp.iterator();
        for (String value : deps) {
            String start = "";
            String[] splt = value.split("/");
            for (String el : splt) {
                rsl.add(el.equals(splt[0]) ? el : rsl.get(rsl.size() - 1) + start + "/" + el);
            }
        }
        tmp.addAll(rsl);
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> ords) {
        ords.sort(new DepDescComp());
    }
}
