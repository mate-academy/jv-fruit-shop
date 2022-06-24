package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.Parser;
import core.basesyntax.strategy.OperationType;

public class CsvParser implements Parser {
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
        return new Operation(type, data[1], Integer.parseInt(data[2]));
    }
}
