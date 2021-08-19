package ru.job4j.prof;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);

    }

    public void addWorkerToProject(Engineer engineer, Project project) { }
}
