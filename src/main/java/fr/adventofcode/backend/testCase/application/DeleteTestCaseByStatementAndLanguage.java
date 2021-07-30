package fr.adventofcode.backend.testCase.application;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.testCase.domain.TestCaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTestCaseByStatementAndLanguage {
    private final TestCaseDAO testCaseDAO;

    @Autowired
    public DeleteTestCaseByStatementAndLanguage(TestCaseDAO testCaseDAO) {
        this.testCaseDAO = testCaseDAO;
    }


    public void execute(String idStatement, Language language){
        testCaseDAO.deleteByStatementAndLanguage(idStatement, language);
    }
}
