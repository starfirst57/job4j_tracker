package ru.job4j.oop;

public class Battery {
    private int load;

    public void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = 0;
    }
}
