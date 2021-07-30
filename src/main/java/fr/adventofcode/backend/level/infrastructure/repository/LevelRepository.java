package fr.adventofcode.backend.level.infrastructure.repository;

import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.level.infrastructure.entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<LevelEntity, String> {
    List<LevelEntity> findAll();

    Optional<LevelEntity> findById(String id);

    String save(Level level);

    void deleteById(String id);
}
