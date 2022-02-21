package service.parse;

import java.util.List;
import java.util.stream.Collectors;
import service.validator.FruitValidator;

public class ParseInput implements ParseRawInput {
    private static final String SEPARATOR = ",";
    private static final int HEADER_LINE = 0;
    private FruitValidator inputValidator;

    @Override
    public List<String[]> parse(List<String> inputData) {
        inputValidator = new FruitValidator();
        inputValidator.isFileEmpty(inputData);
        inputData.remove(HEADER_LINE);
        List<String[]> parsedData = inputData.stream()
                    .map(line -> line.split(SEPARATOR))
                    .collect(Collectors.toList());
        inputValidator.isDataCorrect(parsedData);
        return parsedData;
    }
}
