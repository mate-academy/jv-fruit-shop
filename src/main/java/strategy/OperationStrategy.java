package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    FruitHandler get(FruitTransaction.Operation operation);
}
