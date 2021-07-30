package fr.adventofcode.backend.theme.application;

import fr.adventofcode.backend.theme.domain.ThemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllYear {

    private final ThemeDao themeDao;

    @Autowired
    public FindAllYear(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    public List<Integer> execute(){
        return themeDao.findAllYear();
    }

}
