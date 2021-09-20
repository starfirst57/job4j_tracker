package ru.job4j.stream;

import java.util.stream.Stream.*;

public class Phone {
    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private double memory;
    private String display;
    private float weight;

    @Override
    public String toString() {
        return "Phone{"
                + "manufacturer='" + manufacturer + '\''
                + ", model='" + model + '\''
                + ", year=" + year
                + ", color='" + color + '\''
                + ", memory=" + memory
                + ", display='" + display + '\''
                + ", weight=" + weight
                + '}';
    }

    static class Builder {
        private String manufacturer;
        private String model;
        private int year;
        private String color;
        private double memory;
        private String display;
        private float weight;

        Builder buildManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildMemory(double memory) {
            this.memory = memory;
            return this;
        }

        Builder buildDisplay(String display) {
            this.display = display;
            return this;
        }

        Builder buildWeight(float weight) {
            this.weight = weight;
            return this;
        }

        Phone build() {
            Phone phone = new Phone();
            phone.manufacturer = manufacturer;
            phone.model = model;
            phone.memory = memory;
            phone.year = year;
            phone.color = color;
            phone.display = display;
            phone.weight = weight;
            return phone;
        }
    }

    public static void main(String[] args) {
        Phone phone = new Builder()
                .buildColor("red")
                .buildManufacturer("Samsung")
                .buildDisplay("OLED")
                .buildYear(2015)
                .buildMemory(12354645.2313)
                .buildModel("A50")
                .buildWeight(115.7f)
                .build();
        System.out.println(phone);
    }
}
