package core.basesyntax.files;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String FIRST_WORD_IN_TITLE = "type";
    private static final String WORD_SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitRecordDto> parseStrings(List<String> lines) {
        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>();
        if (lines.get(0).contains(FIRST_WORD_IN_TITLE)) {
            lines.remove(0);
        }
        for (String line : lines) {
            String[] shopData = line.split(WORD_SEPARATOR);
            fruitRecordDtoList.add(new FruitRecordDto(
                    Operation.getOperationTypeByLetter(shopData[OPERATION]),
                    new Fruit(shopData[FRUIT_NAME]),
                    Integer.parseInt(shopData[QUANTITY])));
        }
        return fruitRecordDtoList;
    }
}
