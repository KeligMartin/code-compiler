package fr.adventofcode.backend.statement.application;

import fr.adventofcode.backend.level.domain.Level;
import fr.adventofcode.backend.statement.application.dto.StatementDto;
import fr.adventofcode.backend.statement.domain.Statement;
import fr.adventofcode.backend.statement.domain.StatementDAO;
import fr.adventofcode.backend.theme.domain.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddStatement {

    private final StatementDAO statementDAO;

    @Autowired
    public AddStatement(StatementDAO statementDAO) {
        this.statementDAO = statementDAO;
    }

    public String execute(StatementDto statementDto) {
        Statement statement = new Statement(statementDto.getDescription(), new Theme(statementDto.getIdTheme()),statementDto.getTitle(),new Level(statementDto.getIdLevel()), statementDto.getCreatedAt());
        return this.statementDAO.save(statement);
    }
}
