package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handleTransaction(FruitTransaction transaction);
}
