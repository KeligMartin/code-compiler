package fr.adventofcode.backend.compiler.infrastructure;

import fr.adventofcode.backend.compiler.application.dto.CompileDTO;
import fr.adventofcode.backend.compiler.application.dto.CompileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/compile")
public class CompileController {

  private final fr.adventofcode.backend.compiler.application.Compile compile;

  @Autowired
  public CompileController(
      fr.adventofcode.backend.compiler.application.Compile compile) {
    this.compile = compile;

  }

  @PostMapping
  public ResponseEntity<CompileResponse> compile(
      @RequestBody CompileDTO compileDTO, @RequestAttribute("accountId") String accountId)
      throws IOException, InterruptedException {
    return new ResponseEntity<>(this.compile.execute(accountId, compileDTO), HttpStatus.OK);
  }
}
