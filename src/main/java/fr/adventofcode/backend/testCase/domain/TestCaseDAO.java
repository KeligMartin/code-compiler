package fr.adventofcode.backend.testCase.domain;

import fr.adventofcode.backend.language.domain.Language;

import java.util.List;
import java.util.Optional;

public interface TestCaseDAO {

    List<TestCase> findByStatement_IdStatement(String idStatement);

    List<TestCase> findTestsCases(String idStatement, Language language);

    String save(TestCase testCase);

    Optional<TestCase> findTestCaseByIdTestCase(String idTestCase);

    void delete(String idTestCase);

    void deleteByStatementAndLanguage(String idStatement,Language language);
}
