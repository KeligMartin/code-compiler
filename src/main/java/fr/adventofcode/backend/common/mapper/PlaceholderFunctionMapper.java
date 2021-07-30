package fr.adventofcode.backend.common.mapper;

import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunction;
import fr.adventofcode.backend.placeholderFunction.infrastructure.entity.PlaceholderFunctionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceholderFunctionMapper implements ObjectMapper<PlaceholderFunction, PlaceholderFunctionEntity>{

    private final StatementMapper statementMapper;

    @Autowired
    public PlaceholderFunctionMapper(StatementMapper statementMapper) {
        this.statementMapper = statementMapper;
    }

    @Override
    public PlaceholderFunction toDomain(PlaceholderFunctionEntity placeholderFunctionEntity) {
        return new PlaceholderFunction(placeholderFunctionEntity.getIdPlaceholderFunction(),placeholderFunctionEntity.getCode(),placeholderFunctionEntity.getLanguage(),statementMapper.toDomain(placeholderFunctionEntity.getStatement()));
    }

    @Override
    public PlaceholderFunctionEntity toEntity(PlaceholderFunction placeholderFunction) {
    return new PlaceholderFunctionEntity(
        placeholderFunction.getIdPlaceholderFunction(), placeholderFunction.getCode(),placeholderFunction.getLanguage(),statementMapper.toEntity(placeholderFunction.getStatement()));
    }
}
