package fr.adventofcode.backend.statement.infrastructure.repository;


import fr.adventofcode.backend.statement.infrastructure.entity.StatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StatementRepository extends JpaRepository<StatementEntity, String> {

    Optional<StatementEntity> findByIdStatement(String IdStatement);

    List<StatementEntity> findByThemeEntity_IdTheme(String themeEntity_idTheme);

}
