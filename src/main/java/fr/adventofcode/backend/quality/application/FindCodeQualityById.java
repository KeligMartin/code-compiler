package fr.adventofcode.backend.quality.application;

import fr.adventofcode.backend.common.exception.ResourceWithIdNotFoundException;
import fr.adventofcode.backend.quality.domain.CodeQuality;
import fr.adventofcode.backend.quality.domain.CodeQualityDao;
import org.springframework.stereotype.Service;

@Service
public class FindCodeQualityById {

    private final CodeQualityDao codeQualityDao;

    public FindCodeQualityById(CodeQualityDao codeQualityDao) {
        this.codeQualityDao = codeQualityDao;
    }

    public CodeQuality execute(String id){
        return codeQualityDao.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException("code quality", id));
    }
}
