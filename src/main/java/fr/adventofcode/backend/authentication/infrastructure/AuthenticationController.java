package fr.adventofcode.backend.authentication.infrastructure;

import fr.adventofcode.backend.authentication.application.Login;
import fr.adventofcode.backend.authentication.application.Register;
import fr.adventofcode.backend.authentication.application.dto.LoginDTO;
import fr.adventofcode.backend.authentication.application.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final Register register;
    private final Login login;

    @Autowired
    public AuthenticationController(Register register, Login login) {
        this.register = register;
        this.login = login;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO registerDTO){
        URI uri = register.execute(registerDTO);
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        HttpHeaders httpHeaders = login.execute(loginDTO);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
