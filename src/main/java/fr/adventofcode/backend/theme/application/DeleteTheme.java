package fr.adventofcode.backend.theme.application;

import fr.adventofcode.backend.theme.domain.ThemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteTheme {
    private final ThemeDao themeDao;

    @Autowired
    public DeleteTheme(ThemeDao themeDao){
        this.themeDao = themeDao;
    }
    public void execute(String id){
        themeDao.delete(id);
    }
}
