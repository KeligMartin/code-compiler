package fr.adventofcode.backend.quality.listeners.java;

import fr.adventofcode.backend.quality.listeners.CodeQualityListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LineLengthListener implements CodeQualityListener {

    public List<String> getTokensFromCode(String source) {
        final List<String> errors = new ArrayList<>();
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(source, "\n");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        for (String token: tokens) {
            if (token.length() >= 100) {
                errors.add(String.format("Line %d is too long !", tokens.indexOf(token)));
            }
        }
        return errors;
    }

    public List<String> getErrors(String source) {
        return Collections.unmodifiableList(getTokensFromCode(source));
    }
}
