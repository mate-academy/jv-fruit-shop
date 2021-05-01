package core.basesyntax.service.parser;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.Operation;

import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String NEGATIVE_VALUE_EXCEPTION = "Quantity can't be less than 0";
    private static final String INSUFFICIENT_NUMBER_OF_VALUES = "Current line has less "
            + "than three elements";
    private static final String SPLITTER = ",";
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitRecordDto> parse(List<String> lines) {
        String operationType;
        String fruitName;
        int quantity = 0;
        String[] currentLineArray;
        List<FruitRecordDto> recordDtos = new ArrayList<>(lines.size());
        for (String currentLine : lines) {
            currentLineArray = currentLine.split(SPLITTER);
            if (currentLineArray.length < 3) {
                throw new RuntimeException(INSUFFICIENT_NUMBER_OF_VALUES);
            }
            operationType = Operation.getOperationByLetter(currentLineArray[OPERATION_TYPE]
                    .trim()).getOperation();
            fruitName = currentLineArray[FRUIT_NAME].trim();
            if (quantity < 0) {
                throw new RuntimeException(NEGATIVE_VALUE_EXCEPTION);
            }
            quantity = Integer.parseInt(currentLineArray[QUANTITY].trim());
            FruitRecordDto currentDto = new FruitRecordDto(operationType, fruitName, quantity);
            recordDtos.add(currentDto);
        }
        return recordDtos;
    }
}
