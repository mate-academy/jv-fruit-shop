package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    void setStrategy(FruitTransaction.Operation key, OperationHandler strategy);

    OperationHandler getStrategy(FruitTransaction.Operation key);
}
