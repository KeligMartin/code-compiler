package fr.adventofcode.backend.userResponse.application;

import fr.adventofcode.backend.userResponse.domain.UserResponse;
import fr.adventofcode.backend.userResponse.domain.UserResponseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUserResponses {

    private final UserResponseDAO userResponseDAO;

    @Autowired
    public FindAllUserResponses(UserResponseDAO userResponseDAO) {
        this.userResponseDAO = userResponseDAO;
    }

    public List<UserResponse> execute() {
        return userResponseDAO.findAll();
    }
}
