package fr.adventofcode.backend.userResponse.infrastructure;


import fr.adventofcode.backend.userResponse.application.AddUserResponse;

import fr.adventofcode.backend.userResponse.application.FindAnswerCodeByResolvedAndAccountId;
import fr.adventofcode.backend.userResponse.application.FindUserResponse;
import fr.adventofcode.backend.userResponse.application.FindUserResponseByIdStatementAndIdAccount;
import fr.adventofcode.backend.userResponse.application.dto.FindUserResponseRequestDTO;

import fr.adventofcode.backend.userResponse.application.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("userResponses")
public class UserResponseController {

    private final AddUserResponse addUserResponse;
    private final FindAnswerCodeByResolvedAndAccountId findAnswerCodeByResolvedAndAccountId;

    private final FindUserResponse findUserResponse;
    private final FindUserResponseByIdStatementAndIdAccount findUserResponseByIdStatementAndIdAccount;

 @Autowired
  public UserResponseController(AddUserResponse addUserResponse, FindUserResponse findUserResponse, FindAnswerCodeByResolvedAndAccountId findAnswerCodeByResolvedAndAccountId, FindUserResponseByIdStatementAndIdAccount findUserResponseByIdStatementAndIdAccount) {

     this.addUserResponse = addUserResponse;
     this.findAnswerCodeByResolvedAndAccountId = findAnswerCodeByResolvedAndAccountId;
     this.findUserResponse = findUserResponse;

     this.findUserResponseByIdStatementAndIdAccount = findUserResponseByIdStatementAndIdAccount;
 }

    @PostMapping("/search")
    public ResponseEntity getUserResponse(@RequestBody FindUserResponseRequestDTO findUserResponseRequestDTO,@RequestAttribute("accountId") String idAccount){
        return new ResponseEntity(findUserResponse.execute(findUserResponseRequestDTO,idAccount), HttpStatus.OK);
    }


    @PostMapping
        public ResponseEntity addUserResponse(
                @RequestBody @Valid UserResponseDTO userResponseDTO, HttpServletRequest httpServletRequest, @RequestAttribute("accountId") String accountId) {
        String userResponseId = addUserResponse.execute(userResponseDTO, accountId);


        URI uri =
                ServletUriComponentsBuilder.fromContextPath(httpServletRequest)
                        .path("/userResponse/{id}")
                        .buildAndExpand(userResponseId)
                        .toUri();


        return ResponseEntity.created(uri).build();
    }



    @GetMapping("/user/resolved/{resolved}")
    public ResponseEntity<?> findAnswerCodeByResolvedAndAccountId( @PathVariable Boolean resolved, @RequestAttribute("accountId") String accountId){
        return new ResponseEntity<>(findAnswerCodeByResolvedAndAccountId.execute(accountId, resolved), HttpStatus.OK);
    }


    @GetMapping("/user/statement/{idStatement}")
    public ResponseEntity<?> findUserResponseResolvedByIdStatementAndIdAccount( @PathVariable String idStatement, @RequestAttribute("accountId") String accountId){
    return new ResponseEntity<>(
        findUserResponseByIdStatementAndIdAccount.execute(accountId,idStatement), HttpStatus.OK);
    }

}
