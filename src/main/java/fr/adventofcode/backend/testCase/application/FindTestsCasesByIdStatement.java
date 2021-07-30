package fr.adventofcode.backend.testCase.application;

import fr.adventofcode.backend.testCase.domain.TestCase;
import fr.adventofcode.backend.testCase.domain.TestCaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindTestsCasesByIdStatement {
    private  final TestCaseDAO testCaseDAO;

    @Autowired
    public FindTestsCasesByIdStatement(TestCaseDAO testCaseDAO){
        this.testCaseDAO = testCaseDAO;
    }

    public List<TestCase> execute(String idStatement){
        return testCaseDAO.findByStatement_IdStatement(idStatement);
    }
}
