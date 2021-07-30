package fr.adventofcode.backend.theme.application;

import fr.adventofcode.backend.theme.application.dto.ThemeDto;
import fr.adventofcode.backend.theme.domain.Theme;
import fr.adventofcode.backend.theme.domain.ThemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddTheme {

    private  final ThemeDao themeDao;

    @Autowired
    public AddTheme(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    //TODO convert to request
    public String execute(ThemeDto themeDto){
        Theme theme=new Theme(themeDto.getTitle(),themeDto.getDateAffected());
        return themeDao.save(theme);
    }
}
