package ru.job4j.poly;

public class VehicleArray {
    public static void main(String[] args) {
        Vehicle bus = new PolyBus();
        Vehicle train = new Train();
        Vehicle plane = new Plane();
        Vehicle[] array = {bus, train, plane};
        for (int i = 0; i < array.length; i++) {
            array[i].move();
            array[i].fuel();
        }
    }
}
