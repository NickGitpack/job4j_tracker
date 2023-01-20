package ru.job4j.polytasks;

public class Train implements Vehicle {

    public void move() {
        System.out.println("Скоростное движение по рельсам");
    }

    public void fuel() {
        System.out.println("Потребляет x объем оплива");
    }
}
