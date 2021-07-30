package fr.adventofcode.backend.userResponse.application.dto;
import fr.adventofcode.backend.language.domain.Language;


public class FindUserResponseRequestDTO {
    private final  String idStatement;

    private final Language language;

    public FindUserResponseRequestDTO(String idStatement, Language language) {
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
