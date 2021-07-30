package fr.adventofcode.backend.testCase.application.dto;

import fr.adventofcode.backend.language.domain.Language;

public class SearchPlaceholderDTO {
    private final String idStatement;

    private final Language language;


    public SearchPlaceholderDTO(String idStatement, Language language) {
        this.idStatement = idStatement;
        this.language = language;
    }


    public String getIdStatement() {
        return idStatement;
    }

    public Language getLanguage() {
        return language;
    }
}
