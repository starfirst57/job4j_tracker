package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second =  o2.split("/");
        for (int i = 0; i < Math.min(first.length, second.length); i++) {
            if (!first[i].equals(second[i])) {
                return i == 0 ? second[i].compareTo(first[i])
                            : first[i].compareTo(second[i]);
            }
        }
        return Integer.compare(first.length, second.length);
    }
}
