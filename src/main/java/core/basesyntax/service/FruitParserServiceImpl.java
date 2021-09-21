package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;

public class FruitParserServiceImpl implements FruitParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public FruitRecord parseRecord(String[] recordData) {
        return new FruitRecord(FruitRecord.Type.valueOfLabel(recordData[OPERATION_TYPE_INDEX]),
        new Fruit(recordData[FRUIT_NAME_INDEX]), Integer.parseInt(recordData[FRUIT_AMOUNT_INDEX]));
    }
}
