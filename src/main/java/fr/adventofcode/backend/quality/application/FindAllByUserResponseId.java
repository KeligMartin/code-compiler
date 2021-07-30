package fr.adventofcode.backend.quality.application;

import fr.adventofcode.backend.quality.domain.CodeQuality;
import fr.adventofcode.backend.quality.domain.CodeQualityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllByUserResponseId {

    private final CodeQualityDao codeQualityDao;

    @Autowired
    public FindAllByUserResponseId(CodeQualityDao codeQualityDao) {
        this.codeQualityDao = codeQualityDao;
    }

    public List<CodeQuality> execute(String userResponseId) {
        return codeQualityDao.findAllByUserResponseId(userResponseId);
    }
}
