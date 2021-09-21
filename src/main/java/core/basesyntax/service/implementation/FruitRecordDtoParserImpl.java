package core.basesyntax.service.implementation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FruitRecordDtoParser;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public FruitRecordDto parseRecord(String[] recordData) {
        return new FruitRecordDto(FruitRecordDto.Type.valueOfLabel(recordData[OPERATION_TYPE_INDEX]),
        new Fruit(recordData[FRUIT_NAME_INDEX]), Integer.parseInt(recordData[FRUIT_AMOUNT_INDEX]));
    }
}
