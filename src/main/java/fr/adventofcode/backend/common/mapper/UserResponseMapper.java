package fr.adventofcode.backend.common.mapper;

import fr.adventofcode.backend.userResponse.domain.UserResponse;
import fr.adventofcode.backend.userResponse.infrastructure.entity.UserResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserResponseMapper  implements ObjectMapper<UserResponse, UserResponseEntity>{
    private final StatementMapper statementMapper;

    private final AccountMapper accountMapper;

    @Autowired
    public UserResponseMapper(StatementMapper statementMapper, AccountMapper accountMapper){
        this.statementMapper = statementMapper;
        this.accountMapper = accountMapper;
    }

    @Override
    public UserResponse toDomain(UserResponseEntity userResponseEntity) {
        return new UserResponse(userResponseEntity.getIdUserResponse(), userResponseEntity.getCode(), userResponseEntity.getResolved(),userResponseEntity.getResolvedDate(), statementMapper.toDomain(userResponseEntity.getStatement()),accountMapper.toDomain(userResponseEntity.getAccount()),userResponseEntity.getLanguage());
    }

    @Override
    public UserResponseEntity toEntity(UserResponse userResponse) {
        return new UserResponseEntity(userResponse.getIdUserResponse(), userResponse.getCode(), userResponse.getResolved(),userResponse.getResolvedDate(), statementMapper.toEntity(userResponse.getStatement()),accountMapper.toEntity(userResponse.getAccount()),userResponse.getLanguage());
    }
}
