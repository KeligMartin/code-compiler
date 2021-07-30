package fr.adventofcode.backend.authentication.application.dto;

import fr.adventofcode.backend.common.annotation.StrongPassword;
import fr.adventofcode.backend.role.domain.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class RegisterDTO {

    @Email
    private final String email;

    @Size(min = 6, max = 25)
    private final String username;

    @StrongPassword
    private final String password;

    private  final LocalDate birthDate;

    private final Role role;

    public RegisterDTO(String email, String username, String password, LocalDate birthDate, Role role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Role getRole() {
        return role;
    }
}
