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
            String[] splitedRecord = line.split(SEPARATOR);
            if (splitedRecord.length > CORRECT_LENGTH) {
                throw new RuntimeException("Wrong number of columns");
            }

            String operationType = splitedRecord [TYPE].trim();
            Operation operationTypeCorrect = Operation.getOperationByShortName(operationType);

            int quantity;
            try {
                quantity = Integer.parseInt(splitedRecord [QUANTITY]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid value entered - " + splitedRecord [QUANTITY]);
            }
            FruitRecordDto dto = new FruitRecordDto(operationTypeCorrect,
                    splitedRecord [FRUIT_NAME].trim(), quantity);
            recordDtos.add(dto);
        }
        return recordDtos;
    }
}
