package fr.adventofcode.backend.ranking;

import fr.adventofcode.backend.role.domain.ConstantsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Set;

@RestController
@RequestMapping("/rankings")
public class RankingController {

    private final GetRankings getRankings;

    @Autowired
    public RankingController(GetRankings getRankings) {
        this.getRankings = getRankings;
    }

    @GetMapping
    @RolesAllowed({ConstantsRole.ADMIN,ConstantsRole.USER})
    public ResponseEntity<Set<Ranking>> getAll() {
        return new ResponseEntity<>(getRankings.execute(), HttpStatus.OK);
    }
}
