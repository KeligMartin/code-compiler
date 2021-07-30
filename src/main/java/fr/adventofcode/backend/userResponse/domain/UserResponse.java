package fr.adventofcode.backend.userResponse.domain;

import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.statement.domain.Statement;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class UserResponse
{

    private String idUserResponse;
    private String code ;
    private Boolean resolved;
    private LocalDateTime resolvedDate;
    private Statement statement;
    private Account account;
    private Language language;

    public UserResponse(String idUserResponse, String code, Boolean resolved, LocalDateTime resolvedDate, Statement statement, Account account, Language language){
        this.idUserResponse = idUserResponse;
        this.code = code;
        this.resolved = resolved;
        this.resolvedDate = resolvedDate;

        this.statement = statement;
        this.account = account;
        this.language = language;
    }

    public UserResponse(String code, Boolean resolved, LocalDateTime resolvedDate, Statement statement, Account account, Language language){
        this.code = code;
        this.resolved = resolved;
        this.resolvedDate = resolvedDate;

        this.statement = statement;
        this.account = account;
        this.language = language;
    }

    public UserResponse(){

    }

    public String getIdUserResponse() {
        return idUserResponse;
    }

    public void setIdUserResponse(String idUserResponse) {
        this.idUserResponse = idUserResponse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(LocalDateTime resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}
