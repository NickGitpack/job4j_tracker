package ru.job4j.early;

import static java.lang.Character.toLowerCase;

public class Test {

    public static void main(String[] args) {
        String password = "Ln2$MUSERTY12";
        boolean check = false;
        String[] keywords = new String[] {"qwerty", "12345", "password", "admin", "user"};
        StringBuilder sb = new StringBuilder();
        char[] pass = password.toCharArray();
        for (char index : pass) {
            System.out.println(index);
            index = toLowerCase(index);
            sb.append(index);
            System.out.println(index);
        }
        String str = sb.toString();
        System.out.println(str);
        for (String keyword : keywords) {
            if (str.contains(keyword)) {
                System.out.println(keyword);
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
    }
}
