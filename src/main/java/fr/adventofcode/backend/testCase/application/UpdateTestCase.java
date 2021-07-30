package fr.adventofcode.backend.testCase.application;

import fr.adventofcode.backend.statement.domain.Statement;
import fr.adventofcode.backend.testCase.application.dto.CodeSkeletonDTO;
import fr.adventofcode.backend.testCase.domain.TestCase;
import fr.adventofcode.backend.testCase.domain.TestCaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTestCase {
    private final TestCaseDAO testCaseDAO;

    @Autowired
    public UpdateTestCase(TestCaseDAO testCaseDAO) {
        this.testCaseDAO = testCaseDAO;
    }

    public String execute(String idTestCase,CodeSkeletonDTO codeSkeletonDTO){
        TestCase testCase =new TestCase(idTestCase,codeSkeletonDTO.getCode(), codeSkeletonDTO.getLanguage(),new Statement(codeSkeletonDTO.getIdStatement()), codeSkeletonDTO.getExpectedOutput());
        return   testCaseDAO.save(testCase);
    }
}
