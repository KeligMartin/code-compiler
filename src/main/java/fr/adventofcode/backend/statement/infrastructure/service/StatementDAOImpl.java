package fr.adventofcode.backend.statement.infrastructure.service;

import fr.adventofcode.backend.common.mapper.StatementMapper;
import fr.adventofcode.backend.statement.domain.Statement;
import fr.adventofcode.backend.statement.domain.StatementDAO;
import fr.adventofcode.backend.statement.infrastructure.entity.StatementEntity;
import fr.adventofcode.backend.statement.infrastructure.repository.StatementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class StatementDAOImpl implements StatementDAO {

    private final StatementRepository statementRepository;

    private final StatementMapper statementMapper;

    @Autowired
    public StatementDAOImpl(StatementRepository statementRepository, StatementMapper statementMapper) {
        this.statementRepository = statementRepository;
        this.statementMapper = statementMapper;
    }

    @Override
    public Optional<Statement> findByIdStatement(String idStatement) {
         return statementRepository.findByIdStatement(idStatement)
                .map(statementMapper::toDomain);
    }

    @Override
    public String save(fr.adventofcode.backend.statement.domain.Statement statement) {
        StatementEntity statementEntity = statementMapper.toEntity(statement);
        statementRepository.save(statementEntity);
        return statementEntity.getIdStatement();
    }

    @Override
    public List<Statement> findByThemeEntity_IdTheme(String idTheme) {
        return statementRepository.findByThemeEntity_IdTheme(idTheme).stream().map(statementMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(String idStatement) {
        this.statementRepository.deleteById(idStatement);
    }

}
