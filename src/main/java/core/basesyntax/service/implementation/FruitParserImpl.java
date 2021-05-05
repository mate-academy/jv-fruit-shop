package core.basesyntax.service.implementation;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.OperationType;
import core.basesyntax.service.OperatorParse;
import java.util.List;
import java.util.stream.Collectors;

public class FruitParserImpl implements FruitParser {
    private static final int HEAD_LINE = 1;
    private static final String SEPARATOR = ",";
    private static final int COUNT_OF_COLUMNS = 3;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        return lines.stream()
                .skip(HEAD_LINE)
                .map(this::parseInputData)
                .collect(Collectors.toList());
    }

    private FruitRecordDto parseInputData(String line) {
        OperatorParse operatorParse = new OperatorParseImpl();
        String[] splitedLine = line.split(SEPARATOR);
        if (splitedLine.length != COUNT_OF_COLUMNS) {
            throw new IllegalArgumentException("required 3 parameters, but provided: "
                    + splitedLine.length);
        }
        try {
            OperationType operation = operatorParse.parse(splitedLine[0].toLowerCase());
            if (Integer.parseInt(splitedLine[2]) < 0) {
                throw new IllegalArgumentException("Quantity can't be less then zero");
            }
            return new FruitRecordDto(operation, splitedLine[1].toLowerCase(),
                    Integer.parseInt(splitedLine[2]));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Illegal type argument passed in file", ex);
        }
    }
}
