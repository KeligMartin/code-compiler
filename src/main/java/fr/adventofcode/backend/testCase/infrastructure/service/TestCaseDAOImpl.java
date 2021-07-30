package fr.adventofcode.backend.testCase.infrastructure.service;

import fr.adventofcode.backend.common.mapper.TestCaseMapper;
import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.statement.application.FindByIdStatement;
import fr.adventofcode.backend.testCase.domain.TestCase;
import fr.adventofcode.backend.testCase.domain.TestCaseDAO;
import fr.adventofcode.backend.testCase.infrastructure.entity.TestCaseEntity;
import fr.adventofcode.backend.testCase.infrastructure.repository.TestCaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class TestCaseDAOImpl implements TestCaseDAO {

    private final TestCaseRepository testCaseRepository;

    private final TestCaseMapper testCaseMapper;

    private final FindByIdStatement findByIdStatement;

    @Autowired
    public TestCaseDAOImpl(TestCaseRepository testCaseRepository, TestCaseMapper testCaseMapper, FindByIdStatement findByIdStatement) {
        this.testCaseRepository = testCaseRepository;
        this.testCaseMapper = testCaseMapper;
        this.findByIdStatement = findByIdStatement;
    }

    @Override
    public List<TestCase> findTestsCases(String idStatement, Language language) {
        return testCaseRepository.findByStatement_IdStatementAndLanguage(idStatement, language).stream().map(testCaseMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public String save(TestCase testCase) {

        testCase.setStatement(findByIdStatement.execute(testCase.getStatement().getIdStatement()));
        TestCaseEntity testCaseEntity = testCaseMapper.toEntity(testCase);
        return testCaseRepository.save(testCaseEntity).getIdTestCase();
    }

    @Override
    public void delete(String idTestCase) {
        testCaseRepository.deleteById(idTestCase);
    }

    @Override
    @Transactional
    public void   deleteByStatementAndLanguage(String idStatement,Language language) {
        testCaseRepository.deleteByStatement_IdStatementAndLanguage(idStatement,language);
    }


    @Override
    public Optional<TestCase> findTestCaseByIdTestCase(String idTestCase) {
         return testCaseRepository.findByIdTestCase(idTestCase)
                .map(testCaseMapper::toDomain);
    }

    @Override
    public List<TestCase> findByStatement_IdStatement(String idStatement) {
        return testCaseRepository.findByStatement_IdStatement(idStatement).stream().map(testCaseMapper::toDomain).collect(Collectors.toList());
    }
}
