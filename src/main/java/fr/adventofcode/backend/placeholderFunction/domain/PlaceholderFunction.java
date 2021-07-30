package fr.adventofcode.backend.placeholderFunction.domain;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.statement.domain.Statement;

public class PlaceholderFunction {

    private String idPlaceholderFunction;

    private String code;

    private Language language;

    private Statement statement;

    public PlaceholderFunction(String idPlaceholderFunction, String code, Language language, Statement statement) {
        this.idPlaceholderFunction = idPlaceholderFunction;
        this.code = code;
        this.language = language;
        this.statement = statement;
    }
    public PlaceholderFunction( String code, Language language, Statement statement) {
        this.code = code;
        this.language = language;
        this.statement = statement;
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

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
