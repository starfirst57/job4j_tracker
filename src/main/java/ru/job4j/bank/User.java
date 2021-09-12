package ru.job4j.bank;

import java.util.Objects;

/**
 * Описывает модель данных пользователя с полями passport и username
 * @author Андрей Хоржевский
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     * Конструктор класса User
     * @param passport String
     * @param username String
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает значение поля passport
     * @return String
     */
    public String getPassport() {
        return passport;
    }

    /**
     *Задает значение поля passport
     * @param passport String
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает значение роля username
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Задает значение поля username
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Производит сравнение двух объектов по ссылке, классу и полю passport
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает hash значение поля passport
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
