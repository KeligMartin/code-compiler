package fr.adventofcode.backend.quality.listeners.java;

import fr.adventofcode.backend.quality.antlr4.Java8BaseListener;
import fr.adventofcode.backend.quality.antlr4.Java8Lexer;
import fr.adventofcode.backend.quality.antlr4.Java8Parser;
import fr.adventofcode.backend.quality.listeners.CodeQualityListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MethodBodyListener extends Java8BaseListener implements CodeQualityListener {

    private final Set<String> errorsSet = new HashSet<>();

    @Override
    public void enterMethodBody(Java8Parser.MethodBodyContext bodyContext) {

        String methodName = bodyContext.getParent().getText();
        methodName = methodName.substring(0, methodName.indexOf(')') + 1);

        if(bodyContext.stop.getLine() - bodyContext.start.getLine() > 15) {
            errorsSet.add(String.format("Method %s is too long !", methodName));
        }
    }

    public List<String> getTokensFromCode(String source) {
        final List<String> errors = new ArrayList<>(errorsSet);
        Java8Lexer lexer = new Java8Lexer(CharStreams.fromString(source));
        Java8Parser parser = new Java8Parser(new CommonTokenStream(lexer));
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        parseTreeWalker.walk(this, tree);
        errorsSet.clear();
        return new ArrayList<>(errors);
    }

    public List<String> getErrors(String source) {
        return Collections.unmodifiableList(getTokensFromCode(source));
    }
}
