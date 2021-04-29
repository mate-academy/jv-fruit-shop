package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.service.DataParserService;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    private static final String DATA_COLUMN_SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final int COLUMN_HEADER_ROW = 1;

    @Override
    public List<FruitDataDto> parseDataFromInputFile(List<String> dataFromInputFile) {
        return dataFromInputFile.stream()
                .skip(COLUMN_HEADER_ROW)
                .map(string -> string.split(DATA_COLUMN_SEPARATOR))
                .filter(this::isValid)
                .map(array -> new FruitDataDto(array[OPERATION_TYPE_INDEX],
                        array[FRUIT_NAME_INDEX], Integer.parseInt(array[FRUIT_QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }

    private boolean isValid(String[] currentDataStringArray) {
        if (currentDataStringArray.length != 3) {
            throw new RuntimeException("Incorrect data format");
        }
        if (Integer.parseInt(currentDataStringArray[FRUIT_QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("Input quantity should be greater then zero");
        }
        if (!FruitDataDto.Operations.contains(currentDataStringArray[OPERATION_TYPE_INDEX])) {
            throw new RuntimeException("Incorrect operation");
        }
        return true;
    }
}
