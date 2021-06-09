package core.basesyntax.files;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String WORDS_IN_TITLE = "type,fruit,quantity";
    private static final String WORD_SEPARATOR = ",";
    private static final int CORRECT_LENGTH = 3;
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitRecordDto> parseStrings(List<String> lines) {
        lines.remove(WORDS_IN_TITLE);

        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>();
        for (String line : lines) {
            String[] shopData = line.split(WORD_SEPARATOR);
            if (shopData.length != CORRECT_LENGTH) {
                throw new RuntimeException("The number of columns is wrong");
            }
            String operationType = shopData[OPERATION];
            Operation operation = Operation.getOperationTypeByLetter(operationType);
            FruitRecordDto fruitRecordDto = new FruitRecordDto(operation,
                    shopData[FRUIT_NAME], Integer.parseInt(shopData[QUANTITY]));
            fruitRecordDtoList.add(fruitRecordDto);
        }
        return fruitRecordDtoList;
    }
}
