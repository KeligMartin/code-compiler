package fr.adventofcode.backend.theme.domain;

import java.time.LocalDate;

public class Theme {
    private String idTheme;

    private String title;

    private LocalDate dateAffected;

    public Theme(String idTheme, String title, LocalDate dateAffected) {
        this.idTheme = idTheme;
        this.title = title;
        this.dateAffected = dateAffected;
    }

    public Theme(String title, LocalDate dateAffected){
        this.title=title;
        this.dateAffected=dateAffected;
    }

    public Theme(String idTheme){
        this.idTheme = idTheme;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateAffected() {
        return dateAffected;
    }

    public void setDateAffected(LocalDate dateAffected) {
        this.dateAffected = dateAffected;
    }

}
