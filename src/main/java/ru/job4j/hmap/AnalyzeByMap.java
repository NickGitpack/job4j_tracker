package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double avScore = 0;
        int index = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                avScore += subject.score();
                index++;
            }
        }
        return avScore / index;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double acc = 0;
            int index = 0;
            for (Subject subject : pupil.subjects()) {
                acc += subject.score();
                index++;
            }
            Label label = new Label(pupil.name(), acc / index);
            list.add(label);
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        int index = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
            index++;
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            Label label = new Label(entry.getKey(), (double) entry.getValue() / index);
            list.add(label);
        }

        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double acc = 0;
            for (Subject subject : pupil.subjects()) {
                acc += subject.score();
            }
            Label label = new Label(pupil.name(), acc);
            list.add(label);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            Label label = new Label(entry.getKey(), (double) entry.getValue());
            list.add(label);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}