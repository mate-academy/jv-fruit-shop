package core.basesyntax.strategy.strategyimpl;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void processedTransaction(FruitTransaction fruitTransaction);
}
