package fr.adventofcode.backend.authentication.application;

import fr.adventofcode.backend.account.application.FindAccountByUsername;
import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.authentication.application.dto.LoginDTO;
import fr.adventofcode.backend.authentication.infrastructure.config.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class Login {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final FindAccountByUsername findAccountByUsername;

    public Login(TokenProvider tokenProvider,
                 AuthenticationManagerBuilder authenticationManagerBuilder,
                 FindAccountByUsername findAccountByUsername) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.findAccountByUsername = findAccountByUsername;
    }

    public HttpHeaders execute(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

        Account account = findAccountByUsername.execute(loginDTO.getUsername());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        String token = tokenProvider.createToken(authentication, account.getId());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Expose-Headers", "Authorization");
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return httpHeaders;
    }
}
