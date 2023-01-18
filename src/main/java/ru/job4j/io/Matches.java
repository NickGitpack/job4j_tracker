package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            while (matches < 1 || matches > 3 || count < matches) {
                System.out.println("Только числа от 1 до 3 и не больше " + count);
                matches = Integer.parseInt(input.nextLine());
            }
            if (count - matches == 0) {
                break;
            } else {
                count = count - matches;
                System.out.println(count);
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
