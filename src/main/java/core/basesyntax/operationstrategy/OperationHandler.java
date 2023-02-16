package core.basesyntax.operationstrategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handleOperation(FruitTransaction transaction);
}
