package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    public static boolean upperCaseCheck(String password) {
        boolean result = true;
        char[] pass = password.toCharArray();
        for (char symbol : pass) {
            if (isUpperCase(symbol)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean lowerCaseCheck(String password) {
        boolean result = true;
        char[] pass = password.toCharArray();
        for (char symbol : pass) {
            if (isLowerCase(symbol)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean numbersCheck(String password) {
        boolean result = true;
        char[] pass = password.toCharArray();
        for (char symbol : pass) {
            if (isDigit(symbol)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean symbolsCheck(String password) {
        boolean result = true;
        char[] pass = password.toCharArray();
        for (char symbol : pass) {
            if (symbol >= 33 && symbol <= 47
                    || symbol >= 58 && symbol <= 64
                    || symbol >= 91 && symbol <= 96
                    || symbol >= 123 && symbol <= 126) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean keywordsCheck(String password) {
        boolean result = false;
        StringBuilder sb = new StringBuilder();
        char[] pass = password.toCharArray();
        for (char index : pass) {
            index = toLowerCase(index);
            sb.append(index);
        }
        String str = sb.toString();
        if (str.contains("qwerty")
                || str.contains("12345")
                || str.contains("password")
                || str.contains("admin")
                || str.contains("user")) {
            result = true;
        }
        return result;
    }

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
            }
        if (upperCaseCheck(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (lowerCaseCheck(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (numbersCheck(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (symbolsCheck(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (keywordsCheck(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

}
