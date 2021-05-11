package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.operations.Operations;
import core.basesyntax.service.DataParserService;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {

    private static final String DATA_COLUMN_SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final int COLUMN_HEADER_ROW = 1;
    private static final String FIRST_EXCEPTION_MESSAGE = "Incorrect data format";
    private static final String SECOND_EXCEPTION_MESSAGE
            = "Input quantity should be greater then zero";
    private static final String THIRD_EXCEPTION_MESSAGE = "Incorrect operation";

    @Override
    public List<FruitDataDto> parseDataFromInputFile(List<String> dataFromInputFile) {
        return dataFromInputFile.stream()
                .skip(COLUMN_HEADER_ROW)
                .map(string -> string.split(DATA_COLUMN_SEPARATOR))
                .filter(this::isValid)
                .map(array -> new FruitDataDto(Operations
                        .getEnumByString(array[OPERATION_TYPE_INDEX]),
                        new Fruit(array[FRUIT_NAME_INDEX]),
                        Integer.parseInt(array[FRUIT_QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }

    private boolean isValid(String[] currentDataStringArray) {
        if (currentDataStringArray.length != 3) {
            throw new RuntimeException(FIRST_EXCEPTION_MESSAGE);
        }
        if (Integer.parseInt(currentDataStringArray[FRUIT_QUANTITY_INDEX]) < 0) {
            throw new RuntimeException(SECOND_EXCEPTION_MESSAGE);
        }
        if (!Operations.contains(currentDataStringArray[OPERATION_TYPE_INDEX])) {
            throw new RuntimeException(THIRD_EXCEPTION_MESSAGE);
        }
        return true;
    }
}
