package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(el -> el.getSubjects().stream())
                .mapToDouble(Subject::getScore).average().orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return  stream
                .flatMap(subj -> subj.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(Subject::getName,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)
                        )
                ).entrySet()
                .stream()
                .map(
                        el -> new Tuple(el.getKey(), el.getValue())
                )
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(
                        x -> new Tuple(
                                x.getName(),
                                x.getSubjects()
                                        .stream()
                                        .mapToDouble(Subject::getScore)
                                        .average().orElse(0D)

                        )
                ).collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(
                        x -> new Tuple(
                                x.getName(),
                                x.getSubjects()
                                        .stream()
                                        .mapToDouble(Subject::getScore)
                                        .sum()

                        )
                ).max(Comparator.comparingDouble(Tuple::getScore)).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(subj -> subj.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(Subject::getName,
                                Collectors.summingDouble(Subject::getScore)
                        )
                ).entrySet()
                .stream()
                .map(
                        el -> new Tuple(el.getKey(), el.getValue())
                )
                .max(Comparator.comparingDouble(Tuple::getScore)).orElse(null);
    }

    public static void main(String[] args) {

    }
}
