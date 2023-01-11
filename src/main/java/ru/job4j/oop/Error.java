package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error empty = new Error();
        Error first = new Error(true, 1, "Error 1");
        Error second = new Error(false, 2, "Error 2");
        empty.printInfo();
        first.printInfo();
        second.printInfo();
    }
}
