package core.basesyntax.dto;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String SEPARATOR = ",";
    private static final String COLUMNS_NAME = "type,fruit,quantity";
    private static final int TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int CORRECT_LENGTH = 3;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        lines.remove(COLUMNS_NAME);
        List<FruitRecordDto> recordDtos = new ArrayList<>(lines.size());

        for (String line : lines) {
            String[] parseLine = line.split(SEPARATOR);
            if (parseLine.length > CORRECT_LENGTH) {
                throw new RuntimeException("Wrong number of columns");
            }

            String operationType = parseLine[TYPE];
            Operation operationTypeCorrect = Operation.getOperationByShortName(operationType);

            int quantity; //додаткова перевірка, якщо в колонку quantity введуть слово
            try {
                quantity = Integer.parseInt(parseLine[QUANTITY]);// тут буде помилка якщо буде слово
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid value entered - " + parseLine[QUANTITY]);
            }
            FruitRecordDto dto = new FruitRecordDto(operationTypeCorrect,
                    parseLine[FRUIT_NAME], quantity);
            recordDtos.add(dto);
        }
        return recordDtos;
    }
}
