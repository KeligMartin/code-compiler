package fr.adventofcode.backend.common.mapper;

import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.level.infrastructure.entity.LevelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelMapper implements ObjectMapper<Level, LevelEntity>{

    @Autowired
    public LevelMapper(){
    }
    @Override
    public Level toDomain(LevelEntity levelEntity) {
        return new Level(levelEntity.getId(),
                levelEntity.getName(),
                levelEntity.getCreatedAt(),
                levelEntity.getGain()
        );
    }

    @Override
    public LevelEntity toEntity(Level level) {
        return new LevelEntity(
                level.getId(),
                level.getName(),
                level.getCreatedAt(),
                level.getGain()
        );
    }
}
