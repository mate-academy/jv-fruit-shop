package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    int getQuantityToAdd(FruitTransaction fruitTransaction);
}
