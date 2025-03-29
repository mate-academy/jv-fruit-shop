package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void processTransaction(FruitTransaction transaction);
}
