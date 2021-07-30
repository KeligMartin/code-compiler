package fr.adventofcode.backend.account.application;


import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.account.domain.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddAccount {

    private final AccountDao accountDao;

    @Autowired
    public AddAccount(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String execute(Account account) {
        return accountDao.save(account);
    }
}
