package fr.adventofcode.backend.userResponse.infrastructure.repository;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.userResponse.infrastructure.entity.UserResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserResponseRepository extends JpaRepository<UserResponseEntity,String> {
    List<UserResponseEntity> findByResolvedAndAccountId(Boolean resolved, String accountId);

    Optional<UserResponseEntity> findByStatement_IdStatementAndLanguageAndAccount_Id(String idStatement, Language language, String account_id);

    List<UserResponseEntity> findAll();

    Optional<UserResponseEntity> findByIdUserResponse(String idUserResponse);

    List<UserResponseEntity> findByStatement_IdStatementAndAccount_IdAndResolvedIsTrue(String statement_idStatement, String account_id);
 }

