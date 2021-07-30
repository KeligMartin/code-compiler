package fr.adventofcode.backend.quality.listeners.python;

import fr.adventofcode.backend.quality.listeners.CodeQualityListener;
import fr.adventofcode.backend.quality.antlr4.Python3Lexer;
import fr.adventofcode.backend.quality.antlr4.Python3Parser;
import fr.adventofcode.backend.quality.antlr4.Python3ParserBaseListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FunctionNameListener extends Python3ParserBaseListener implements CodeQualityListener {

    private final Set<String> errorsSet = new HashSet<>();


    public void enterFuncdef(Python3Parser.FuncdefContext ctx) {
        String methodName = ctx.NAME().getText();
        if(methodName.matches("(.*[A-Z].*)")){
            errorsSet.add(String.format("Method %s must not contain uppercase character!", methodName));
        }
    }

    public List<String> getTokensFromCode(String source){
        final List<String> errors = new ArrayList<>(errorsSet);
        Python3Lexer lexer = new Python3Lexer(CharStreams.fromString(source));
        Python3Parser parser = new Python3Parser(new CommonTokenStream(lexer));
        ParseTree tree = parser.funcdef();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
        errorsSet.clear();
        return errors;
    }

    public List<String> getErrors(String source) {
        return Collections.unmodifiableList(getTokensFromCode(source));
    }
}
