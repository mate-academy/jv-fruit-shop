package service;

import model.Operation;
import strategy.OperationHandler;

public interface FruitTransactionProcessor {
    OperationHandler get(Operation operation);
}
