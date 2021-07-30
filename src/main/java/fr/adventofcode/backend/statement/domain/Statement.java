package fr.adventofcode.backend.statement.domain;

import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.theme.domain.Theme;

import java.time.LocalDate;

public class Statement {

    private String idStatement;

    private String description;

    private Theme theme;

    private String title;

    private Level level;

    private LocalDate createdAt;




    public Statement(String idStatement, String description, Theme theme, String title, Level level, LocalDate createdAt) {
        this.idStatement = idStatement;
        this.description = description;
        this.theme = theme;
        this.title = title;
        this.level = level;
        this.createdAt = createdAt;
    }


    public Statement(String description, Theme theme, String title, Level level, LocalDate createdAt) {
        this.description = description;
        this.theme = theme;
        this.title = title;
        this.level = level;
        this.createdAt = createdAt;
    }
    public Statement(String idStatement){
        this.idStatement=idStatement;
    }

    public Statement(){

    }
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
