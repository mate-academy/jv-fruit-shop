package service.operations;

import model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation type);
}
