package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordParserImpl implements FruitRecordParser {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int CORRECT_FIELDS = 3;
    private static final String SPLITTER = ",";
    private static final String ERROR = "Data is not correct";

    @Override
    public List<FruitRecordDto> parse(List<String> strings) {
        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>();
        for (int i = 1; i < strings.size(); i++) {
            String line = strings.get(i);
            String[] columnsDto = line.split(SPLITTER);
            if (columnsDto.length != CORRECT_FIELDS) {
                throw new RuntimeException(ERROR);
            }
            String operation = columnsDto[OPERATION_TYPE].trim();
            String fruitName = columnsDto[FRUIT_NAME].trim();
            int fruitQuantity = Integer.parseInt(columnsDto[QUANTITY]);
            fruitRecordDtoList.add(new FruitRecordDto(findOperation(operation),
                    fruitName, checkQuantity(fruitQuantity)));
        }
        return fruitRecordDtoList;
    }

    private OperationType findOperation(String shortNameOfOperation) {
        switch (shortNameOfOperation) {
            case "b": {
                return OperationType.BALANCE;
            }
            case "p": {
                return OperationType.PURCHASE;
            }
            case "s": {
                return OperationType.SUPPLY;
            }
            case "r": {
                return OperationType.RETURN;
            }
            default: {
                throw new RuntimeException("Wrong operation type");
            }
        }
    }

    private int checkQuantity(int fruitQuantity) {
        if (fruitQuantity > 0) {
            return fruitQuantity;
        }
        throw new RuntimeException(ERROR);
    }
}
