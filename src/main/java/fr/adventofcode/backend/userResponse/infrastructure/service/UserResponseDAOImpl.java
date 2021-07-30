package fr.adventofcode.backend.userResponse.infrastructure.service;

import fr.adventofcode.backend.account.application.FindAccountById;
import fr.adventofcode.backend.common.mapper.UserResponseMapper;
import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.statement.application.FindByIdStatement;
import fr.adventofcode.backend.userResponse.domain.UserResponse;
import fr.adventofcode.backend.userResponse.domain.UserResponseDAO;
import fr.adventofcode.backend.userResponse.infrastructure.entity.UserResponseEntity;
import fr.adventofcode.backend.userResponse.infrastructure.repository.UserResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class UserResponseDAOImpl implements UserResponseDAO {

  private final FindByIdStatement findByIdStatement;

  private final FindAccountById findAccountById;

  private final UserResponseMapper userResponseMapper;

  private final UserResponseRepository userResponseRepository;

  @Autowired
  public UserResponseDAOImpl(
      FindByIdStatement findByIdStatement,
      FindAccountById findAccountById,
      UserResponseMapper userResponseMapper,
      UserResponseRepository userResponseRepository) {
    this.findByIdStatement = findByIdStatement;
    this.findAccountById = findAccountById;
    this.userResponseMapper = userResponseMapper;
    this.userResponseRepository = userResponseRepository;
  }

  public List<UserResponse> findAll() {
    return userResponseRepository.findAll().stream().map(userResponseMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public String save(UserResponse userResponse) {
    findByStatement_IdStatementAndLanguageAndAccount_Id(userResponse.getStatement().getIdStatement(),userResponse.getLanguage(),userResponse.getAccount().getId())
        .ifPresent(
            userResponse1 ->{
              userResponse.setIdUserResponse(userResponse1.getIdUserResponse());
            } );

    userResponse.setStatement(
        findByIdStatement.execute(userResponse.getStatement().getIdStatement()));

    userResponse.setAccount(findAccountById.execute(userResponse.getAccount().getId()));
    UserResponseEntity userResponseEntity = userResponseMapper.toEntity(userResponse);
    return userResponseRepository.save(userResponseEntity).getIdUserResponse();
  }


    @Override
    public List<UserResponse> findByResolvedAndAccountId(Boolean resolved, String accountId) {
        return userResponseRepository.findByResolvedAndAccountId(resolved, accountId)
                .stream().map(userResponseMapper::toDomain)
                .collect(Collectors.toList());
  }

  @Override
  public Optional<UserResponse> findByStatement_IdStatementAndLanguageAndAccount_Id(
          String idStatement, Language language, String idAccount) {
    return userResponseRepository.findByStatement_IdStatementAndLanguageAndAccount_Id(
            idStatement,
            language,
            idAccount
            )
        .map(userResponseMapper::toDomain);
  }

  public Optional<UserResponse> findByIdUserResponse(String idUserResponse){
    return userResponseRepository.findByIdUserResponse(idUserResponse).map(userResponseMapper::toDomain);
  }

  @Override
  public List<UserResponse> findUserResponseByIdStatementAndIdAccount(String idStatement, String idAccount) {
    return  userResponseRepository.findByStatement_IdStatementAndAccount_IdAndResolvedIsTrue(idStatement,idAccount)
            .stream().map(userResponseMapper::toDomain)
            .collect(Collectors.toList());
  }

}
