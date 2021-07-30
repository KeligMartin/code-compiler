package fr.adventofcode.backend.account.infrastructure.service;


import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.account.domain.AccountDao;
import fr.adventofcode.backend.account.infrastructure.entity.AccountEntity;
import fr.adventofcode.backend.account.infrastructure.repository.AccountRepository;
import fr.adventofcode.backend.common.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AccountDAOImpl implements AccountDao {

    private final AccountRepository repository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountDAOImpl(AccountRepository repository, AccountMapper accountMapper){
        this.repository = repository;
        this.accountMapper = accountMapper;
    }

    public List<Account> findAll(){
        return repository.findAll()
                .stream()
                .map(accountMapper::toDomain)
                .collect(Collectors.toList()
                );
    }

    public Optional<Account> findById(String id){
        return repository.findById(id)
                .map(accountMapper::toDomain);
    }

    public Optional<Account> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(accountMapper::toDomain);
    }

    public String save(Account account){
        AccountEntity accountEntity = accountMapper.toEntity(account);
        repository.save(accountEntity);
        return accountEntity.getId();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
