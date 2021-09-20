package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает функционал регистрации пользователей в системе банка,
 * поиска пользователя по паспортным данным,
 * создания банковских счетов пользователя,
 * поиска банковских счетов по номеру счета
 * и перевода денег между счетами
 * @author Андрей Хоржевский
 * @version 1.0
 */
public class BankService {
    /**
     * Хранит список пользователей типа User со списком их счетов типа Account списком List
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет в список users нового уникального пользователя с пустым списком счетов
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавляет пользователю новый банковский счет при условии,
     * что такого счета не содержится в списке счетов пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Возвращает пользователя по паспортным данным из списка users,
     * если пользователь не найден метод вернет null
     * @return User
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(
                        u -> u.getPassport().equals(passport)
                )
                .findFirst();
    }

    /**
     * Возвращает банковский счет пользователя,
     * если счет не найден метод вернет null
     * @return Account
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(
                        r -> r.getRequisite().equals(requisite)
                )
                .findFirst());
    }

    /**
     * Переводит конкретную сумму принимаемую
     * в качестве параметра с одного счета на другой
     * @param srcPassport паспорт пользователя с которого переводятся деньги
     * @param srcRequisite номер счета с которого переводятся деньги
     * @param destPassport паспорт пользователя которому переводятся деньги
     * @param destRequisite номер счета на который переводятся деньги
     * @param amount сумма перевода
     * @return boolean
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dst = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dst.isPresent()
                && src.get().getBalance() >= amount) {
            src.get().setBalance(src.get().getBalance() - amount);
            dst.get().setBalance(dst.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
