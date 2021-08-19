package ru.job4j.prof;

public class Builder extends Engineer {
    private String company;
    private String project;

    public Builder(String name, String surname, String education, String birthday,
                   String company, String project) {
        super(name, surname, education, birthday);
        this.company = company;
        this.project = project;

    }

    public void dateFinishProject(Builder engineer, String project, String date) { }
}

