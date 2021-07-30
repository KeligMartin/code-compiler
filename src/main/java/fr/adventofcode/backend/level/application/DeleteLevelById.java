package fr.adventofcode.backend.level.application;

import fr.adventofcode.backend.level.domain.LevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteLevelById {

    private final LevelDao levelDao;

    @Autowired
    public DeleteLevelById(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    public void execute(String id){
        levelDao.deleteById(id);

    }
}
