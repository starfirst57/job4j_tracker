package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
           int length = Math.min(left.length(), right.length());
           for (int i = 0; i < length; i++) {
               char first = left.charAt(i);
               char second = right.charAt(i);
               if (first != second) {
                   return Character.compare(first, second);
               }
           }
        return Integer.compare(left.length(), right.length());
    }
}
