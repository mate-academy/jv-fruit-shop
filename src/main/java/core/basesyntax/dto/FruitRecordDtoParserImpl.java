package core.basesyntax.dto;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        List<FruitRecordDto> recordDto = new ArrayList<>();
        for (String line : lines) {
            if (line.equals(lines.get(0))) {
                continue;
            }
            String[] parseLine = line.split(",");
            String operationType = parseLine[OPERATION].trim();
            Operation operationTypeCorrect = Operation.getOperationByShortName(operationType);
            String fruitName = parseLine[FRUIT].trim();
            Integer quantity;
            try {
                quantity = Integer.parseInt(parseLine[QUANTITY].trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException("Illegal characters in use...", e);
            }
            FruitRecordDto dto = new FruitRecordDto(operationTypeCorrect, fruitName, quantity);
            recordDto.add(dto);
        }
        return recordDto;
    }
}
