package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("nikita@mail.ru", "Nikita Ivanov");
        map.put("ivan@mail.ru", "Ivan Petrov");
        map.put("vlad@mail.ru", "Vladimir Sidorov");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
