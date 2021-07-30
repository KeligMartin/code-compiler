package fr.adventofcode.backend.placeholderFunction.application;

import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import fr.adventofcode.backend.placeholderFunction.application.dto.FindPlaceholderFunctionDTO;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunction;
import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunctionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPlaceholderFunction {

    private final PlaceholderFunctionDAO placeholderFunctionDAO;

    @Autowired
    public  FindPlaceholderFunction(PlaceholderFunctionDAO placeholderFunctionDAO){

        this.placeholderFunctionDAO = placeholderFunctionDAO;
    }

    public PlaceholderFunction execute(FindPlaceholderFunctionDTO findPlaceholderFunctionDTO){
        return placeholderFunctionDAO.findPlaceholderFunction(findPlaceholderFunctionDTO.getIdStatement(),findPlaceholderFunctionDTO.getLanguage())
                .orElseThrow(() -> new ResourceWithIdNotFoundException("placeholderFunction", findPlaceholderFunctionDTO.getIdStatement()));
    }
}
