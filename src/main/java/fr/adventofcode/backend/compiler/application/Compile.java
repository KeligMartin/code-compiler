package fr.adventofcode.backend.compiler.application;

import fr.adventofcode.backend.compiler.application.dto.CompileDTO;
import fr.adventofcode.backend.compiler.application.dto.CompileResponse;
import fr.adventofcode.backend.compiler.infrastructure.service.CompileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Compile  {
    private final CompileService compileService;

    @Autowired
    public Compile(CompileService compileService) {
        this.compileService = compileService;
    }


    public CompileResponse execute(String idAccount, CompileDTO compileDTO) throws IOException, InterruptedException {
        fr.adventofcode.backend.compiler.domain.Compile compile = new fr.adventofcode.backend.compiler.domain.Compile(compileDTO.getLanguage(),compileDTO.getCode(),compileDTO.getIdStatement(),compileDTO.getIdTestCase());
        return compileService.compile(compile,idAccount);
    }

}
