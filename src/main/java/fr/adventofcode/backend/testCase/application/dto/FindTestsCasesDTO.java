package fr.adventofcode.backend.testCase.application.dto;

import fr.adventofcode.backend.language.domain.Language;

public class FindTestsCasesDTO {
    private final Language language;

    private final String idStatement;

    public FindTestsCasesDTO(Language language, String idStatement) {
        this.language = language;
        this.idStatement = idStatement;
    }

    public Language getLanguage() {
        return language;
    }

    public String getIdStatement() {
        return idStatement;
    }


}
