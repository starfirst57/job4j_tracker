package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
           int length = Math.min(left.length(), right.length());
           for (int i = 0; i < length; i++) {
               char char1 = left.charAt(i);
               char char2 = right.charAt(i);
               if (char1 != char2) {
                   return Character.compare(char1, char2);
               }
           }
        return Integer.compare(left.length(), right.length());
    }
}
