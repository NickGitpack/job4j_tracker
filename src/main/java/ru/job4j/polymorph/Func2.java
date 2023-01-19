package ru.job4j.polymorph;

public interface Func2 extends Func1 {
    default double func(double x, double y) {
        return x * x - y + 5;
    }

    default void funcMessage() {
        System.out.println("Сообщение из Func1");
    }
}
