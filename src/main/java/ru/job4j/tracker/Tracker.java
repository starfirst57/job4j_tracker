package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] notNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                notNull[size] = items[i];
                size++;
            }
        }
        notNull = Arrays.copyOf(notNull, size);
        return notNull;
    }

    public Item[] findByName(String key) {
        Item[] search = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (key.equals(items[i].getName())) {
                    search[size] = items[i];
                    size++;
                }
            }
        }
        search = Arrays.copyOf(search, size);
        return search;
    }
}