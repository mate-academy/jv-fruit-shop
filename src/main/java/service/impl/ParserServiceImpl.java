package service.impl;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.dto.FruitRecordDto;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int CORRECT_FIELDS_NUMBER = 3;
    private static final String BALANCE_OPERATION = "b";
    private static final String DELIMITER = ",";
    private static final String ERROR_FIELDS_NUMBER = "Invalid number of fields!";
    private static final String ERROR_FIELDS = "Invalid one or more fields!";
    private static final String REGEX_ONLY_DIGITS = "\\d+";

    @Override
    public List<FruitRecordDto> parseToDto(List<String> strings) {
        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>(strings.size());
        for (String string : strings) {
            String[] fieldsDto = string.split(DELIMITER);
            if (fieldsDto.length != CORRECT_FIELDS_NUMBER) {
                throw new RuntimeException(ERROR_FIELDS_NUMBER);
            }
            String operation = fieldsDto[OPERATION_TYPE];
            String fruitName = fieldsDto[FRUIT_NAME];
            String fruitQuantity = fieldsDto[QUANTITY];
            if (Storage.validOperations.contains(operation)
                    && Storage.validFruitNames.contains(fruitName)
                    && fruitQuantity.matches(REGEX_ONLY_DIGITS)) {
                fruitRecordDtoList.add(new FruitRecordDto(operation, fruitName,
                        Integer.parseInt(fruitQuantity)));
                if (BALANCE_OPERATION.equals(operation)) {
                    Storage.fruits.put(new Fruit(fruitName), Integer.parseInt(fruitQuantity));
                }
            } else {
                throw new RuntimeException(ERROR_FIELDS);
            }
        }
        return fruitRecordDtoList;
    }
}
