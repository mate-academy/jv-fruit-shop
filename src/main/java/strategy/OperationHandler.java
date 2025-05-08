package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void processOperation(FruitTransaction fruitTransaction);
}
