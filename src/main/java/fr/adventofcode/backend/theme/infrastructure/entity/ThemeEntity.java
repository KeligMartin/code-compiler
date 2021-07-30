package fr.adventofcode.backend.theme.infrastructure.entity;

import fr.adventofcode.backend.statement.infrastructure.entity.StatementEntity;
import fr.adventofcode.backend.testCase.infrastructure.entity.TestCaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "theme")
public class ThemeEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String idTheme;

    private String title;

    private LocalDate dateAffected;

    @OneToMany(
            mappedBy = "themeEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<StatementEntity>  statementEntities = new ArrayList<>();

    public ThemeEntity(String idTheme, String title, LocalDate dateAffected) {
        this.idTheme = idTheme;
        this.title = title;
        this.dateAffected = dateAffected;
    }

    public ThemeEntity(){

    }




    public String getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(String idTheme) {
        this.idTheme = idTheme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titre) {
        this.title = titre;
    }

    public LocalDate getDateAffected() {
        return dateAffected;
    }

    public void setDateAffected(LocalDate dateAffected) {
        this.dateAffected = dateAffected;
    }

    public List<StatementEntity> getStatementEntities() {
        return statementEntities;
    }

    public void setStatementEntities(List<StatementEntity> statementEntities) {
        this.statementEntities = statementEntities;
    }
}
