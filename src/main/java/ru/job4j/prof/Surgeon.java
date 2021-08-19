package ru.job4j.prof;

public class Surgeon extends Doctor {
    private String workDirection;
    private double experience;

    public Surgeon(String name, String surname, String education,
                   String birthday, String workDirection, double experience) {
        super(name, surname, education, birthday);

    }

    public double getExperience() {
        return experience;
    }

    public String getWorkDirection() {
        return workDirection;
    }

    public void surgery(Surgeon name, Pacient pacient, String date) {

    }
}
