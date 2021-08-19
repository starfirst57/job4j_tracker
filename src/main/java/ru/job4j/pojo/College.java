package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Пупкин Иван Иванович");
        student.setGroup("Ф-122");
        student.setStartDate("12.08.2006");
        System.out.println(student.getName());
        System.out.println(student.getGroup());
        System.out.println(student.getStartDate());
    }
}
