package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] string = new String[] {"One", "Two", "Three"};
        try {
            indexOf(string, "Five");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

        try {
            indexOf(string, "One");
            System.out.println();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
