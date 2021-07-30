package fr.adventofcode.backend.account.domain;

import java.util.List;
import java.util.Optional;

public interface AccountDao {

    List<Account> findAll();

    Optional<Account> findById(String id);

    Optional<Account> findByUsername(String username);

    String save(Account account);

    void deleteById(String id);
}
