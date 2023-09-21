package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    public void handleOperation(FruitTransaction fruitTransaction);
}
