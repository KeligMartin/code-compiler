package fr.adventofcode.backend.level.application;

import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.level.domain.LevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindLevelById {
    private final LevelDao levelDao;

    @Autowired
    public FindLevelById(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    public Level execute(String id){
        return levelDao.findById(id)
                .orElseThrow(() -> new ResourceWithIdNotFoundException("level", id));
    }
}
