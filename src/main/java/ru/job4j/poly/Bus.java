package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Автобус выехал");
    }

    @Override
    public void passenger(int count) {
        if (count >= 6) {
            System.out.println("Мест больше нет");
        } else {
            System.out.println("Есть еще " + (6 - count) + " мест");
        }
    }

    @Override
    public double fuel(int liters) {
        double price = 46.5;
        return price * liters;
        }
    }

