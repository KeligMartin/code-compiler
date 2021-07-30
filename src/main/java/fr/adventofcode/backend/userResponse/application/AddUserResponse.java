package fr.adventofcode.backend.userResponse.application;

import fr.adventofcode.backend.account.domain.Account;
import fr.adventofcode.backend.statement.domain.Statement;
import fr.adventofcode.backend.userResponse.application.dto.UserResponseDTO;
import fr.adventofcode.backend.userResponse.domain.UserResponse;
import fr.adventofcode.backend.userResponse.domain.UserResponseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserResponse {

    private final UserResponseDAO userResponseDAO;

    @Autowired
    public AddUserResponse(UserResponseDAO userResponseDAO){

        this.userResponseDAO = userResponseDAO;
    }


    public String execute(UserResponseDTO userResponseDTO, String accountId){
        UserResponse userResponse=new UserResponse(userResponseDTO.getCode(),userResponseDTO.getResolved(),userResponseDTO.getResolvedDate(),new Statement(userResponseDTO.getIdStatement()),new
                Account(accountId),userResponseDTO.getLanguage());
       return userResponseDAO.save(userResponse);
    }
}
