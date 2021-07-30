package fr.adventofcode.backend.theme.application;

import fr.adventofcode.backend.theme.domain.Theme;
import fr.adventofcode.backend.theme.domain.ThemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllByYear {

    private  final ThemeDao themeDao;

    @Autowired
    public FindAllByYear(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    public List<Theme> execute(String year){
        return themeDao.findAllByYear(year);
    }
}
