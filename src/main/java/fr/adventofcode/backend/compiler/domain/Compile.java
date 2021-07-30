package fr.adventofcode.backend.compiler.domain;

import fr.adventofcode.backend.language.domain.Language;

public class Compile {
    private final Language language;

    private final String code;

    private final String idStatement;

    private final String idTestCase;



    public Compile(Language language, String code, String idStatement, String idTestCase) {
        this.language = language;
        this.code = code;
        this.idStatement = idStatement;
        this.idTestCase = idTestCase;
    }

    public String getIdTestCase() {
        return idTestCase;
    }

    public Language getLanguage() {
        return language;
    }

    public String getCode() {
        return code;
    }

    public String getIdStatement() {
        return idStatement;
    }
}
