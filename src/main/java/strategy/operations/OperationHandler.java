package strategy.operations;

import model.FruitTransaction;

public interface OperationHandler {
    void handler(FruitTransaction fruitTransaction);
}
