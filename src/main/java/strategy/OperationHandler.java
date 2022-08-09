package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void changeQuantity(FruitTransaction fruitTransaction);
}
