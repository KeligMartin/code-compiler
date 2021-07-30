package fr.adventofcode.backend.theme.domain;

import java.util.List;

public interface ThemeDao {

    List<Integer> findAllYear();

    List<Theme> findAllByYear(String year);

    String save(Theme theme);

    void delete(String idTheme);

}
