package core.basesyntax.dto;

import core.basesyntax.service.OperationType;
import core.basesyntax.service.OperatorParser;
import core.basesyntax.service.implementation.OperatorParserImpl;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String DELIMITER = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private final List<FruitRecordDto> fruitRecordDtos = new ArrayList<>();

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        fruitRecordDtos.clear();
        lines.remove(0);
        for (String line : lines) {
            if (line.isEmpty()) {
                break;
            }
            line = line.trim();
            OperatorParser operatorParser = new OperatorParserImpl();
            String[] lineInfo = line.split(DELIMITER);
            OperationType operation = operatorParser.parse(lineInfo[INDEX_OF_OPERATION]);
            String fruitName = lineInfo[INDEX_OF_FRUIT];
            int quantity = Integer.parseInt(lineInfo[INDEX_OF_QUANTITY]);
            fruitRecordDtos.add(new FruitRecordDto(operation, fruitName, quantity));
        }
        return fruitRecordDtos;
    }
}
