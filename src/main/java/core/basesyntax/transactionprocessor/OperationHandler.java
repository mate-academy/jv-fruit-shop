package core.basesyntax.transactionprocessor;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}
