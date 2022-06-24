package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.Parser;
import core.basesyntax.model.OperationType;

public class CsvParser implements Parser {
    private static final int FRUIT_POSITION = 1;
    private static final int AMOUNT_POSITION = 2;

    @Override
    public Operation parse(String line) {
        String[] data = line.split(",");
        OperationType type = null;
        for (OperationType operationType : OperationType.values()) {
            if (data[0].equals(operationType.getAbbreviation())) {
                type = operationType;
                break;
            }
        }
        if (type == null) {
            throw new RuntimeException("Incorrect input data: " + line + "\n Couldn't"
                    + " find that operationType");
        }
        return new Operation(type, data[FRUIT_POSITION],
                Integer.parseInt(data[AMOUNT_POSITION]));
    }
}
