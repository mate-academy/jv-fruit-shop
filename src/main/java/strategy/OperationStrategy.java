package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    void apply(FruitTransaction.Operation operation, int quantity);
}
