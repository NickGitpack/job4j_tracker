package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int all) {
        return sum(all) + multiply(all) + minus(all) + divide(all);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(10);
        System.out.println(result);
        int min = minus(10);
        System.out.println(min);
        int div = calculator.divide(10);
        System.out.println(div);
        int op = calculator.sumAllOperation(10);
        System.out.println(op);
    }
}