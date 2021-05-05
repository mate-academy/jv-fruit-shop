package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.OperationType;
import model.dto.FruitRecordDto;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";
    private static final String ERROR_FIELDS = "Invalid format of string!";
    private static final String HEAD = "type,fruit,quantity";
    private static final String REGEX_FOR_VALIDATION = "[b,s,r,p],[a-z]+,[0-9]+";

    @Override
    public List<FruitRecordDto> parseToDto(List<String> strings) {
        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>(strings.size());
        for (String string : strings) {
            if (string.equals(HEAD)) {
                continue;
            }
            if (string.matches(REGEX_FOR_VALIDATION)) {
                String[] fieldsDto = string.split(DELIMITER);
                fruitRecordDtoList.add(new FruitRecordDto(
                        OperationType.getOperationType(fieldsDto[OPERATION_TYPE_INDEX]),
                        fieldsDto[FRUIT_NAME_INDEX],
                        Integer.parseInt(fieldsDto[QUANTITY_INDEX])));
            } else {
                throw new RuntimeException(ERROR_FIELDS);
            }
        }
        return fruitRecordDtoList;
    }
}
