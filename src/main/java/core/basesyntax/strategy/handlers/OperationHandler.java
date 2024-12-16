package core.basesyntax.strategy.handlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    default Boolean isValidTransactionData(String fruit, int quantity) {
        return fruit != null && quantity > 0;
    }

    Boolean executeOperation(FruitTransaction transaction);
}
