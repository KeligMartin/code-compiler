package fr.adventofcode.backend.account.domain;

import fr.adventofcode.backend.role.domain.Role;

import java.time.LocalDate;


public class Account {

    private String id;
    private String email;
    private String username;
    private String password;
    private LocalDate birthdate;
    private Role role;

    public  Account(String id, String email, String username, String password, LocalDate birthdate, Role role){
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.role = role;
    }

    public Account(String email, String username, String password,LocalDate birthdate,Role role){
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.role = role;

    }
    public  Account(String id){
        this.id = id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
