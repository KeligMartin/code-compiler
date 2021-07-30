package fr.adventofcode.backend.level.application;

import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.level.domain.LevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllLevels {
    private final LevelDao levelDao;

    @Autowired
    public FindAllLevels(LevelDao levelDao){
        this.levelDao = levelDao;
    }

    public List<Level> execute(){ return levelDao.findAll(); }

}
