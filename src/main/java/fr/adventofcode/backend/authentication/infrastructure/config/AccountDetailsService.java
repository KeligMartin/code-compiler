package fr.adventofcode.backend.authentication.infrastructure.config;

import fr.adventofcode.backend.account.application.FindAccountByUsername;
import fr.adventofcode.backend.account.domain.Account;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AccountDetailsService implements UserDetailsService {

    private final FindAccountByUsername findAccountByUsername;

    public AccountDetailsService(FindAccountByUsername findAccountByUsername) {
        this.findAccountByUsername = findAccountByUsername;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = findAccountByUsername.execute(username);

        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole().name())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }


}


