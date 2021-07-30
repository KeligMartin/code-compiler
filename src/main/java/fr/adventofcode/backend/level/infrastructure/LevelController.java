package fr.adventofcode.backend.level.infrastructure;

import fr.adventofcode.backend.level.application.*;
import fr.adventofcode.backend.level.application.dto.LevelDTO;
import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.role.domain.ConstantsRole;
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
@RequestMapping("/levels")
public class LevelController {

    private final FindAllLevels findAllLevels;
    private final FindLevelById findLevelById;
    private final DeleteLevelById deleteLevelById;
    private final UpdateLevel updateLevel;
    private  final AddLevel addLevel;

    @Autowired
    public LevelController(FindAllLevels findAllLevels,
                           FindLevelById findLevelById,
                           DeleteLevelById deleteLevelById, UpdateLevel updateLevel, AddLevel addLevel) {
        this.findAllLevels = findAllLevels;
        this.findLevelById = findLevelById;
        this.deleteLevelById = deleteLevelById;
        this.updateLevel = updateLevel;
        this.addLevel = addLevel;
    }


    @PostMapping
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity<?> addLevel(@RequestBody @Valid LevelDTO levelDto, HttpServletRequest request)  {
            String levelId = addLevel.execute(levelDto);

            URI uri = ServletUriComponentsBuilder.fromContextPath(request)
                    .path("/levels/{id}")
                    .buildAndExpand(levelId)
                    .toUri();

            return ResponseEntity.created(uri).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Level> findLevelById(@PathVariable String id){
        return new ResponseEntity<>(findLevelById.execute(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Level>> findAllLevels(){
        return new ResponseEntity<>(findAllLevels.execute(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity<?> deleteLevelById(@PathVariable String id){
        deleteLevelById.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity<Level> updateLevel(@PathVariable String id,@RequestBody Level level){
        updateLevel.execute(id, level);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
