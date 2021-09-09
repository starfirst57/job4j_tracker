package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private Tracker tracker = new Tracker();

    private static SingleTracker singletrack = null;

    public SingleTracker getSingletrack() {
        if (singletrack == null) {
            singletrack = new SingleTracker();
        }
        return singletrack;
    }

    private SingleTracker() { }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public List<Item> showAll() {
       return tracker.findAll();
    }

    public void delete(int id) {
        tracker.delete(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }
}

