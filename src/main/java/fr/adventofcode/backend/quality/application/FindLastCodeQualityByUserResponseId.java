package fr.adventofcode.backend.quality.application;

import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import fr.adventofcode.backend.quality.domain.CodeQuality;
import fr.adventofcode.backend.quality.domain.CodeQualityDao;
import org.springframework.stereotype.Service;

@Service
public class FindLastCodeQualityByUserResponseId {

    private final CodeQualityDao codeQualityDao;

    public FindLastCodeQualityByUserResponseId(CodeQualityDao codeQualityDao) {
        this.codeQualityDao = codeQualityDao;
    }

    public CodeQuality execute(String userResponseId) {
        return codeQualityDao
                .findLastByUserResponseId(userResponseId)
                .orElse(null);
    }
}
