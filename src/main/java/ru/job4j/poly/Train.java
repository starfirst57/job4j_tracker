package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по жлезнодорожным путям.");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " использует дизельное топливо.");
    }
}
