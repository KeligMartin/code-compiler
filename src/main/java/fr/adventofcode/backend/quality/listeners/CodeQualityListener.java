package fr.adventofcode.backend.quality.listeners;

import java.util.List;

public interface CodeQualityListener {
    List<String> getTokensFromCode(String source);

    List<String> getErrors(String source);
}
