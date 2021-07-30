package fr.adventofcode.backend.quality;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeQualityHelper {

    private final ICodeQualityService codeQualityService;

    @Autowired
    public CodeQualityHelper(ICodeQualityService codeQualityService) {
        this.codeQualityService = codeQualityService;
    }

    public List<String> getErrors(String code) {
        return codeQualityService.execute(code);
    }
}
