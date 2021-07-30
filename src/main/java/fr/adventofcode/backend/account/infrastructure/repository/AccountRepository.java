package fr.adventofcode.backend.account.infrastructure.repository;

import fr.adventofcode.backend.account.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    List<AccountEntity> findAll();

    Optional<AccountEntity> findById(String id);

    Optional<AccountEntity> findByUsername(String username);

    void deleteById(String id);
}
