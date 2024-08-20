package service.operation;

import model.FruitTransaction;

public interface OperationHandler {
    void operation(FruitTransaction.Operation operation, FruitTransaction fruitTransaction);
}
