package fr.adventofcode.backend.level.application;

import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.level.domain.LevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateLevel {
    private final LevelDao levelDao;

    @Autowired
    public UpdateLevel(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    public void execute(String id, Level level){
        levelDao.updateLevel(id, level);
    }
}
