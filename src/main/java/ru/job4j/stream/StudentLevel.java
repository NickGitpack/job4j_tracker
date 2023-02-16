package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(st -> st != null && st.getScore() > bound)
                .sorted(Comparator.comparing(Student::getScore)
                .reversed())
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}