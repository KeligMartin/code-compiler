package fr.adventofcode.backend.level.domain;

import java.util.List;
import java.util.Optional;

public interface LevelDao {
    List<Level> findAll();
    Optional<Level> findById(String id);
    String save(Level level);
    void deleteById(String id);
    Level updateLevel(String id, Level level);

}

