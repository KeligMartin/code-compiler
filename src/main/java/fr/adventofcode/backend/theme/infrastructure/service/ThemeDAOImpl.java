package fr.adventofcode.backend.theme.infrastructure.service;

import fr.adventofcode.backend.common.mapper.ThemeMapper;
import fr.adventofcode.backend.theme.domain.Theme;
import fr.adventofcode.backend.theme.domain.ThemeDao;
import fr.adventofcode.backend.theme.infrastructure.entity.ThemeEntity;
import fr.adventofcode.backend.theme.infrastructure.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ThemeDAOImpl implements ThemeDao {

    private final ThemeRepository themeRepository;
    private final ThemeMapper themeMapper;

    @Autowired
    public ThemeDAOImpl(ThemeRepository themeRepository, ThemeMapper themeMapper) {
        this.themeRepository = themeRepository;
        this.themeMapper = themeMapper;
    }

    @Override
    public List<Integer> findAllYear() {
        return themeRepository.findAllYear();
    }

    @Override
    public List<Theme> findAllByYear(String year) {
        return themeRepository.findAllByYear(year).stream()
                .map(themeMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public String save(Theme theme) {
        ThemeEntity themeEntity=themeMapper.toEntity(theme);
         themeRepository.save(themeEntity);
         return themeEntity.getIdTheme();
    }

    @Override
    public void delete(String idTheme) {
        this.themeRepository.deleteById(idTheme);
    }


}
