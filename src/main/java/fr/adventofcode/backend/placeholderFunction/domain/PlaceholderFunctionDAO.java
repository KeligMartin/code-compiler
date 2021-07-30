package fr.adventofcode.backend.placeholderFunction.domain;


import fr.adventofcode.backend.language.domain.Language;

import java.util.List;
import java.util.Optional;

public interface PlaceholderFunctionDAO{
    Optional<PlaceholderFunction> findPlaceholderFunction(String idStatement, Language language);

    String save(PlaceholderFunction placeholderFunction);

    void deleteAllById(String idPlaceholderFunction);

    List<PlaceholderFunction>  findPlaceholderFunctionByIdStatement(String idStatement);
}
