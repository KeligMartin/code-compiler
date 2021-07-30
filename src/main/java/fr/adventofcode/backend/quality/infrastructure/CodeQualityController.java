package fr.adventofcode.backend.quality.infrastructure;

import fr.adventofcode.backend.quality.application.AddCodeQuality;
import fr.adventofcode.backend.quality.application.FindCodeQualityById;
import fr.adventofcode.backend.quality.application.FindLastCodeQualityByUserResponseId;
import fr.adventofcode.backend.quality.domain.CodeQuality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping("/code-qualities")
public class CodeQualityController {

    private final AddCodeQuality addCodeQuality;
    private final FindCodeQualityById findCodeQualityById;
    private final FindLastCodeQualityByUserResponseId findLastCodeQualityByUserResponseId;

    @Autowired
    public CodeQualityController(AddCodeQuality addCodeQuality,
                                 FindCodeQualityById findCodeQualityById,
                                 FindLastCodeQualityByUserResponseId findLastCodeQualityByUserResponseId) {
        this.addCodeQuality = addCodeQuality;
        this.findCodeQualityById = findCodeQualityById;
        this.findLastCodeQualityByUserResponseId = findLastCodeQualityByUserResponseId;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CodeQuality codeQuality, HttpServletRequest request) {
        String codeQualityId = addCodeQuality.execute(codeQuality);
        URI uri = ServletUriComponentsBuilder.fromContextPath(request)
                .path("/code-qualities/{id}")
                .buildAndExpand(codeQualityId)
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CodeQuality> findById(@PathVariable String id) {
        return new ResponseEntity<>(findCodeQualityById.execute(id), HttpStatus.OK);
    }

    @GetMapping("/user-responses/{userResponseId}/last")
    public ResponseEntity<CodeQuality> findLastByUserResponseId(@PathVariable String userResponseId) {
        return new ResponseEntity<>(findLastCodeQualityByUserResponseId.execute(userResponseId), HttpStatus.OK);
    }
}
