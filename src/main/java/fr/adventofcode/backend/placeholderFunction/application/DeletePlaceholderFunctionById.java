package fr.adventofcode.backend.placeholderFunction.application;


import fr.adventofcode.backend.placeholderFunction.domain.PlaceholderFunctionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePlaceholderFunctionById {
    private final PlaceholderFunctionDAO placeholderFunctionDAO;

    @Autowired
    public DeletePlaceholderFunctionById(PlaceholderFunctionDAO placeholderFunctionDAO) {
        this.placeholderFunctionDAO = placeholderFunctionDAO;
    }


    public void execute(String idPlaceholderFunction){
        placeholderFunctionDAO.deleteAllById(idPlaceholderFunction);
    }
}
