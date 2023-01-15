package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan Ivanov");
        student.setGroup("2B");
        student.setEnter(new Date());

        System.out.println(student.getName()
                + " has entered to group "
                    + student.getGroup() + " at " + student.getEnter());

    }
}
