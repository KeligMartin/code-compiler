package fr.adventofcode.backend.common.mapper;

import fr.adventofcode.backend.theme.domain.Theme;
import fr.adventofcode.backend.theme.infrastructure.entity.ThemeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeMapper implements ObjectMapper<Theme, ThemeEntity> {

    @Autowired
    public ThemeMapper() {

    }

    @Override
    public  Theme toDomain(ThemeEntity themeEntity) {
        return new Theme(themeEntity.getIdTheme(), themeEntity.getTitle(), themeEntity.getDateAffected());
    }

    @Override
    public ThemeEntity toEntity(Theme theme) {
        return new ThemeEntity(theme.getIdTheme(), theme.getTitle(), theme.getDateAffected());
    }
}
