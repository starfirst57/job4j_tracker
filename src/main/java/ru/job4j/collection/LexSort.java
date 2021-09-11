package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftSplit = left.split("\\.",0);
        String[] rightSplit = right.split("\\.",0);
        int leftInt = Integer.parseInt(leftSplit[0]);
        int rightInt = Integer.parseInt(rightSplit[0]);
        return Integer.compare(leftInt, rightInt);
    }
}
