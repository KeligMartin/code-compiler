package fr.adventofcode.backend.level.application;

import fr.adventofcode.backend.level.application.dto.LevelDTO;
import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.level.domain.LevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddLevel {
    private final LevelDao levelDao;

    @Autowired
    public AddLevel(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    public String execute(LevelDTO levelDTO){
        Level level = new Level(levelDTO.getName(), levelDTO.getCreatedAt(), levelDTO.getGain());
        return levelDao.save(level);
    }

}
