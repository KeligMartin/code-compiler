package fr.adventofcode.backend.quality.infrastructure.service;

import fr.adventofcode.backend.common.mapper.CodeQualityMapper;
import fr.adventofcode.backend.quality.domain.CodeQuality;
import fr.adventofcode.backend.quality.domain.CodeQualityDao;
import fr.adventofcode.backend.quality.infrastructure.entity.CodeQualityEntity;
import fr.adventofcode.backend.quality.infrastructure.repository.CodeQualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CodeQualityDaoImpl implements CodeQualityDao {

    private final CodeQualityRepository repository;
    private final CodeQualityMapper mapper;

    @Autowired
    public CodeQualityDaoImpl(CodeQualityRepository repository, CodeQualityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<CodeQuality> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<CodeQuality> findById(String id) {
        return repository.findByIdCodeQuality(id).map(mapper::toDomain);
    }

    public List<CodeQuality> findAllByUserResponseId(String userResponseId) {
        return repository.findAllByUserResponseId(userResponseId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CodeQuality> findLastByUserResponseId(String userResponseId) {
        return repository.findFirstByUserResponseIdOrderByDateDesc(userResponseId).map(mapper::toDomain);
    }

    @Override
    public String save(CodeQuality codeQuality) {
        CodeQualityEntity codeQualityEntity = mapper.toEntity(codeQuality);
        repository.save(codeQualityEntity);
        return codeQualityEntity.getIdCodeQuality();
    }
}
