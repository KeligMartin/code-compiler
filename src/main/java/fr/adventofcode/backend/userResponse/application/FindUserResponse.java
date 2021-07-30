package fr.adventofcode.backend.userResponse.application;

import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import fr.adventofcode.backend.userResponse.application.dto.FindUserResponseRequestDTO;
import fr.adventofcode.backend.userResponse.domain.UserResponse;
import fr.adventofcode.backend.userResponse.domain.UserResponseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FindUserResponse {

    private final UserResponseDAO userResponseDAO;

    @Autowired
    public FindUserResponse(UserResponseDAO userResponseDAO){

        this.userResponseDAO = userResponseDAO;
    }

    public UserResponse execute(FindUserResponseRequestDTO findUserResponseRequestDTO, String idAccount){
        return userResponseDAO.findByStatement_IdStatementAndLanguageAndAccount_Id(findUserResponseRequestDTO.getIdStatement(),findUserResponseRequestDTO.getLanguage(),idAccount).orElseThrow(()->
                new ResourceWithIdNotFoundException("userResponse : idStatement + language + idAccount",String.format(" %s %s %s ",findUserResponseRequestDTO.getIdStatement(),findUserResponseRequestDTO.getLanguage().toString(),idAccount )));
    }
}
