package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public static final String EXTRA_TOMATO = "extra tomato";

    @Override
    public String name() {
        return super.name() + " + " + EXTRA_TOMATO;
    }
}
