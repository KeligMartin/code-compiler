package fr.adventofcode.backend.account.repository;

import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.account.infrastructure.entity.AccountEntity;
import fr.adventofcode.backend.account.infrastructure.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@SqlDataAccount
@Transactional
public class AccountRepositoryIntegrationTest {

    @Autowired
    AccountRepository accountRepository;
    @Autowired EntityManager entityManager;

    @Test
    public void should_find_all_accounts() {
        assertThat( accountRepository.findAll() ).hasSize(3);
    }

    @Test
    public void should_find_by_uuid() {
        AccountEntity account = accountRepository.getOne("1");

        assertThat(account).isNotNull();
        assertThat(account.getEmail()).isEqualTo("abc@gmail.com");
    }
}