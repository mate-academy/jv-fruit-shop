package core.basesyntax.service.impl;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int REQUIRED_LENGTH = 3;

    @Override
    public FruitRecord parseData(String data) {
        String[] record = data.split((COMMA));
        if (validate(record)) {
            return new FruitRecord(HandlerStorage
                    .getOperation(record[OPERATION_INDEX].charAt(OPERATION_INDEX)),
                    record[FRUIT_NAME_INDEX],
                    Integer.parseInt(record[QUANTITY_INDEX]));
        }
        throw new RuntimeException("Data is invalid: " + data);
    }

    private boolean validate(String[] data) {
        return data.length == REQUIRED_LENGTH
                && data[FRUIT_NAME_INDEX].length() > 0
                && Integer.parseInt(data[QUANTITY_INDEX]) > 0;
    }
}
