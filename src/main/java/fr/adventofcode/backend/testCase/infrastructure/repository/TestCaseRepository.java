package fr.adventofcode.backend.testCase.infrastructure.repository;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.testCase.infrastructure.entity.TestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCaseEntity,String> {

    // Pour avoir la liste des languages dispo pour cette enonce
    List<TestCaseEntity> findByStatement_IdStatement(String idStatement);

     List<TestCaseEntity> findByStatement_IdStatementAndLanguage(String idStatement, Language language);

     Optional<TestCaseEntity> findByIdTestCase(String idTestCase);


     void deleteByStatement_IdStatementAndLanguage(String idStatement,Language language);
}
