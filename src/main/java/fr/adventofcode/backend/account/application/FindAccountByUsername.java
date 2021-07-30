package fr.adventofcode.backend.account.application;


import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.account.domain.AccountDao;
import fr.adventofcode.backend.common.exception.AccountWithUsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FindAccountByUsername {

    private final AccountDao accountDao;

    public FindAccountByUsername(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account execute(String username){
        return accountDao.findByUsername(username)
                .orElseThrow(() -> new AccountWithUsernameNotFoundException(username));
    }
}
