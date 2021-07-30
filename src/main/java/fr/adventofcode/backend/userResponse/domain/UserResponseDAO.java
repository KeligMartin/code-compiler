package fr.adventofcode.backend.userResponse.domain;


import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.userResponse.infrastructure.entity.UserResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserResponseDAO {
    String save(UserResponse userResponse);

    Optional<UserResponse> findByIdUserResponse(String idUserResponse);

    List<UserResponse> findAll();

    List<UserResponse> findByResolvedAndAccountId(Boolean resolved, String accountId);

    Optional<UserResponse> findByStatement_IdStatementAndLanguageAndAccount_Id(String idStatement, Language language, String account_id);

    List<UserResponse> findUserResponseByIdStatementAndIdAccount(String idStatement, String idAccount);
}
