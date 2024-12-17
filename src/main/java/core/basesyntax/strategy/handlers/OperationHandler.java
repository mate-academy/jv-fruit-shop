package core.basesyntax.strategy.handlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    default void checkIfTransactionDataIsValid(String fruit, int quantity) {
        if (fruit == null || quantity < 0) {
            throw new RuntimeException("Invalid data transaction.");
        }
    }

    void executeOperation(FruitTransaction transaction);
}
