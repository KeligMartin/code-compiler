package fr.adventofcode.backend.quality;

import fr.adventofcode.backend.quality.listeners.java.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Primary
public class JavaCodeQualityService implements ICodeQualityService {

    private final DuplicatedLineListener duplicatedLineListener;
    private final LineLengthListener lineLengthListener;
    private final MethodBodyListener methodBodyListener;
    private final NestedIfStatementListener nestedIfStatementListener;
    private final NestedWhileStatementListener nestedWhileStatementListener;
    private final StatementRedundancyListener statementRedundancyListener;
    private final TooMuchStatementsListener tooMuchStatementsListener;

    @Autowired
    public JavaCodeQualityService(DuplicatedLineListener duplicatedLineListener,
                                  LineLengthListener lineLengthListener,
                                  MethodBodyListener methodBodyListener,
                                  NestedIfStatementListener nestedIfStatementListener,
                                  NestedWhileStatementListener nestedWhileStatementListener,
                                  StatementRedundancyListener statementRedundancyListener,
                                  TooMuchStatementsListener tooMuchStatementsListener) {
        this.duplicatedLineListener = duplicatedLineListener;
        this.lineLengthListener = lineLengthListener;
        this.methodBodyListener = methodBodyListener;
        this.nestedIfStatementListener = nestedIfStatementListener;
        this.nestedWhileStatementListener = nestedWhileStatementListener;
        this.statementRedundancyListener = statementRedundancyListener;
        this.tooMuchStatementsListener = tooMuchStatementsListener;
    }

    public List<String> execute(String code){
        return Stream.of(
                duplicatedLineListener.getErrors(code),
                lineLengthListener.getErrors(code),
                methodBodyListener.getErrors(code),
                nestedIfStatementListener.getErrors(code),
                nestedWhileStatementListener.getErrors(code),
                statementRedundancyListener.getErrors(code),
                tooMuchStatementsListener.getErrors(code))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
