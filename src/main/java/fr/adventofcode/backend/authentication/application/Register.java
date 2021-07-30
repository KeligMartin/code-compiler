package fr.adventofcode.backend.authentication.application;


import fr.adventofcode.backend.account.application.AddAccount;
import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.authentication.application.dto.RegisterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class Register {

    private final AddAccount addAccount;

    @Autowired
    public Register(AddAccount addAccount) {
        this.addAccount = addAccount;
    }

    public URI execute(RegisterDTO registerDTO) {
        Account account = new Account(registerDTO.getEmail(), registerDTO.getUsername(), registerDTO.getPassword(),registerDTO.getBirthDate(), registerDTO.getRole());
        String id = addAccount.execute(account);
        return ServletUriComponentsBuilder.fromPath("/api/users").path("/{id}").buildAndExpand(id).toUri();
    }
}
