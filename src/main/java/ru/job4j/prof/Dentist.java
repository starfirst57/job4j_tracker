package ru.job4j.prof;

public class Dentist extends Doctor {
    private String workAddress;

    public Dentist(String name, String surname, String education,
                   String birthday, String workAddress) {
        super(name, surname, education, birthday);
        this.workAddress = workAddress;
    }

    public String[] getPatientsList(Dentist dentist) {
        String[] array = new String[4];
        return array;
    }
}
