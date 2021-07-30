package fr.adventofcode.backend.testCase.application;


import fr.adventofcode.backend.testCase.domain.TestCaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTestCase {
    private final TestCaseDAO testCaseDAO;

    @Autowired
    public DeleteTestCase(TestCaseDAO testCaseDAO) {
        this.testCaseDAO = testCaseDAO;
    }


    public void execute(String idTestCase){
        testCaseDAO.delete(idTestCase);
    }
}
