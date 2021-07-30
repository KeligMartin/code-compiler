package fr.adventofcode.backend.statement.application;

import fr.adventofcode.backend.statement.domain.Statement;
import fr.adventofcode.backend.statement.domain.StatementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindStatementByIdTheme {

    private final StatementDAO statementDAO;

    @Autowired
    public FindStatementByIdTheme(StatementDAO statementDAO) {
        this.statementDAO = statementDAO;
    }

    public List<Statement> execute(String idTheme){
        return statementDAO.findByThemeEntity_IdTheme(idTheme);
    }
}
