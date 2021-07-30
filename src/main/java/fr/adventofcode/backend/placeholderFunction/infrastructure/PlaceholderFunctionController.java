package fr.adventofcode.backend.placeholderFunction.infrastructure;

import fr.adventofcode.backend.placeholderFunction.application.*;
import fr.adventofcode.backend.placeholderFunction.application.dto.FindPlaceholderFunctionDTO;
import fr.adventofcode.backend.placeholderFunction.application.dto.PlaceholderFunctionDTO;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunction;
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
@RequestMapping("placeholderFunction")
public class PlaceholderFunctionController {

    private final AddPlaceholderFunction addPlaceholderFunction;

    private final FindPlaceholderFunction findPlaceholderFunction;

    private final UpdatePlaceholderFunction updatePlaceholderFunction;

    private final DeletePlaceholderFunctionById deletePlaceholderFunctionById;

    private final FindPlaceholderFunctionByIdStatement findPlaceholderFunctionByIdStatement;

    @Autowired
    public PlaceholderFunctionController(AddPlaceholderFunction addPlaceholderFunction, FindPlaceholderFunction findPlaceholderFunction, UpdatePlaceholderFunction updatePlaceholderFunction, DeletePlaceholderFunctionById deletePlaceholderFunctionById, FindPlaceholderFunctionByIdStatement findPlaceholderFunctionByIdStatement) {
        this.addPlaceholderFunction = addPlaceholderFunction;
        this.findPlaceholderFunction = findPlaceholderFunction;
        this.updatePlaceholderFunction = updatePlaceholderFunction;
        this.deletePlaceholderFunctionById = deletePlaceholderFunctionById;
        this.findPlaceholderFunctionByIdStatement = findPlaceholderFunctionByIdStatement;
    }

    @PostMapping("statement/language")
    public ResponseEntity<PlaceholderFunction> findPlaceholderFunction(@RequestBody FindPlaceholderFunctionDTO findPlaceholderFunctionDTO) {
        return new ResponseEntity<>(findPlaceholderFunction.execute(findPlaceholderFunctionDTO), HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity addPlaceholderFunction(
            @RequestBody @Valid PlaceholderFunctionDTO placeholderFunctionDTO, HttpServletRequest httpServletRequest) {
        String placeholderFunctionId = addPlaceholderFunction.execute(placeholderFunctionDTO);

        URI uri =
                ServletUriComponentsBuilder.fromContextPath(httpServletRequest)
                        .path("/placeholderFunction/{id}")
                        .buildAndExpand(placeholderFunctionId)
                        .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idPlaceholder}")
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity updatePlaceholderFunction(@PathVariable String idPlaceholder,
            @RequestBody @Valid PlaceholderFunctionDTO placeholderFunctionDTO) {
        updatePlaceholderFunction.execute(idPlaceholder,placeholderFunctionDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idPlaceholderFunction}")
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity deleteTestCase(
            @PathVariable String idPlaceholderFunction) {
        deletePlaceholderFunctionById.execute(idPlaceholderFunction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/statement/{idStatement}")
    public ResponseEntity<List<PlaceholderFunction>> findPlaceholderFunctionByIdStatement(@PathVariable String idStatement){
        return ResponseEntity.ok(findPlaceholderFunctionByIdStatement.execute(idStatement));
    }



}
