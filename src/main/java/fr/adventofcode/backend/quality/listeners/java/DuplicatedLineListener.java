package fr.adventofcode.backend.quality.listeners.java;

import fr.adventofcode.backend.quality.listeners.CodeQualityListener;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DuplicatedLineListener implements CodeQualityListener {



    public List<String> getTokensFromCode(String source) {
        final List<String> errors = new ArrayList<>();
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(source, "\n");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        Set<String> duplicates = getDuplicatedLines(tokens);

        for (String line:
             duplicates) {
            errors.add(String.format("Duplicated line %d with statement \"%s\"" , tokens.indexOf(line), line));
        }
        return errors;
    }

    public Set<String> getDuplicatedLines(List<String> tokens) {

        Set<String> duplicates = new HashSet<>();
        return tokens.stream().filter(token -> !duplicates.add(token)).collect(Collectors.toSet());
    }

    public List<String> getErrors(String source) {
        return Collections.unmodifiableList(getTokensFromCode(source));
    }
}
