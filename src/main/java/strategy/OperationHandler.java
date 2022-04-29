package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    int changeAmount(FruitTransaction fruitTransaction);
}
