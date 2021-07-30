package fr.adventofcode.backend.userResponse.application;

import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import fr.adventofcode.backend.userResponse.domain.UserResponse;
import fr.adventofcode.backend.userResponse.domain.UserResponseDAO;
import org.springframework.stereotype.Service;

@Service
public class FindUserResponseById {

    private final UserResponseDAO userResponseDAO;

    public FindUserResponseById(UserResponseDAO userResponseDAO) {
        this.userResponseDAO = userResponseDAO;
    }

    public UserResponse execute(String idUserResponse){
        return userResponseDAO.findByIdUserResponse(idUserResponse).orElseThrow(() -> new ResourceWithIdNotFoundException("userResponse", idUserResponse));
    }
}
