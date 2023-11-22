package impl.operation.operations;

import model.FruitTransaction;

public interface OperationHandler {
    void handleTransaction(FruitTransaction fruitTransaction);
}
