package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        List<String> list = new ArrayList();
        list.add("abcde");
        list.add("abc");
        list.sort(comparator);
        list.forEach(System.out::println);
    }
}
