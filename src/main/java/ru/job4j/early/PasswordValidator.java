package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    public static boolean keywordsCheck(String password) {
        boolean checkkey = false;
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
                checkkey = true;
                break;
            }
        }
        return checkkey;
    }

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
            } else if (!isDigit(symbol) && !isLetter(symbol)) {
                symbols = true;
            } else if (upper && lower && numbers && symbols) {
                break;
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

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (keywordsCheck(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        if (check(password)) {
            return password;
        }
        return password;
    }
}
