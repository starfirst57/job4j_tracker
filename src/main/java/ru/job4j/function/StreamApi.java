package ru.job4j.function;

import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, -6, 7, 8, -10);
        List<Integer> positive = list.stream()
                .filter(el -> el > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
