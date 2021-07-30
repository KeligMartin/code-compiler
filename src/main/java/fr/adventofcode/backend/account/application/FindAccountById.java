package fr.adventofcode.backend.account.application;


import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.account.domain.AccountDao;
import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindAccountById {

    private final AccountDao accountDao;

    @Autowired
    public FindAccountById(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    public Account execute(String id){
        return accountDao.findById(id)
                .orElseThrow(() -> new ResourceWithIdNotFoundException("user", id));
    }
}
