package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void handleOperation(FruitTransaction fruitTransaction);
}


