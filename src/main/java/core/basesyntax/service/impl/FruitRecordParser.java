package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.interfaces.Parser;

public class FruitRecordParser implements Parser<String, FruitRecord> {
    public static final String CSV_SEPARATOR = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitRecord parse(String value) {
        String[] split = value.split(CSV_SEPARATOR);
        String operation = split[OPERATION_INDEX];
        String fruitName = split[FRUIT_INDEX];
        int quantity = Integer.parseInt(split[QUANTITY_INDEX]);
        Fruit fruit = new Fruit(fruitName);
        return new FruitRecord(operation, fruit, quantity);
    }
}
