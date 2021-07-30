package fr.adventofcode.backend.placeholderFunction.application;

import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunction;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunctionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindPlaceholderFunctionByIdStatement {

    private final PlaceholderFunctionDAO placeholderFunctionDAO;

    @Autowired
    public  FindPlaceholderFunctionByIdStatement(PlaceholderFunctionDAO placeholderFunctionDAO){

        this.placeholderFunctionDAO = placeholderFunctionDAO;
    }

    public List<PlaceholderFunction> execute(String idStatement){
        return placeholderFunctionDAO.findPlaceholderFunctionByIdStatement(idStatement);
    }
}
