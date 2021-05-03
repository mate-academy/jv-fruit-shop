package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.DataValidation;
import core.basesyntax.service.FruitRecordDtoParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";
    private DataValidation dataValidation = new DataValidationImpl();

    @Override
    public List<FruitRecordDto> parseLines(List<String> records) {
        List<FruitRecordDto> fruitRecordDto = new ArrayList<>(records.size());
        for (String record : records) {
            if (!dataValidation.checkLine(record)) {
                continue;
            }
            String[] recordArray = record.split(SPLITERATOR);
            String operation = recordArray[OPERATION_INDEX];
            Operation recordOperation = Operation.getOperationByLetter(operation);
            FruitRecordDto newFruitRecordDto = new FruitRecordDto(recordOperation,
                    recordArray[FRUIT_NAME_INDEX],
                    Integer.valueOf(recordArray[QUANTITY_INDEX]));
            fruitRecordDto.add(newFruitRecordDto);
        }
        return fruitRecordDto;
    }
}
