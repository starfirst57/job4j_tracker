package ru.job4j.poly;

public class PolyBus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по шоссе и магистралям.");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " заправляется 95ым бензином.");
    }
}
