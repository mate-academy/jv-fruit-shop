package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void operationProcess(FruitTransaction fruitTransaction);
}
