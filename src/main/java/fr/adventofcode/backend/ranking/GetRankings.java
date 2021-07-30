package fr.adventofcode.backend.ranking;

import fr.adventofcode.backend.quality.application.FindLastCodeQualityByUserResponseId;
import fr.adventofcode.backend.userResponse.application.FindAllUserResponses;
import fr.adventofcode.backend.userResponse.domain.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetRankings {

    private final FindAllUserResponses findAllUserResponses;
    private final FindLastCodeQualityByUserResponseId findLastCodeQualityByUserResponseId;

    @Autowired
    public GetRankings(FindAllUserResponses findAllUserResponses, FindLastCodeQualityByUserResponseId findLastCodeQualityByUserResponseId) {
        this.findAllUserResponses = findAllUserResponses;
        this.findLastCodeQualityByUserResponseId = findLastCodeQualityByUserResponseId;
    }

    public Set<Ranking> execute() {
        List<UserResponse> userResponses = findAllUserResponses.execute();

        Set<Ranking> rankings = new HashSet<>();

        for (UserResponse userResponse: userResponses) {
            var lastCodeQuality = findLastCodeQualityByUserResponseId.execute(userResponse.getIdUserResponse());
            if(lastCodeQuality != null){
                Ranking ranking = new Ranking(userResponse.getAccount().getUsername(), lastCodeQuality.getGain());
                Ranking myRank = rankings.stream().filter(r -> ranking.getUsername().equals(r.getUsername())).findFirst().orElse(null);
                if (myRank != null) {
                    myRank.setGain(myRank.getGain() + ranking.getGain());
                }else{
                    rankings.add(ranking);
                }
            }
        }
        return rankings;
    }
}
