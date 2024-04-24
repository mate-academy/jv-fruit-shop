package service;

import model.FruitOperationType;

public interface FruitOperationTypeParser {
    FruitOperationType checkAndGetOperationType(String line);
}
