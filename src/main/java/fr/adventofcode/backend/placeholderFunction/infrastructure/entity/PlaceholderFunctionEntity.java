package fr.adventofcode.backend.placeholderFunction.infrastructure.entity;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.statement.infrastructure.entity.StatementEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity(name = "placeholderFunction")
public class PlaceholderFunctionEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String idPlaceholderFunction;

    @Column(length=10485760)
    private String code;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne
    @JoinColumn(name="idStatement", nullable=false)
    private StatementEntity statement;

    public PlaceholderFunctionEntity(String idPlaceholderFunction, String code, Language language, StatementEntity statement) {
        this.idPlaceholderFunction = idPlaceholderFunction;
        this.code = code;
        this.language = language;
        this.statement = statement;
    }

    public PlaceholderFunctionEntity(){

    }

    public String getIdPlaceholderFunction() {
        return idPlaceholderFunction;
    }

    public void setIdPlaceholderFunction(String idPlaceholderFunction) {
        this.idPlaceholderFunction = idPlaceholderFunction;
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

    public StatementEntity getStatement() {
        return statement;
    }

    public void setStatement(StatementEntity statementEntity) {
        this.statement = statementEntity;
    }
}
