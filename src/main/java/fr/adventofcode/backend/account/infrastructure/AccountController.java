package fr.adventofcode.backend.account.infrastructure;


import fr.adventofcode.backend.account.application.DeleteAccountById;
import fr.adventofcode.backend.account.application.FindAccountById;
import fr.adventofcode.backend.account.application.FindAllAccounts;
import fr.adventofcode.backend.account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final FindAllAccounts findAllAccounts;
    private final FindAccountById findAccountById;
    private final DeleteAccountById deleteAccountById;

    @Autowired
    public AccountController(FindAllAccounts findAllAccounts,
                             FindAccountById findAccountById,
                             DeleteAccountById deleteAccountById) {
        this.findAllAccounts = findAllAccounts;
        this.findAccountById = findAccountById;
        this.deleteAccountById = deleteAccountById;
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAllAccounts(){

        return new ResponseEntity<>(findAllAccounts.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable String id) {
        return new ResponseEntity<>(findAccountById.execute(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccountById(@PathVariable String id) {
        deleteAccountById.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
