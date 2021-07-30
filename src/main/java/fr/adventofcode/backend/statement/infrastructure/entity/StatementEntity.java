package fr.adventofcode.backend.statement.infrastructure.entity;

import fr.adventofcode.backend.level.infrastructure.entity.LevelEntity;

import fr.adventofcode.backend.placeholderFunction.infrastructure.entity.PlaceholderFunctionEntity;

import fr.adventofcode.backend.testCase.infrastructure.entity.TestCaseEntity;
import fr.adventofcode.backend.theme.infrastructure.entity.ThemeEntity;
import fr.adventofcode.backend.userResponse.infrastructure.entity.UserResponseEntity;
import org.aspectj.weaver.ast.Test;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "statement")
public class StatementEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String idStatement;

    @Column(length=10485760)
    private String description;

    private String title;

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name="idTheme", nullable=false)
    private ThemeEntity themeEntity;

    @ManyToOne
    @JoinColumn(name="level", nullable=false)
    private LevelEntity level;

    @OneToMany(
            mappedBy = "statement",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<TestCaseEntity> testsCases = new ArrayList<>();

    @OneToMany(
            mappedBy = "statement",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<UserResponseEntity> userResponseEntities = new ArrayList<>();


    @OneToMany(
            mappedBy = "statement",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<PlaceholderFunctionEntity> placeholderFunction = new ArrayList<>();

    public StatementEntity(String idStatement, String description, String title, LocalDate createdAt, ThemeEntity themeEntity, LevelEntity level) {
        this.idStatement = idStatement;
        this.description = description;
        this.title = title;
        this.createdAt = createdAt;
        this.themeEntity = themeEntity;
        this.level = level;
    }

    public StatementEntity(String idStatement) {
        this.idStatement = idStatement;
    }



    public StatementEntity(){

    }



    public LevelEntity getLevel() {
        return level;
    }

    public void setLevel(LevelEntity levelEntity) {
        this.level = levelEntity;
    }

    public ThemeEntity getThemeEntity() {
        return themeEntity;
    }

    public void setThemeEntity(ThemeEntity themeEntity) {
        this.themeEntity = themeEntity;
    }


    public String getIdStatement() {
        return idStatement;
    }

    public void setIdStatement(String idStatement) {
        this.idStatement = idStatement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String outputFileUrl) {
        this.title = outputFileUrl;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    public List<TestCaseEntity> getTestsCases() {
        return testsCases;
    }

    public void setTestsCases(List<TestCaseEntity> testsCases) {
        this.testsCases = testsCases;
    }

    public List<PlaceholderFunctionEntity> getPlaceholderFunction() {
        return placeholderFunction;
    }

    public void setPlaceholderFunction(List<PlaceholderFunctionEntity> placeholderFunction) {
        this.placeholderFunction = placeholderFunction;
    }

    public List<UserResponseEntity> getUserResponseEntities() {
        return userResponseEntities;
    }

    public void setUserResponseEntities(List<UserResponseEntity> userResponseEntities) {
        this.userResponseEntities = userResponseEntities;
    }
}
