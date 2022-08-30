package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    int handle(FruitTransaction fruitTransaction);
}
