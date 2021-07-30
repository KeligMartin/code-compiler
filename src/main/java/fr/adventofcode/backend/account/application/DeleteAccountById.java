package fr.adventofcode.backend.account.application;


import fr.adventofcode.backend.account.domain.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountById {

    private final AccountDao accountDao;
    private final FindAccountById findAccountById;

    @Autowired
    public DeleteAccountById(AccountDao accountDao, FindAccountById findAccountById) {
        this.accountDao = accountDao;
        this.findAccountById = findAccountById;
    }

    public void execute(String id) {
        findAccountById.execute(id);
        accountDao.deleteById(id);
    }
}
