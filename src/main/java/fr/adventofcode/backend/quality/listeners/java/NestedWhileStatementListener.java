package fr.adventofcode.backend.quality.listeners.java;

import fr.adventofcode.backend.quality.antlr4.Java8BaseListener;
import fr.adventofcode.backend.quality.antlr4.Java8Lexer;
import fr.adventofcode.backend.quality.antlr4.Java8Parser;
import fr.adventofcode.backend.quality.listeners.CodeQualityListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.pattern.ParseTreeMatch;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class NestedWhileStatementListener extends Java8BaseListener implements CodeQualityListener {



    public List<String> getTokensFromCode(String source) {
        List<String> errors = new ArrayList<>();
        Java8Lexer lexer = new Java8Lexer(CharStreams.fromString(source));
        Java8Parser parser = new Java8Parser(new CommonTokenStream(lexer));
        ParseTree tree = parser.compilationUnit();
        ParseTreePattern p = parser.compileParseTreePattern("<whileStatement>", Java8Parser.RULE_whileStatement);
        List<ParseTreeMatch> matches = p.findAll(tree, "//whileStatement");
        for (ParseTreeMatch match : matches) {
            String statement = match.get("whileStatement").getText();
            String findStatement = "while(";
            int lastIndex = 0;
            int count = 0;
            while(lastIndex != -1){
                lastIndex = statement.indexOf(findStatement,lastIndex);
                if(lastIndex != -1){
                    count ++;
                    lastIndex += findStatement.length();
                }
            }
            if(count == 2){
                errors.add("Nested while statement !");
                break;
            }
        }
        return errors;
    }

    public List<String> getErrors(String source) {
        return Collections.unmodifiableList(getTokensFromCode(source));
    }
}
