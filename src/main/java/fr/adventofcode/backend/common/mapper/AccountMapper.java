package fr.adventofcode.backend.common.mapper;

import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.account.infrastructure.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper implements ObjectMapper<Account, AccountEntity> {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Account toDomain(AccountEntity accountEntity) {
        return new Account(accountEntity.getId(),
                accountEntity.getEmail(),
                accountEntity.getUsername(),
                accountEntity.getPassword(),
                accountEntity.getBirthdate(),
                accountEntity.getRole()
        );
    }

    public AccountEntity toEntity(Account account) {
        return new AccountEntity(
                account.getId(),
                account.getEmail(),
                account.getUsername(),
                passwordEncoder.encode(account.getPassword()),
                account.getRole(),
                 account.getBirthdate());
    }
}
