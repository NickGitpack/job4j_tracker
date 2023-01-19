package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Ехать");
    }

    @Override
    public void passangers(int pass) {
        System.out.println("Число пассажиров " + pass);
    }

    @Override
    public int addFuel(int price) {
        return price * 60;
    }
}
