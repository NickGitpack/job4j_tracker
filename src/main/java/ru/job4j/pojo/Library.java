package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book drama = new Book("Dubrovsiy", 120);
        Book comedy = new Book("12 chairs", 200);
        Book detective = new Book("Sherlok Holmes", 300);
        Book code = new Book("Clean code", 10);
        Book[] books = new Book[4];
        books[0] = drama;
        books[1] = comedy;
        books[2] = detective;
        books[3] = code;
        for (Book b : books) {
            System.out.println(b.getName() + " " + b.getPages());
        }
        books[0] = code;
        books[3] = drama;
        for (Book b : books) {
            if (b.getName().equals("Clean code")) {
                System.out.println(b.getName() + " " + b.getPages());
            }
        }
    }
}
