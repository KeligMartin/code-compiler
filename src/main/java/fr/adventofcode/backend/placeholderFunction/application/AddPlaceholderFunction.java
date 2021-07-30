package fr.adventofcode.backend.placeholderFunction.application;

import fr.adventofcode.backend.placeholderFunction.application.dto.PlaceholderFunctionDTO;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunction;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunctionDAO;
import fr.adventofcode.backend.statement.domain.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPlaceholderFunction {

    private final PlaceholderFunctionDAO placeholderFunctionDAO;

    @Autowired
    public AddPlaceholderFunction(PlaceholderFunctionDAO placeholderFunctionDAO) {
        this.placeholderFunctionDAO = placeholderFunctionDAO;
    }

    public String execute(PlaceholderFunctionDTO placeholderFunctionDTO){
        PlaceholderFunction placeholderFunction=new PlaceholderFunction(placeholderFunctionDTO.getCode(),placeholderFunctionDTO.getLanguage(),new Statement(placeholderFunctionDTO.getIdStatement()));

        return  placeholderFunctionDAO.save(placeholderFunction);
    }
}
