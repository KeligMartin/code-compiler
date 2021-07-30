package fr.adventofcode.backend.statement.application.dto;

import java.time.LocalDate;


public class StatementDto {

    private final String description;

    private final String idTheme;

    private final String title;

    private final String idLevel;

    private final LocalDate createdAt;


    public StatementDto(String description, String idTheme , String title, String idLevel, LocalDate createdAt) {
        this.description = description;
        this.idTheme = idTheme;
        this.title = title;
        this.idLevel = idLevel;
        this.createdAt = createdAt;
    }
    public String getIdLevel() {
        return idLevel;
    }

    public String getDescription() {
        return description;
    }

    public String getIdTheme() {
        return idTheme;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
