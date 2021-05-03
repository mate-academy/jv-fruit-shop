package core.basesyntax.dto;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String SEPARATOR = ",";
    private static final int COLUMNS_NAME = 0;
    private static final int TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> recordDtos = new ArrayList<>(lines.size());
        for (String line : lines) {
            if (line.equals(lines.get(COLUMNS_NAME))) {
                continue;
            }

            String[] parseLine = line.split(SEPARATOR);
            if (parseLine.length > 3) {
                throw new RuntimeException("Wrong number of columns");
            }

            String operationType = parseLine[TYPE];
            Operation operationTypeCorrect = Operation.getOperationByShortName(operationType);
            String fruitName = parseLine[FRUIT_NAME];

            int quantity; //додаткова перевірка, якщо в колонку quantity введуть null
            try {
                quantity = Integer.parseInt(parseLine[QUANTITY]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid value entered - " + parseLine[QUANTITY]);
            }
            FruitRecordDto dto = new FruitRecordDto(operationTypeCorrect, fruitName, quantity);
            recordDtos.add(dto);
        }
        return recordDtos;
    }
}
