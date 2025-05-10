package service;

import model.FruitOperationType;

public interface FruitOperationTypeParser {
    FruitOperationType getOperationType(String line);
}
