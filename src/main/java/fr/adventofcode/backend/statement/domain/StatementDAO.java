package fr.adventofcode.backend.statement.domain;

import java.util.List;
import java.util.Optional;

public interface StatementDAO {

    Optional<Statement> findByIdStatement(String idStatement);

    String save(Statement statement);

    List<Statement> findByThemeEntity_IdTheme(String idTheme);

    void deleteById(String idStatement);
}
