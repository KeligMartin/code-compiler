package fr.adventofcode.backend.common.mapper;

import fr.adventofcode.backend.testCase.domain.TestCase;
import fr.adventofcode.backend.testCase.infrastructure.entity.TestCaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseMapper implements ObjectMapper<TestCase, TestCaseEntity> {

    private final StatementMapper statementMapper;

    @Autowired
    public TestCaseMapper(StatementMapper statementMapper){
        this.statementMapper = statementMapper;
    }

    @Override
    public TestCase toDomain(TestCaseEntity testCaseEntity) {
        return new TestCase(testCaseEntity.getIdTestCase(), testCaseEntity.getCode(), testCaseEntity.getLanguage(),statementMapper.toDomain(testCaseEntity.getStatement()), testCaseEntity.getExpectedOutput());
    }

    @Override
    public TestCaseEntity toEntity(TestCase testCase) {
        return new TestCaseEntity(testCase.getIdTestCase(), testCase.getCode(), testCase.getLanguage(),statementMapper.toEntity(testCase.getStatement()), testCase.getExpectedOutput());
    }
}
