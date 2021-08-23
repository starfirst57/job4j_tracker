package ru.job4j.poly;

public interface Transport {
    void ride();

    void passenger(int count);

    double fuel(int liters);
}
