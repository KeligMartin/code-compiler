package fr.adventofcode.backend.placeholderFunction.application;


import fr.adventofcode.backend.placeholderFunction.application.dto.PlaceholderFunctionDTO;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunction;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunctionDAO;
import fr.adventofcode.backend.statement.domain.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePlaceholderFunction {
    private final PlaceholderFunctionDAO placeholderFunctionDAO;


    @Autowired
    public  UpdatePlaceholderFunction(PlaceholderFunctionDAO placeholderFunctionDAO){

        this.placeholderFunctionDAO = placeholderFunctionDAO;
    }

    public String execute(String idPlaceholder, PlaceholderFunctionDTO placeholderFunctionDTO){
        PlaceholderFunction placeholderFunction=new PlaceholderFunction(idPlaceholder,placeholderFunctionDTO.getCode(),placeholderFunctionDTO.getLanguage(),
                new Statement(placeholderFunctionDTO.getIdStatement()));

        return  placeholderFunctionDAO.save(placeholderFunction);
    }


}
