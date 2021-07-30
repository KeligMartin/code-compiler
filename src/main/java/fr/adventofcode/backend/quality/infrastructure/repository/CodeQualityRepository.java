package fr.adventofcode.backend.quality.infrastructure.repository;

import fr.adventofcode.backend.quality.infrastructure.entity.CodeQualityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeQualityRepository extends JpaRepository<CodeQualityEntity, String> {

    List<CodeQualityEntity> findAll();

    Optional<CodeQualityEntity> findByIdCodeQuality(String idCodeQuality);

    List<CodeQualityEntity> findAllByUserResponseId(String userResponseId);

    Optional<CodeQualityEntity> findFirstByUserResponseIdOrderByDateDesc(String userResponseId);
}
