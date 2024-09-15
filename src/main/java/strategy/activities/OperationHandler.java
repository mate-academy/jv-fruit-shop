package strategy.activities;

import model.FruitTransaction;

public interface OperationHandler {
    void executeTransaction(FruitTransaction transaction);
}
