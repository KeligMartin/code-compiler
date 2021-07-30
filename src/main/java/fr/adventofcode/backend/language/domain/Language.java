package fr.adventofcode.backend.language.domain;

public enum Language {
    C("C"),
    JAVA ("JAVA"),
    PYTHON("PYTHON");

    private final String name;

    Language(String s) {
        name = s;
    }
}
