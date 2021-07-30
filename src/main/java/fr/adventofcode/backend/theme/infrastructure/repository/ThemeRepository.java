package fr.adventofcode.backend.theme.infrastructure.repository;

import fr.adventofcode.backend.theme.infrastructure.entity.ThemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<ThemeEntity, String> {

    @Query("select  distinct substring(CAST(t.dateAffected as string),1,4) from theme t ")
    List<Integer> findAllYear();

    @Query("select t  FROM theme t where substring(CAST(t.dateAffected as string),1,4)=:year")
    List<ThemeEntity> findAllByYear(String year);

}

