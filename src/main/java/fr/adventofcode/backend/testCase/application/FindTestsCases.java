package fr.adventofcode.backend.testCase.application;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.testCase.domain.TestCase;
import fr.adventofcode.backend.testCase.domain.TestCaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindTestsCases {

    private final TestCaseDAO testCaseDAO;

    @Autowired
    public FindTestsCases(TestCaseDAO testCaseDAO) {
        this.testCaseDAO = testCaseDAO;
    }


    public List<TestCase> execute(String idStatement, Language language){
        return testCaseDAO.findTestsCases(idStatement,language);
    }

}
