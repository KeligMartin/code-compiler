package fr.adventofcode.backend.theme.application;

import fr.adventofcode.backend.theme.application.dto.ThemeDto;
import fr.adventofcode.backend.theme.domain.Theme;
import fr.adventofcode.backend.theme.domain.ThemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTheme {

    private final ThemeDao themeDao;

    @Autowired
    public UpdateTheme(ThemeDao themeDao){

        this.themeDao = themeDao;
    }
    public void execute(String id, ThemeDto themeDto){
        Theme theme=new Theme(id,themeDto.getTitle(),themeDto.getDateAffected());
        themeDao.save( theme);
    }

}
