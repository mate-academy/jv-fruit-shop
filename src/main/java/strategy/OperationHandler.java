package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    int operationHandle(FruitTransaction fruitTransaction);
}
