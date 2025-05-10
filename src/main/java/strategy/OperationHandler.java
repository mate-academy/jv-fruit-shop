package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    int getQuantityToCalculate(FruitTransaction fruitTransaction);
}
