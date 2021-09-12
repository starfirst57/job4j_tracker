package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных банковского счета с полями
 * requisite и  balance
 * @author Андрей Хоржевский
 * @version 1.0
 */
public class Account {
    /**
     * Номер счета
     */
    private String requisite;
    /**
     * Сумма на счете
     */
    private double balance;

    /**
     * Консутруктор класса Account
     * @param requisite String
     * @param balance String
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает значение поля requisite
     * @return String
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Возвращает значение поля balance
     * @return double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Задает значение поля requisite
     * @param requisite String
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Задает значение поля balance
     * @param balance double
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает два объекта по полю requisite
     * @param o объект с которым производится сравнение
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
        Account account = (Account) o;
        return requisite.equals(account.requisite);
    }

    /**
     * Возвращает hash поля requisite
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
