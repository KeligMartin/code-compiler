package fr.adventofcode.backend.placeholderFunction.infrastructure.repository;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.placeholderFunction.infrastructure.entity.PlaceholderFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceholderFunctionRepository extends JpaRepository<PlaceholderFunctionEntity,String> {
    Optional<PlaceholderFunctionEntity> findFirstByStatement_IdStatementAndLanguage(String idStatement, Language language);

    List<PlaceholderFunctionEntity> findByStatement_IdStatement(String idStatement);
}
