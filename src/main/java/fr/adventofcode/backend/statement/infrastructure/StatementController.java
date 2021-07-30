package fr.adventofcode.backend.statement.infrastructure;

import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.role.domain.ConstantsRole;
import fr.adventofcode.backend.statement.application.*;
import fr.adventofcode.backend.statement.application.dto.StatementDto;
import fr.adventofcode.backend.statement.domain.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/statements")
public class StatementController {

    private final FindByIdStatement findByIdStatement;
    private final AddStatement addStatement;
    private final FindStatementByIdTheme findStatementByIdTheme;
    private final UpdateStatement updateStatement;
    private final DeleteStatementById deleteStatementById;


    @Autowired
    public StatementController(FindByIdStatement findByIdStatement, AddStatement addStatement, FindStatementByIdTheme findStatementByIdTheme, UpdateStatement updateStatement, DeleteStatementById deleteStatementById) {
        this.findByIdStatement = findByIdStatement;
        this.addStatement = addStatement;
        this.findStatementByIdTheme = findStatementByIdTheme;
        this.updateStatement = updateStatement;
        this.deleteStatementById = deleteStatementById;
    }

    @GetMapping("/themes/{idTheme}")
    public ResponseEntity<List<Statement>> findStatementByTheme(@PathVariable String idTheme){
        return ResponseEntity.ok(findStatementByIdTheme.execute(idTheme));
    }


    @GetMapping("/{idStatement}")
    public ResponseEntity<Statement> findOneByIdStatement(@PathVariable String idStatement){
        return ResponseEntity.ok(findByIdStatement.execute(idStatement));
    }

    @PostMapping
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity<List<Account>> addStatement(@RequestBody StatementDto statement, HttpServletRequest httpServletRequest){
        String levelId = addStatement.execute(statement);

        URI uri = ServletUriComponentsBuilder.fromContextPath(httpServletRequest)
                .path("/statements/{id}")
                .buildAndExpand(levelId)
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idStatement}")
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity updateStatement(@PathVariable String idStatement,@RequestBody StatementDto statementDto, HttpServletRequest httpServletRequest){
        updateStatement.execute(idStatement,statementDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{idStatement}")
    @RolesAllowed({ConstantsRole.ADMIN})
    public ResponseEntity deleteStatement(@PathVariable String idStatement){
        deleteStatementById.execute(idStatement);
        return ResponseEntity.ok().build();
    }
}
