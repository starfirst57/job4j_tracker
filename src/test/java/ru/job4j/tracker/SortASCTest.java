package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SortASCTest {

    @Test
    public void sortForward() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2,"two"));
        items.add(new Item(4, "four"));
        items.add(new Item(3, "three"));
        items.add(new Item(1, "one"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1, "one"));
        expected.add(new Item(2,"two"));
        expected.add(new Item(3, "three"));
        expected.add(new Item(4, "four"));
        items.sort(new SortASC());
        assertEquals(expected, items);
    }

    @Test
    public void sortReversed() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2,"two"));
        items.add(new Item(4, "four"));
        items.add(new Item(3, "three"));
        items.add(new Item(1, "one"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(4, "four"));
        expected.add(new Item(3, "three"));
        expected.add(new Item(2,"two"));
        expected.add(new Item(1, "one"));
        items.sort(new SortASC().reversed());
        assertEquals(expected, items);
    }
}