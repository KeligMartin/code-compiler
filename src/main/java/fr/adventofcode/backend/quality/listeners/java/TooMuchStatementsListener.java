package fr.adventofcode.backend.quality.listeners.java;

import fr.adventofcode.backend.quality.listeners.CodeQualityListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TooMuchStatementsListener implements CodeQualityListener {

    public List<String> getTokensFromCode(String source) {
        List<String> errors = new ArrayList<>();
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(source, "\n");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken().replace(" ", ""));
        }

        int countIf = (int) tokens.stream().filter(token -> token.startsWith("if(")).count();
        if(countIf >= 5) {
            errors.add("Too much if statements !");
        }

        int countWhile = (int) tokens.stream().filter(token -> token.startsWith("while(")).count();
        if(countWhile >= 3) {
            errors.add("Too much while statements !");
        }

        int countFor = (int) tokens.stream().filter(token -> token.startsWith("for(")).count();
        if(countFor >= 3) {
            errors.add("Too much for statements !");
        }
        return errors;
    }

    public List<String> getErrors(String source) {
        return Collections.unmodifiableList(getTokensFromCode(source));
    }

}
