package fr.adventofcode.backend.statement.application;

import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import fr.adventofcode.backend.statement.domain.Statement;
import fr.adventofcode.backend.statement.domain.StatementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByIdStatement {

    private final StatementDAO statementDAO;

    @Autowired
    public FindByIdStatement(StatementDAO statementDAO) {
        this.statementDAO = statementDAO;
    }

    public Statement execute(String idStatement){
        return this.statementDAO.findByIdStatement(idStatement).orElseThrow(()-> new ResourceWithIdNotFoundException("statement", idStatement));
    }
}
