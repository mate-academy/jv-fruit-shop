package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    int getOperation(FruitTransaction data, int amount);
}
