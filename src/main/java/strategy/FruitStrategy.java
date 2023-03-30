package strategy;

import model.FruitTransaction;

public interface FruitStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
