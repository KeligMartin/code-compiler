package fr.adventofcode.backend.quality.listeners.python;

import fr.adventofcode.backend.quality.listeners.CodeQualityListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

@Component
public class FunctionLengthListener implements CodeQualityListener {

    @Override
    public List<String> getTokensFromCode(String source) {
        final List<String> errors = new ArrayList<>();
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(source, "\n");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        if (tokens.size() > 15) {
            errors.add("Your function is too long !");
        }
        return errors;
    }

    @Override
    public List<String> getErrors(String source) {
        return Collections.unmodifiableList(getTokensFromCode(source));
    }
}
