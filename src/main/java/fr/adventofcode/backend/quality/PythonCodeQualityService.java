package fr.adventofcode.backend.quality;

import fr.adventofcode.backend.quality.listeners.python.FunctionLengthListener;
import fr.adventofcode.backend.quality.listeners.python.FunctionNameListener;
import fr.adventofcode.backend.quality.listeners.python.PythonLineLengthListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PythonCodeQualityService implements ICodeQualityService {


    private final FunctionLengthListener functionLengthListener;
    private final PythonLineLengthListener lineLengthListener;
    private final FunctionNameListener functionNameListener;

    @Autowired
    public PythonCodeQualityService(FunctionLengthListener functionLengthListener, FunctionNameListener functionNameListener, PythonLineLengthListener lineLengthListener) {
        this.functionLengthListener = functionLengthListener;
        this.lineLengthListener = lineLengthListener;
        this.functionNameListener = functionNameListener;
    }

    public List<String> execute(String code) {
        return Stream.of(
                functionLengthListener.getErrors(code),
                lineLengthListener.getErrors(code),
                functionNameListener.getErrors(code))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
