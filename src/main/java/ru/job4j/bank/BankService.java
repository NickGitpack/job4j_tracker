package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;
import ru.job4j.tracker.StubOutput;

import java.util.*;
/**
 * Класс описывает работу простейшей системы по взаимодействию с
 * банковскими счетами и переводом транзакций.
 * @author NIKITA IVANOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции типа Map : ключ/значение
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя User и добавляет его в коллекцию
     * в качестве ключа. В качестве значения пользователю создается банковский аккаунт.
     * @param user пользователь, который добавляется в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя по паспорту User.
     * @param passport параметр, по которому происходит определения пользователя.
     * @return возвращает результат удаления (true / false)
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет банковский аккаунт пользователю.
     * @param passport поиск пользователя происходит по этому параметру.
     * @param account проверяет, существует ли такой аккаунт у найденного пользователя. Если нет, добавит его.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> acc = users.get(user);
            if (!acc.contains(account)) {
                acc.add(account);
            }
        }
    }

    /**
     * Метод ищет  среди всех пользователей того, кому принадлежит переданный в метод паспорт.
     * @param passport номер паспорта, по которому происходит поиск.
     * @return возвращает либо найденного подьзователя, либо нулевое значение.

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }
    */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет номер аккаунт по данным паспорта пользователя и по реквизитам аккаунта.
     * @param passport номер паспорта, по которому происходит поиск.
     * @param requisite номер аккаунта, по которому происходит поиск.
     * @return возвращает найденный аккаунт, или нулевое значение.

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> account = users.get(user);
            for (Account acc : account) {
                if (requisite.equals(acc.getRequisite())) {
                    return acc;
                }
            }

        }
        return null;
    }
    */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(req -> req.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод проверяет возможность, и если это возможно, совершает денежный перевод с одного аккаунта на другой.
     * @param srcPassport номер паспорта отправителя, по которому происходит поиск.
     * @param srcRequisite реквизиты аккаунта отправителя, по которому происходит поиск.
     * @param destPassport номер паспорта получателя, по которому происходит поиск.
     * @param destRequisite реквизиты аккаунта получателя, по которому происходит поиск.
     * @param amount сумма перевода.
     * @return возвращает информацию о том, совершен перевод или нет.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }

        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}