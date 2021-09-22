package core.basesyntax.service.impl;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.Validator;

public class ParseServiceImpl implements ParseService, Validator {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int REQUIRED_LENGTH = 3;

    @Override
    public FruitRecord parseData(String data) {
        if (validate(data)) {
            String[] record = data.split((COMMA));
            Operation operation = Operation.get(record[OPERATION_INDEX].substring(0, 1));
            return new FruitRecord(operation,
                    record[FRUIT_NAME_INDEX],
                    Integer.parseInt(record[QUANTITY_INDEX]));
        }
        throw new RuntimeException("Data is invalid: " + data);
    }

    @Override
    public boolean validate(String data) {
        String[] line = data.split((COMMA));
        return line.length == REQUIRED_LENGTH
                && line[FRUIT_NAME_INDEX].length() > 0
                && Integer.parseInt(line[QUANTITY_INDEX]) > 0;
    }
}
