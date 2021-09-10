package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> persons = new HashMap<>();
        persons.put("admin@admin.com", "Ivan Ivanov");
        persons.put("coconut@rambler.ru", "Petr Petrov");
        persons.put("pineapple@yandex.ru", "Sergei Sergeev");
        for (String key: persons.keySet()) {
            System.out.println(persons.get(key));
        }
    }
}
