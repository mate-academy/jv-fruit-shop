package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    void processTransaction(FruitTransaction transaction);
}

