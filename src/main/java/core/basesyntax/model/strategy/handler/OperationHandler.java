package core.basesyntax.model.strategy.handler;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void processingOperation(FruitTransaction transaction);
}
