package ru.job4j.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = x -> x.getName().equals(key);
        Predicate<Person> surname = x -> x.getSurname().equals(key);
        Predicate<Person> phone = x -> x.getPhone().equals(key);
        Predicate<Person> address = x -> x.getAddress().equals(key);
        Predicate<Person> combine = x -> !x.equals((name.or(surname)).or(phone.or(address)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}
