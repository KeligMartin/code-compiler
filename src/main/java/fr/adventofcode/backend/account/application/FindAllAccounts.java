package fr.adventofcode.backend.account.application;


import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.account.domain.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllAccounts {

    private final AccountDao accountDao;

    @Autowired
    public FindAllAccounts(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    public List<Account> execute(){
        return accountDao.findAll();
    }
}
