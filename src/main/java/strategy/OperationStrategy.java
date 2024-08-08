package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    void handleOperation(FruitTransaction transaction);
}
