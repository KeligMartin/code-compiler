package fr.adventofcode.backend.theme.application.dto;

import java.time.LocalDate;

public class ThemeDto {
    private final String title;

    private final LocalDate dateAffected;

    public ThemeDto(String title, LocalDate dateAffected) {
        this.title = title;
        this.dateAffected = dateAffected;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDateAffected() {
        return dateAffected;
    }


}
