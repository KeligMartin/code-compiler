package fr.adventofcode.backend.quality;

import java.util.List;

public interface ICodeQualityService {
    List<String> execute(String code);
}
