package ru.job4j.format;

public class Format {

    public static void getGreeting(String name) {
        System.out.println(String.format("Привет! Я %s", name));
    }

    public static void main(String[] args) {
        getGreeting("Елена");
    }

}
