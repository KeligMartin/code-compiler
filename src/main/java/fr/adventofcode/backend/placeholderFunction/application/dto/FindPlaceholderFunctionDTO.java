package fr.adventofcode.backend.placeholderFunction.application.dto;

import fr.adventofcode.backend.language.domain.Language;

public class FindPlaceholderFunctionDTO {
    private final String idStatement;

    private final Language language;

    public FindPlaceholderFunctionDTO(String idStatement, Language language) {
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
