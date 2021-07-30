package fr.adventofcode.backend.quality.domain;

import java.util.List;
import java.util.Optional;

public interface CodeQualityDao {

    List<CodeQuality> findAll();

    Optional<CodeQuality> findById(String id);

    List<CodeQuality> findAllByUserResponseId(String userResponseId);

    Optional<CodeQuality> findLastByUserResponseId(String userResponseId);

    String save(CodeQuality codeQuality);
}
