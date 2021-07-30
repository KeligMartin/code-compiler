package fr.adventofcode.backend.quality.application;


import fr.adventofcode.backend.quality.domain.Status;

import java.util.List;

public class CodeQualityUtils {

    public static int calculateGain (int levelGain, List<String> errors) {
        if (errors.size() == 0) {
            return levelGain * 5;
        }
        else if (errors.size() < 3) {
            return levelGain * 3;
        }
        return levelGain;
    }

    public static Status calculateStatus (List<String> errors) {
        if (errors.size() == 0) {
            return Status.AWESOME;
        }
        else if(errors.size() < 3) {
            return Status.GOOD;
        }
        return Status.BAD;
    }
}
