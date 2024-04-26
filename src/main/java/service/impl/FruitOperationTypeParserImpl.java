package service.impl;

import java.util.NoSuchElementException;
import model.FruitOperationType;
import service.FruitOperationTypeParser;

public class FruitOperationTypeParserImpl implements FruitOperationTypeParser {
    @Override
    public FruitOperationType getOperationType(String operation) {
        for (FruitOperationType operationType : FruitOperationType.values()) {
            if (operationType.getOperationCode().equalsIgnoreCase(operation)) {
                return operationType;
            }
        }
        throw new NoSuchElementException("No such operation: " + operation);
    }
}
