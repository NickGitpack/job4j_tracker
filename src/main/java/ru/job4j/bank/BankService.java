package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;
import ru.job4j.tracker.StubOutput;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        return users.keySet().remove(user);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        System.out.println(users.get(user));
        for (Account acc : users.get(user)) {
            System.out.println(acc.getRequisite() + " = " + acc.getBalance());
        }
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

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