package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import core.basesyntax.service.ToRecordParser;

public class CsvToRecordParser implements ToRecordParser {
    public static final int COLUMNS_COUNT = 3;
    public static final int OPERATION_COLUMN = 0;
    public static final int FRUIT_COLUMN = 1;
    public static final int AMOUNT_COLUMN = 2;

    @Override
    public Record parse(String string) {
        String[] data = string.split(",");
        if (data.length != COLUMNS_COUNT) {
            throw new RuntimeException("Cant parse data");
        }
        return new Record(Operation.parseString(data[OPERATION_COLUMN]),
                new Fruit(data[FRUIT_COLUMN]),
                Long.parseLong(data[AMOUNT_COLUMN]));
    }
}
