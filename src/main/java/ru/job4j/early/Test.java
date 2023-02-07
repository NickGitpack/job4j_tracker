package ru.job4j.early;

import static java.lang.Character.*;

public class Test {
    public static boolean check(String password) {
        boolean upper = false;
        boolean lower = false;
        boolean numbers = false;
        boolean symbols = false;
        char[] pass = password.toCharArray();
        for (char symbol : pass) {
            if (isUpperCase(symbol)) {
                upper = true;

            } else if (isLowerCase(symbol)) {
                lower = true;
            } else if (isDigit(symbol)) {
                numbers = true;
            } else if (symbol >= 33 && symbol <= 47
                    || symbol >= 58 && symbol <= 64
                    || symbol >= 91 && symbol <= 96
                    || symbol >= 123 && symbol <= 126) {
                symbols = true;
            }
        }
        if (!upper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!numbers) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!symbols) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return true;
    }

    public static boolean keywordsCheck(String password) {
        String[] keywords = new String[] {"qwerty", "12345", "password", "admin", "user"};
        StringBuilder sb = new StringBuilder();
        char[] pass = password.toCharArray();
        for (char index : pass) {
            index = toLowerCase(index);
            sb.append(index);
        }
        String str = sb.toString();
        for (String keyword : keywords) {
            if (str.contains(keyword)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String password = "Ln2$mUSerTY12";
        if (keywordsCheck(password)) {
            System.out.println("Error");
        }
    }
}
