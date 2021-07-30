package fr.adventofcode.backend.placeholderFunction.application.dto;

import fr.adventofcode.backend.language.domain.Language;

public class PlaceholderFunctionDTO {

    private final String code;
    private final Language language;
    private final String idStatement;

    public PlaceholderFunctionDTO(String code, Language language, String idStatement) {
        this.code = code;
        this.language = language;
        this.idStatement = idStatement;
    }


    public String getCode() {
        return code;
    }

    public Language getLanguage() {
        return language;
    }

    public String getIdStatement() {
        return idStatement;
    }
}
