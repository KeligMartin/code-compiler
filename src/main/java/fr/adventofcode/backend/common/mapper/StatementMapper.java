package fr.adventofcode.backend.common.mapper;

import fr.adventofcode.backend.statement.infrastructure.entity.StatementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatementMapper   implements ObjectMapper<fr.adventofcode.backend.statement.domain.Statement, StatementEntity>{

    private final ThemeMapper themeMapper;

    private final LevelMapper levelMapper;

    @Autowired
    public StatementMapper(ThemeMapper themeMapper, LevelMapper levelMapper) {
        this.themeMapper = themeMapper;
        this.levelMapper = levelMapper;
    }

    @Override
    public fr.adventofcode.backend.statement.domain.Statement toDomain(StatementEntity statementEntity) {
        return new fr.adventofcode.backend.statement.domain.Statement(statementEntity.getIdStatement(), statementEntity.getDescription(), themeMapper.toDomain(statementEntity.getThemeEntity()),statementEntity.getTitle(), levelMapper.toDomain(statementEntity.getLevel()), statementEntity.getCreatedAt());
    }

    @Override
    public StatementEntity toEntity(fr.adventofcode.backend.statement.domain.Statement statement) {
        return new StatementEntity(statement.getIdStatement(),statement.getDescription(),statement.getTitle(),statement.getCreatedAt(),themeMapper.toEntity(statement.getTheme()),levelMapper.toEntity(statement.getLevel()));
    }
}
