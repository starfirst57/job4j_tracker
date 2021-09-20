package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Возвращает пользователя по паспортным данным из списка users,
     * если пользователь не найден метод вернет null
     * @return User
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(
                        u -> u.getPassport().equals(passport)
                )
                .findFirst()
                .orElse(null);
    }

    /**
     * Возвращает банковский счет пользователя,
     * если счет не найден метод вернет null
     * @return Account
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(
                            r -> r.getRequisite().equals(requisite)
                    )
                    .findFirst()
                    .orElse(null);
        }
        return null;
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
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dst = findByRequisite(destPassport, destRequisite);
        if (src != null && dst != null
                && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dst.setBalance(dst.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
