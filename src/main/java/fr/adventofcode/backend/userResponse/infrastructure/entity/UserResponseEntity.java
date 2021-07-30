package fr.adventofcode.backend.userResponse.infrastructure.entity;

import fr.adventofcode.backend.account.infrastructure.entity.AccountEntity;
import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.statement.infrastructure.entity.StatementEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "userResponse")
public class UserResponseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String idUserResponse;

    @Column(length=10485760)
    private String code ;

    private Boolean resolved;

    private LocalDateTime resolvedDate;

    @ManyToOne
    @JoinColumn(name="idStatement", nullable=false)
    private StatementEntity statement;

    @ManyToOne
    @JoinColumn(name="idAccount", nullable=false)
    private AccountEntity account;

    @Enumerated(EnumType.STRING)
    private Language language;


    public UserResponseEntity(String idUserResponse, String code, Boolean resolved, LocalDateTime resolvedDate, StatementEntity statement, AccountEntity account, Language language) {
        this.idUserResponse = idUserResponse;
        this.code = code;
        this.resolved = resolved;
        this.resolvedDate = resolvedDate;
        this.statement = statement;
        this.account = account;
        this.language = language;
    }

    public UserResponseEntity() {

    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity accountEntity) {
        this.account = accountEntity;
    }


    public StatementEntity getStatement() {
        return statement;
    }

    public void setStatement(StatementEntity statementEntity) {
        this.statement = statementEntity;
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

}
