package fr.adventofcode.backend.common.mapper;

import fr.adventofcode.backend.quality.domain.CodeQuality;
import fr.adventofcode.backend.quality.infrastructure.entity.CodeQualityEntity;
import org.springframework.stereotype.Service;

@Service
public class CodeQualityMapper implements ObjectMapper<CodeQuality, CodeQualityEntity> {

    public CodeQuality toDomain(CodeQualityEntity codeQualityEntity) {
        return new CodeQuality(codeQualityEntity.getIdCodeQuality(),
                codeQualityEntity.getErrors(),
                codeQualityEntity.getDate(),
                codeQualityEntity.getGain(),
                codeQualityEntity.getStatus(),
                codeQualityEntity.getUserResponseId()
        );
    }


    public CodeQualityEntity toEntity(CodeQuality codeQuality) {
        return new CodeQualityEntity(codeQuality.getIdCodeQuality(),
                codeQuality.getErrors(),
                codeQuality.getDate(),
                codeQuality.getGain(),
                codeQuality.getStatus(),
                codeQuality.getUserResponseId()
        );
    }
}
