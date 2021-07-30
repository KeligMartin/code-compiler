package fr.adventofcode.backend.testCase.domain;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.statement.domain.Statement;

public class TestCase {
    private String idTestCase;

    private String code;

    private Language language;

    private Statement statement;

    private String expectedOutput;

    public TestCase(String idTestCase, String code, Language language, Statement statement, String expectedOutput) {
        this.idTestCase = idTestCase;
        this.code = code;
        this.language = language;
        this.statement = statement;
        this.expectedOutput = expectedOutput;
    }

    public TestCase(String code, Language language, Statement statement, String expectedOutput) {
        this.code = code;
        this.language = language;
        this.statement = statement;
        this.expectedOutput = expectedOutput;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public String getIdTestCase() {
        return idTestCase;
    }

    public void setIdTestCase(String idTestCase) {
        this.idTestCase = idTestCase;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }


}
