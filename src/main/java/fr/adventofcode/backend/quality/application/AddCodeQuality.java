package fr.adventofcode.backend.quality.application;

import fr.adventofcode.backend.language.domain.Language;
import fr.adventofcode.backend.quality.CodeQualityHelper;
import fr.adventofcode.backend.quality.JavaCodeQualityService;
import fr.adventofcode.backend.quality.PythonCodeQualityService;
import fr.adventofcode.backend.quality.domain.CodeQuality;
import fr.adventofcode.backend.quality.domain.CodeQualityDao;
import fr.adventofcode.backend.userResponse.application.FindUserResponseById;
import fr.adventofcode.backend.userResponse.domain.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static fr.adventofcode.backend.quality.application.CodeQualityUtils.calculateGain;
import static fr.adventofcode.backend.quality.application.CodeQualityUtils.calculateStatus;


import java.time.LocalDateTime;

@Service
public class AddCodeQuality {

    private final CodeQualityDao codeQualityDao;
    private final JavaCodeQualityService codeQualityService;
    private final PythonCodeQualityService pythonCodeQualityService;
    private final FindUserResponseById findUserResponseById;

    @Autowired
    public AddCodeQuality(CodeQualityDao codeQualityDao, JavaCodeQualityService codeQualityService, FindUserResponseById findUserResponseById, PythonCodeQualityService pythonCodeQualityService) {
        this.codeQualityDao = codeQualityDao;
        this.codeQualityService = codeQualityService;
        this.findUserResponseById = findUserResponseById;
        this.pythonCodeQualityService = pythonCodeQualityService;
    }

    public String execute(CodeQuality codeQuality) {
        UserResponse userResponse = findUserResponseById.execute(codeQuality.getUserResponseId());
        if(userResponse.getLanguage().equals(Language.JAVA)) {
            CodeQualityHelper helper = new CodeQualityHelper(codeQualityService);
            codeQuality.setErrors(helper.getErrors("public class SampleClass {\n" + userResponse.getCode() + "}"));
            codeQuality.setGain(calculateGain(
                    userResponse.getStatement().getLevel().getGain(),
                    codeQuality.getErrors())
            );
            codeQuality.setStatus(calculateStatus(codeQuality.getErrors()));
            codeQuality.setDate(LocalDateTime.now());
            codeQuality.setUserResponseId(userResponse.getIdUserResponse());
            return codeQualityDao.save(codeQuality);
        }
        if(userResponse.getLanguage().equals(Language.PYTHON)) {
            CodeQualityHelper helper = new CodeQualityHelper(pythonCodeQualityService);
            codeQuality.setErrors(helper.getErrors(userResponse.getCode()));
            codeQuality.setGain(calculateGain(
                    userResponse.getStatement().getLevel().getGain(),
                    codeQuality.getErrors())
            );
            codeQuality.setStatus(calculateStatus(codeQuality.getErrors()));
            codeQuality.setDate(LocalDateTime.now());
            codeQuality.setUserResponseId(userResponse.getIdUserResponse());
            return codeQualityDao.save(codeQuality);
        }
        return null;
    }
}
