package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void transaction(FruitTransaction fruitTransaction);
}
