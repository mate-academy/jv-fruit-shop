package service.strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void updateNumberOfFruit(FruitTransaction fruitTransaction);
}
