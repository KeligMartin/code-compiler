package fr.adventofcode.backend.statement.application;

import fr.adventofcode.backend.statement.domain.StatementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStatementById {
    private final StatementDAO statementDAO;

    @Autowired
    public DeleteStatementById(StatementDAO statementDAO) {
        this.statementDAO = statementDAO;
    }

    public void execute(String idStatement) {
         this.statementDAO.deleteById(idStatement);
    }
}
