package fr.adventofcode.backend.testCase.infrastructure.entity;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.statement.infrastructure.entity.StatementEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "testCase")
public class TestCaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String idTestCase;

    @Column(length=10485760)
    private String code;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne
    @JoinColumn(name="idStatement", nullable=false )
    private StatementEntity statement;

    private String expectedOutput;


    public TestCaseEntity(String idTestCase, String code, Language language, StatementEntity statement, String expectedOutput) {
        this.idTestCase = idTestCase;
        this.code = code;
        this.language = language;
        this.statement = statement;
        this.expectedOutput = expectedOutput;
    }

    public TestCaseEntity(){

    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String output) {
        this.expectedOutput = output;
    }

    public String getIdTestCase() {
        return idTestCase;
    }

    public void setIdTestCase(String idMainStatement) {
        this.idTestCase = idMainStatement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String mainCode) {
        this.code = mainCode;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public StatementEntity getStatement() {
        return statement;
    }

    public void setStatement(StatementEntity statementEntity) {
        this.statement = statementEntity;
    }

}
