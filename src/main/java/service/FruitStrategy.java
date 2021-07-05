package service;

import model.OperationType;

public interface FruitStrategy {
    OperationHandler get(OperationType type);
}
