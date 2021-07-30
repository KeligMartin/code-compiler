package fr.adventofcode.backend.level.infrastructure.service;

import fr.adventofcode.backend.common.mapper.LevelMapper;
import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.level.domain.LevelDao;
import fr.adventofcode.backend.level.infrastructure.entity.LevelEntity;
import fr.adventofcode.backend.level.infrastructure.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LevelDAOImpl implements LevelDao {

    private final LevelRepository repository;
    private final LevelMapper levelMapper;

    @Autowired
    public LevelDAOImpl(LevelRepository repository, LevelMapper levelMapper) {
        this.repository = repository;
        this.levelMapper = levelMapper;
    }

    public List<Level> findAll(){
        return repository.findAll()
                .stream()
                .map(levelMapper::toDomain)
                .collect(Collectors.toList());
    }


    public Optional<Level> findById(String id) {
        return repository.findById(id)
                .map(levelMapper::toDomain);
    }

    public String save(Level level) {
        LevelEntity levelEntity = levelMapper.toEntity(level);
        repository.save(levelEntity);
        return levelEntity.getId();
    }

    public void deleteById(String id) { repository.deleteById(id);}


    public Level updateLevel(String id, Level level) {
        Optional<Level> levelOpt = repository.findById(id).map(levelMapper::toDomain);
        Level levelUp = levelOpt.get();
        levelUp.setName(level.getName());
        levelUp.setCreatedAt(level.getCreatedAt());
        levelUp.setGain(level.getGain());
        repository.save(levelUp);
        return levelUp;

    }





}
