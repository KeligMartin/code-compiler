package fr.adventofcode.backend.placeholderFunction.infrastructure.service;

import fr.adventofcode.backend.common.mapper.PlaceholderFunctionMapper;
import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunction;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunctionDAO;
import fr.adventofcode.backend.placeholderFunction.infrastructure.entity.PlaceholderFunctionEntity;
import fr.adventofcode.backend.placeholderFunction.infrastructure.repository.PlaceholderFunctionRepository;
import fr.adventofcode.backend.statement.application.FindByIdStatement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class PlaceholderFunctionDAOImpl implements PlaceholderFunctionDAO {

    private final PlaceholderFunctionRepository placeholderFunctionRepository;

    private final PlaceholderFunctionMapper placeholderFunctionMapper;

    private final FindByIdStatement findByIdStatement;

    @Autowired
    public PlaceholderFunctionDAOImpl(PlaceholderFunctionRepository placeholderFunctionRepository, PlaceholderFunctionMapper placeholderFunctionMapper, FindByIdStatement findByIdStatement) {
        this.placeholderFunctionRepository = placeholderFunctionRepository;
        this.placeholderFunctionMapper = placeholderFunctionMapper;
        this.findByIdStatement = findByIdStatement;
    }

    @Override
    public Optional<PlaceholderFunction> findPlaceholderFunction(String idStatement, Language language) {
        return placeholderFunctionRepository.findFirstByStatement_IdStatementAndLanguage(idStatement,language).map(placeholderFunctionMapper::toDomain) ;
    }

    @Override
    public String save(PlaceholderFunction placeholderFunction) {
        placeholderFunction.setStatement(findByIdStatement.execute(placeholderFunction.getStatement().getIdStatement()));
        PlaceholderFunctionEntity placeholderFunctionEntity = placeholderFunctionMapper.toEntity(placeholderFunction);
        return placeholderFunctionRepository.save(placeholderFunctionEntity).getIdPlaceholderFunction();
    }

    @Override
    public void deleteAllById(String idPlaceholderFunction) {
        this.placeholderFunctionRepository.deleteById(idPlaceholderFunction);
    }

    @Override
    public List<PlaceholderFunction> findPlaceholderFunctionByIdStatement(String idStatement) {
        log.info(idStatement);
        return this.placeholderFunctionRepository.findByStatement_IdStatement(idStatement).stream().map(placeholderFunctionMapper::toDomain).collect(Collectors.toList());
    }


}
