package fr.adventofcode.backend.testCase.application;

import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import fr.adventofcode.backend.testCase.domain.TestCase;
import fr.adventofcode.backend.testCase.domain.TestCaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindTestCaseByIdTestCase {
    private final TestCaseDAO testCaseDAO;

    @Autowired
    public FindTestCaseByIdTestCase(TestCaseDAO testCaseDAO) {
        this.testCaseDAO = testCaseDAO;
    }


    public TestCase execute(String idTestCase){
        return testCaseDAO.findTestCaseByIdTestCase(idTestCase).orElseThrow(() -> new ResourceWithIdNotFoundException("testCase", idTestCase));
    }
}
