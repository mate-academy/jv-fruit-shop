package service;

import model.FruitTransaction;
import strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation type);
}
