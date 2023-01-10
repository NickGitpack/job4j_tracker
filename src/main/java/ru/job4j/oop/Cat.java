package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println(this.name + " eats " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}
