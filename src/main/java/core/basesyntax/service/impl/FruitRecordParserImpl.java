package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordParser;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordParserImpl implements FruitRecordParser {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int CORRECT_FIELDS_NUMBER = 3;
    private static final String WORDS_DIVIDER = ",";
    private static final String ERROR_MESSAGE = "Invalid data!";

    @Override
    public List<FruitRecordDto> parse(List<String> strings) {
        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>();
        for (String string : strings) {
            if (string.equals("type,fruit,quantity")) {
                continue;
            }
            String[] fieldsDto = string.split(WORDS_DIVIDER);
            if (fieldsDto.length != CORRECT_FIELDS_NUMBER) {
                throw new RuntimeException(ERROR_MESSAGE);
            }
            String operation = fieldsDto[OPERATION_TYPE];
            String fruitName = fieldsDto[FRUIT_NAME];
            int fruitQuantity = Integer.parseInt(fieldsDto[QUANTITY]);
            isValid(operation, fruitQuantity);
            fruitRecordDtoList.add(new FruitRecordDto(operation, fruitName, fruitQuantity));
        }
        return fruitRecordDtoList;
    }

    private boolean isValid(String operation, int fruitQuantity) {
        if (Storage.validOperations.contains(operation)
                && fruitQuantity > 0) {
            return true;
        }
        throw new RuntimeException(ERROR_MESSAGE);
    }
}
