package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void applyTransactionToStorage(FruitTransaction fruitTransaction);
}
