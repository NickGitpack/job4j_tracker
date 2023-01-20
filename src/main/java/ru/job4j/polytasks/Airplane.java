package ru.job4j.polytasks;

public class Airplane implements Vehicle {

    public void move() {
        System.out.println("Полет в стратосфере");
    }

    public void fuel() {
        System.out.println("Потребляет n объем оплива");
    }
}
