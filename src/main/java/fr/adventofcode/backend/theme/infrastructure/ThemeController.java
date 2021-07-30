package fr.adventofcode.backend.theme.infrastructure;

import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.role.domain.ConstantsRole;
import fr.adventofcode.backend.theme.application.*;
import fr.adventofcode.backend.theme.application.dto.ThemeDto;
import fr.adventofcode.backend.theme.domain.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("themes")
public class ThemeController {

    private final FindAllYear findAllYear;
    private final FindAllByYear findAllByYear;
    private final AddTheme addTheme;
    private final UpdateTheme updateTheme;
    private final DeleteTheme deleteTheme;


    @Autowired
    public ThemeController(FindAllYear findAllYear, FindAllByYear findAllByYear, AddTheme addTheme, UpdateTheme updateTheme, DeleteTheme deleteTheme) {
        this.findAllYear = findAllYear;
        this.findAllByYear = findAllByYear;
        this.addTheme = addTheme;
        this.updateTheme = updateTheme;
        this.deleteTheme = deleteTheme;
    }

    @GetMapping("/years")
    @RolesAllowed({ConstantsRole.ADMIN,ConstantsRole.USER })
    public ResponseEntity findAllYear(){
        return new ResponseEntity(findAllYear.execute(), HttpStatus.OK);
    }

    @GetMapping("/years/{year}")
    @RolesAllowed({ConstantsRole.ADMIN ,ConstantsRole.USER})
    public ResponseEntity<List<Theme>> findAllThemByYear(@PathVariable String year){
        return ResponseEntity.ok(findAllByYear.execute(year));
    }

    @PostMapping
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity addTheme(@RequestBody @Valid ThemeDto theme, HttpServletRequest httpServletRequest){
        String themeId = addTheme.execute(theme);

        URI uri = ServletUriComponentsBuilder.fromContextPath(httpServletRequest)
                .path("/themes/{id}")
                .buildAndExpand(themeId)
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity<Level> updateTheme(@PathVariable String id, @RequestBody ThemeDto themeDto){
        updateTheme.execute(id, themeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity<Level> deleteTheme(@PathVariable String id){
        deleteTheme.execute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

