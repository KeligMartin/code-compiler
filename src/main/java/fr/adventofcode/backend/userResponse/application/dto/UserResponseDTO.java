package fr.adventofcode.backend.userResponse.application.dto;

import fr.adventofcode.backend.language.domain.Language;

import java.time.LocalDateTime;


public class UserResponseDTO {

    private final String code ;

    private final Boolean resolved;

    private final LocalDateTime resolvedDate;


    private final String  idStatement;

    private final Language language;

    public UserResponseDTO(String code, Boolean resolved, LocalDateTime resolvedDate, String idStatement, Language language) {
        this.code = code;
        this.resolved = resolved;
        this.resolvedDate = resolvedDate;
        this.idStatement = idStatement;
        this.language = language;
    }


    public String getCode() {
        return code;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public LocalDateTime getResolvedDate() {
        return resolvedDate;
    }


    public String getIdStatement() {
        return idStatement;
    }

    public Language getLanguage() {
        return language;
    }
}
