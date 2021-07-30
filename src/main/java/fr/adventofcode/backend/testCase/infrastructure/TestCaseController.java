package fr.adventofcode.backend.testCase.infrastructure;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.role.domain.ConstantsRole;
import fr.adventofcode.backend.testCase.application.*;
import fr.adventofcode.backend.testCase.application.dto.CodeSkeletonDTO;
import fr.adventofcode.backend.testCase.application.dto.FindTestsCasesDTO;
import fr.adventofcode.backend.testCase.domain.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/testCase")
public class TestCaseController {

  private final FindTestsCasesByIdStatement findByIdStatement;

  private final FindTestsCases findTestsCases;

  private final AddTestCase addTestCase;

  private final FindTestCaseByIdTestCase findTestCaseByIdTestCase;

  private final UpdateTestCase updateTestCase;

  private final DeleteTestCase deleteTestCase;

  private final DeleteTestCaseByStatementAndLanguage deleteTestCaseByStatementAndLanguage;

  @Autowired
  public TestCaseController(
          FindTestsCasesByIdStatement findByIdStatement,
          FindTestsCases findTestsCases,
          AddTestCase addTestCase,
          FindTestCaseByIdTestCase findTestCaseByIdTestCase, UpdateTestCase updateTestCase, DeleteTestCase deleteTestCase, DeleteTestCaseByStatementAndLanguage deleteTestCaseByStatementAndLanguage) {
    this.findByIdStatement = findByIdStatement;
    this.findTestsCases = findTestsCases;
    this.addTestCase = addTestCase;

    this.findTestCaseByIdTestCase = findTestCaseByIdTestCase;
    this.updateTestCase = updateTestCase;
    this.deleteTestCase = deleteTestCase;
    this.deleteTestCaseByStatementAndLanguage = deleteTestCaseByStatementAndLanguage;
  }


  @GetMapping("/statements/{idStatement}")
  public ResponseEntity<List<TestCase>> findByIdStatement(@PathVariable String idStatement) {
    return ResponseEntity.ok(findByIdStatement.execute(idStatement));
  }

  @PostMapping("testsCases")
  public ResponseEntity<List<TestCase>> findByIdStatementAndLanguage(
          @RequestBody FindTestsCasesDTO findTestsCasesDTO) {
    return ResponseEntity.ok(findTestsCases.execute(findTestsCasesDTO.getIdStatement(), findTestsCasesDTO.getLanguage()));
  }

  @GetMapping("/{idTestCase}")
  public ResponseEntity<TestCase> findByIdStatementAndLanguage(
         @PathVariable String idTestCase) {
    return ResponseEntity.ok(findTestCaseByIdTestCase.execute(idTestCase));
  }

  @DeleteMapping("/{idTestCase}")
  @RolesAllowed({ConstantsRole.ADMIN})
  public ResponseEntity deleteTestCase(
          @PathVariable String idTestCase) {
    deleteTestCase.execute(idTestCase);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/statement/{idStatement}/language/{language}")
  @RolesAllowed({ConstantsRole.ADMIN})
  public ResponseEntity deleteTestsCasesByStatement(
          @PathVariable String idStatement,@PathVariable Language language) {
    deleteTestCaseByStatementAndLanguage.execute(idStatement,language);
    return ResponseEntity.ok().build();
  }


  @PutMapping("/{idTestCase}")
  @RolesAllowed({ConstantsRole.ADMIN})
  public ResponseEntity updateTestCase(
         @PathVariable String idTestCase, @RequestBody @Valid CodeSkeletonDTO codeSkeletonDTO) {
    updateTestCase.execute(idTestCase,codeSkeletonDTO);
    return ResponseEntity.ok().build();
  }


  @PostMapping
  @RolesAllowed({ConstantsRole.ADMIN})
  public ResponseEntity addTestCase(
      @RequestBody @Valid CodeSkeletonDTO codeSkeletonDTO, HttpServletRequest httpServletRequest) {
    String testCaseId = addTestCase.execute(codeSkeletonDTO);

    URI uri =
        ServletUriComponentsBuilder.fromContextPath(httpServletRequest)
            .path("/testCase/{id}")
            .buildAndExpand(testCaseId)
            .toUri();

    return ResponseEntity.created(uri).build();
  }

}
